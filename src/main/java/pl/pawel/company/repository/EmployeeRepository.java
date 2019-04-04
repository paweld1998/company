package pl.pawel.company.repository;

import pl.pawel.company.entity.Employee;

import java.util.List;

public interface EmployeeRepository {


    Employee create(Employee employee);

    Employee update(Employee employee);

    Employee get(Long id);

    Employee delete(Long id);

    void deleteAll();

    List<Employee> getAll();
}
