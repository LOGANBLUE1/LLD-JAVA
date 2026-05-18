package designProblemsAndGames.parkingLot.parking;

import designProblemsAndGames.parkingLot.rest.SlotType;
import designProblemsAndGames.parkingLot.rest.Vehicle;
import designProblemsAndGames.parkingLot.slot.Slot;

public interface ParkingFloorInterface {
    boolean isSlotAvailable(SlotType SlotType);
    String park(String lotId, Vehicle vehicle);
    void unpark(String ticketId);
    int getFreeSlotCount(SlotType slotType);
    Slot getSlotById(int slotId);
}

