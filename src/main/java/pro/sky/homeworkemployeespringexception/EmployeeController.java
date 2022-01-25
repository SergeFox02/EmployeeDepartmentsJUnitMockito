package pro.sky.homeworkemployeespringexception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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
    public boolean findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/add")
    public boolean addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public boolean removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/get")
    public Set<Employee> getEmployeeList() {
        return employeeService.getEmployee();
    }
}
