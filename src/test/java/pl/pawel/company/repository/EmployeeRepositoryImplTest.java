package pl.pawel.company.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.pawel.company.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class EmployeeRepositoryImplTest {


    private  Employee employee ;
    private List<Employee> employeeList = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        employee = new Employee(1L,"pawel","duplaga");
        employeeList.add(employee);
    }

    @After
    public void tearDown() throws Exception {
        employeeList.clear();
    }

    @Test
    public void createTest() {
    }

    @Test
    public void updateTest() {
        Employee update = new Employee(2L,"tomasz","duplaga");
        employee=update;
        assertEquals((Long)2L,employee.getId());
        assertEquals("tomasz",employee.getFirstName());
        assertEquals("duplaga",employee.getLastName());
        //assertEquals(update,employee);
    }

    @Test
    public void getTest() {
        assertEquals((Long)1L,employee.getId());
    }

    @Test
    public void deleteTest() {
        //assertTrue(employeeList.contains(employee));
        employeeList.remove(employee);
        assertFalse(employeeList.contains(employee));
    }
}