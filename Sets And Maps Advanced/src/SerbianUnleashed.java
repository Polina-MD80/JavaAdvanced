import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class SerbianUnleashed {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Map<String, Integer>> places = new LinkedHashMap<> ();

        Pattern pattern = Pattern.compile ("^(?<name>([A-z]+[\\s]){1,3})@(?<place>([A-z]+[\\s]){1,3})(?<price>\\d+)[\\s](?<count>\\d+)$");
        String input;
        while (!"End".equals (input = scanner.nextLine ())){
            Matcher matcher = pattern.matcher (input);
            if (matcher.find ()){
                String name = matcher.group ("name");
                String place = matcher.group ("place");
                int price = Integer.parseInt (matcher.group ("price"));
                int count = Integer.parseInt (matcher.group ("count"));
                int sum = price * count;

                places.putIfAbsent (place, new LinkedHashMap<> ());
                places.get (place).putIfAbsent (name, 0);
                int newSum = places.get (place).get (name) + sum;
                places.get (place).put (name, newSum);

            }
        }
        places.entrySet ().forEach (place->{
            System.out.println (place.getKey ().trim ());
            place.getValue ().entrySet ().stream().sorted ((s1,s2)-> Integer.compare (s2.getValue (),s1.getValue ()))
                    .forEach (s -> System.out.printf ("#  %s -> %d%n", s.getKey ().trim (), s.getValue ()));
        });
    }
}
