package pro.sky.Lesson24.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArrayEmployeesFullException extends RuntimeException {
    public ArrayEmployeesFullException(String message) {
        super(message);
    }

}
