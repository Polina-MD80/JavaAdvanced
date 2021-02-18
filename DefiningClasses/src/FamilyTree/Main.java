package FamilyTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public
class Main {
    static Map<Person, Tree> people;

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        people = new HashMap<> ();

        String personInput = scanner.nextLine ();
        Person thePerson   = createPerson (personInput);
        Tree   tree        = new Tree (thePerson);

        people.put (thePerson, tree);

        while (!"End".equals (personInput = scanner.nextLine ())) {
            if (!personInput.contains ("-")) {
                String personName        = personInput.substring (0, personInput.lastIndexOf (" "));
                String personDateOfBirth = personInput.substring (personInput.lastIndexOf (" ") + 1);
                updateTheMap (personName, personDateOfBirth);
            } else {
                String[] tokens       = personInput.split (" - ");
                String   parentInfo   = tokens[0];
                String   childInfo    = tokens[1];
                Person   parentExists = checkForAlreadyCreatedPerson (parentInfo);
                Person   childExists  = checkForAlreadyCreatedPerson (childInfo);

                if (parentExists != null) {
                    if (childExists != null) {
                        people.get (parentExists).getChildren ().add (childExists);
                    } else {
                        childExists = createPerson (childInfo);
                        people.get (parentExists).getChildren ().add (childExists);
                        people.put (childExists, new Tree (childExists));
                    }
                    people.get (childExists).getParents ().add (parentExists);
                } else {
                    parentExists = createPerson (parentInfo);
                    people.put (parentExists, new Tree (parentExists));
                    if (childExists != null) {
                        people.get (parentExists).getChildren ().add (childExists);
                        people.get (childExists).getParents ().add (parentExists);
                    } else {
                        childExists = createPerson (childInfo);
                        people.put (childExists, new Tree (childExists));
                        people.get (parentExists).getChildren ().add (childExists);
                        people.get (childExists).getParents ().add (parentExists);
                    }
                }
            }
        }

        System.out.println (people.get (thePerson).getParentsToString ());
        System.out.println (people.get (thePerson).getChildrenToString ());


    }

    private static
    void updateTheMap (String personName, String personDateOfBirth) {
        Person person = checkForAlreadyCreatedPerson (personName);
        if (person != null) {
            person.setDateOfBirth (personDateOfBirth);
        } else {
            person = checkForAlreadyCreatedPerson (personDateOfBirth);
            if (person != null) {
                person.setName (personName);
            }else {
                person = new Person (personName,personDateOfBirth);
                people.put (person,new Tree (person));
            }
        }
    }


    private static
    Person checkForAlreadyCreatedPerson (String string) {
        for (Person person : people.keySet ()) {
            if (person.getName () != null && person.getName ().equals (string)) {
                return person;
            }
            if (person.getDateOfBirth () != null && person.getDateOfBirth ().equals (string)) {
                return person;
            }
        }
        return null;
    }

    /*private static
    void updateTheMap (Person person) {
        boolean foundPerson = false;
        for (Person personKey : people.keySet ()) {
            if (personKey.getDateOfBirth () != null) {
                if (personKey.getDateOfBirth ().equals (person.getDateOfBirth ())) {
                    personKey.setName (person.getName ());
                    foundPerson = true;
                    break;
                } else if (personKey.getName () != null) {
                    if (personKey.getName ().equals (person.getName ())) {
                        personKey.setDateOfBirth (person.getDateOfBirth ());
                        foundPerson = true;
                        break;
                    }
                }
            }
        }
        if (!foundPerson) {
            Tree tree = new Tree (person);
            people.put (person, tree);
        }
    }*/


    private static
    Person createPerson (String info) {
        Person person = new Person ();
        if (!info.contains ("/")) {
            person.setName (info);
        } else {
            person.setDateOfBirth (info);
        }
        return person;
    }


}
