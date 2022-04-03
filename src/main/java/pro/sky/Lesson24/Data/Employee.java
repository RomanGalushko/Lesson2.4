package pro.sky.Lesson24.Data;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;

    public Employee(String fullName, String lastName) {
        this.firstName = fullName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) &&  Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}