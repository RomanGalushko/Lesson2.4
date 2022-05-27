package pro.sky.Lesson.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.Lesson.Data.Employee;
import pro.sky.Lesson.Service.DepartmentService;
import pro.sky.Lesson.Service.EmployeeService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName,
                                Integer departmentId, Integer salary) {
        return employeeService.addEmployee(firstName, lastName, departmentId, salary);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @Override
    public List<Employee> allEmployee() {
        return employeeService.allEmployee();
    }

    @Override
    public List<Employee> employeeMaxSalary(Integer departmentId) {
        return employeeService.employeeMaxSalary(departmentId);
    }

    @Override
    public List<Employee> employeeMinSalary(Integer departmentId) {
        return employeeService.employeeMinSalary(departmentId);
    }

    @Override
    public List<Employee> employeeAllDepartmentId(Integer departmentId) {
        return employeeService.employeeAllDepartmentId(departmentId);
    }

    @Override
    public List<Employee> allEmployeeByDepartments() {
        return employeeService.allEmployeeByDepartments();
    }
}