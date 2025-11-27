package slot;

import rest.Vehicle;
import rest.SlotType;

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

    @Override
    public void occupy(Vehicle vehicle) {
        if (this.free && vehicle.slotType == this.slotType) {
            this.parkedVehicle = vehicle;
            this.free = false;
        }
    }

    @Override
    public void free() {
        this.parkedVehicle = null;
        this.free = true;
    }
}
