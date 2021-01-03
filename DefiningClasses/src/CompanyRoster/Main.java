package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public
class Main {
    public static
    void main (String[] args) {
        Scanner                     scanner     = new Scanner (System.in);
        int                         n           = Integer.parseInt (scanner.nextLine ());
        Map<String, List<Employee>> info        = new HashMap<> ();
        List<Department>            departments = new ArrayList<> ();
        for (int i = 0; i < n; i++) {
            String[] tokens   = scanner.nextLine ().split ("\\s+");
            Employee employee = new Employee (tokens[0], Double.parseDouble (tokens[1]), tokens[2], tokens[3]);
            if (tokens.length > 4) {
                if (tokens[4].contains ("@")) {
                    employee.setEmail (tokens[4]);
                } else {
                    employee.setAge (Integer.parseInt (tokens[4]));
                }
            }
            if (tokens.length == 6) {
                employee.setAge (Integer.parseInt (tokens[5]));
            }
            if (!info.containsKey (tokens[3])) {
                Department department = new Department ();
                department.setName (tokens[3]);
                departments.add (department);
                department.addSalary (Double.parseDouble (tokens[1]));
            }else {
                for (Department department : departments) {
                    if (department.getName ().equals (tokens[3])){
                        department.addSalary (Double.parseDouble (tokens[1]));
                    }
                }
            }

            info.putIfAbsent (tokens[3], new ArrayList<> ());
            info.get (tokens[3]).add (employee);

        }
      Optional<Department> best = departments.stream ().max((f, s)->Double.compare (f.getAverageSalary (f.getSalaries ()), s.getAverageSalary (s.getSalaries ())));
       String bestDepartment = best.get ().getName ();
        System.out.println ("Highest Average Salary: " + bestDepartment);

      info.get (bestDepartment).stream ().sorted ((f,s)->Double.compare (s.getSalary (),f.getSalary ()))
              .forEach (System.out::println);
    }
}

