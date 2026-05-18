package designProblemsAndGames.parkingLot.parking;

import designProblemsAndGames.parkingLot.rest.Vehicle;
import designProblemsAndGames.parkingLot.rest.DisplayType;
import designProblemsAndGames.parkingLot.rest.SlotType;

public interface ParkingLotInterface {
    String park(Vehicle vehicle);
    void unpark(String ticketId);
    void display(DisplayType displayType, SlotType slotType);
}