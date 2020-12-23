import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class CountSymbols {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<Character,Integer> map = new TreeMap<> ();

        char[] listOfChars = scanner.nextLine ().toCharArray ();

        for (char c : listOfChars) {
            map.putIfAbsent (c,0);
            int newCount = map.get (c) + 1;
            map.put (c,newCount);
        }

        map.forEach ((key, value) -> System.out.printf ("%c: %d time/s%n", key, value));
    }
}
