package pro.sky.homeworkemployeespringexception;

import java.util.Map;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName);
    boolean removeEmployee(Integer id);
    boolean findEmployee(String firstName, String lastName);
    Map<Integer, Employee> getEmployee();
}
