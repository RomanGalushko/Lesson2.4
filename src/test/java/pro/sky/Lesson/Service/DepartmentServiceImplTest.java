package pro.sky.Lesson.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Lesson.Exception.InvalidNameException;
import pro.sky.Lesson.Exception.ThereNoEmployeeException;
import pro.sky.Lesson.Service.Impl.DepartmentServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static pro.sky.Lesson.Constants.DepartmentServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void callMethodAddEmployee() {
        when(employeeServiceMock.addEmployee(
                DEFAULT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_DEPARTMENTID,
                DEFAULT_EMPLOYEE_SALARY))
                .thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.addEmployee(
                        DEFAULT_EMPLOYEE_FIRSTNAME,
                        DEFAULT_EMPLOYEE_LASTNAME,
                        DEFAULT_EMPLOYEE_DEPARTMENTID,
                        DEFAULT_EMPLOYEE_SALARY));
    }

    @Test
    public void callMethodRemoveEmployee() {
        when(employeeServiceMock.removeEmployee(
                DEFAULT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_LASTNAME))
                .thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.removeEmployee(
                        DEFAULT_EMPLOYEE_FIRSTNAME,
                        DEFAULT_EMPLOYEE_LASTNAME));
    }

    @Test
    public void callMethodFindEmployee() {
        when(employeeServiceMock.findEmployee(
                DEFAULT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_LASTNAME))
                .thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.findEmployee(
                        DEFAULT_EMPLOYEE_FIRSTNAME,
                        DEFAULT_EMPLOYEE_LASTNAME));
    }

    @Test
    public void callMethodAllEmployeeList() {
        when(employeeServiceMock.allEmployee()).thenReturn(DEFAULT_ALL_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_ALL_EMPLOYEE, out.allEmployee());
    }

    @Test
    public void callServiceMethodFindEmployeeMaxSalary() {
        when(employeeServiceMock.employeeMaxSalary(DEFAULT_EMPLOYEE_DEPARTMENTID)).
                thenReturn(DEFAULT_LIST_OF_EMPLOYEES_MIN_MAX_SALARY_IN_DEPT);

        Assertions.assertEquals(DEFAULT_LIST_OF_EMPLOYEES_MIN_MAX_SALARY_IN_DEPT,
                out.employeeMinSalary(DEFAULT_EMPLOYEE_DEPARTMENTID));
    }

    @Test
    public void callServiceMethodWhenFindEmployeeMinSalary() {
        when(employeeServiceMock.employeeMinSalary(DEFAULT_EMPLOYEE_DEPARTMENTID)).
                thenReturn(DEFAULT_LIST_OF_EMPLOYEES_MIN_MAX_SALARY_IN_DEPT);

        Assertions.assertEquals(DEFAULT_LIST_OF_EMPLOYEES_MIN_MAX_SALARY_IN_DEPT,
                out.employeeMinSalary(DEFAULT_EMPLOYEE_DEPARTMENTID));
    }

    @Test
    public void callServiceMethodFindEmployeeAllDepartmentId() {
        when(employeeServiceMock.employeeAllDepartmentId(DEFAULT_EMPLOYEE_DEPARTMENTID)).
                thenReturn(DEFAULT_LIST_OF_EMPLOYEES_MIN_MAX_SALARY_IN_DEPT);

        Assertions.assertEquals(DEFAULT_LIST_OF_EMPLOYEES_MIN_MAX_SALARY_IN_DEPT,
                out.employeeAllDepartmentId(DEFAULT_EMPLOYEE_DEPARTMENTID));
    }

    @Test
    public void callServiceMethodAllEmployeeByDepartments() {
        when(employeeServiceMock.allEmployeeByDepartments()).
                thenReturn(DEFAULT_ALL_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_ALL_EMPLOYEE,
                out.allEmployeeByDepartments());
    }

    @Test
    public void shouldThrowAnExceptionWhenTheServiceUsesTheAddEmployeeMethod() {
        when(employeeServiceMock.addEmployee(anyString(), anyString(), anyInt(), anyInt())).
                thenThrow(InvalidNameException.class);

        Assertions.assertThrows(InvalidNameException.class, () -> out.addEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_DEPARTMENTID,
                DEFAULT_EMPLOYEE_SALARY));
    }

    @Test
    public void shouldThrowAnExceptionWhenTheServiceUsesTheRemoveEmployeeMethod() {
        when(employeeServiceMock.removeEmployee(anyString(), anyString())).
                thenThrow(ThereNoEmployeeException.class);

        Assertions.assertThrows(ThereNoEmployeeException.class, () -> out.removeEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME));
    }

    @Test
    public void shouldThrowAnExceptionWhenTheServiceUsesTheFindEmployeeMethod() {
        when(employeeServiceMock.findEmployee(anyString(), anyString())).
                thenThrow(InvalidNameException.class);

        Assertions.assertThrows(InvalidNameException.class, () -> out.findEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME));
    }
}