package pro.sky.Lesson.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ThereEmployeeException extends RuntimeException {
    public ThereEmployeeException(String message) {
        super(message);
    }

    public ThereEmployeeException() {
        super();
    }
}