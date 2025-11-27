package models;

public final class Reservation {
    public final long id;
    public final long restaurantId;
    public final long tableId;
    public final long userId;
    public final TimeRange slot;
    public final int groupSize;
    public final ReservationStatus status;

    public Reservation(long id, long restaurantId, long tableId, long userId, TimeRange slot, int groupSize, ReservationStatus status) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.tableId = tableId;
        this.userId = userId;
        this.slot = slot;
        this.groupSize = groupSize;
        this.status = status;
    }
    public Reservation withStatus(ReservationStatus s) {
        return new Reservation(id, restaurantId, tableId, userId, slot, groupSize, s);
    }
}
