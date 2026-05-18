package creationalPatterns.Builder.builders;
import creationalPatterns.Builder.cars.CarType;
import creationalPatterns.Builder.components.Engine;
import creationalPatterns.Builder.components.GPSNavigator;
import creationalPatterns.Builder.components.Transmission;
import creationalPatterns.Builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}