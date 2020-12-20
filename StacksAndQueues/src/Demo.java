import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public
class Demo {
    public static
    void main (String[] args) {
        System.out.println (Integer.BYTES);
        int[] nums = new int[10];
        System.out.println (nums.length * Integer.BYTES);

        //Stack<Integer> stack = new Stack<> ();
        ArrayDeque<Integer> stack = new ArrayDeque<> ();
        stack.push (13);
        stack.push (11);
        stack.push (7);
        /*System.out.println (stack.size ());
        System.out.println (stack.peek ());
        System.out.println (stack.size ());
        System.out.println (stack.pop ());
        System.out.println (stack.size ());*/
        while (!stack.isEmpty ()){
            System.out.println (stack.pop ());

        }
        int[] arr = new int[2];
        System.out.println (arr[0]);

    }
}
