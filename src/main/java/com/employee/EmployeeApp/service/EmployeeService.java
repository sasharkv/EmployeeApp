package com.employee.EmployeeApp.service;

import com.employee.EmployeeApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Service is a singleton, Spring creates an instance of
// this class and registers it when a Spring app starts up
@Service
public class EmployeeService {

    // added "new ArrayList<>" because otherwise employeeList would have been immutable.
    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First Emp", "Washington"),
            new Employee(2, "Second Emp", "New York")
    ));

    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    public Employee getAnEmployee(int id){
        return employeeList.stream().filter(e -> (
                e.getEmployeeId() == id)).findFirst().get();
    }

    public void createEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void updateEmployee(Employee employee){
        ArrayList<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList){
            if (emp.getEmployeeId() == employee.getEmployeeId()){
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;
    }

    public void deleteEmployee(int id){
        ArrayList<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList){
            if (emp.getEmployeeId() == id)
                continue; // continue means we're skipping the rest of the part of the loop
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;
    }
}
