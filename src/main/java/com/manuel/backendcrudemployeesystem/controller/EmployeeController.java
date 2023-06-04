package com.manuel.backendcrudemployeesystem.controller;

import com.manuel.backendcrudemployeesystem.model.Employee;
import com.manuel.backendcrudemployeesystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    private EmployeeRepository getEmployeeRepository(){
        return this.employeeRepository;
    }

    @PostMapping("employee")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return this.getEmployeeRepository().save(newEmployee);

    }

    @GetMapping("employees")
    List<Employee> getEmployees(){
        return this.getEmployeeRepository().findAll();
    }

    @GetMapping("employee/{id}")
    Optional<Employee> getEmployee(@PathVariable Long id){
        return this.getEmployeeRepository().findById(id);
    }
}
