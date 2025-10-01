package repository;

import models.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findById(long id);
    List<Restaurant> findAll();
    void save(Restaurant r);
}
