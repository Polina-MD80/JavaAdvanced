package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public
class Tree extends Person{
  private   Person centre;
  private  List<Person> parents;
  private  List<Person> children;

    public
    Tree (Person person) {
        this.centre = person;
        this.parents = new ArrayList<> ();
        this.children = new ArrayList<> ();
    }

    public
    Person getCentre () {
        return centre;
    }
}
