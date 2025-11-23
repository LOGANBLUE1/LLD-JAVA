import parking.ParkingLot;
import rest.DisplayType;
import rest.SlotType;
import rest.Vehicle;

public class Main {

    public static void main(String[] args) {
        //TIP create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
        ParkingLot parkingLot = new ParkingLot("PR1234", 2, 6);

        //TIP park_vehicle <vehicle_type> <reg_no> <color>
        String ticket1 = parkingLot.park(new Vehicle(SlotType.CAR, "KA-01-HH-1234", "White"));
        String ticket2 = parkingLot.park(new Vehicle(SlotType.CAR, "KA-01-HH-1234", "White"));

        //TIP unpark_vehicle
        parkingLot.unpark(ticket2);

        //TIP display <display_type> <vehicle_type>
        for(SlotType type : SlotType.values()) {
            for(DisplayType displayType : DisplayType.values()) {
                parkingLot.display(displayType, type);
            }
        }
    }
}