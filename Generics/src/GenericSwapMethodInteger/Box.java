package GenericSwapMethodInteger;


import java.util.ArrayList;
import java.util.List;

public
class Box<T>{
    private final
    List<T> elements;

    public Box(){
        elements = new ArrayList<> ();
    }
    public void addElement(T element){
        this.elements.add (element);
    }

    public void swap(int[] command){
        T tempo = this.elements.get (command[0]);
        this.elements.set (command[0], this.elements.get (command[1]));
        this.elements.set (command[1],tempo);
    }

    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder ();
        for (T element : elements) {
            sb.append (String.format ("%s: %d%n", element.getClass ().getName (),element));
        }
        return sb.toString ();
    }

}