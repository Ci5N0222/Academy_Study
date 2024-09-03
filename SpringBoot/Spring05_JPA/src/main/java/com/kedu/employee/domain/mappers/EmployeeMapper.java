package com.kedu.employee.domain.mappers;

import com.kedu.employee.domain.entity.Employee;
import com.kedu.employee.dto.EmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper{

    // Entity를 DTO로 변환
    EmployeeDTO toEmployeeDTO(Employee entity);
    List<EmployeeDTO> toEmployeeDTOList(List<Employee> list);
    
    // DTO를 Entity로 변환
    Employee toEmployee(EmployeeDTO dto);
    List<Employee> toEmployeeList(List<EmployeeDTO> list);

}
