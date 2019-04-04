package pl.pawel.company.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.pawel.company.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class EmployeeRepositoryImplTest {


    private  Employee employee ;
    private EmployeeRepository  employeeRepository= new EmployeeRepositoryImpl();


    @Before
    public void setUp() {
        employee = new Employee("pawel","duplaga");
        employeeRepository.create( employee);
    }

    @After
    public void tearDown()  {
        employeeRepository.deleteAll();
    }

    @Test
    public void createTest() {
        Employee employee = employeeRepository.create(new Employee("1323", "123"));
        List<Employee> all = employeeRepository.getAll();
        assertThat(all.size(), equalTo(2)) ;
    }

    @Test
    public void updateTest() {
        Employee employee = employeeRepository.getAll().get(0);
        employee.setFirstName("dupa");

        employeeRepository.update(employee);
        assertEquals((Long)2L, this.employee.getId());
        assertEquals("duplaga", this.employee.getLastName());
        //assertEquals(update,employee);
    }

    @Test
    public void getTest() {
        Employee employee = employeeRepository.getAll().get(0);
    }

    @Test
    public void deleteTest() {
        Employee employee = employeeRepository.getAll().get(0);
        employeeRepository.delete(employee.getId());

        assertThat(0,equalTo(employeeRepository.getAll().size()));
    }
}