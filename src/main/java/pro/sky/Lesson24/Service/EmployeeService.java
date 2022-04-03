package pro.sky.Lesson24.Service;

import pro.sky.Lesson24.Data.Employee;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    Employee[] allEmployee();
}