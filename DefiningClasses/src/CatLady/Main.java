package CatLady;

import java.util.*;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String           input = scanner.nextLine ();
        Map<String, Cat> cats  = new HashMap<> ();
        while (!"End".equals (input)) {
            String[] tokens      = input.split ("\\s+");
            String   breed       = tokens[0];
            String   name        = tokens[1];
            double      measurement = Double.parseDouble (tokens[2]);


            switch (breed) {
                case "Siamese":
                    Siamese siamese = new Siamese (breed, name, measurement);
                    cats.put (name, siamese);
                    break;

                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire (breed, name, measurement);
                    cats.put (name, streetExtraordinaire);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric (breed, name, measurement);
                    cats.put (name, cymric);
                    break;
            }

            input = scanner.nextLine ();
        }

        String catToPrint = scanner.nextLine();

        System.out.println (cats.get (catToPrint));

    }
}
