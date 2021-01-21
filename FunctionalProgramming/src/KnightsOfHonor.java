import java.util.Scanner;
import java.util.function.Consumer;

public
class KnightsOfHonor {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        Consumer <String[]> printer = names ->{
            for (String name : names) {
                System.out.println ("Sir " + name);
            }
        };

        String[] namesArray = scanner.nextLine ().split ("\\s+");

        printer.accept (namesArray);
    }
}
