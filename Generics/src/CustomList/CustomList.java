package CustomList;

import java.util.*;

public
class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public
    CustomList () {
        this.values = new ArrayList<> ();
    }

    public
    void add (T element) {
        this.values.add (element);
    }

    public
    T remove (int index) {

        return this.values.remove (index);
    }


    public
    boolean contains (T element) {
        return this.values.contains (element);
    }

    public
    void swap (int index1, int index2) {

        Collections.swap (this.values, index1, index2);
    }

    public
    int getSize () {
        return this.values.size ();
    }

    public
    T getElement (int index) {
        return this.values.get (index);
    }

    public
    int countGreaterThan (T element) {
        return (int) this.values.stream ().filter (e -> e.compareTo (element) > 0).count ();
    }

    public
    T getMax () {
        return Collections.max (this.values);

    }

    public
    T getMin () {
        return Collections.min (this.values);
    }

    private
    void validateListNotEmpty () {
        if (this.values.isEmpty ()) {
            throw new IllegalStateException ("List is empty");
        }
    }

    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder ();
        for (T value : this.values) {
            sb.append (String.format ("%s%n", value));
        }
        return sb.toString ();
    }

    @Override
    public
    int hashCode () {
        return super.hashCode ();
    }

    public
    Iterator<T> iterator () {

        return new Iterator<> () {

            private int index = 0;

            @Override
            public
            boolean hasNext () {
                return index < values.size ();
            }

            @Override
            public
            T next () {
                T element = values.get (index);
                index++;
                return element;
            }
        };
    }


}


