package CatLady;

public
class StreetExtraordinaire extends Cat{
    private double decibelsOfMeows;

    public
    StreetExtraordinaire (String breed, String name, double decibelsOfMeows) {
        super (breed, name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public
    String toString () {
        return String.format ("%s%.2f", super.toString (),this.decibelsOfMeows);
    }
}
