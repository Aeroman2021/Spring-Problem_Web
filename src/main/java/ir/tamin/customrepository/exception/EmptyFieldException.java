package ir.tamin.customrepository.exception;

public class EmptyFieldException extends RuntimeException{
    public EmptyFieldException() {
        super("firstName or lastName is empty.");
    }


}
