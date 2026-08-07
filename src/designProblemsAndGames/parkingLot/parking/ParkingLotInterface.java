package designProblemsAndGames.parkingLot.parking;

import designProblemsAndGames.parkingLot.rest.Ticket;
import designProblemsAndGames.parkingLot.rest.Vehicle;
import designProblemsAndGames.parkingLot.rest.DisplayType;
import designProblemsAndGames.parkingLot.rest.SlotType;

public interface ParkingLotInterface {
    /** Returns the issued ticket, or null if the vehicle is already parked / the lot is full. */
    Ticket park(Vehicle vehicle);

    /** Returns the ticket that was closed, or null if the ticket id is unknown. */
    Ticket unpark(String ticketId);

    void display(DisplayType displayType, SlotType slotType);
}
