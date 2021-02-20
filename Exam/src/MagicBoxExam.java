import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public
class MagicBoxExam {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayDeque<Integer> firstQueue = new ArrayDeque<> ();
        ArrayDeque<Integer> secondStack = new ArrayDeque<> ();

        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (firstQueue::offer);
        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (secondStack::push);

        int value = 0;

        while (!firstQueue.isEmpty ()&&!secondStack.isEmpty ()){
            int currantFirst = firstQueue.peek ();
            int currantSecond = secondStack.peek ();

            int currantSum = currantFirst+currantSecond;

            if (currantSum%2!=0){
                firstQueue.offer (secondStack.pop ());
            }else {
                value+= currantSum;
                firstQueue.poll ();
                secondStack.pop ();
            }
        }
        if (firstQueue.isEmpty ()){
            System.out.println ("First magic box is empty.");
        }else {
            System.out.println ("Second magic box is empty.");
        }

        if (value>=90){
            System.out.printf ("Wow, your prey was epic! Value: %d", value);
        }else {
            System.out.printf ("Poor prey... Value: %d", value);
        }
    }
}
