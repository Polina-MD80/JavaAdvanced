package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public
class Tree {
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
    List<Person> getParents () {
        return parents;
    }

    public
    List<Person> getChildren () {
        return children;
    }

    public
    Person getCentre () {
        return centre;
    }
    public String getParentsToString(){
        StringBuilder sb = new StringBuilder ("Parents:");
        for (Person parent : this.parents) {
            sb.append (System.lineSeparator ()).append (parent);
        }
       return sb.toString ();
    }
    public String getChildrenToString(){
        StringBuilder sb = new StringBuilder (System.lineSeparator () + "Children:");
        for (Person child : children) {
            sb.append (System.lineSeparator ()).append (child);
        }
        return sb.toString ();
    }
}
