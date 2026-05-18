package designProblemsAndGames.restaurantBooking.services;

import designProblemsAndGames.restaurantBooking.models.GeoLocation;
import designProblemsAndGames.restaurantBooking.models.Restaurant;

import java.util.List;
import java.util.Optional;

public interface DiscoveryService {
    List<Restaurant> nearby(GeoLocation userLoc, double radiusKm, Optional<Integer> limit);
}