import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public
class AppliedArithmetic {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        Consumer<List<Integer>> printer = numList -> {
            for (Integer number : numList) {
                System.out.print (number + " ");
            }
        };
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split ("\\s+")).map (Integer::parseInt)
                .collect (Collectors.toList ());
        String command;
        while (!"end".equals (command = scanner.nextLine ())) {
            if ("print".equals (command)) {
                printer.accept (numbers);
                System.out.println ();
            } else {
                Function<List<Integer>, List<Integer>> function = modifyList (command);
                numbers = function.apply (numbers);
            }
        }

    }

    private static
    Function<List<Integer>, List<Integer>> modifyList (String command) {
        if (command.equals ("add")) {
            return numList -> numList.stream ().map (e -> e + 1).collect (Collectors.toList ());
        } else if (command.equals ("multiply")) {
            return numList -> numList.stream ().map (e -> e * 2).collect (Collectors.toList ());
        } else if (command.equals ("subtract")) {
            return numList -> numList.stream ().map (e -> e - 1).collect (Collectors.toList ());
        }
        return numList -> numList;

    }


}
