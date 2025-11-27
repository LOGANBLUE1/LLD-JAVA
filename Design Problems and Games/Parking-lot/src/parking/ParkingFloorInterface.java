package parking;

import rest.SlotType;
import slot.Slot;

import java.util.List;

public interface ParkingFloorInterface {
    boolean isSlotAvailable(SlotType SlotType);
    String park(String lotId, rest.Vehicle vehicle);
    void unpark(String ticketId);
    int getFreeSlotCount(SlotType slotType);
    Slot getSlotById(int slotId);
}
