package designProblemsAndGames.parkingLot.rest;

import java.time.LocalDateTime;

/**
 * Immutable record of one parking session.
 * <p>
 * It carries the location (floorId + slotId), so unparking never has to parse the ticket id
 * back into a floor and a slot. entryTime is what a fee calculator would need later.
 */
public record Ticket(String id, Vehicle vehicle, String floorId, int slotId, LocalDateTime entryTime) {

    public static Ticket issue(String id, Vehicle vehicle, String floorId, int slotId) {
        return new Ticket(id, vehicle, floorId, slotId, LocalDateTime.now());
    }
}
