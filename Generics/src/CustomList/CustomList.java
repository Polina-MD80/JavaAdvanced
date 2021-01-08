package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public
class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public
    CustomList () {
        this.values = new ArrayList<> ();
    }

    //•	void add(T element)
    //•	T remove(int index)
    //•	boolean contains(T element)
    //•	void swap(int index, int index)
    //•	int countGreaterThan(T element)
    //•	T getMax()
    //•	T getMin()
    public
    void add (T element) {
        this.values.add (element);
    }

    public
    T remove (int index) {
        validateIndex (index);

        return this.values.remove (index);

    }

    private
    void validateIndex (int index) {
        if (index < 0 || index >= this.values.size ()) {
            throw new IndexOutOfBoundsException ("Invalid Index");
        }
    }

    public
    boolean contains (T element) {
        return this.values.contains (element);
    }

    public
    void swap (int index1, int index2) {
        validateIndex (index1);
        validateIndex (index2);
        Collections.swap (this.values, index1, index2);
//        T temp = this.values.get (index1);
//        this.values.set (index1,this.values.get (index2));
//        this.values.set (index2,temp);
    }
    public int getSize(){
        return this.values.size ();
    }
    public T getElement(int index){
        return this.values.get (index);
    }

    public
    int countGreaterThan (T element) {
        return (int) this.values.stream ().filter (e -> e.compareTo (element) > 0).count ();
    }

    public
    T getMax () {
        //return Collections.max (this.values);
        validateListNotEmpty ();
        T max = this.values.get (0);
        for (T value : this.values) {
            if (max.compareTo (value) < 0) {
                max = value;
            }
        }
        return max;
    }
    public
    T getMin () {
        //return Collections.max (this.values);
        validateListNotEmpty ();
        T min = this.values.get (0);
        for (T value : this.values) {
            if (min.compareTo (value) > 0) {
                min = value;
            }
        }
        return min;
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
            sb.append (String.format ("%s%n",value));
        }
        return sb.toString ();
    }
}
