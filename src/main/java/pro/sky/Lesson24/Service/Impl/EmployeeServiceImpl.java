package pro.sky.Lesson24.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.Lesson24.Exception.ArrayEmployeesFullException;
import pro.sky.Lesson24.Data.Employee;
import pro.sky.Lesson24.Service.EmployeeService;
import pro.sky.Lesson24.Exception.ThereEmployeeException;
import pro.sky.Lesson24.Exception.ThereNoEmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Employee[] employees = new Employee[5];
    static int counter = 0;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (counter <= employees.length) {
            for (Employee employee : employees) {
                if (employee != null && employeeCompare(firstName, lastName, employee)) {
                    throw new ThereEmployeeException("есть сотрудник");
                }
            }
        } else {
            throw new ArrayEmployeesFullException("массив сотрудников переполнен");
        }
        int i = 0;
        while (employees[i] != null) {
            i++;
        }
        employees[i] = new Employee(firstName, lastName);
        counter++;
        return employees[i];
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employeeCompare(firstName, lastName, employees[i])) {
                employees[i] = null;
                counter--;
                return new Employee(firstName, lastName);
            }
        }
        throw new ThereNoEmployeeException("сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee != null && employeeCompare(firstName, lastName, employee)) {
                return employee;
            } else {
                throw new ThereNoEmployeeException("сотрудник не найден");
            }
        }
        return null;
    }

    @Override
    public Employee[] allEmployee() {
        for (int i = 0; i < employees.length; i++) {
            return employees;
        }
        return null;
    }

    private boolean employeeCompare(String firstName, String lastName, Employee employee) {
        boolean compare = employee.getFirstName().equals(firstName) &&
                employee.getLastName().equals(lastName);
        return compare;
    }
}




