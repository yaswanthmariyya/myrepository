package com.yaswanth.app04.controller;

import com.yaswanth.app04.beans.Employee;
import com.yaswanth.app04.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    public Employee addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);
    }
    public Employee SearchEmployee(int eno) {
        return employeeService.searchEmployee(1);
    }
    public Employee getEmployeeEname(String ename) {
        return employeeService.getEmployeeByEname(ename);
    }
    public Employee getEmployeeEaddr(String eaddr) {
        return employeeService.getEmployeeByEaddr(eaddr);
    }
    public Employee UpdateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }
    public String DeleteEmployee(int eno) {
        return employeeService.deleteEmployee(eno);
    }
}
