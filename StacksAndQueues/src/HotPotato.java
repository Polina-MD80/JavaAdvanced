import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public
class HotPotato {
    public static
    void main (String[] args) {
        Scanner  scanner = new Scanner (System.in);
        String[] names   = scanner.nextLine ().split ("\\s+");
        int      n       = Integer.parseInt (scanner.nextLine ());

        ArrayDeque<String> queue = new ArrayDeque<> ();

        Collections.addAll (queue, names);
        while (queue.size () > 1) {
            for (int i = 1; i <= n; i++) {
                if (i != n) {
                    queue.offer (Objects.requireNonNull (queue.poll ()));
                } else {
                    System.out.println ("Removed " + queue.poll ());
                }
            }
        }

        System.out.println ("Last is " + queue.peek ());
    }
}
