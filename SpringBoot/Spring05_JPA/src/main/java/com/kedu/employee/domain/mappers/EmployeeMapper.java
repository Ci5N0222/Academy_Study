package com.kedu.employee.domain.mappers;

import com.kedu.employee.domain.entity.Employee;
import com.kedu.employee.dto.EmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper{
    EmployeeDTO toEmployeeDTO(Employee entity);
    Employee toEmployee(EmployeeDTO dto);

    List<EmployeeDTO> toEmployeeDTOList(List<Employee> list);
    List<Employee> toEmployeeList(List<EmployeeDTO> list);

}
