package com.manuel.backendcrudemployeesystem.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id){
        super("Could not find the user with id " + id);
    }
}
