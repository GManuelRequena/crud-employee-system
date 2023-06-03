package com.manuel.backendcrudemployeesystem.repository;

import com.manuel.backendcrudemployeesystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
