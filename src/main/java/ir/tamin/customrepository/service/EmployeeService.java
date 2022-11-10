package ir.tamin.customrepository.service;


import ir.tamin.customrepository.exception.EmployeeNotFoundException;
import ir.tamin.customrepository.exception.EmptyFieldException;
import ir.tamin.customrepository.model.EmployeeEntity;
import ir.tamin.customrepository.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

//    public EmployeeEntity saveOrUpdate(EmployeeEntity employeeEntity){
//
//        Optional<EmployeeEntity> foundEntity = employeeRepository.findById(employeeEntity.getId());
//        if (foundEntity.isPresent()){
//            EmployeeEntity foundedEntity = foundEntity.get();
//            foundedEntity.setFirstName(employeeEntity.getFirstName());
//            foundedEntity.setLastName(employeeEntity.getLastName());
//            return foundedEntity;
//        }
//        else
//            return  employeeRepository.save(employeeEntity);
//    }

    public EmployeeEntity create(EmployeeEntity employeeEntity){
        if(employeeEntity.getFirstName() == null || employeeEntity.getLastName() == null){
            throw new EmptyFieldException();
        }else
            return employeeRepository.save(employeeEntity);
    }

    public void deleteById(Long id){
        Optional<EmployeeEntity> foundedEntity = employeeRepository.findById(id);
        if(foundedEntity.isPresent()){
            employeeRepository.deleteById(id);
        }else
            throw new EmployeeNotFoundException(id);
    }

    public EmployeeEntity findById(Long id){
         return employeeRepository.findById(id)
                    .orElseThrow(()->new EmployeeNotFoundException(id));
    }

    public List<EmployeeEntity> findAll(){
        return employeeRepository.findAll();
    }


    public List<EmployeeEntity> findAll(int page,int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Pageable pageable = pageRequest.toOptional().get();
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll(pageable).getContent();
        return employeeEntityList;

    }


    public String findFirstNameById(Long firstName){
        return  employeeRepository.getFirstName(firstName);
    }



}
