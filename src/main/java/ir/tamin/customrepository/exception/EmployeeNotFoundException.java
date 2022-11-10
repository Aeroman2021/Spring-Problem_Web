package ir.tamin.customrepository.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("The customer with id " + id + " not found");
    }
}
