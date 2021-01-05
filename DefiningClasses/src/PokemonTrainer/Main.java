package PokemonTrainer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<> ();
        // "<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>"

        String input = scanner.nextLine ();

        while (!"Tournament".equals (input)) {
            String[] tokens      = input.split ("\\s+");
            String   trainerName = tokens[0];
            String   pokemonName = tokens[1];
            String   element     = tokens[2];
            int      health      = Integer.parseInt (tokens[3]);
            Pokemon  pokemon     = new Pokemon (pokemonName, element, health);
            if (!trainers.containsKey (trainerName)) {
                trainers.put (trainerName, new Trainer (trainerName));
            }
            trainers.get (trainerName).getPokemonList ().add (pokemon);

            input = scanner.nextLine ();
        }
        input = scanner.nextLine ();

        while (!"End".equals (input)) {


            for (Map.Entry<String, Trainer> trainerEntry : trainers.entrySet ()) {
                boolean isPresent = false;
                for (Pokemon pokemon : trainerEntry.getValue ().getPokemonList ()) {
                    if (pokemon.getElement ().equals (input)) {
                        isPresent = true;
                        trainerEntry.getValue ().addBadge (trainerEntry.getValue ().badges);
                        break;
                    }
                }
                if (!isPresent) {
                    trainerEntry.getValue ().getPokemonList ().forEach (pokemon -> pokemon.loseTenHealth (pokemon.getHealth ()));
                    trainerEntry.getValue ().getPokemonList ().removeIf (pokemon -> pokemon.getHealth () <= 0);
                }
            }


            input = scanner.nextLine ();
        }
        trainers.values ()
                .stream().sorted ((t1,t2)->Integer.compare (t2.badges,t1.badges))
                .forEach (t -> System.out.printf ("%s %d %d%n", t.getTrainerName (),t.badges, t.getPokemonList ().size ()));

    }
}
