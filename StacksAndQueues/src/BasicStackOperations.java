import java.util.ArrayDeque;
import java.util.Scanner;

public
class BasicStackOperations {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     N       = scanner.nextInt ();
        int     S       = scanner.nextInt ();
        int     X       = scanner.nextInt ();

        ArrayDeque<Integer> stack = new ArrayDeque<> ();

        for (int i = 0; i < N; i++) {
            stack.push (scanner.nextInt ());
        }
        for (int i = 0; i < S; i++) {
            stack.pop ();
        }
        if (!stack.isEmpty ()) {
            if (stack.contains (X)) {
                System.out.println ("true");
            } else {
                System.out.println (stack.stream ().min (Integer::compareTo).orElseThrow ());
            }
        }else {
            System.out.println ("0");
        }
    }
}
