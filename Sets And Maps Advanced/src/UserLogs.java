import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class UserLogs {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<> ();

        String input;

        while (!"end".equals (input = scanner.nextLine ())){
            String[] tokens = input.split ("\\s+");
            String userName = tokens[2].substring (5);
            String iP = tokens[0].substring (3);

            users.putIfAbsent (userName, new LinkedHashMap<> ());
            users.get (userName).putIfAbsent (iP,0);
            int count = users.get (userName).get (iP) + 1;
            users.get (userName).put (iP,count);
        }
        users.entrySet ().forEach (u ->{
            System.out.println (u.getKey () + ": ");
            StringBuilder sb = new StringBuilder ();
            u.getValue ().entrySet ().forEach (ip -> {
                sb.append (ip.getKey ()).append (" => ").append (ip.getValue ()).append (", ");

            });
            System.out.println (sb.substring (0,sb.length ()-2) + ".");
        });
    }
}
