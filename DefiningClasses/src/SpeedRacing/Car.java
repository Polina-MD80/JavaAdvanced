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

    public
    boolean drive (int distToDrive) {
        double neededFuel = this.consumption * distToDrive;
        if (neededFuel <= this.fuel) {
            this.fuel -= neededFuel;
            this.distance += distToDrive;
            return true;
        }
        return false;
    }

    @Override
    public
    String toString () {
        return String.format ("%s %.2f %d", this.model,this.fuel,this.distance);
    }
}
