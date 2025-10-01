package adapters;

import models.Restaurant;
import repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryRestaurantRepo implements RestaurantRepository {
    private final Map<Long, Restaurant> store = new ConcurrentHashMap<>();
    public Optional<Restaurant> findById(long id) { return Optional.ofNullable(store.get(id)); }
    public List<Restaurant> findAll() { return new ArrayList<>(store.values()); }
    public void save(Restaurant r) { store.put(r.id, r); }
}
