package com.manuel.backendcrudemployeesystem.service;

import com.manuel.backendcrudemployeesystem.exception.EmployeeNotFoundException;
import com.manuel.backendcrudemployeesystem.model.Employee;
import com.manuel.backendcrudemployeesystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private EmployeeRepository getEmployeeRepository(){
        return this.employeeRepository;
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee){
        Employee actualEmployee = this.getEmployeeRepository().findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        if(updatedEmployee.getFirstName() != null){
            actualEmployee.setFirstName(updatedEmployee.getFirstName());
        }

        if(updatedEmployee.getLastName() != null){
            actualEmployee.setLastName(updatedEmployee.getLastName());
        }

        if(updatedEmployee.getEmail() != null){
            actualEmployee.setEmail(updatedEmployee.getEmail());
        }

        if(updatedEmployee.getDateOfBirth() != null){
            actualEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        }

        if(updatedEmployee.getWorkingSince() != null){
            actualEmployee.setWorkingSince(updatedEmployee.getWorkingSince());
        }

        return this.getEmployeeRepository().save(actualEmployee);
    }

    public String deleteEmployee(Long id){
        this.getEmployeeRepository().deleteById(id);
        return "User with "+id+" has been deleted successfully";
    }
}
