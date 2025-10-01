package repository;

import models.Reservation;
import models.TimeRange;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(long id);
    List<Reservation> findByTableAndOverlapping(long tableId, TimeRange slot);
    Reservation save(Reservation r);
    Reservation update(Reservation r);
}
