package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public
class Box <T extends Comparable<T>>{
    private List<T> values;
    public Box(){
        this.values = new ArrayList<> ();
    }
    public void addElement (T element){
        this.values.add (element);
    }
    public int countGrater(T element){

        int count = (int) this.values.stream ().filter (e -> e.compareTo (element) > 0).count ();
        return count;
    }

}
