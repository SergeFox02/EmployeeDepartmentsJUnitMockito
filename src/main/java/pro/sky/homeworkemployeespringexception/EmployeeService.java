package pro.sky.homeworkemployeespringexception;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName);
    boolean removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
