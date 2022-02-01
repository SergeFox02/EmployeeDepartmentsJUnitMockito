package pro.sky.homeworkemployeespringexception;

import java.util.Map;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName);
    boolean removeEmployee(String firstName, String lastName);
    boolean findEmployee(String firstName, String lastName);
    Map<String, Employee> getEmployee();
}
