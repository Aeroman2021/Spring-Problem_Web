package ir.tamin.customrepository.ws;

import ir.tamin.customrepository.model.EmployeeEntity;
import ir.tamin.customrepository.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/Employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeEntity> create(@RequestBody  EmployeeEntity employeeEntity){
        EmployeeEntity result = employeeService.create(employeeEntity);
        return new ResponseEntity<>(result,new HttpHeaders(), HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity<EmployeeEntity> update(@RequestBody EmployeeEntity employeeEntity){
//        EmployeeEntity result = employeeService.saveOrUpdate(employeeEntity);
//        return new ResponseEntity<>(result,new HttpHeaders(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getById(@PathVariable Long id){
        EmployeeEntity result = employeeService.findById(id);
        return new ResponseEntity<>(result,new HttpHeaders(),HttpStatus.OK);
    }


    @GetMapping( produces = "application/json")
    public ResponseEntity<List<EmployeeEntity>> getAll(){
        List<EmployeeEntity> result = employeeService.findAll();
        return new ResponseEntity<>(result,new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<EmployeeEntity>> getAllByPageNumberAndSize(@PathVariable int page,
                                                                          @PathVariable int size){
        List<EmployeeEntity> result = employeeService.findAll(page,size);
        return new ResponseEntity<>(result,new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<EmployeeEntity>> delete(Long id){
        employeeService.deleteById(id);
        return new ResponseEntity<>(new HttpHeaders(),HttpStatus.OK);
    }

}
