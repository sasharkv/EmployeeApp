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
    // @RequestMapping("/employees")
    // same as:
    // @RequestMapping( value = "/employees", method = RequestMethod.GET)
    // same as:
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id){
        return employeeService.getAnEmployee(id);
    }

    // @RequestMapping(value = "/employees", method = RequestMethod.POST)
    // same as:
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

    // @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    // same as:
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    // @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE )
    // same as:
    @DeleteMapping("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees();
    }
}
