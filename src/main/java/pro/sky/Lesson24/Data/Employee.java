package pro.sky.Lesson24.Data;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final Integer departmentId;
    private final Integer salary;

    public Employee(String fullName, String lastName, Integer departmentId, Integer salary) {
        this.firstName = fullName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(departmentId, employee.departmentId) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }
}