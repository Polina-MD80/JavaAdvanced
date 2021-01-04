package SpeedRacing;

public
class Car {
    private String model;
    double fuel;
    double consumption;
    private int distance;

    public
    Car (String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distance = 0;
    }
}
