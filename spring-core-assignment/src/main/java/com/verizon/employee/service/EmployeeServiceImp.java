package com.verizon.employee.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.verizon.employee.dao.EmployeeDao;
import com.verizon.employee.model.Employee;
 
@Service
public class EmployeeServiceImp implements EmployeeService{
 
    @Autowired
    private EmployeeDao empDao;
    @Override
    public Employee addEmp(Employee emp) {
        // TODO Auto-generated method stub
        return empDao.addEmp(emp);
    }
 
    @Override
    public Employee updateEmp(Employee emp) {
        // TODO Auto-generated method stub
        return empDao.updateEmp(emp);
    }
 
    @Override
    public Employee getEmpById(int empId) {
        // TODO Auto-generated method stub
        return empDao.getEmpById(empId);
    }
 
    @Override
    public boolean deleteEmpById(int empId) {
        // TODO Auto-generated method stub
        return empDao.deleteEmpById(empId);
    }
 
    @Override
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return empDao.getAllEmployees();
    }
 
    
 
}
 
