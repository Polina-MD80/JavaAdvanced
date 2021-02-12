package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner     scanner     = new Scanner (System.in);
        CustomStack customStack = new CustomStack ();
        String command = scanner.nextLine ();

        while (!command.equals ("END")){
            String[] tokens = command.split ("\\s+",2);

            switch (tokens[0]){
                case "Push":
                    int[] numbers = Arrays.stream (tokens[1].trim ().split (", ")).mapToInt (Integer::parseInt).toArray ();
                    for (int i = 0; i < numbers.length; i++) {
                        customStack.push (numbers[i]);
                    }break;
                case "Pop":
                    customStack.pop ();
            }

            command = scanner.nextLine ();
        }
        customStack.iterator ().forEachRemaining (System.out::println);
        customStack.iterator ().forEachRemaining (System.out::println);


    }
}
