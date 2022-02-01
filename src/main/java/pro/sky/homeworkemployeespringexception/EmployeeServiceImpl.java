package pro.sky.homeworkemployeespringexception;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private Map<Integer, Employee> employees = new HashMap<>();
    private Integer nextId = 0;

    private Integer getNextId() {
        return nextId++;
    }

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        Employee addEmployee = new Employee(firstName, lastName);
        if (!employees.containsValue(addEmployee)) {
            employees.put(getNextId(), addEmployee);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEmployee(Integer id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
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
    public Map<Integer, Employee> getEmployee() {
        return employees;
    }
}
