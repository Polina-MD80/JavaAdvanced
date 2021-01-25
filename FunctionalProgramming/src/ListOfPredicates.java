import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public
class ListOfPredicates {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int number = Integer.parseInt (scanner.nextLine ());
        int[] dividers = Arrays.stream(scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();

        Predicate<Integer> divisible = n -> {
            boolean isDivisible = true;
            for (int divider : dividers) {
                if (n % divider != 0) {
                    isDivisible = false;
                    break;
                }
            }
            return isDivisible;
        };

         IntStream.range (1, number + 1).boxed ().filter ( divisible).forEach (e-> System.out.print (e+ " "));



    }
}
