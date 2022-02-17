package pro.sky.homeworkemployeespringexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homeworkemployeespringexception.data.Employee;
import pro.sky.homeworkemployeespringexception.service.EmployeeService;

import java.util.Collection;
import java.util.Map;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String helloEmployee() {
        return "Hello Employee!";
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/put")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") Integer department,
                                @RequestParam("salary") Double salary
    ) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/set")
    public Map<String, Employee> setEmployeeMap() {
        return employeeService.setEmployee();
    }

    @GetMapping(path = "/get")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/total-salary")
    public double totalSum() {
        return employeeService.getTotalSalaryEmployees();
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary() {
        return employeeService.findEmployeeWithMinSalary();
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary() {
        return employeeService.findEmployeeWithMaxSalary();
    }

    @GetMapping(path = "/medium-salary")
    public OptionalDouble mediumSalary() {
        return employeeService.mediumSalaryEmployee();
    }
}
