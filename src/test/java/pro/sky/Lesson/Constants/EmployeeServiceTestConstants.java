package pro.sky.Lesson.Constants;

import pro.sky.Lesson.Data.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeServiceTestConstants {

    public static final String WRONG_LASTNAME = "Ivanov6";
    public static final String WRONG_FIRSTNAME = "Ivan6";
    public static final String RIGHT_FIRSTNAME = "Ivan";
    public static final String RIGHT_LASTNAME = "Ivanov";
    public static final Integer DEFAULT_EMPLOYEE_DEPARTMENTID = 1;
    public static final Integer DEFAULT_EMPLOYEE_SALARY = 10000;
    public static final String DEFAULT_FULLNAME = RIGHT_LASTNAME + RIGHT_FIRSTNAME;
    public static final String INVALID_FULLNAME_DEFAULT = "FAKE NAME";
    public static final Map<String, Employee> DEFAULT_EMPLOYEE_MAP =
            new HashMap<>((Map.of(DEFAULT_FULLNAME,
                    new Employee(RIGHT_FIRSTNAME, RIGHT_LASTNAME,
                            DEFAULT_EMPLOYEE_DEPARTMENTID,
                            DEFAULT_EMPLOYEE_SALARY))));
}