import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public
class ThePartyReservationFilterModule {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> names = Arrays.stream (scanner.nextLine ().split ("\\s+")).collect(Collectors.toList());
        List<String> copyOfNames = names;
        Map<String, List<String>> removedNames = new HashMap<> ();

        String command;

        while (!"Print".equals (command = scanner.nextLine ())){
            String[] tokens = command.split (";");

            BiPredicate<String,String> predicate = findNames(tokens[1]);

            switch (tokens[0]){
                case "Add filter":
                    String key = tokens[1] + tokens[2];
                    removedNames.put (key,new ArrayList<> ());

                    removedNames.get (key).addAll (names.stream ().filter (n-> predicate.test (n,tokens[2])).collect(Collectors.toList()));
                    names = names.stream ().filter (n->!predicate.test (n,tokens[2])).collect(Collectors.toList());

                    break;
                case "Remove filter":
                    String keyToReturn = tokens[1] + tokens[2];
                    for (Map.Entry<String, List<String>> entry : removedNames.entrySet ()) {
                        if (entry.getKey ().equals (keyToReturn)){
                            names.addAll (entry.getValue ());
                        }
                    }
                    removedNames.remove (keyToReturn);

                    break;
            }

        }


       BiPredicate<List<String>, String> order = List::contains;
        List<String>finalNames = names;
        copyOfNames.stream ().filter (name->order.test (finalNames, name)).forEach (n-> System.out.print (n + " "));
    }

    private static
    BiPredicate<String, String> findNames (String startOrEnd) {
        switch (startOrEnd){
            case "Starts with": return String::startsWith;
            case "Ends with": return String::endsWith;
            case "Length": return (string, n) -> string.length () == Integer.parseInt (n);
            case "Contains": return String::contains;
        }

        return null;
    }
}
