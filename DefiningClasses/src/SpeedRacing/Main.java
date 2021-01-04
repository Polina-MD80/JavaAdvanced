package SpeedRacing;

import java.util.*;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());

        Map<String, Car> cars = new LinkedHashMap<> ();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble (tokens[1]);
            double consumption =Double.parseDouble (tokens[2]);
            Car car = new Car (model, fuel, consumption);
            cars.put (model,car);
        }
        String input = scanner.nextLine ();
        while (!"End".equals (input)){
            String[] command = input.split ("\\s+");
            String model = command[1];
            int distToDrive = Integer.parseInt (command[2]);
            Car carToDrive = cars.get (model);
            if (!carToDrive.drive(distToDrive)){
                System.out.println ("Insufficient fuel for the drive");
            }

            input = scanner.nextLine ();
        }
        cars.values ().forEach (System.out::println);
    }
}
