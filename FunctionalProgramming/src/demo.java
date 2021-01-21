import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public
class demo {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        Consumer<int[]> printer = numList -> {
            for (Integer number : numList) {
                System.out.print (number + " ");
            }
        };
        int[] numbers = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        Function<int[], int[]> function = numList -> Arrays.stream (numList).map (e ->  e += 1).toArray ();
        numbers = function.apply (numbers);
        printer.accept (numbers);
    }
}
