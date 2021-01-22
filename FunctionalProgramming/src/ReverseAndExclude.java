import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public
class ReverseAndExclude {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());
        Integer                       n      = Integer.parseInt (scanner.nextLine ());
        BiFunction<Integer,Integer, Integer> divide = (a,b) -> a%b;
        Predicate<Integer> checkIfDivisible = num -> divide.apply (num,n)!=0;
        Consumer<List<Integer>> printer = nums-> nums.forEach (num-> System.out.print (num+" "));

        numbers = numbers.stream ().filter (checkIfDivisible).collect (Collectors.toList ());
        Collections.reverse (numbers);
        printer.accept (numbers);
    }
}
