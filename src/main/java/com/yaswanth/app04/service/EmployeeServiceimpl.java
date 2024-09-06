package com.yaswanth.app04.service;

import com.yaswanth.app04.beans.Employee;
import com.yaswanth.app04.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return emp;
    }

    @Override
    public Employee searchEmployee(int eno) {
        Employee employee = employeeRepository.findById(eno).get();
        return employee;
    }
    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getEno()).get();
        emp.setEname(employee.getEname());
        emp.setEsal(employee.getEsal());
        emp.setEaddr(employee.getEaddr());
        return emp;
    }

    @Override
    public String deleteEmployee(int eno) {
        Employee emp = employeeRepository.findById(eno).get();
        employeeRepository.delete(emp);
        return "Employee deleted Successfully";
    }

    @Override
    public Employee getEmployeeByEname(String ename) {
        employeeRepository.findByEname(ename);
        return null;
    }

    @Override
    public Employee getEmployeeByEaddr(String eaddr) {
        employeeRepository.findByEaddr(eaddr);
        return null;
    }
}
