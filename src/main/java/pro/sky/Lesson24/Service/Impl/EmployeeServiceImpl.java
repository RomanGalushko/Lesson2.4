package pro.sky.Lesson24.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.Lesson24.Data.Employee;
import pro.sky.Lesson24.Exception.ThereEmployeeException;
import pro.sky.Lesson24.Exception.ThereNoEmployeeException;
import pro.sky.Lesson24.Service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>();

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        String fullName = firstName + lastName;
        if (employees.containsKey(fullName)) {
            throw new ThereEmployeeException("есть сотрудник");
        }
        employees.put(fullName, new Employee(firstName, lastName));
        return true;
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        String fullName = firstName + lastName;
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
            return true;
        }
        throw new ThereNoEmployeeException("сотрудник не найден");
    }

    @Override
    public boolean findEmployee(String firstName, String lastName) {
        String fullName = firstName + lastName;
        if (employees.containsKey(fullName)) {
            return true;
        }
        throw new ThereNoEmployeeException("сотрудник не найден");
    }

    @Override
    public List<Employee> allEmployee() {
        return new ArrayList<>(employees.values());
    }
}