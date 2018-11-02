package com.verizon.employee.dao;
 
import java.util.List;
 
import com.verizon.employee.model.Employee;
 
public interface EmployeeDao {
 
    Employee addEmp(Employee emp);
    Employee updateEmp(Employee emp);
    Employee getEmpById(int empId);
    boolean deleteEmpById(int empId);
    List<Employee> getAllEmployees();
}
