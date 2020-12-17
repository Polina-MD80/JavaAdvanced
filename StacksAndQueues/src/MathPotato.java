import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public
class MathPotato {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] names   = scanner.nextLine ().split ("\\s+");
        int      n       = Integer.parseInt (scanner.nextLine ());

        ArrayDeque<String> queue = new ArrayDeque<> ();

        Collections.addAll (queue, names);

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(Objects.requireNonNull (queue.poll ()));

            if (isPrime(cycle))
                System.out.println("Prime " + queue.peek());
            else
                System.out.println("Removed " + queue.poll());

            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static
    boolean isPrime (int cycle) {
        if (cycle==1){
            return false;
        }
        for (int n = 2; n <= cycle/2; n++) {
            if (cycle%n==0){
                return false;
            }
        }
        return true;
    }
}
