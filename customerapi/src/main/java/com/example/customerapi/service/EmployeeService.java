package com.example.customerapi.service;

import com.example.customerapi.entity.Employee;
import com.example.customerapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    List<Employee> employees =new ArrayList<>();

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployee(){
        employees =employeeRepository.findAll();
        return employees;
    }

    public Employee findById(long id) throws Exception {
       return employeeRepository.findById(id)
                .orElseThrow(()->new Exception("Customer can not find"));
    }

    public Employee createEmployee (Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> replaceCustomer (Employee newEmployee, Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstname(newEmployee.getFirstname());
                    employee.setLastname(newEmployee.getLastname());

                    return employeeRepository.save(employee);
                });
    }

    public Employee deleteById(Long id){
        employees =employeeRepository.findAll();
        Iterator<Employee> iterator= employees.iterator();
        while (iterator.hasNext()){
            Employee employee=iterator.next();
            if(employee.getId()==id){
                iterator.remove();
                employeeRepository.deleteById(id);
                return employee;
            }
        }
        return null;
    }

}
