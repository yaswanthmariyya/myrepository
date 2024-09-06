package com.yaswanth.app04.service;

import com.yaswanth.app04.beans.Employee;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee searchEmployee(int eno);
    public Employee updateEmployee(Employee employee);
    public String deleteEmployee(int eno);
    public Employee getEmployeeByEname(String ename);
    public Employee getEmployeeByEaddr(String eaddr);

}
