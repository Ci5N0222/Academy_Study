package com.kedu.employee.controller;

import com.kedu.employee.dto.EmployeeDTO;
import com.kedu.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> list(){
        List<EmployeeDTO> list = employeeService.getList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{type}/{empName}")
    public ResponseEntity<List<EmployeeDTO>> searchlist(@PathVariable String type, @PathVariable String empName){
        List<EmployeeDTO> list = employeeService.searchList(type, empName);
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<Void> update(@PathVariable String empId, @RequestBody EmployeeDTO employeeDTO){
        employeeService.updateEmp(employeeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{empId}")
    public ResponseEntity<Void> delete(@PathVariable String empId){
        employeeService.deleteEmp(empId);
        return ResponseEntity.ok().build();
    }

}
