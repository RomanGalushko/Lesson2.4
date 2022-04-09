package pro.sky.Lesson24.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.Lesson24.Data.Employee;
import pro.sky.Lesson24.Exception.ThereEmployeeException;
import pro.sky.Lesson24.Exception.ThereNoEmployeeException;
import pro.sky.Lesson24.Service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        if (employeeCompare(firstName, lastName)) {
            throw new ThereEmployeeException("есть сотрудник");
        }
        return employees.add(new Employee(firstName, lastName));
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        if (employeeCompare(firstName, lastName)) {
            return employees.remove(new Employee(firstName, lastName));
        }
        throw new ThereNoEmployeeException("сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (employeeCompare(firstName, lastName)) {
            return new Employee(firstName, lastName);
        }
        throw new ThereNoEmployeeException("сотрудник не найден");
    }

    @Override
    public List<Employee> allEmployee() {
        return employees;
    }

    public boolean employeeCompare(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employees.contains(employee);
    }
}