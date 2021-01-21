import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public
class ConsumerPrint {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Consumer<List<String>> printer = names -> {
            for (String name : names) {
                System.out.println (name);
            }
        };
        List <String> namesList = Arrays.stream (scanner.nextLine ().split ("\\s+")).collect(Collectors.toList());

        printer.accept (namesList);
    }
}
