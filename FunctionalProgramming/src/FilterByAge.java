import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public
class FilterByAge {
    public static
    class Person{
        String name;
        int age;

        public
        Person (String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());

        List<Person> people = new ArrayList<> ();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split (", ");
            String name = tokens[0];
            int age = Integer.parseInt (tokens[1]);

            Person person = new Person (name, age);
            people.add (person);
        }

        String criteria = scanner.nextLine ();
        int ageCriteria = Integer.parseInt (scanner.nextLine ());
        String format = scanner.nextLine ();

        Predicate<Person> ageFilter = createAgeFilter(criteria,ageCriteria);

        Function<Person,String> formatter = createFormatter(format);

        System.out.println (people.stream ()
                .filter (ageFilter)
                .map (formatter)
                .collect (Collectors.joining (System.lineSeparator ())));


    }

    private static
    Function<Person, String> createFormatter (String format) {
        if (format.equals ("name")){
            return p -> p.name;
        }else if (format.equals ("age")){
            return p-> String.valueOf (p.age);
        }else {
            return p-> String.format ("%s - %d", p.name, p.age);
        }
    }

    private static
    Predicate<Person> createAgeFilter (String criteria, int ageCriteria) {
        if (criteria.equals ("older")){
            return p -> p.age >= ageCriteria;
        }else return p-> p.age <= ageCriteria;
    }
}
