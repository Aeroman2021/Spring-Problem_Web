package ir.tamin.customrepository.repository;


import ir.tamin.customrepository.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>,CustomEmployeeRepository {


}
