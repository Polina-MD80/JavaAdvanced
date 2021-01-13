import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class SortEvenNumbers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String output = Arrays.stream (scanner.nextLine ().split (", "))
                .mapToInt (e -> Integer.parseInt (e))
                .filter (e -> e % 2 == 0)
                .mapToObj (e -> String.valueOf (e))
                .collect (Collectors.joining (", "));

        System.out.println (output);
        if (output.length () != 0) {
            String secondOutput = Arrays.stream (output.split (", "))
                    .mapToInt (Integer::parseInt)
                    .sorted ()
                    .boxed ()
                    .map (e -> "" + e)
                    .collect (Collectors.joining (", "));

            System.out.println (secondOutput);
        }
    }
}
