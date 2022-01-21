package pro.sky.homeworkemployeespringexception;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);
    void removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
