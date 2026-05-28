package creationalPatterns.builder.example2;


// This is example of builder pattern without director. Client code directly uses builder to create product.
// This process is called as method chaining.
public class Demo {
    static void main(String[] args) {
        Car car = new Car.Builder()
                .setEngine("V8")
                .setWheels(4)
                .setSunroof(true)
                .build();

        System.out.println(car);
    }
}
