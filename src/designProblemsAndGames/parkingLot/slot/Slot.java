package designProblemsAndGames.parkingLot.slot;


import designProblemsAndGames.parkingLot.rest.SlotType;
import designProblemsAndGames.parkingLot.rest.Vehicle;

public class Slot implements SlotInterface {
    private int slotNo;
    private SlotType slotType;
    private boolean free;
    private Vehicle parkedVehicle;

    public Slot(int slotNo, SlotType slotType) {
        this.slotNo = slotNo;
        this.slotType = slotType;
        this.free = true;
        this.parkedVehicle = null;
    }

    @Override
    public int getId() {
        return this.slotNo;
    }

    @Override
    public SlotType getType() {
        return this.slotType;
    }

    @Override
    public boolean isFree() {
        return this.free;
    }

    // The slot owns its own invariant: fail loudly rather than no-op. A silent no-op here used to
    // leave the slot in neither freeSlots nor occupied - unbookable and un-freeable forever.
    @Override
    public void occupy(Vehicle vehicle) {
        if (!this.free) {
            throw new IllegalStateException("Slot " + slotNo + " is already occupied");
        }
        if (vehicle.slotType != this.slotType) {
            throw new IllegalArgumentException(
                    "Slot " + slotNo + " is of type " + slotType + ", cannot hold " + vehicle.slotType);
        }
        this.parkedVehicle = vehicle;
        this.free = false;
    }

    @Override
    public void free() {
        if (this.free) {
            throw new IllegalStateException("Slot " + slotNo + " is already free");
        }
        this.parkedVehicle = null;
        this.free = true;
    }
}
