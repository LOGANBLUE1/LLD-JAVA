package builder;

public class Car {
    public static class Builder {
        private String make;
        private String model;
        private int year;
        private String color;

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public final String make;
    public final String model;
    public final int year;
    public final String color;

    private Car(Builder builder){
        this.color = builder.color;
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
    }

    @Override
    public String toString() {
        return "Car - {" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
