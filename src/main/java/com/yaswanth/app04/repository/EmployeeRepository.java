package com.yaswanth.app04.repository;

import com.yaswanth.app04.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findByEname(String ename);
    public Employee findByEaddr(String eaddr);
}
