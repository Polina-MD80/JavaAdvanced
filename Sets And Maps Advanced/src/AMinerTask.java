import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class AMinerTask {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer> collection = new LinkedHashMap<> ();
        String input = scanner.nextLine ();
        while (!"stop".equals (input)){
            collection.putIfAbsent (input,0);
            int amount = scanner.nextInt ();
            scanner.nextLine ();

            collection.put (input,collection.get (input)+amount);

            input = scanner.nextLine ();
        }
        collection.forEach ((key, value) -> System.out.printf ("%s -> %d%n", key, value));

    }
}
