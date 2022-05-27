package pro.sky.Lesson.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.Lesson.Exception.InvalidNameException;
import pro.sky.Lesson.Exception.ThereNoEmployeeException;
import pro.sky.Lesson.Service.Impl.EmployeeServiceImpl;

import static pro.sky.Lesson.Constants.EmployeeServiceTestConstants.*;

public class EmployeeServiceImplTest {

    public final EmployeeService out = new EmployeeServiceImpl();

    @Test
    public void shouldThrowInvalidNameException() {
        Assertions.assertThrows(InvalidNameException.class,
                () -> out.checkInvalidNameException(WRONG_LASTNAME, WRONG_FIRSTNAME));
        Assertions.assertDoesNotThrow(
                () -> out.checkInvalidNameException(RIGHT_LASTNAME, RIGHT_FIRSTNAME));
    }

    @Test
    public void shouldThrowThereEmployeeException() {
        Assertions.assertDoesNotThrow(
                () -> out.checkThereEmployeeException(DEFAULT_EMPLOYEE_MAP, DEFAULT_FULLNAME));
    }

    @Test
    public void shouldThrowThereNoEmployeeException() {
        Assertions.assertThrows(ThereNoEmployeeException.class,
                () -> out.checkEmployeeNotFoundException(DEFAULT_EMPLOYEE_MAP, INVALID_FULLNAME_DEFAULT));
    }

    @Test
    public void shouldThrowNullPointerException() {
        Assertions.assertNotNull(NullPointerException.class,
                () -> String.valueOf(out.allEmployeeByDepartments()));
    }
}