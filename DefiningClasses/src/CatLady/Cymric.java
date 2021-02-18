package CatLady;

public
class Cymric extends Cat{
    private double furLength;

    public
    Cymric (String breed, String name, double furLength) {
        super (breed, name);
        this.furLength = furLength;
    }

    @Override
    public
    String toString () {
        return String.format ("%s%.2f", super.toString (),this.furLength);
    }
}
