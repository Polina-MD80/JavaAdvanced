package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Person> people = new ArrayList<> ();

        String command = scanner.nextLine ();
        while (!command.equals ("END")) {
            String[] tokens = command.split ("\\s+");
            String   name   = tokens[0];
            int      age    = Integer.parseInt (tokens[1]);
            String   town   = tokens[2];

            Person   person = new Person (name, age, town);

            people.add (person);

            command = scanner.nextLine ();
        }
        int n = Integer.parseInt (scanner.nextLine ());

        Person personToCompare = people.get (n-1);

        int countEqual = 0;
        for (Person person : people) {
            if (personToCompare.compareTo (person)==0){
                countEqual++;
            }
        }
        if (countEqual==1){
            System.out.println ("No matches");
        }else {
            System.out.print (countEqual+ " ");
            System.out.print (people.size () - countEqual + " ");
            System.out.print (people.size ());
        }


    }
}
