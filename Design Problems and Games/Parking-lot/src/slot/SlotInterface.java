package slot;

import rest.Vehicle;
import rest.SlotType;

public interface SlotInterface {
    int getId();
    SlotType getType();
    boolean isFree();
    void occupy(Vehicle vehicle);
    void free();
}