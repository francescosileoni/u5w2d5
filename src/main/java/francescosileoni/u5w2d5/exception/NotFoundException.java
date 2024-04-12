package francescosileoni.u5w2d5.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int id){
        super("The record with id " + id +"is not found");
    }
}
