package designProblemsAndGames.restaurantBooking.services;

import designProblemsAndGames.restaurantBooking.models.Reservation;
import designProblemsAndGames.restaurantBooking.models.TimeRange;

public interface BookingService {
    Reservation book(long userId, long restaurantId, int groupSize, TimeRange slot);
    void cancel(long reservationId);
}
