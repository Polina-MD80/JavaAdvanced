package parking;

public
class Car {
    //•	manufacturer: String
    //•	model: String
    //•	year: int
    private String manufacturer;
    private String model;
    private  int year;

    public
    Car (String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public
    String getManufacturer () {
        return this.manufacturer;
    }

    public
    String getModel () {
        return this.model;
    }

    public
    int getYear () {
        return this.year;
    }

    @Override
    public
    String toString () {
        return String.format ("%s %s (%d)",this.manufacturer,this.model,this.year);
    }
}
