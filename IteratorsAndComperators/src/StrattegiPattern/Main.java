package StrattegiPattern;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Set<Person> setByName = new HashSet<> ();
        Set<Person> setByAge = new HashSet<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine ().split ("\\s+");
            String name = input[0];
            int age = Integer.parseInt (input[1]);
            Person person = new Person (name, age);
            setByName.add (person);
            setByAge.add (person);
        }
        setByName.stream ().sorted (new ComparatorByName ()).forEach (System.out::println);
        setByAge.stream ().sorted (new ComparatorByAge ()).forEach (System.out::println);

    }
}
