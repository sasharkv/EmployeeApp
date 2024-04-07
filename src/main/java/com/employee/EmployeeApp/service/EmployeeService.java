package com.employee.EmployeeApp.service;

import com.employee.EmployeeApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

// Service is a singleton, Spring creates an instance of
// this class and registers it when a Spring app starts up
@Service
public class EmployeeService {

    List<Employee> employeeList = Arrays.asList(
            new Employee(1, "First Emp", "Washington"),
            new Employee(2, "Second Emp", "New York")
    );

    public List<Employee> getAllEmployees(){
        return employeeList;
    }

}
