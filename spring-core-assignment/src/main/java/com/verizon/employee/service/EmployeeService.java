package com.verizon.employee.service;
 
import java.util.List;
 
import com.verizon.employee.model.Employee;
 
public interface EmployeeService {
 
    Employee addEmp(Employee emp);
    Employee updateEmp(Employee emp);
    Employee getEmpById(int empId);
    boolean deleteEmpById(int empId);
    List<Employee> getAllEmployees();
}
