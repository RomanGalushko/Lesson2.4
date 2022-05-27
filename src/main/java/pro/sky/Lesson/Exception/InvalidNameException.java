package pro.sky.Lesson.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(String fullName) {
        super(fullName);
    }

    public InvalidNameException() {
        super();
    }
}