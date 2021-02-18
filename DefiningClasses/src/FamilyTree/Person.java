package FamilyTree;

public
class Person {
   private String name;
   private String dateOfBirth;

    public
    Person () {
    }

    public
    Person (String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public
    void setName (String name) {
        this.name = name;
    }

    public
    String getName () {
        return name;
    }

    public
    String getDateOfBirth () {
        return dateOfBirth;
    }

    public
    void setDateOfBirth (String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public
    String toString () {
        return String.format ("%s %s",this
        .name,this.dateOfBirth);
    }
}
