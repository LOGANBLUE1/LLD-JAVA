package models;

import java.util.List;

public final class Restaurant {
    public final long id;
    public final String name;
    public final GeoLocation location;
    public final double rating;
    public final List<Long> tableIds; // reference

    public Restaurant(long id, String name, GeoLocation location, double rating, List<Long> tableIds) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.tableIds = tableIds;
    }
}