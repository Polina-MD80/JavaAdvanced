import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public
class PeriodicTable {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());

        Set<String> elements = new TreeSet<> ();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine ().split ("\\s+");
            for (int j = 0; j < line.length; j++) {
                elements.add (line[j]);
            }
        }
        elements.forEach (e-> System.out.print (e+" "));
    }
}
