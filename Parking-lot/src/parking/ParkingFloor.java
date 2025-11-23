package parking;

import rest.SlotType;
import rest.Vehicle;
import slot.Slot;

import java.util.*;

public class ParkingFloor implements ParkingFloorInterface{
    public String id;
    int numberOfSlots;
    private final Map<Integer, Slot> slotById;
    private final List<Slot> allSlots;
    private final Map<SlotType, NavigableSet<Slot>> freeSlots = new HashMap<>();

    public ParkingFloor(String id, int numberOfSlots) {
        this.id = id;
        this.numberOfSlots = numberOfSlots;
        this.slotById = new HashMap<>();
        this.allSlots = new ArrayList<>();
        for (SlotType type : SlotType.values()) {
            freeSlots.put(type, new TreeSet<>(Comparator.comparingInt(Slot::getId)));
        }
        this.initializeSlots();
    }

    @Override
    public boolean isSlotAvailable(SlotType SlotType) {// O(1)
        return this.getFreeSlotCount(SlotType) > 0;
    }

    @Override
    public String park(String lotId, Vehicle vehicle) {// O(log n)
        if(!isSlotAvailable(vehicle.slotType)) {
            return null;
        }
        String slotId = this.bookSlot(vehicle);
        // Generate Ticket ID as <lotId>_<floorId>_<slotId>
        return lotId + "_" + this.id + "_" + slotId;
    }

    @Override
    public void unpark(String ticketId) { // O(log n)
        int slotId = Integer.parseInt(ticketId);
        Slot slot = this.getSlotById(slotId);
        if (slot != null && !slot.isFree()) {
            slot.free();
            freeSlots.get(slot.getType()).add(slot);// O(log n)
        } else {
            System.out.println("Invalid Ticket ID or Slot already free: " + ticketId);
        }
    }

    @Override
    public int getFreeSlotCount(SlotType SlotType) {// O(1)
        return freeSlots.get(SlotType).size();
    }

    @Override
    public Slot getSlotById(int slotId) {// O(1)
        return this.slotById.get(slotId);
    }

    private String bookSlot(Vehicle vehicle){// O(log n)
        NavigableSet<Slot> set = freeSlots.get(vehicle.slotType);
        if(set.isEmpty()){
            return null;
        }
        Slot slot = set.first();// O(1)
        set.remove(slot);// O(log n)
        slot.occupy(vehicle);// O(1)
        return String.valueOf(slot.getId());
    }

    public void displayFreeSlots(SlotType slotType) {
        List<Integer> freeSlotNumbers = freeSlots.get(slotType)
                .stream()
                .map(Slot::getId)
                .toList();
        System.out.println("Free slots for " + slotType.getName() + " on Floor " + this.id +  ": " + freeSlotNumbers);
    }

    public void displayOccupiedSlots(SlotType SlotType) {
        List<Integer> occupiedSlotNumbers = new ArrayList<>();
        for (Slot slot : allSlots) {
            if (slot.getType() == SlotType && !slot.isFree()) {
                occupiedSlotNumbers.add(slot.getId());
            }
        }
        System.out.println("Occupied slots for " + SlotType.getName() + " on Floor " + this.id +  ": " + occupiedSlotNumbers);
    }

    SlotType getSlotTypeForSlot(int slotNumber) {
        if (slotNumber == 1) {
            return SlotType.TRUCK;
        } else if (slotNumber >= 2 && slotNumber <= 3) {
            return SlotType.BIKE;
        } else if (slotNumber >= 4 && slotNumber <= numberOfSlots) {
            return SlotType.CAR;
        } else {
            return null;
        }
    }

    private void initializeSlots() {
        for(int i = 1; i <= numberOfSlots; i++) {
            SlotType SlotType = getSlotTypeForSlot(i);
            Slot slot = new Slot(i, SlotType);
            allSlots.add(slot);
            slotById.put(i, slot);
            freeSlots.get(SlotType).add(slot);
        }
    }

}
