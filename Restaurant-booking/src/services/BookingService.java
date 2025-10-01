package services;

import models.Reservation;
import models.TimeRange;

public interface BookingService {
    Reservation book(long userId, long restaurantId, int groupSize, TimeRange slot);
    void cancel(long reservationId);
}
