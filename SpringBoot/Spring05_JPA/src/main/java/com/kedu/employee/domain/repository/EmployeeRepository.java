package com.kedu.employee.domain.repository;

import com.kedu.employee.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository  extends JpaRepository<Employee, String> {

    List<Employee> findByEmpNameContaining(String empName);
    List<Employee> findByPhoneContaining(String phone);

    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT emp.salary FROM Employee emp WHERE emp.empName = :empName)")
    List<Employee> findEmployeesWithHigherSalary(@Param("empName") String empName);

}
