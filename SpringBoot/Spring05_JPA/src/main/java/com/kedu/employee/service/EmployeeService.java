package com.kedu.employee.service;

import com.kedu.employee.domain.entity.Employee;
import com.kedu.employee.domain.mappers.EmployeeMapper;
import com.kedu.employee.domain.repository.EmployeeRepository;
import com.kedu.employee.dto.EmployeeDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    /** 직원 목록 **/
    public List<EmployeeDTO> getList() {
        List<Employee> list = employeeRepository.findAll();
        return employeeMapper.toEmployeeDTOList(list);
    }

    /** 직원 검색 (이름, 전화번호) **/
    public List<EmployeeDTO> searchList(String type, String data) {
        if(type.equals("phone")){
            List<Employee> list = employeeRepository.findByPhoneContaining(data);
            return employeeMapper.toEmployeeDTOList(list);
        } else if(type.equals("name")) {
            List<Employee> list = employeeRepository.findByEmpNameContaining(data);
            return employeeMapper.toEmployeeDTOList(list);
        } else {
            List<Employee> list = employeeRepository.findEmployeesWithHigherSalary(data);
            return employeeMapper.toEmployeeDTOList(list);
        }
    }

    /** 직원 정보 수정 **/
    public void updateEmp(EmployeeDTO employeeDTO) {
        Employee emp =  employeeRepository.findById(employeeDTO.getEmpId()).orElseThrow(() -> new EntityNotFoundException("Employee Not Found"));
        emp.setEmpId(employeeDTO.getEmpId());
        emp.setEmpName(employeeDTO.getEmpName());
        emp.setPhone(employeeDTO.getPhone());
        emp.setSalary(employeeDTO.getSalary());
        emp.setHire_date(employeeDTO.getHire_date());

        employeeRepository.save(emp);
    }

    /** 직원 삭제 **/
    public void deleteEmp(String empId) {
        employeeRepository.deleteById(empId);
    }

}
