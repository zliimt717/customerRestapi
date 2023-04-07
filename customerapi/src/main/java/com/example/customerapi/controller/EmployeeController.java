package com.example.customerapi.controller;

import com.example.customerapi.entity.Employee;
import com.example.customerapi.repository.EmployeeRepository;
import com.example.customerapi.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> allEmployees(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) throws Exception {
        return employeeService.findById(id);
    }

    @PostMapping("/employees/post/employee")
    Employee createEmployee(@RequestBody Employee newEmployee){
        return employeeService.createEmployee(newEmployee);
    }

   @PutMapping("/employees/put/{id}")
    Optional<Employee> replaceCustomer(@RequestBody Employee newEmployee, @PathVariable Long id){
        return employeeService.replaceCustomer(newEmployee,id);

    }

     @DeleteMapping("/employees/delete/{id}")
    Employee deleteEmployee(@PathVariable Long id){
        return employeeService.deleteById(id);
    }
}
