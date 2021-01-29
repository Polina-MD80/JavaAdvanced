package RawData;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public
class Main {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Car> cars = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine ().split ("\\s+");

            String model       = input[0];
            int    engineSpeed = Integer.parseInt (input[1]);
            int    enginePower = Integer.parseInt (input[2]);
            Engine engine      = new Engine (engineSpeed, enginePower);
            int    cargoWeight = Integer.parseInt (input[3]);
            String cargoType   = input[4];
            Cargo  cargo       = new Cargo (cargoWeight, cargoType);

            Car car = new Car (model, engine, cargo);
            for (int j = 5; j < input.length - 1; j+=2) {
                double pressure = Double.parseDouble (input[j]);
                int    age      = Integer.parseInt (input[j + 1]);
                Tire   tire     = new Tire (pressure, age);
                car.addTire (tire);
            }

            cars.add (car);

        }
        String command = scanner.nextLine ();

        switch (command){
            case "fragile":
                //Cargo Type is "fragile" with a tire whose pressure is  < 1

                Predicate<List<Tire>> predicate = tires -> {
                   boolean isLowOnPressure = false;
                    for (Tire tire : tires) {
                        if (tire.getPressure () < 1) {
                            isLowOnPressure = true;
                            break;
                        }
                    }
                    return isLowOnPressure;
                };

                cars.stream ().filter (car -> car.getCargo ().getTypeOfCargo ().equals ("fragile"))
                        .filter (car -> predicate.test (car.getTires ()))
                        .forEach (car -> System.out.println (car.getModel ()));
                break;

            case "flamable":
                //Cargo Type is "flamable" and have Engine Power > 250.
                cars.stream ().filter (car -> car.getCargo ().getTypeOfCargo ().equals ("flamable"))
                        .filter (car -> car.getEngine ().getEnginePower ()>250)
                        .forEach (car -> System.out.println (car.getModel ()));
                break;
        }


    }
}
