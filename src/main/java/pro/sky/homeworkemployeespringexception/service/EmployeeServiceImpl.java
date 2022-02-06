package pro.sky.homeworkemployeespringexception.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkemployeespringexception.data.Employee;
import pro.sky.homeworkemployeespringexception.exception.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map<String, Employee> employees = new HashMap<>();

    private String key(String firstName, String lastName) {
        return firstName + lastName;
    }

    @Override
    public Map<String, Employee> setEmployee() {
        employees.put(key("Ivan1", "Ivanov1"), new Employee("Ivan1", "Ivanov1", 1, 70_000.0));
        employees.put(key("Ivan2", "Ivanov2"), new Employee("Ivan2", "Ivanov2", 1, 80_000.0));
        employees.put(key("Ivan3", "Ivanov3"), new Employee("Ivan3", "Ivanov3", 1, 90_000.0));
        employees.put(key("Ivan4", "Ivanov4"), new Employee("Ivan4", "Ivanov4", 2, 120_000.0));
        employees.put(key("Ivan5", "Ivanov5"), new Employee("Ivan5", "Ivanov5", 2, 130_000.0));
        employees.put(key("Ivan6", "Ivanov6"), new Employee("Ivan6", "Ivanov6", 2, 125_000.0));
        employees.put(key("Ivan7", "Ivanov7"), new Employee("Ivan7", "Ivanov7", 3, 200_000.0));
        employees.put(key("Ivan8", "Ivanov8"), new Employee("Ivan8", "Ivanov8", 4, 150_000.0));
        employees.put(key("Ivan9", "Ivanov9"), new Employee("Ivan9", "Ivanov9", 5, 500_000.0));
        return employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        Employee addEmployee = new Employee(firstName, lastName, department, salary);
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
            return employees.remove(key);
        } else {
            throw new NotFoundException("Не возможно удалить! Работник не найден.");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = key(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        } else {
            throw new NotFoundException("Работник не найден.");
        }
    }

    @Override
    public Employee findEmployeeWithMaxSalary() {
        return getAllEmployees().stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new NotFoundException("Такого отдела не существует."));
    }

    @Override
    public Employee findEmployeeWithMinSalary() {
        return getAllEmployees().stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new NotFoundException("Такого отдела не существует."));
    }

    @Override
    public OptionalDouble mediumSalaryEmployee() {
        return getAllEmployees().stream()
                .map(Employee::getSalary)
                .mapToDouble(s -> s)
                .average();
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public double getTotalSalaryEmployees() {
        return getAllEmployees().stream()
                .map(Employee::getSalary)
                .mapToDouble(s -> s)
                .sum();
    }
}
