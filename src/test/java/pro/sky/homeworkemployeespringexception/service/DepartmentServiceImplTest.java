package pro.sky.homeworkemployeespringexception.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homeworkemployeespringexception.data.Employee;
import pro.sky.homeworkemployeespringexception.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    private static final int DEFAULT_DEPARTMENT = 1;
    private static final int INVALID_DEPARTMENT =  -1;
    private static final int MAX_SALARY = 100_000;
    private static final int MIN_SALARY = 50_000;
    private static final int TOTAL_SALARY = MAX_SALARY + MIN_SALARY;
    private static final int MEDIUM_SALARY = TOTAL_SALARY/2;
    private static final Employee EMPLOYEE_WITH_MAX_SALARY = new Employee("Ivan", "Ivanov", DEFAULT_DEPARTMENT, MAX_SALARY);
    private static final Employee EMPLOYEE_WITH_MIN_SALARY = new Employee("Pyotor", "Petrov", DEFAULT_DEPARTMENT, MIN_SALARY);

    private final Collection<Employee> DEFAULT_ALL_EMPLOYEE = new ArrayList<>(List.of(
            EMPLOYEE_WITH_MAX_SALARY, EMPLOYEE_WITH_MIN_SALARY)
    );

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    DepartmentServiceImplTest() {
    }

    @Test
    public void shouldReturnTrueFindEmployeeWithMaxSalaryByDepartmentId(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(DEFAULT_ALL_EMPLOYEE);
        assertEquals(EMPLOYEE_WITH_MAX_SALARY, out.findEmployeeWithMaxSalaryByDepartmentId(DEFAULT_DEPARTMENT));
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }

    @Test
    public void shouldReturnNullWhenEmployeesListIsNullInMaxSalaryByDepartmentId(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEFAULT_DEPARTMENT));
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }

    @Test
    public void shouldReturnThrowFindEmployeeWithMaxSalaryByInvalidDepartmentId(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(DEFAULT_ALL_EMPLOYEE);
        assertThrows(NotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(INVALID_DEPARTMENT));
    }

    @Test
    public void shouldReturnTrueFindEmployeeWithMinSalaryByDepartmentId(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(DEFAULT_ALL_EMPLOYEE);
        assertEquals(EMPLOYEE_WITH_MIN_SALARY, out.findEmployeeWithMinSalaryByDepartmentId(DEFAULT_DEPARTMENT));
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }

    @Test
    public void shouldReturnNullWhenEmployeesListIsNullInMinSalaryByDepartmentId(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEFAULT_DEPARTMENT));
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }

    @Test
    public void shouldReturnThrowFindEmployeeWithMinSalaryByInvalidDepartmentId(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(DEFAULT_ALL_EMPLOYEE);
        assertThrows(NotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(INVALID_DEPARTMENT));
    }

    @Test
    public void shouldReturnTrueFindEmployeesByDepartmentId(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(DEFAULT_ALL_EMPLOYEE);
        assertEquals(DEFAULT_ALL_EMPLOYEE, out.findEmployeesByDepartmentId(DEFAULT_DEPARTMENT));
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }

    @Test
    public void shouldReturnTrueTotalSalaryOfDepartment(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(DEFAULT_ALL_EMPLOYEE);
        assertEquals(TOTAL_SALARY, out.findTotalSalaryOfDepartment(DEFAULT_DEPARTMENT));
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }

    @Test
    public void shouldReturnTrueMediumSalaryOfDepartment(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(DEFAULT_ALL_EMPLOYEE);
        assertEquals(MEDIUM_SALARY, out.findMediumSalaryOfDepartment(DEFAULT_DEPARTMENT).getAsDouble());
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }

    @Test
    public void shouldReturnThrowWhenInvalidDepartment(){
        when(employeeServiceMock.getAllEmployees()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> out.findMediumSalaryOfDepartment(INVALID_DEPARTMENT));
        verify(employeeServiceMock, times(1)).getAllEmployees();
    }
}