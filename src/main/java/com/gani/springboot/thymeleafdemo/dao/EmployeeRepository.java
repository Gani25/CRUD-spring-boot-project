package com.gani.springboot.thymeleafdemo.dao;

import com.gani.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it no need to write any code..

    // add a custom method to sort by first name
    public List<Employee> findAllByOrderByFirstNameAsc();
}
