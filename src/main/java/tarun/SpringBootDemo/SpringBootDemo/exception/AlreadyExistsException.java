package tarun.SpringBootDemo.SpringBootDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException {
    private String message;
    public AlreadyExistsException(){}
    public AlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
