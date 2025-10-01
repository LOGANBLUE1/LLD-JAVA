package services;


import models.*;
import repository.ReservationRepository;
import repository.RestaurantRepository;
import repository.TableRepository;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

public final class BookingServiceImpl implements BookingService {
    private final RestaurantRepository restaurants; private final TableRepository tables; private final ReservationRepository reservations;
    // Locks per table to serialize bookings on the same resource (fine-grained concurrency control)
    private final ConcurrentMap<Long, ReentrantLock> tableLocks = new ConcurrentHashMap<>();

    public BookingServiceImpl(RestaurantRepository r, TableRepository t, ReservationRepository res) {
        this.restaurants = r; this.tables = t; this.reservations = res;
    }

    public Reservation book(long userId, long restaurantId, int groupSize, TimeRange slot) {
        if (groupSize <= 0) throw new IllegalArgumentException("groupSize must be > 0");
        Restaurant rest = restaurants.findById(restaurantId).orElseThrow(() -> new NoSuchElementException("restaurant not found"));
        // Best-fit: smallest table with capacity >= groupSize
        List<Table> candidates = tables.findByRestaurant(rest.id).stream()
                .filter(t -> t.capacity >= groupSize)
                .sorted(Comparator.comparingInt(t -> t.capacity))
                .toList();
        if (candidates.isEmpty()) throw new IllegalStateException("No table has enough capacity");

        for (Table table : candidates) {
            ReentrantLock lock = tableLocks.computeIfAbsent(table.id, k -> new ReentrantLock());
            if (!lock.tryLock()) continue; // optimistic: try next table
            try {
                // re-check availability under lock
                boolean occupied = !reservations.findByTableAndOverlapping(table.id, slot).isEmpty();
                if (occupied) continue;
                Reservation created = new Reservation(0L, rest.id, table.id, userId, slot, groupSize, ReservationStatus.BOOKED);
                return reservations.save(created);
            } finally {
                lock.unlock();
            }
        }
        throw new IllegalStateException("No tables available for the requested time slot");
    }

    public void cancel(long reservationId) {
        Reservation r = reservations.findById(reservationId).orElseThrow(() -> new NoSuchElementException("reservation not found"));
        if (r.status != ReservationStatus.BOOKED) return;
        reservations.update(r.withStatus(ReservationStatus.CANCELLED));
    }
}
