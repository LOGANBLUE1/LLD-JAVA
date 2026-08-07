package designProblemsAndGames.parkingLot.parking;

import designProblemsAndGames.parkingLot.rest.SlotType;
import designProblemsAndGames.parkingLot.rest.Vehicle;
import designProblemsAndGames.parkingLot.slot.Slot;

/**
 * A floor knows about slots only. Ticketing is the lot's job, so nothing here deals in ticket ids.
 */
public interface ParkingFloorInterface {
    String getId();

    /** Occupies the nearest free compatible slot and returns it, or null if this floor has none. */
    Slot reserveSlot(Vehicle vehicle);

    void releaseSlot(int slotId);

    int getFreeSlotCount(SlotType slotType);

    Slot getSlotById(int slotId);
}
