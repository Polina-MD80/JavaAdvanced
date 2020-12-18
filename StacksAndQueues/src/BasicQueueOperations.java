import java.util.ArrayDeque;
import java.util.Scanner;

public
class BasicQueueOperations {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int     N       = scanner.nextInt ();
        int     S       = scanner.nextInt ();
        int     X       = scanner.nextInt ();

        ArrayDeque<Integer> queue = new ArrayDeque<> ();

        for (int i = 0; i < N; i++) {
            queue.offer (scanner.nextInt ());
        }
        for (int i = 0; i < S; i++) {
            queue.poll ();
        }
        if (queue.isEmpty ()){
            System.out.println ("0");
        }else {
            if (queue.contains (X)){
                System.out.println ("true");
            }else {
                System.out.println (queue.stream ().min (Integer::compare).orElseThrow ());
            }
        }
    }
}
