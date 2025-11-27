package models;

public final class Table {
    public final long id;
    public final int capacity;
    public final long restaurantId;

    public Table(long id, int capacity, long restaurantId) {
        this.id = id;
        this.capacity = capacity;
        this.restaurantId = restaurantId;
    }
}