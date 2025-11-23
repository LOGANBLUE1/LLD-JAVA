package rest;

public enum SlotType {
    TRUCK("Truck"),
    BIKE("Bike"),
    CAR("Car");

   private String name;
    SlotType(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
