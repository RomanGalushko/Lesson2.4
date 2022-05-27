package pro.sky.Lesson.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ThereNoEmployeeException extends RuntimeException {
    public ThereNoEmployeeException(String message) {
        super(message);
    }

    public ThereNoEmployeeException() {
        super();
    }
}