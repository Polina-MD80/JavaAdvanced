package EqualityLogic;

import java.util.Objects;

public
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public
    boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && name.equals (person.name);
    }

    @Override
    public
    int hashCode () {
        return Objects.hash (name, age);
    }


    @Override
    public
    int compareTo (Person o) {
        int result = this.name.compareTo (o.name);
        if (result==0){
            result = Integer.compare (this.age,o.age);
        }
        return result;
    }
}
