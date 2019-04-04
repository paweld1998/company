package pl.pawel.company.repository;

import pl.pawel.company.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<Employee> employeeList;


    public EmployeeRepositoryImpl(){    //czy robic konstruktor zeby dla kazdego nowego obiektu tworzyla mi sie nowa lista pracowników;
        employeeList=new ArrayList<>();

    }


    public Employee create(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee update(Employee employee) { //robic to scannerem ? czy o to chodzi ?

        Scanner scanner = new Scanner(System.in);

        System.out.println("podaj imie:");
        String imie = scanner.nextLine();

        System.out.println("podaj nazwisko:");
        String nazwisko = scanner.nextLine();

        employee.setFirstName(imie);
        employee.setLastName(nazwisko);

        return employee;


    }

    public Employee get(Long id) {

        for(int i =0;i<employeeList.size();i++){
            if(employeeList.get(i).getId().equals(id))
                return employeeList.get(i);
        }

        return null; //co zwracac jesli nie znajde pracownika; (wlasny wyjatek ?)
    }

    public Employee delete(Long id) {

        for(int i=0;i<employeeList.size();i++){

            if(employeeList.get(i).getId().equals(id)){

                Employee employee = employeeList.get(i);
                employeeList.remove(i);
                return employee;
            }
        }

        return null; //co zwracac jesli nie znajde pracownika; (wlasny wyjatek ?)"NoEmployeeException" ?? :D

    }

    @Override
    public void deleteAll() {
        employeeList.clear();

    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }


}
