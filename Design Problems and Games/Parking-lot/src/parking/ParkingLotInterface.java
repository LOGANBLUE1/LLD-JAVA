package parking;

import rest.Vehicle;

public interface ParkingLotInterface {
    String park(Vehicle vehicle);
    void unpark(String ticketId);
    void display(rest.DisplayType displayType, rest.SlotType slotType);
}