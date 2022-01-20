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
        if (employeeService.findEmployee(firstName, lastName)) {
            return "Сотрудник найден!";
        } else {
            return "Сотрудник не найден!";
        }
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        if (employeeService.addEmployee(firstName, lastName)) {
            return "Новый сотрудник добавлен!";
        } else {
            return "Нет мест для нового сотрудника!";
        }
    }

    @GetMapping("/delete")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        if (employeeService.removeEmployee(firstName, lastName)) {
            return "Сотрудник удален из списка!";
        } else {
            return "Такого сотрудника в списке нет!";
        }
    }
}
