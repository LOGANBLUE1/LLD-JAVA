package designProblemsAndGames.parkingLot.slot;

import designProblemsAndGames.parkingLot.rest.Vehicle;
import designProblemsAndGames.parkingLot.rest.SlotType;

public interface SlotInterface {
    int getId();
    SlotType getType();
    boolean isFree();
    void occupy(Vehicle vehicle);
    void free();
}