import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public
class PredicateParty {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> names = Arrays.stream (scanner.nextLine ().split ("\\s+")).collect (Collectors.toList ());
        String       command;


        while (!"Party!".equals (command = scanner.nextLine ())) {
            String[] tokens = command.split ("\\s+");
            BiPredicate<String, String> filter = checkForPredicate (tokens[1]);
            switch (tokens[0]) {
                case "Remove":
                     names = names.stream ().filter (n -> !filter.test (n, tokens[2])).collect (Collectors.toList ());
                     break;
                case "Double":
                    List<String> namesToAdd = names.stream ().filter ((n -> filter.test (n, tokens[2]))).collect (Collectors.toList ());
                    names.addAll (namesToAdd);
                    break;
            }

        }
        if (names.isEmpty ()){
            System.out.println ("Nobody is going to the party!");
        }else {
            System.out.print (names.stream ().sorted (String::compareTo).collect (Collectors.joining (", ")));
            System.out.println (" are going to the party!");
        }
    }

    private static
    BiPredicate<String, String> checkForPredicate (String act) {
        switch (act) {
            case "StartsWith":
                return String::startsWith;

            case "EndsWith":
                return String::endsWith;

            case "Length":
                return (string, n) -> string.length () == Integer.parseInt (n);

        }
        return null;
    }
}
