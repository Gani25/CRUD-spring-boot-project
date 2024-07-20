package com.gani.springboot.thymeleafdemo.service;

import com.gani.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    void deleteEmployeeById(int id);

    Page<Employee> getAllEmployees(int pageNum, String sortField, String sortDir);
}
