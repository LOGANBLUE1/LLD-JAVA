package designProblemsAndGames.parkingLot.parking;

import designProblemsAndGames.parkingLot.rest.DisplayType;
import designProblemsAndGames.parkingLot.rest.Ticket;
import designProblemsAndGames.parkingLot.rest.Vehicle;
import designProblemsAndGames.parkingLot.rest.SlotType;
import designProblemsAndGames.parkingLot.slot.Slot;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkingLot implements ParkingLotInterface {
    private final String id;
    // LinkedHashMap: floors are iterated in order when allocating, and looked up by id in O(1)
    // when unparking. The old List forced parkingFloors.get(floorId - 1), which silently assumed
    // floors are always named "1".."n".
    private final Map<String, ParkingFloor> floorById = new LinkedHashMap<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private final Map<String, String> activeTicketIdByRegistrationNumber = new HashMap<>();

    public ParkingLot(String id, int numberOfFloors, int slotsPerFloor) {
        this.id = id;
        for (int i = 1; i <= numberOfFloors; i++) {
            String floorId = String.valueOf(i);
            floorById.put(floorId, new ParkingFloor(floorId, slotsPerFloor));
        }
    }

    @Override
    public Ticket park(Vehicle vehicle) {
        String existingTicketId = activeTicketIdByRegistrationNumber.get(vehicle.registrationNumber);
        if (existingTicketId != null) {
            System.out.println("Vehicle " + vehicle.registrationNumber
                    + " is already parked. Ticket ID: " + existingTicketId);
            return null;
        }
        for (ParkingFloor floor : floorById.values()) {
            Slot slot = floor.reserveSlot(vehicle);// null => no free compatible slot on this floor
            if (slot == null) {
                continue;
            }
            Ticket ticket = Ticket.issue(
                    this.generateTicketId(floor.getId(), slot.getId()), vehicle, floor.getId(), slot.getId());
            activeTickets.put(ticket.id(), ticket);
            activeTicketIdByRegistrationNumber.put(vehicle.registrationNumber, ticket.id());
            System.out.println("Parked vehicle. Ticket ID: " + ticket.id());
            return ticket;
        }
        System.out.println("Parking Lot Full for vehicle type /parking not accepted : " + vehicle.slotType);
        return null;
    }

    @Override
    public Ticket unpark(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);// O(1), no split/parseInt to get it wrong
        if (ticket == null) {
            System.out.println("Invalid or already used Ticket ID: " + ticketId);
            return null;
        }
        activeTicketIdByRegistrationNumber.remove(ticket.vehicle().registrationNumber);
        floorById.get(ticket.floorId()).releaseSlot(ticket.slotId());
        System.out.println("Unparked vehicle " + ticket.vehicle().registrationNumber
                + " from floor " + ticket.floorId() + ", slot " + ticket.slotId());
        return ticket;
    }

    // <lotId>_<floorId>_<slotId> - keeps the problem statement's output format. Unique across
    // active tickets; a sequence would be needed if we ever wanted ticket history.
    private String generateTicketId(String floorId, int slotId) {
        return this.id + "_" + floorId + "_" + slotId;
    }

    @Override
    public void display(DisplayType displayType, SlotType slotType){
        switch (displayType) {
//            case FREE_COUNT:
//                this.displayFreeCount(slotType);
//                break;
            case FREE_SLOTS:
                this.displayFreeSlots(slotType);
                break;
            case OCCUPIED_SLOTS:
                this.displayOccupiedSlots(slotType);
                break;
        }
    }

    private void displayFreeSlots(SlotType type){
        for(ParkingFloor floor : floorById.values()){
            floor.displayFreeSlots(type);
        }
    }
//
//    private void displayFreeCount(SlotType type){
//        for(ParkingFloor floor : floorById.values()){
//            System.out.println("No. of free slots for " + type + " on Floor " + floor.getId() + ": " + floor.getFreeSlotCount(type));
//        }
//    }

    private void displayOccupiedSlots(SlotType type){
        for(ParkingFloor floor : floorById.values()){
            floor.displayOccupiedSlots(type);
        }
    }
}
