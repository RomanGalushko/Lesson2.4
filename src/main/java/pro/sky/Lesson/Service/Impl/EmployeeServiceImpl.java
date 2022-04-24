package pro.sky.Lesson.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.Lesson.Data.Employee;
import pro.sky.Lesson.Exception.ThereEmployeeException;
import pro.sky.Lesson.Exception.ThereNoEmployeeException;
import pro.sky.Lesson.Exception.InvalidNameException;
import pro.sky.Lesson.Service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public boolean addEmployee(String firstName, String lastName, Integer departmentId, Integer salary) {
        String fullName = firstName + lastName;
        if (employees.containsKey(fullName)) {
            throw new ThereEmployeeException("есть сотрудник");
        }
        if (!isAlpha(fullName)) {
            throw new InvalidNameException(fullName);
        }
        employees.put(fullName, new Employee(capitalize(firstName), capitalize(lastName), departmentId, salary));
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

    @Override
    public List<Employee> employeeMaxSalary(Integer departmentId) {
        Integer maxSalary = employees.values().stream()
                .filter(d -> d.getDepartmentId().equals(departmentId))
                .map(Employee::getSalary)
                .max(Integer::compare).get();
        return employees.values().stream()
                .filter(d -> d.getDepartmentId().equals(departmentId))
                .filter(e -> e.getSalary().equals(maxSalary))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> employeeMinSalary(Integer departmentId) {
        Integer minSalary = employees.values().stream()
                .filter(d -> d.getDepartmentId().equals(departmentId))
                .map(Employee::getSalary)
                .min(Integer::compare).get();
        return employees.values().stream()
                .filter(d -> d.getDepartmentId().equals(departmentId))
                .filter(e -> e.getSalary().equals(minSalary))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> employeeAllDepartmentId(Integer departmentId) {
        return employees.values().stream()
                .filter(d -> d.getDepartmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> allEmployeeByDepartments() {
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
}