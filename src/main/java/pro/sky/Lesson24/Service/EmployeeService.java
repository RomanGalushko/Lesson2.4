package pro.sky.Lesson24.Service;

import pro.sky.Lesson24.Data.Employee;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName, Integer departmentId, Integer salary);

    boolean removeEmployee(String firstName, String lastName);

    boolean findEmployee(String firstName, String lastName);

    List<Employee> allEmployee();

    List<Employee> employeeMaxSalary(Integer departmentId);

    List<Employee> employeeMinSalary(Integer departmentId);

    List<Employee> employeeAllDepartmentId(Integer departmentId);

    List<Employee> allEmployeeByDepartments();
}