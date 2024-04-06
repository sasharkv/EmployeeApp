package com.employee.EmployeeApp.controller;

import com.employee.EmployeeApp.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody //because we're passing the return employeeList
/* @RestController //same as the two annotations above combined */
public class EmployeeController {

    @RequestMapping("/employees")
    public List<Employee> findAllEmployees(){
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "First Emp", "Washington"),
                new Employee(2, "Second Emp", "New York")
        );
        return employeeList;
    }
}
