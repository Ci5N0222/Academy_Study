package com.kedu.employee.domain.repository;

import com.kedu.employee.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository  extends JpaRepository<Employee, String> {

    // 직원의 이름으로 검색하여 조회하는 메서드
    List<Employee> findByEmpNameContaining(String empName);

    // 직원의 전화번호로 검색하여 조회하는 메서드
    List<Employee> findByPhoneContaining(String phone);

    // 직원의 이름을 검색하여 해당 직원보다 급여가 높은 사람을 조회하는 메서드
    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT emp.salary FROM Employee emp WHERE emp.empName = :empName)")
    List<Employee> findEmployeesWithHigherSalary(@Param("empName") String empName);

}
