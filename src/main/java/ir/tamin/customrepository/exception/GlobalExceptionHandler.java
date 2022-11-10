package ir.tamin.customrepository.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@RestControllerAdvice
public class GlobalExceptionHandler implements ProblemHandling {

    @ExceptionHandler
    public ResponseEntity<Problem> handleEmployeeNotFound(EmployeeNotFoundException ex, NativeWebRequest request) {
        ThrowableProblem problem = Problem.builder().withStatus(Status.NOT_FOUND)
                .withTitle("Employee Not Found.")
                .withDetail(ex.getMessage())
                .build();
        return create(problem,request);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleEmptyField(EmptyFieldException ex, NativeWebRequest request) {
        ThrowableProblem problem = Problem.builder().withStatus(Status.BAD_REQUEST)
                .withTitle("Empty firstName or lastName")
                .withDetail(ex.getMessage())
                .build();
        return create(problem,request);
    }
}
