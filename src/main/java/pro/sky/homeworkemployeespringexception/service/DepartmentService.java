package pro.sky.homeworkemployeespringexception.service;

import pro.sky.homeworkemployeespringexception.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public interface DepartmentService {

    Employee findEmployeeWithMaxSalaryByDepartmentId(int department);
    Employee findEmployeeWithMinSalaryByDepartmentId(int department);
    Collection<Employee> findEmployeesByDepartmentId(int department);
    Map<Integer, List<Employee>> findAllEmployees();
    double findTotalSalaryOfDepartment(int department);
    OptionalDouble findMediumSalaryOfDepartment(int department);

}
