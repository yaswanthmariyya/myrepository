package com.yaswanth.app04.runner;

import com.yaswanth.app04.beans.Employee;
import com.yaswanth.app04.controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.naming.directory.SearchControls;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private EmployeeController employeeController;
    @Override
    public void run(String... args) throws Exception {
        /*Employee employee = new Employee();
        employee.setEname("Mariyya");
        employee.setEsal(60000);
        employee.setEaddr("Bangalor");
        Employee emp = employeeController.addEmployee(employee);
        System.out.println(emp);*/
/*
        Employee employee = new Employee();
        employee.setEno(2);
        employee.setEname("Yaswanth");
        employee.setEsal(70000);
        employee.setEaddr("hyderbad");
        Employee emp = employeeController.UpdateEmployee(employee);
        System.out.println(emp);*/
       /* String status = employeeController.DeleteEmployee(2);
        System.out.println(status);*/
        Employee employee = employeeController.getEmployeeEname("yaswanth");
        System.out.println(employee);
        Employee employee1 = employeeController.getEmployeeEaddr("chennai");
        System.out.println(employee1);


    }
}
