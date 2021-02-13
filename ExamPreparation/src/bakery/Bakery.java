package bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public
class Bakery {

    private String name;
    private int capacity;
    private
    List<Employee> employees;

    public
    Bakery (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<> ();
    }

    //•	Field employees – List that holds added Employees
    //•	Method add(Employee employee) – adds an entity to the data if there is room for him/her.
    //•	Method remove(String name) – removes an employee by given name, if such exists, and returns bool.
    //•	Method getOldestEmployee() – returns the oldest employee.
    //•	Method getEmployee(string name) – returns the employee with the given name.
    //•	Getter getCount() – returns the number of employees.
    //•	report() – returns a string in the following format:
    //o	"Employees working at Bakery {bakeryName}:
    //{Employee1}
    public
    void add (Employee employee) {
        if (this.capacity>this.employees.size ()){
            this.employees.add (employee);
        }
    }
    public boolean remove(String name ){
        return this.employees.removeIf (e->e.getName ().equals (name));
    }

    public Employee getOldestEmployee(){
        return this.employees.stream ().max(Comparator.comparing (Employee::getAge)).orElseThrow ();
    }
    public Employee getEmployee(String name){
       Employee employee = null;
        for (Employee empl : this.employees) {
            if (empl.getName ().equals (name)){
               employee = empl;break;
            }
        }
        return employee;

    }
    public int getCount(){
        return this.employees.size ();
    }
    public String report(){
        StringBuilder sb = new StringBuilder ("Employees working at Bakery " + this.name+":");
        sb.append (System.lineSeparator ());
        this.employees.stream ().forEach (e->sb.append (e).append (System.lineSeparator ()));
        return sb.toString ().trim ();

    }


}

