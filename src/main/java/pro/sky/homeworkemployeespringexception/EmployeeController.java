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
    public String getPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeService.findEmployee(firstName, lastName);
        } catch (NotFoundException exception) {
            throw new NotFoundException();
        }
        return String.valueOf(employeeService.findEmployee(firstName, lastName));
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        if (employeeService.addEmployee(firstName, lastName)) {
            return "Сотрудник " + firstName + " " + lastName + " успешно создан.";
        } else {
            throw new EmployeeArrayIsFull();
        }
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        if (employeeService.removeEmployee(firstName, lastName)) {
            return "Сотрудник " + firstName + " " + lastName + " удален.";
        } else {
            throw new NotFoundException();
        }
    }
}
