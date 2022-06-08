package pro.sky.homeworkemployeespringexception.service;

import org.junit.jupiter.api.Test;
import pro.sky.homeworkemployeespringexception.data.Employee;
import pro.sky.homeworkemployeespringexception.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    private final static String DEFAULT_FIRST_NAME = "Ivan";
    private final static String DEFAULT_LAST_NAME = "Ivanov";
    private final static int DEFAULT_DEPARTMENT = 1;
    private final static int DEFAULT_SALARY = 100_000;
    private final static Employee DEFAULT_EMPLOYEE = new Employee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_DEPARTMENT, DEFAULT_SALARY);

    @Test
    public void shouldReturnTrueAddEmployee() {
        Employee result = out.addEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_DEPARTMENT, DEFAULT_SALARY);
        assertEquals(result, DEFAULT_EMPLOYEE);
    }

    @Test
    public void shouldReturnThrowWhenAddExistEmployee() {
        out.addEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_DEPARTMENT, DEFAULT_SALARY);
        assertThrows(NotFoundException.class, () -> out.addEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_DEPARTMENT, DEFAULT_SALARY));
    }

    @Test
    public void shouldReturnTrueRemoveEmployee() {
        out.addEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_DEPARTMENT, DEFAULT_SALARY);
        Employee result = out.removeEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);
        assertEquals(result, DEFAULT_EMPLOYEE);
    }

    @Test
    public void shouldReturnThrowWhenRemoveNotExistEmployee() {
        assertThrows(NotFoundException.class, () -> out.removeEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME));
    }

    @Test
    public void shouldReturnTrueFindEmployee() {
        out.addEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_DEPARTMENT, DEFAULT_SALARY);
        Employee result = out.findEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);
        assertEquals(result, DEFAULT_EMPLOYEE);
    }

    @Test
    public void shouldReturnThrowWhenFindNotExistEmployee() {
        assertThrows(NotFoundException.class, () -> out.findEmployee(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME));
    }
}