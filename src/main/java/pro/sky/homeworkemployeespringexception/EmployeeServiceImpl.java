package pro.sky.homeworkemployeespringexception;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    Employee[] employees = {
            new Employee("Ivan1", "Ivanov1"),
            new Employee("Ivan2", "Ivanov2"),
            new Employee("Ivan3", "Ivanov3"),
            new Employee("Ivan4", "Ivanov4"),
            new Employee("Ivan5", "Ivanov5"),
            new Employee("Ivan6", "Ivanov6")
    };

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return true;
            }
        }
        throw new EmployeeArrayIsFull();
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getFirstName().equals(firstName) && this.employees[i].getLastName().equals(lastName)) {
                this.employees[i] = null;
                return true;
            }
        }
        throw new NotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFirstName().equals(firstName) &&
                    employees[i].getLastName().equals(lastName)) {
                return employees[i];
            }
        }
        throw new NotFoundException();
    }
}
