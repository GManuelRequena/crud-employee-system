package com.manuel.backendcrudemployeesystem.controller;

import com.manuel.backendcrudemployeesystem.exception.EmployeeNotFoundException;
import com.manuel.backendcrudemployeesystem.model.Employee;
import com.manuel.backendcrudemployeesystem.repository.EmployeeRepository;
import com.manuel.backendcrudemployeesystem.service.EmployeeService;
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

    @Autowired
    EmployeeService employeeService;

    private EmployeeService getEmployeeService(){
        return this.employeeService;
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
        return Optional.ofNullable(this.getEmployeeRepository().findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));
    }

    @PutMapping("employee/{id}")
    Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee){

        Optional<Employee> actualEmployee = Optional.ofNullable(this.getEmployeeRepository().findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));

        return this.getEmployeeService().updateEmployee(id, newEmployee);

    }

    @DeleteMapping("employee/{id}")
    String deleteUser(@PathVariable Long id){

        Optional<Employee> actualEmployee = Optional.ofNullable(this.getEmployeeRepository().findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));

        return this.getEmployeeService().deleteEmployee(actualEmployee.get().getId());
    }
}
