package CarSalesman;

public
class Engine {
    //has model, power, displacement and efficiency
    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

    public
    Engine (String engineModel, String power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public
    Engine (String engineModel, String power, String displacement, String efficiency) {
        this(engineModel,power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public Engine(String engineModel, String power, String displacement){
        this(engineModel, power);
        this.displacement = displacement;

    }

    public
    void setEfficiency (String efficiency) {
        this.efficiency = efficiency;
    }

    public
    String getEngineModel () {
        return engineModel;
    }
    //<EngineModel>:
    //Power: <EnginePower>
    //Displacement: <EngineDisplacement>
    //Efficiency: <EngineEfficiency>

    @Override
    public
    String toString () {
        return String.format ("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s", this.engineModel,
                this.power,this.displacement,this.efficiency);
    }
}
