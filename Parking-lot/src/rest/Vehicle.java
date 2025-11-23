package rest;

public class Vehicle {
    public SlotType slotType;
    public String registrationNumber;
    public String color;

    public Vehicle(SlotType type, String registrationNumber, String color) {
        this.slotType = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}