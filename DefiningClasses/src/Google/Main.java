package Google;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine ();

        Map<String, Person> people = new HashMap<> ();
        while (!"End".equals (input)) {
            String[] tokens     = input.split ("\\s+", 3);
            String   personName = tokens[0];
            String   object     = tokens[1];
            String   objectName = tokens[2];
            people.putIfAbsent (personName, new Person (personName));
            switch (object) {
                case "company":
                    String[] companyDetails = objectName.split ("\\s+");
                    people.get (personName).setCompany (companyDetails[0]);
                    people.get (personName).setCompanyDepartment (companyDetails[1]);
                    people.get (personName).setSalary (Double.parseDouble (companyDetails[2]));
                    break;
                case "car":
                    people.get (personName).setCar (objectName);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon (objectName);
                    people.get (personName).getPokemonList ().add (pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent (objectName);
                    people.get (personName).getParentsList ().add (parent);
                    break;
                case "children":
                    Child child = new Child (objectName);
                    people.get (personName).getChildrenList ().add (child);
                    break;
            }
            input = scanner.nextLine ();
        }
       input = scanner.nextLine ();
        //•	"<Name> company <companyName> <department> <salary>"
        //•	"<Name> pokemon <pokemonName> <pokemonType>"
        //•	"<Name> parents <parentName> <parentBirthday>"
        //•	"<Name> children <childName> <childBirthday>"
        //•	"<Name> car <carModel> <carSpeed>"

        System.out.println (input);
        System.out.println ("Company:");
        if (people.get (input).company!=null){
            System.out.printf ("%s %s %.2f%n", people.get (input).company,people.get (input).companyDepartment, people.get (input).salary );
        }
        System.out.println ("Car:");
        if (people.get (input).car!=null){
            System.out.println (people.get (input).car);
        }
        System.out.println ("Pokemon:");
        if (!people.get (input).getPokemonList ().isEmpty ()){
            for (Pokemon pokemon : people.get (input).getPokemonList ()) {
                System.out.println (pokemon.getPokemonName ());
            }
        }
        System.out.println ("Parents:");
        if (!people.get (input).getParentsList ().isEmpty ()){
            for (Parent parent : people.get (input).getParentsList ()) {
                System.out.println (parent.getParentName ());
            }

        }
        System.out.println ("Children:");
        if (!people.get (input).getChildrenList ().isEmpty ()){
            for (Child child : people.get (input).getChildrenList ()) {
                System.out.println (child.getChildName ());
            }

        }

    }
}
