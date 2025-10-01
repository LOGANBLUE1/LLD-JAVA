package adapters;


import models.Reservation;
import models.ReservationStatus;
import models.TimeRange;
import repository.ReservationRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class InMemoryReservationRepo implements ReservationRepository {
    private final Map<Long, Reservation> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public Optional<Reservation> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }
    public List<Reservation> findByTableAndOverlapping(long tableId, TimeRange slot) {
        return store.values().stream()
                .filter(r -> r.tableId == tableId && r.status == ReservationStatus.BOOKED && r.slot.overlaps(slot))
                .toList();
    }
    public Reservation save(Reservation r) {
        long id = (r.id == 0L) ? seq.getAndIncrement() : r.id;
        Reservation toSave = new Reservation(id, r.restaurantId, r.tableId, r.userId, r.slot, r.groupSize, r.status);
        store.put(id, toSave);
        return toSave;
    }
    public Reservation update(Reservation r) {
        store.put(r.id, r);
        return r;
    }
}