package adapters;

import models.Table;
import repository.TableRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryTableRepo implements TableRepository {
    private final Map<Long, Table> store = new ConcurrentHashMap<>();
    public Optional<Table> findById(long id) { return Optional.ofNullable(store.get(id)); }
    public List<Table> findByRestaurant(long restaurantId) {
        return store.values().stream().filter(t -> t.restaurantId == restaurantId).sorted(Comparator.comparingInt(t -> t.capacity)).toList();
    }
    public void save(Table t) { store.put(t.id, t); }
}
