package com.kedu.employee.dto;

import java.sql.Date;

public class EmployeeDTO {
    private String empId;
    private String empName;
    private String phone;
    private int salary;
    private Date hire_date;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public EmployeeDTO(){}

    public EmployeeDTO(String empId, String empName, String phone, int salary, Date hire_date) {
        this.empId = empId;
        this.empName = empName;
        this.phone = phone;
        this.salary = salary;
        this.hire_date = hire_date;
    }
}
