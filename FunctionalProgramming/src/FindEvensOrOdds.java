import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public
class FindEvensOrOdds {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[]  numbers  = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        String criteria = scanner.nextLine ();

        Predicate<Integer> filtration = getFilteredIntegers (criteria);
        Consumer<Integer> printNum = p-> System.out.print (p + " ");
        IntStream.range (numbers[0],numbers[1] + 1).boxed ().filter (filtration)
                .forEach (printNum);
    }

    private static
    Predicate<Integer> getFilteredIntegers (String criteria) {
        if (criteria.equals ("even")) {
            return n -> n % 2 == 0;
        } else {
            return n -> n % 2 != 0;
        }
    }
}
