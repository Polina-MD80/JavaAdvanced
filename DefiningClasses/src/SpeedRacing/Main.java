package SpeedRacing;

import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble (tokens[1]);
            double consumption =Double.parseDouble (tokens[2]);

        }
    }
}
