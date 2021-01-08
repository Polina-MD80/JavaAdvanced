package GenericCountMethodString;

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
    /*public void swap(int[] command){
        T tempo = this.values.get (command[0]);
        this.values.set (command[0], this.values.get (command[1]));
        this.values.set (command[1],tempo);
    }*/

    public int countGrater(T element){

        int count = (int) this.values.stream ().filter (e -> e.compareTo (element) > 0).count ();
        return count;
    }



    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder ();
        for (T value : this.values) {
            sb.append (String.format ("%s: %s%n", value.getClass ().getName (),value));
        }
        return sb.toString ();
    }
}
