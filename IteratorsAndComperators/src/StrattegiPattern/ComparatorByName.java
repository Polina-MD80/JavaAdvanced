package StrattegiPattern;

import java.util.Comparator;

public
class ComparatorByName implements Comparator<Person> {

    @Override
    public
    int compare (Person first, Person second) {
        int result = Integer.compare (first.getName ().length (),second.getName ().length ());
        if (result==0){
            result = first.getName ().compareTo (second.getName ());
        }

        return result;
    }
}
