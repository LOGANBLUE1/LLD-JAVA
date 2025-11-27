package builder;

public class Main {
    public static void main(String[] args) {
        Car.Builder builder = new Car.Builder();

        var build = builder
                .setMake("Toyota")
                .setModel("Corolla")
                .setYear(2020)
                .build();

        System.out.println(build.toString());
    }
}
