package CompanyRoster;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public
class Department {
    private String name;
    private List<Double> salaries;

    public
    Department () {
        this.salaries = new ArrayList<> ();
    }

    public
    void setName (String name) {

        this.name = name;
    }

    public
    String getName () {
        return this.name;
    }

    public
    List<Double> getSalaries () {
        return salaries;
    }



    public void addSalary(double salary){
        this.salaries.add (salary);
    }

    public double getAverageSalary(List<Double> salaries){
        double sum = 0;
        for (Double salary : salaries) {
            sum+=salary;

        }
        return sum/salaries.size ();
    }
}
