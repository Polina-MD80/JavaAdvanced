package CarSalesman;

public
class Car {
    //A Car has a model, engine, weight and color
    private String carModel;
    private String carEngine;
    private String weight;
    private String colour;

    public
    Car (String carModel, String carEngine) {
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.weight = "n/a";
        this.colour = "n/a";
    }

    public
    Car (String carModel, String carEngine, String weight, String colour) {
        this(carModel, carEngine);
        this.weight = weight;
        this.colour = colour;
    }

    public
    Car (String carModel, String carEngine, String weight) {
        this(carModel, carEngine);
        this.weight = weight;
    }

    public
    void setColour (String colour) {
        this.colour = colour;
    }

    public
    String getCarModel () {
        return carModel;
    }

    public
    String getCarEngine () {
        return carEngine;
    }

    public
    String getWeight () {
        return weight;
    }

    public
    String getColour () {
        return colour;
    }
}
