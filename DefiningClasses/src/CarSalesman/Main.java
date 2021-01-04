package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Engine> engines = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            Engine   engine;
            String[] engInfo     = scanner.nextLine ().split ("\\s+");
            String   engineModel = engInfo[0];
            String   power       = engInfo[1];
            if (engInfo.length == 2) {
                engine = new Engine (engineModel, power);
            } else if (engInfo.length == 4) {
                engine = new Engine (engInfo[0], engInfo[1], engInfo[2], engInfo[3]);
            } else {
                try {
                    int checkInt = Integer.parseInt (engInfo[2]);
                    engine = new Engine (engineModel, power, engInfo[2]);
                } catch (NumberFormatException e) {
                    engine = new Engine (engineModel, power);
                    engine.setEfficiency (engInfo[2]);
                }
            }
            engines.add (engine);
        }
        n = Integer.parseInt (scanner.nextLine ());
        List<Car> cars = new ArrayList<> ();
        for (int i = 0; i < n; i++) {
            Car      car;
            String[] carInfo   = scanner.nextLine ().split ("\\s+");
            String   carModel  = carInfo[0];
            String   carEngine = carInfo[1];
            if (carInfo.length == 2) {
                car = new Car (carModel, carEngine);
            } else if (carInfo.length == 4) {
                car = new Car (carModel, carEngine, carInfo[2], carInfo[3]);
            }else {
                try {
                    int checkCarWeight = Integer.parseInt (carInfo[2]);
                    car = new Car (carModel,carEngine,carInfo[2]);
                }catch (NumberFormatException e){
                    car = new Car (carModel,carEngine);
                    car.setColour (carInfo[2]);
                }
            }
            cars.add (car);
        }
        cars.stream ().forEach (car -> {
            System.out.println (car.getCarModel ()+":");
            engines.stream ().forEach (engine -> {
            if (engine.getEngineModel ().equals (car.getCarEngine ())){
                System.out.println (engine);
            }
        });
            //Weight: <CarWeight>
            //Color: <CarColor>
            System.out.println ("Weight: " + car.getWeight ());
            System.out.println ("Color: " + car.getColour ());

        });
    }
}
