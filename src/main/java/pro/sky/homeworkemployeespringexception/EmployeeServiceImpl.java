package pro.sky.homeworkemployeespringexception;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        Employee addEmployee = new Employee(firstName, lastName);
        String employee = firstName+lastName;
        if (!employees.containsValue(addEmployee)) {
            employees.put(employee, addEmployee);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        String employee = firstName + lastName;
        if (employees.containsKey(employee)) {
            employees.remove(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean findEmployee(String firstName, String lastName) {
        return employees.containsValue(new Employee(firstName, lastName));
    }

    @Override
    public Map<String, Employee> getEmployee() {
        return employees;
    }
}
