package com.employee.EmployeeApp.controller;

import com.employee.EmployeeApp.entity.Employee;
import com.employee.EmployeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody //because we're passing the return employeeList
/* @RestController //same as the two annotations above combined */
public class EmployeeController {

    // Autowired annotation checks if there are any dependencies of this
    // particular file and inject the dependencies over here
    @Autowired
    EmployeeService employeeService;

    // by default @RequestMapping considers this request as a GET
    @RequestMapping("/employees")
    public List<Employee> findAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id){
        return employeeService.getAnEmployee(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }


}
