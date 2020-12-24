import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class HandsOfCards {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Set<String>> players = new LinkedHashMap<> ();

        String input = scanner.nextLine ();

        while (!"JOKER".equals (input)) {

            String[] tokens = input.split (": ");
            String   name   = tokens[0];
            String[] cards  = tokens[1].split (", ");

            players.putIfAbsent (name, new HashSet<> ());
            players.get (name).addAll (Arrays.asList (cards.clone ()));

            input = scanner.nextLine ();
        }
        Pattern pattern = Pattern.compile ("(?<small>(?<digit>\\d+)(?<colour>[SHDC]))|(?<big>(?<bigCard>[JQKA])(?<bigColour>[SHDC]))");
        for (Map.Entry<String, Set<String>> player : players.entrySet ()) {
            int total = 0;

            for (String card : player.getValue ()) {
                Matcher matcher    = pattern.matcher (card);
                int     multiplier = 0;
                if (matcher.find ()) {
                    String smallCard = matcher.group ("small");
                    //String bigCard   = matcher.group ("big");
                    String colour = "";
                    int    digit  = 0;
                    if (smallCard != null) {
                        digit = Integer.parseInt (matcher.group ("digit"));
                        colour = matcher.group ("colour");
                    } else {
                        String bigString = matcher.group ("bigCard");
                        switch (bigString) {
                            case "J":
                                digit = 11;
                                break;
                            case "Q":
                                digit = 12;
                                break;
                            case "K":
                                digit = 13;
                                break;
                            case "A":
                                digit = 14;
                                break;
                        }
                        colour = matcher.group ("bigColour");
                    }
                    //S -> 4, H-> 3, D -> 2, C -> 1
                    switch (colour) {
                        case "S":
                            multiplier = 4;
                            break;
                        case "H":
                            multiplier = 3;
                            break;
                        case "D":
                            multiplier = 2;
                            break;
                        case "C":
                            multiplier = 1;
                            break;
                    }
                    total += digit * multiplier;
                }

            }
            System.out.printf ("%s: %d%n", player.getKey (),total);
        }

    }
}
