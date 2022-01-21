package pro.sky.homeworkemployeespringexception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return String.valueOf(employeeService.findEmployee(firstName, lastName));
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " успешно создан.";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален.";
    }
}
