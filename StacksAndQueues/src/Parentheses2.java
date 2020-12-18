import java.util.ArrayDeque;
import java.util.Scanner;

public
class Parentheses2 {
    public static
    void main (String[] args) {
        Scanner               scanner    = new Scanner (System.in);
        String                line       = scanner.nextLine ();
        boolean               isBalanced = true;
        ArrayDeque<Character> stack      = new ArrayDeque<> ();


        for (int i = 0; i < line.length (); i++) {
            if (line.charAt (i) == '[' || line.charAt (i) == '{' || line.charAt (i) == '(') {
                stack.push (line.charAt (i));
            } else {
                if (stack.isEmpty ()) {
                    isBalanced = false;
                    break;
                }
                char currant = line.charAt (i);
                if (currant=='}'&&stack.pop ()!='{'){
                    isBalanced = false;break;
                }else if (currant==']'&&stack.pop ()!='['){
                    isBalanced = false;break;
                }else if (currant==')'&&stack.pop ()!='('){
                    isBalanced = false;break;
                }
            }
        }

        if (!isBalanced) {
            System.out.println ("NO");
        } else {
            System.out.println ("YES");
        }
    }
}
