import adapters.InMemoryReservationRepo;
import adapters.InMemoryRestaurantRepo;
import adapters.InMemoryTableRepo;
import models.*;
import services.BookingServiceImpl;
import services.HaversineDiscoveryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Bootstrap repositories
        var restRepo = new InMemoryRestaurantRepo();
        var tableRepo = new InMemoryTableRepo();
        var resRepo = new InMemoryReservationRepo();

        // Seed data
        long r1 = 1L, r2 = 2L; long t11 = 11L, t12 = 12L, t21 = 21L;
        tableRepo.save(new Table(t11, 2, r1));
        tableRepo.save(new Table(t12, 4, r1));
        tableRepo.save(new Table(t21, 6, r2));
        restRepo.save(new Restaurant(r1, "Spice Hub", new GeoLocation(28.6139, 77.2090), 4.5, List.of(t11, t12)));
        restRepo.save(new Restaurant(r2, "Ocean Bistro", new GeoLocation(28.6448, 77.2167), 4.2, List.of(t21)));

        // Services
        var discovery = new HaversineDiscoveryService(restRepo);
        var booking = new BookingServiceImpl(restRepo, tableRepo, resRepo);

        // Discovery example
        GeoLocation userLoc = new GeoLocation(28.6139, 77.2090);
        List<Restaurant> nearby = discovery.nearby(userLoc, 5.0, Optional.of(10));
        System.out.println("Nearby restaurants:");
        for (Restaurant r : nearby) System.out.println(" - " + r.name + " (rating " + r.rating + ")");

        // Booking example
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        TimeRange dinner = new TimeRange(now.plusHours(2), now.plusHours(4));
        Reservation res = booking.book(1001L, r1, 3, dinner); // group size 3 -> picks table capacity 4
        System.out.println("Booked reservation id=" + res.id + " table=" + res.tableId + " at restaurant=" + res.restaurantId);

        // Attempt conflicting booking -> should fail
        try {
            booking.book(2002L, r1, 2, dinner);
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        // Cancel and re-book
        booking.cancel(res.id);
        Reservation res2 = booking.book(2002L, r1, 2, dinner);
        System.out.println("Re-booked reservation id=" + res2.id + " table=" + res2.tableId);
    }
}


