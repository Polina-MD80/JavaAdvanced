import java.util.ArrayList;
import java.util.List;

public
class Car {
    private String brand;
    private String model;
    private int horsepower;

    public
    void setBrand (String brand) {
        this.brand = brand;
    }

    public
    void setModel (String model) {
        this.model = model;
    }

    public
    void setHorsepower (int horsepower) {
        this.horsepower = horsepower;
    }

    public
    String getBrand () {
        return this.brand;
    }

    public
    String getModel () {
        return this.model;
    }

    public
    int getHorsepower () {
        return this.horsepower;
    }
    public void increaseHP(int horsepower){
       this.horsepower += horsepower;
    }

}
