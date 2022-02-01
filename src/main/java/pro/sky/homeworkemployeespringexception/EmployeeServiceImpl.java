package pro.sky.homeworkemployeespringexception;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private Map<String, Employee> employees = new HashMap<>();

    private String key(String firstName, String lastName) {
        return firstName + lastName;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addEmployee = new Employee(firstName, lastName);
        String key = key(firstName, lastName);
        if (!employees.containsKey(key)) {
            employees.put(key, addEmployee);
            return addEmployee;
        }
        throw new NotFoundException("Не возможно добавить! Такой работник уже есть.");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = key(firstName, lastName);
        if (employees.containsKey(key)) {
            employees.remove(key);
            return new Employee(firstName, lastName);
        } else {
            throw new NotFoundException("Не возможно удалить! Работник не найден.");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = key(firstName, lastName);
        if (employees.containsKey(key)) {
            return new Employee(firstName, lastName);
        } else {
            throw new NotFoundException("Работник не найден.");
        }
    }

    @Override
    public Map<String, Employee> getEmployee() {
        return employees;
    }
}
