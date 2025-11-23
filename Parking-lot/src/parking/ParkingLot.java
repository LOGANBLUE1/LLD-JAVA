package parking;

import rest.DisplayType;
import rest.Vehicle;
import rest.SlotType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements ParkingLotInterface {
    String id;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(String id, int numberOfFloors, int slotsPerFloor) {
        this.id = id;
        this.parkingFloors = new ArrayList<>();
        for (int i = 1; i <= numberOfFloors; i++) {
            parkingFloors.add(new ParkingFloor(String.valueOf(i), slotsPerFloor));
        }
    }

    @Override
    public String park(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            String ticketId = floor.park(this.id, vehicle);
            if (ticketId != null) {
                System.out.println("Parked vehicle. Ticket ID: " + ticketId);
                return ticketId;
            }
        }
        System.out.println("Parking Lot Full for vehicle type /parking not accepted : " + vehicle.slotType);
        return null;
    }

    @Override
    public void unpark(String ticketId) {
        List<String> parts = List.of(ticketId.split("_"));
        if(parts.size() != 3){
            System.out.println("Invalid Ticket ID: " + ticketId);
            return;
        }
        var floorId = Integer.parseInt(parts.get(1));
        ParkingFloor parkingFloor = parkingFloors.get(floorId-1);
        parkingFloor.unpark(parts.get(2));
    }

    @Override
    public void display(DisplayType displayType, SlotType slotType){
        switch (displayType) {
            case FREE_COUNT:
                this.displayFreeCount(slotType);
                break;
            case FREE_SLOTS:
                this.displayFreeSlots(slotType);
                break;
            case OCCUPIED_SLOTS:
                this.displayOccupiedSlots(slotType);
                break;
        }
    }

    private void displayFreeSlots(SlotType type){
        for(ParkingFloor floor : parkingFloors){
            floor.displayFreeSlots(type);
        }
    }

    private void displayFreeCount(SlotType type){
        for(ParkingFloor floor : parkingFloors){
            System.out.println("No. of free slots for " + type + " on Floor " + floor.id + ": " + floor.getFreeSlotCount(type));
        }
    }

    private void displayOccupiedSlots(SlotType type){
        for(ParkingFloor floor : parkingFloors){
            floor.displayOccupiedSlots(type);
        }
    }
}
