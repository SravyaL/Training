package com.training.jdbc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.jdbc.dao.EmployeeRepository;
import com.training.jdbc.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;
    
    @Transactional
    @Override
    public Employee addEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    @Transactional
    @Override
    public void deleteEmployee(Long empId) {
        empRepo.deleteById(empId);
    }

    @Override
    public Employee getEmployeeById(Long empId) {   
        Optional<Employee> emp = empRepo.findById(empId);
        return emp.isPresent()?emp.get():null;
    }

    @Override
    public List<Employee> listEmployees() {
        return empRepo.findAll();
    }

}
