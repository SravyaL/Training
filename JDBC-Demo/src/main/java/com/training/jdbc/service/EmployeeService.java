package com.training.jdbc.service;

import java.util.List;

import com.training.jdbc.model.Employee;

public interface EmployeeService {
    public Employee addEmployee(Employee emp);
    public Employee updateEmployee(Employee emp);
    public void deleteEmployee(Long empId);
    public Employee getEmployeeById(Long empId);
    public List<Employee> listEmployees();
}
