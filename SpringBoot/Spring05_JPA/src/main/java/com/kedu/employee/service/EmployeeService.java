package com.kedu.employee.service;

import com.kedu.employee.domain.entity.Employee;
import com.kedu.employee.domain.mappers.EmployeeMapper;
import com.kedu.employee.domain.repository.EmployeeRepository;
import com.kedu.employee.dto.EmployeeDTO;
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
        } else {
            List<Employee> list = employeeRepository.findByEmpNameContaining(data);
            return employeeMapper.toEmployeeDTOList(list);
        }

    }

    /** 직원 삭제 **/
    public void deleteEmp(String empId) {
        employeeRepository.deleteById(empId);
    }

}
