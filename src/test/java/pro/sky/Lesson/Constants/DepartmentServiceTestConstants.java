package pro.sky.Lesson.Constants;

import pro.sky.Lesson.Data.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentServiceTestConstants {
    public static final String DEFAULT_EMPLOYEE_FIRSTNAME = "Ivan";
    public static final String DEFAULT_EMPLOYEE_LASTNAME = "Ivanov";
    public static final Integer DEFAULT_EMPLOYEE_DEPARTMENTID = 1;
    public static final Integer DEFAULT_EMPLOYEE_SALARY = 10000;
    public static final Employee DEFAULT_EMPLOYEE =
            new Employee(DEFAULT_EMPLOYEE_FIRSTNAME, DEFAULT_EMPLOYEE_LASTNAME,
                    DEFAULT_EMPLOYEE_DEPARTMENTID, DEFAULT_EMPLOYEE_SALARY);
    public static final List<Employee> DEFAULT_ALL_EMPLOYEE = new ArrayList<>(Arrays.asList(
            new Employee("Ivanov", "Ivan", 1, 10000),
            new Employee("Ivanov1", "Ivan1", 1, 11000),
            new Employee("Ivanov2", "Ivan2", 2, 12000),
            new Employee("Ivanov3", "Ivan3", 3, 13000),
            new Employee("Ivanov4", "Ivan4", 3, 14000),
            new Employee("Ivanov5", "Ivan5", 1, 15000)
    ));
    public static final List<Employee> DEFAULT_LIST_OF_EMPLOYEES_MIN_MAX_SALARY_IN_DEPT = new ArrayList<>(Arrays.asList(
            new Employee("Ivanov", "Ivan", 1, 10000),
            new Employee("Ivanov1", "Ivan1", 1, 10000),
            new Employee("Ivanov2", "Ivan2", 2, 10000)
    ));
}
