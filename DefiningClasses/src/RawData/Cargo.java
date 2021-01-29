package RawData;

public
class Cargo {
    private  int weight;
    private String typeOfCargo;

    public
    Cargo (int weight, String typeOfCargo) {
        this.weight = weight;
        this.typeOfCargo = typeOfCargo;
    }

    public
    String getTypeOfCargo () {
        return typeOfCargo;
    }
}
