package com.kedu.employee.domain.repository;

import com.kedu.employee.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository  extends JpaRepository<Employee, String> {

    List<Employee> findByEmpNameContaining(String empName);
    List<Employee> findByPhoneContaining(String phone);
}
