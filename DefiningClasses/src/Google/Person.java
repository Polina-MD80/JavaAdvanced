package Google;


import java.util.ArrayList;
import java.util.List;

public
class Person {
    private String personName;
    String car;
    String company;
    String companyDepartment;
    double salary;

    private List<Pokemon> pokemonList;
    private List<Parent> parentsList;
    private List<Child> childrenList;

    public
    Person (String personName) {
        this.personName = personName;
        parentsList = new ArrayList<> ();
        pokemonList = new ArrayList<> ();
        childrenList = new ArrayList<> ();
    }

    public
    void setCar (String car) {
        this.car = car;
    }

    public
    void setCompany (String company) {
        this.company = company;
    }

    public
    void setCompanyDepartment (String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public
    void setSalary (double salary) {
        this.salary = salary;
    }



    public
    List<Pokemon> getPokemonList () {
        return pokemonList;
    }

    public
    List<Parent> getParentsList () {
        return parentsList;
    }

    public
    List<Child> getChildrenList () {
        return childrenList;
    }
}


