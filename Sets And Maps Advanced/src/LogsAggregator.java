import java.util.*;

public
class LogsAggregator {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer>      times     = new HashMap<> ();
        Map<String, Set<String>> addresses = new TreeMap<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] user = scanner.nextLine ().split ("\\s+");
            String   iP   = user[0];
            String   name = user[1];
            int      time = Integer.parseInt (user[2]);

            times.putIfAbsent (name, 0);
            times.put (name, times.get (name) + time);

            addresses.putIfAbsent (name, new TreeSet<> ());
            addresses.get (name).add (iP);

        }
        for (Map.Entry<String, Set<String>> name : addresses.entrySet ()) {
            for (Map.Entry<String, Integer> name2 : times.entrySet ()) {
                if (name.getKey ().equals(name2.getKey ())){
                    System.out.printf ("%s: %d %s%n", name.getKey (), name2.getValue (), name.getValue ().toString ());
                }
            }

        }

    }
}
