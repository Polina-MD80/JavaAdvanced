package GenericSwapMethodString;
import java.util.ArrayList;
import java.util.List;

public
class Box<T>{
    private List<T> values;

    public Box(){
        values = new ArrayList<> ();
    }
    public void addElement (T element){
        this.values.add (element);
    }

    public void swap(int[] command){
        T tempo = this.values.get (command[0]);
        this.values.set (command[0], this.values.get (command[1]));
        this.values.set (command[1],tempo);
    }
    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder ();
        for (T value : values) {
            sb.append (String.format ("%s: %s%n", value.getClass ().getName (),value));
        }
        return sb.toString ();
    }
}
