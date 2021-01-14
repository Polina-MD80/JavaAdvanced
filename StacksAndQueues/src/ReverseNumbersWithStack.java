import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class ReverseNumbersWithStack {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt)
                .forEach (stack::push);

        while (!stack.isEmpty ()){
            System.out.print (stack.pop ()+ " ");
        }
    }
}
