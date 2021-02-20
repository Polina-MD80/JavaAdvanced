package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public
class Dealership {

    private String name;
    private int capacity;
    private
    List<Car> data;

    public
    Dealership (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<> ();
    }

    public
    void add (Car car) {
        if (capacity > this.data.size ()) {
            this.data.add (car);
        }
    }

    public
    boolean buy (String manufacturer, String model) {
        return data.removeIf (car -> car.getManufacturer ().equals (manufacturer) && car.getModel ().equals (model));
    }

    public
    Car getLatestCar () {
        return this.data.stream ().max (Comparator.comparing (Car::getYear)).orElse (null);
    }

    public
    Car getCar (String manufacturer, String model) {
        Car carToReturn = null;
        for (Car car : this.data) {
            if (car.getManufacturer ().equals (manufacturer) && car.getModel ().equals (model)) {
                carToReturn = car;
            }
        }
        return carToReturn;
    }
    public int getCount(){
        return this.data.size ();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder ("The cars are in a car dealership ");
        sb.append (this.name).append (":").append (System.lineSeparator ());
        for (Car car : this.data) {
            sb.append (car).append (System.lineSeparator ());
        }
        return sb.toString ().trim ();
    }
}
