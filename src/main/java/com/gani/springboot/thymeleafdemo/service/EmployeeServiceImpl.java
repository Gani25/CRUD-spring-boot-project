package com.gani.springboot.thymeleafdemo.service;

import com.gani.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.gani.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private final int PAGE_SIZE = 3;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        // return employeeRepository.findAll();
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Page<Employee> getAllEmployees(int pageNum, String sortField, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(
                        sortField).descending();
        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE, sort);
        Page<Employee> pages = employeeRepository.findAll(pageable);

        return pages;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        }
        return theEmployee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
