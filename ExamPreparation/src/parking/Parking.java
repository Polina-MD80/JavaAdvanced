package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public
class Parking {
    //•	type: String
    //•	capacity: int

    private String type;
    private int capacity;
    private List<Car> data;

    public
    Parking (String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<> ();
    }

    public
    void add (Car car) {
        if (this.data.size () < capacity) {
            this.data.add (car);
        }
    }

    public
    boolean remove (String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer ().equals (manufacturer) && car.getModel ().equals (model)) {
                return this.data.remove (car);
            }
        }
        return false;
    }

    public
    Car getLatestCar () {
        return this.data.stream ().max (Comparator.comparing (Car::getYear)).orElse (null);
    }

    public
    Car getCar (String manufacturer, String model) {
        Car car = null;
        for (Car c : this.data) {
            if (c.getModel ().equals (model) && c.getManufacturer ().equals (manufacturer)) {
                car = c;
            }
        }
        return car;
    }

    public
    int getCount () {
        return this.data.size ();
    }


    public
    String getStatistics () {
        StringBuilder sb = new StringBuilder (String.format ("The cars are parked in %s:", this.type));
        sb.append (System.lineSeparator ());
        for (Car c : this.data) {
            sb.append (c).append (System.lineSeparator ());
        }
        return sb.toString ();

    }
}
