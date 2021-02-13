import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public
class Scheduling {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<> ();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<> ();

        Arrays.stream (scanner.nextLine ().split (", ")).mapToInt (Integer::parseInt).forEach (taskStack::push);
        Arrays.stream (scanner.nextLine ().split (" ")).mapToInt (Integer::parseInt).forEach (threadQueue::offer);

        int targetTask = Integer.parseInt (scanner.nextLine ());



        while (true){
            int currantTask = taskStack.peek ();
            int currantThread = threadQueue.peek ();

            if (currantTask==targetTask){
                System.out.printf ("Thread with value %d killed task %d%n", currantThread,currantTask);
                printThreads(threadQueue);return;
            }else if (currantThread >= currantTask){
                taskStack.pop ();
                threadQueue.poll ();
            }else {
                threadQueue.poll ();
            }
        }
    }

    private static
    void printThreads (ArrayDeque<Integer> threadQueue) {
        StringBuilder sb = new StringBuilder ();
        while (!threadQueue.isEmpty ()){
            sb.append (threadQueue.poll ()).append (" ");
        }
        System.out.println (sb.toString ().trim ());
    }
}
