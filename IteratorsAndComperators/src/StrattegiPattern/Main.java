package StrattegiPattern;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Set<Person> setByName = new TreeSet<Person> (new ComparatorByName ());
        Set<Person> setByAge = new TreeSet<Person> (new ComparatorByAge ());

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine ().split ("\\s+");
            String name = input[0];
            int age = Integer.parseInt (input[1]);
            Person person = new Person (name, age);
            setByName.add (person);
            setByAge.add (person);
        }
        /*setByName.stream ().sorted (new ComparatorByName ()).forEach (System.out::println);
        setByAge.stream ().sorted (new ComparatorByAge ()).forEach (System.out::println);*/
        setByName.forEach (System.out::println);
        setByAge.forEach (System.out::println);
    }
}
