import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class PopulationCounter {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Map<String,Long>> countries = new LinkedHashMap<> ();

        String input;
        while (!"report".equals (input = scanner.nextLine ())){
            String[] tokens = input.split ("\\|");

            String country = tokens[1];
            String city = tokens[0];
            long population = Integer.parseInt (tokens[2]);

            countries.putIfAbsent (country, new LinkedHashMap<> ());
            countries.get (country).put (city,population);

        }
        countries.entrySet ().stream ().sorted ((country1,country2)->
                Long.compare (getTotalPopulation(country2.getValue ()),getTotalPopulation(country1.getValue ())))
                .forEach (country->{
                    System.out.printf ("%s (total population: %d)%n", country.getKey (),getTotalPopulation (country.getValue ()));
                    country.getValue ().entrySet ()
                            .stream().sorted ((c1,c2)-> (int) (c2.getValue () - c1.getValue ()))
                            .forEach (city-> System.out.printf ("=>%s: %d%n",city.getKey (),city.getValue ()));

                });

    }

    private static
    long getTotalPopulation (Map<String, Long> cities) {
        long sum = 0;
        for (Map.Entry<String, Long> city : cities.entrySet ()) {
            sum += city.getValue ();
        }
        return sum;
    }
}
