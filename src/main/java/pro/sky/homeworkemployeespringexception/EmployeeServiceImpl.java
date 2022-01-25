package pro.sky.homeworkemployeespringexception;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    Set<Employee> employees = new HashSet<>();

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        Employee addEmployee = new Employee(firstName, lastName);
        if (!employees.contains(addEmployee)) {
            employees.add(addEmployee);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        Employee removeEmployee = new Employee(firstName, lastName);
        if (employees.contains(removeEmployee)) {
            employees.remove(removeEmployee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean findEmployee(String firstName, String lastName) {;
        if (employees.contains(new Employee(firstName, lastName))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Set<Employee> getEmployee() {
        return employees;
    }
}
