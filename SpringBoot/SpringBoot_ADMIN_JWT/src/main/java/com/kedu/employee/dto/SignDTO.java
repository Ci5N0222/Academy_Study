package com.kedu.employee.dto;

import java.sql.Timestamp;

public class SignDTO {
    private int empSeq;
    private int empStateCode;
    private String empId;
    private String empPw;
    private String empName;
    private String empEmail;
    private String empBirth;
    private String empGender;
    private String empTel;
    private String empAddress;
    private String empAvatar;
    private int roleCode;
    private String roleName;
    private int deptCode;
    private String deptName;
    private Timestamp joinDate;
    private Timestamp leaveDate;
    private int annualLeaveDay;
    private int workerStateCode;

    public int getEmpSeq() {
        return empSeq;
    }

    public void setEmpSeq(int empSeq) {
        this.empSeq = empSeq;
    }

    public int getEmpStateCode() {
        return empStateCode;
    }

    public void setEmpStateCode(int empStateCode) {
        this.empStateCode = empStateCode;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpPw() {
        return empPw;
    }

    public void setEmpPw(String empPw) {
        this.empPw = empPw;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(String empBirth) {
        this.empBirth = empBirth;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpAvatar() {
        return empAvatar;
    }

    public void setEmpAvatar(String empAvatar) {
        this.empAvatar = empAvatar;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(int deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public Timestamp getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Timestamp leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getAnnualLeaveDay() {
        return annualLeaveDay;
    }

    public void setAnnualLeaveDay(int annualLeaveDay) {
        this.annualLeaveDay = annualLeaveDay;
    }

    public int getWorkerStateCode() {
        return workerStateCode;
    }

    public void setWorkerStateCode(int workerStateCode) {
        this.workerStateCode = workerStateCode;
    }

    public SignDTO(){};

    public SignDTO(int empSeq, int empStateCode, String empId, String empPw, String empName, String empEmail, String empBirth, String empGender, String empTel, String empAddress, String empAvatar, int roleCode, String roleName, int deptCode, String deptName, Timestamp joinDate, Timestamp leaveDate, int annualLeaveDay, int workerStateCode) {
        this.empSeq = empSeq;
        this.empStateCode = empStateCode;
        this.empId = empId;
        this.empPw = empPw;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empBirth = empBirth;
        this.empGender = empGender;
        this.empTel = empTel;
        this.empAddress = empAddress;
        this.empAvatar = empAvatar;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
        this.annualLeaveDay = annualLeaveDay;
        this.workerStateCode = workerStateCode;
    }
}
