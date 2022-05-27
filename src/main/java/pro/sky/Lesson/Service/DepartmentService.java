package pro.sky.Lesson.Service;

import pro.sky.Lesson.Data.Employee;

import java.util.List;

public interface DepartmentService {

    Employee addEmployee(String firstName, String lastName,
                         Integer departmentId, Integer salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> allEmployee();

    List<Employee> employeeMaxSalary(Integer departmentId);

    List<Employee> employeeMinSalary(Integer departmentId);

    List<Employee> employeeAllDepartmentId(Integer departmentId);

    List<Employee> allEmployeeByDepartments();
}