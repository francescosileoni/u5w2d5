package francescosileoni.u5w2d5.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class BadRequestException extends RuntimeException{
    private List<ObjectError> errorsList;
    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(List<ObjectError> errorsList){
        super("There are  errors in the payload");
        this.errorsList = errorsList;
    }
}
