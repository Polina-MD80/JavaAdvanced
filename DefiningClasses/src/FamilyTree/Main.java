package FamilyTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<Person,Tree> people = new HashMap<> ();

        String personInput = scanner.nextLine ();
        Person heartPerson = new Person ();

        createPerson (personInput, heartPerson);
        Tree tree = new Tree (heartPerson);

        people.put (heartPerson,tree);

        while (!"End".equals (personInput = scanner.nextLine ())){
            if (personInput.contains ("-")){
                String[] tokens = personInput.split (" - ");
                Person personParent = new Person ();
                Person personChild = new Person ();
                createPerson (tokens[0],personParent);
                createPerson (tokens[1],personChild);

            }
        }


    }

    private static
    void createPerson (String personInput, Person heartPerson) {
        if (Character.isDigit (personInput.charAt (0))){
            heartPerson.setDateOfBirth (personInput);
        }else {
            heartPerson.setName (personInput);
        }
    }
}
