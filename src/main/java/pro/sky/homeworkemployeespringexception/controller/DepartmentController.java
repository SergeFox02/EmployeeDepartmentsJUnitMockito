package pro.sky.homeworkemployeespringexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homeworkemployeespringexception.data.Employee;
import pro.sky.homeworkemployeespringexception.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithMaxSalaryByDepartmentId(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithMinSalaryByDepartmentId(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public Collection<Employee> findEmployeesByDepartmentId(@RequestParam int departmentId) {
        return departmentService.findEmployeesByDepartmentId(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllEmployeesByDepartmentId() {
        return departmentService.findAllEmployeesByDepartmentId();
    }

    @GetMapping(path = "/total-salary")
    public double findTotalSalaryOfDepartment(@RequestParam("departmentId") int departmentId) {
        return  departmentService.findTotalSalaryOfDepartment(departmentId);
    }

    @GetMapping(path = "/medium-salary")
    public OptionalDouble findMediumSalaryOfDepartment(@RequestParam("departmentId") int departmentId) {
        return  departmentService.findMediumSalaryOfDepartment(departmentId);
    }
}
