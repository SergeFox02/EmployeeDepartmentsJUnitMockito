package pro.sky.homeworkemployeespringexception.service;

import pro.sky.homeworkemployeespringexception.data.Employee;

import java.util.Collection;
import java.util.Map;
import java.util.OptionalDouble;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, double salary);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Employee findEmployeeWithMaxSalary();
    Employee findEmployeeWithMinSalary();
    OptionalDouble mediumSalaryEmployee();
    Map<String, Employee> setEmployee();
    Collection<Employee> getAllEmployees();
    double getTotalSalaryEmployees();
}
