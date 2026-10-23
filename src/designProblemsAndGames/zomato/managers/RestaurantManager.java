package designProblemsAndGames.zomato.managers;


import designProblemsAndGames.zomato.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Singleton
public class RestaurantManager {
    private List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager() {
        // private constructor
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant r) {
        restaurants.add(r);
    }

    public List<Restaurant> searchByLocation(String loc) {
        String finalLoc = loc.toLowerCase();
        return restaurants.stream()
                .filter(r -> r.getLocation().toLowerCase().equals(finalLoc))
                .collect(Collectors.toList());

    }
}
