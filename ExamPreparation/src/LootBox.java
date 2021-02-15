import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public
class LootBox {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayDeque<Integer> firstQueue = new ArrayDeque<> ();
        ArrayDeque<Integer> secondStack = new ArrayDeque<> ();

        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (firstQueue::offer);
        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (secondStack::push);

        int lootValue = 0;

        while (!firstQueue.isEmpty ()&&!secondStack.isEmpty ()){
            int currantFirst = firstQueue.peek ();
            int currantSecond = secondStack.peek ();

            int currantSum = currantFirst+currantSecond;

            if (currantSum%2!=0){
                firstQueue.offer (secondStack.pop ());
            }else {
                lootValue+= currantSum;
                firstQueue.poll ();
                secondStack.pop ();
            }
        }
        if (firstQueue.isEmpty ()){
            System.out.println ("First lootbox is empty");
        }else {
            System.out.println ("Second lootbox is empty");
        }

        if (lootValue>=100){
            System.out.printf ("Your loot was epic! Value: %d", lootValue);
        }else {
            System.out.printf ("Your loot was poor... Value: %d", lootValue);
        }
    }
}
