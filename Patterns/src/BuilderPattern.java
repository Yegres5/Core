/**
 * <pre>
 * BuilderPattern.CarBuilder carBuilder = new BuilderPattern.CarBuilder();
 * BuilderPattern.Car car = carBuilder
 *         .setNumberOfSeats(16)
 *         .setNumberOfDoors(3)
 *         .setModel("Bus")
 *         .build();
 * </pre>
 */
public final class BuilderPattern {
    public static class Car {
        public Integer numberOfSeats;
        public Integer numberOfDoors;
        public String model;

        public Car(Integer numberOfSeats, Integer numberOfDoors, String model) {
            this.numberOfSeats = numberOfSeats;
            this.numberOfDoors = numberOfDoors;
            this.model = model;

        }
    }

    public static class CarBuilder {
        public Integer numberOfSeats;
        public Integer numberOfDoors;
        public String model;

        public CarBuilder setNumberOfSeats(Integer numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }

        public CarBuilder setNumberOfDoors(Integer numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public Car build() {
            return new Car(numberOfSeats, numberOfDoors, model);
        }
    }
}