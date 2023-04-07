package com.example.customerapi.repository;

import com.example.customerapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
