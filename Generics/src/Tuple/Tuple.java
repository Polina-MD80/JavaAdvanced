package Tuple;

public
class Tuple<U,V> {
    private U first;
    private V second;

    public
    Tuple (U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public
    String toString () {
        return String.format ("%s -> %s", this.first,this.second);
    }
}
