import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
            Predicate<String> check = name -> {
                switch (tokens[0]){
                    case "Remove":
                        if (tokens[1].equals ("StartsWith")){
                            if (name.startsWith (tokens[2])){
                                return false;
                            }
                        }else {
                            if (name.endsWith (tokens[2])){
                                return false;
                            }
                        }
                        break;
                    case "Double":

                        break;
                }
                return true;
            };

            List<String> collect = names.stream ().filter (check).collect (Collectors.toList ());
            System.out.println ();
        }
    }
}
