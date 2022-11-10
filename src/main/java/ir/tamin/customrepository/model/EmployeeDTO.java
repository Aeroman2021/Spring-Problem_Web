package ir.tamin.customrepository.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmployeeDTO {
    @Id
    private Long id;
    private String firstName;
    private String lastName;

}
