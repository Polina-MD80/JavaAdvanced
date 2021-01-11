package Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int[] stoneNumbers = Arrays.stream (scanner.nextLine ().split (", "))
                .mapToInt (Integer::parseInt).toArray ();
        String end = scanner.nextLine ();

         Lake lake = new Lake (stoneNumbers);

         StringBuilder sb = new StringBuilder ();
        for (Integer integer : lake) {
            sb.append (integer).append (", ");
        }

        System.out.println (sb.substring (0, sb.length ()-2));
    }
}
