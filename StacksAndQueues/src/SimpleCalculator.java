import java.util.*;

public
class SimpleCalculator {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] inputs = scanner.nextLine ().split ("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<> ();

        Collections.addAll (stack,inputs);

        while (stack.size ()>1){

            int first = Integer.parseInt (stack.pop ());
            String operator = stack.pop ();
            int second = Integer.parseInt (stack.pop ());

            int result = operator.equals ("+") ?
                    first + second
                    :first - second;
            stack.push (String.valueOf (result));
        }

        System.out.println (stack.peek ());
    }
}
