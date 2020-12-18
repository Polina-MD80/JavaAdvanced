import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public
class BalancedParentheses {
    public static
    void main (String[] args) {
        Scanner scanner     = new Scanner (System.in);
        String parentheses = scanner.nextLine ();

        if (parentheses.length() % 2 != 0||parentheses.length()==0) {
            System.out.println ("NO");
            return;
        }
        ArrayDeque<Character> stack = new ArrayDeque<> ();
        ArrayDeque<Character> queue = new ArrayDeque<> ();

        for (int i = 0; i < parentheses.length()/ 2; i++) {
            queue.offer (parentheses.charAt (i));
        }
        for (int i = parentheses.length()/ 2; i < parentheses.length(); i++) {
            stack.push (parentheses.charAt (i));
        }
        while (!stack.isEmpty ()&&!queue.isEmpty ()) {
            switch (stack.pop ()) {
                case ')':
                    if (queue.poll () != '(') {
                        System.out.println ("NO");
                        return;
                    }
                    break;
                case '}':
                    if (queue.poll () != '{') {
                        System.out.println ("NO");
                        return;
                    }
                    break;
                case ']':
                    if (queue.poll () != '[') {
                        System.out.println ("NO");
                        return;
                    }
                    break;
                    default:
                        System.out.println ("NO");return;

            }
        }
        System.out.println ("YES");

    }
}
