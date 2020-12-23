import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public
class SetsOfElements {
    public static
    void main (String[] args) {
        Scanner     scanner   = new Scanner (System.in);
        Set<String> elementsN = new LinkedHashSet<> ();
        Set<String> elementsM = new HashSet<> ();

        int n = scanner.nextInt ();
        int m = scanner.nextInt ();
        scanner.nextLine ();

        for (int i = 0; i < n; i++) {
            elementsN.add (scanner.nextLine ());
        }
        int o = elementsN.size ();
        for (int i = 0; i < m; i++) {
            elementsM.add (scanner.nextLine ());
        }
        for (int i = 0; i < o; i++) {
            String number = elementsN.iterator ().next ();
            elementsN.remove (number);
            if (elementsM.contains (number)) {
                elementsN.add (number);
            }
        }

        elementsN.forEach (e-> System.out.print (e+" "));
    }
}
