package CompanyRoster;

public
class Employee {
    //name, salary, position, department, email and age
    private final String name;
    private final double salary;
    private String position;
    private String department;
    private String email;
    private int age;



    public
    Employee (String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public
    Employee (String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    public
    void setEmail (String email) {
        this.email = email;
    }

    public
    void setAge (int age) {
        this.age = age;
    }

    public
    double getSalary () {
        return salary;
    }

    //Toshko 609.99 toshko@abv.bg 44
    @Override
    public
    String toString () {
        return String.format ("%s %.2f %s %d", this.name,this.salary, this.email, this.age);
    }
}
