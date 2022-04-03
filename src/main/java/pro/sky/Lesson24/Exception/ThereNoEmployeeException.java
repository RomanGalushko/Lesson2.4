package pro.sky.Lesson24.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ThereNoEmployeeException extends RuntimeException {
    public ThereNoEmployeeException(String message) {
        super(message);
    }


}