package pro.sky.homeworkemployeespringexception.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkemployeespringexception.data.Employee;
import pro.sky.homeworkemployeespringexception.exception.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new NotFoundException("Такого отдела не существует."));
    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new NotFoundException("Такого отдела не существует."));
    }

    @Override
    public Collection<Employee> findEmployeesByDepartmentId(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployees() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public double findTotalSalaryOfDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .map(Employee::getSalary)
                .mapToDouble(s -> s)
                .sum();
    }

    @Override
    public OptionalDouble findMediumSalaryOfDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .map(Employee::getSalary)
                .mapToDouble(s -> s)
                .average();
    }
}
