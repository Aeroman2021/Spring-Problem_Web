package ir.tamin.customrepository.mapper;

import ir.tamin.customrepository.model.EmployeeDTO;
import ir.tamin.customrepository.model.EmployeeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeeDTO modelToDto(EmployeeEntity entity);

    List<EmployeeDTO> modelsToDtos(List<EmployeeEntity> employeeEntityList);

    @InheritInverseConfiguration
    EmployeeEntity dtoToModel(EmployeeDTO employeeDTO);
}