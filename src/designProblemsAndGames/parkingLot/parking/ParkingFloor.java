package designProblemsAndGames.parkingLot.parking;

import designProblemsAndGames.parkingLot.rest.SlotType;
import designProblemsAndGames.parkingLot.rest.Vehicle;
import designProblemsAndGames.parkingLot.slot.Slot;

import java.util.*;

public class ParkingFloor implements ParkingFloorInterface{
    private final String id;
    int numberOfSlots;
    // LinkedHashMap: O(1) lookup by id, and iteration stays in slot order (1..n)
    private final Map<Integer, Slot> slotById;
    private final Map<SlotType, NavigableSet<Slot>> freeSlots = new HashMap<>();

    public ParkingFloor(String id, int numberOfSlots) {
        this.id = id;
        this.numberOfSlots = numberOfSlots;
        this.slotById = new LinkedHashMap<>();
        for (SlotType type : SlotType.values()) {
            freeSlots.put(type, new TreeSet<>(Comparator.comparingInt(Slot::getId)));
        }
        this.initializeSlots();
    }

    @Override
    public String getId() {
        return this.id;
    }

    // Single find-and-book step: an "isSlotAvailable then bookSlot" pair checks twice, has two ways
    // to fail (one of which put "null" inside a ticket id), and races once floors are shared.
    // Callers that only want the count use getFreeSlotCount.
    @Override
    public Slot reserveSlot(Vehicle vehicle) {// O(log n)
        NavigableSet<Slot> free = freeSlots.get(vehicle.slotType);
        Slot slot = free.pollFirst();// O(log n) - nearest free slot on this floor
        if (slot == null) {
            return null;
        }
        slot.occupy(vehicle);// O(1)
        return slot;
    }

    @Override
    public void releaseSlot(int slotId) { // O(log n)
        Slot slot = this.getSlotById(slotId);// O(1)
        if (slot == null) {
            throw new IllegalArgumentException("Floor " + this.id + " has no slot " + slotId);
        }
        slot.free();// throws if the slot was not occupied
        freeSlots.get(slot.getType()).add(slot);// O(log n)
    }

    @Override
    public int getFreeSlotCount(SlotType SlotType) {// O(1)
        return freeSlots.get(SlotType).size();
    }

    @Override
    public Slot getSlotById(int slotId) {// O(1)
        return this.slotById.get(slotId);
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
        for (Slot slot : slotById.values()) {
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
            slotById.put(i, slot);
            freeSlots.get(SlotType).add(slot);
        }
    }

}
