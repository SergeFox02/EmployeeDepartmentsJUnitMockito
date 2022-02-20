package pro.sky.homeworkemployeespringexception.data;

import org.apache.commons.lang3.StringUtils;
import pro.sky.homeworkemployeespringexception.exception.InvalidNameException;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private int department;
    private double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = checkName(firstName);
        this.lastName = checkName(lastName);
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String checkName(String name) {
        if (StringUtils.isAlpha(name)){
            return StringUtils.capitalize(StringUtils.lowerCase(name));
        }
        throw new InvalidNameException("Exception: Invalid name of employee");
    }

    @Override
    public String toString() {
        return "{ firstName: " + firstName + ", lastName: " + lastName + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
