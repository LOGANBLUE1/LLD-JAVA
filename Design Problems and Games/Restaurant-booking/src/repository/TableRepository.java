package repository;

import models.Table;

import java.util.List;
import java.util.Optional;

public interface TableRepository {
    Optional<Table> findById(long id);
    List<Table> findByRestaurant(long restaurantId);
    void save(Table t);
}
