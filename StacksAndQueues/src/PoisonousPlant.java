import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public
class PoisonousPlant {
    public static
    void main (String[] args) {
        Scanner             scanner     = new Scanner (System.in);
        ArrayDeque<Integer> gardenStack = new ArrayDeque<> ();

        int gardenSize = Integer.parseInt (scanner.nextLine ());

        Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt)
                .forEach (gardenStack::push);

        ArrayDeque<Integer> helpStack = new ArrayDeque<> ();
        int                 days      = 0;
        while (true) {
            while (!gardenStack.isEmpty ()) {
                int currant = gardenStack.pop ();
                if (gardenStack.isEmpty ()) {
                    helpStack.push (currant);
                } else {
                    int next = gardenStack.peek ();
                    if (currant < next) {
                        helpStack.push (currant);
                    }

                }
            }
            days++;
            while (!helpStack.isEmpty ()) {
                gardenStack.push (helpStack.pop ());
            }
            if (gardenSize==gardenStack.size ()){
                days--;
                break;
            }else {
                gardenSize = gardenStack.size ();
            }
        }
        System.out.println (days);

    }
}
