
import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public
class InfixToPostfix {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] tokens = scanner.nextLine ().split ("\\s+");

        ArrayDeque<String> queue = new ArrayDeque<> ();
        ArrayDeque<String> stack = new ArrayDeque<> ();

        List<String> signs = List.of ("+", "-", "/", "*");

        for (int i = 0; i < tokens.length; i++) {
            String currant = tokens[i];
            if (!signs.contains (currant)) {
                if (currant.equals (")")) {
                    String poppedElement = stack.pop ();
                    while (!stack.isEmpty ()) {
                        if (!poppedElement.equals ("(")) {
                            queue.offer (poppedElement);
                            poppedElement = stack.pop ();
                        } else break;
                    }
                } else if (currant.equals ("(")){
                    stack.push (currant);

                }else {
                    queue.offer (currant);
                }
            } else {
                while (!stack.isEmpty ()) {
                    String lastElement = stack.peek ();
                    if (signs.indexOf (lastElement) >= signs.indexOf (currant)) {
                        queue.offer (stack.pop ());
                    }else break;
                }

                stack.push (currant);

            }

        }
        while (!stack.isEmpty ()) {
            queue.offer (stack.pop ());
        }
        while (!queue.isEmpty ()) {
            System.out.print (queue.poll () + " ");
        }

    }
}
