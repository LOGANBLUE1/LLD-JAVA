package services;

import models.GeoLocation;
import models.Restaurant;
import repository.RestaurantRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class HaversineDiscoveryService implements DiscoveryService {
    private final RestaurantRepository restaurants;
    public HaversineDiscoveryService(RestaurantRepository restaurants) { this.restaurants = restaurants; }
    public List<Restaurant> nearby(GeoLocation userLoc, double radiusKm, Optional<Integer> limit) {
        record WithDist(Restaurant r, double km) {}
        Stream<WithDist> candidates = restaurants.findAll().stream().map(r -> new WithDist(r, distanceKm(userLoc, r.location)));
        Stream<WithDist> filtered = candidates.filter(w -> w.km <= radiusKm).sorted(Comparator.comparingDouble(w -> w.km));
        Stream<WithDist> limited = limit.map(n -> filtered.limit(n)).orElse(filtered);
        return limited.map(w -> w.r).toList();
    }
    private static double distanceKm(GeoLocation a, GeoLocation b) {
        double R = 6371.0088; // km
        double dLat = Math.toRadians(b.lat - a.lat);
        double dLon = Math.toRadians(b.lon - a.lon);
        double la1 = Math.toRadians(a.lat), la2 = Math.toRadians(b.lat);
        double h = Math.pow(Math.sin(dLat/2),2) + Math.cos(la1)*Math.cos(la2)*Math.pow(Math.sin(dLon/2),2);
        return 2 * R * Math.asin(Math.min(1, Math.sqrt(h)));
    }
}
