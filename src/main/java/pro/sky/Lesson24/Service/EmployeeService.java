package pro.sky.Lesson24.Service;

import pro.sky.Lesson24.Data.Employee;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName);
    boolean removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> allEmployee();
    boolean employeeCompare(String firstName, String lastName);
}