package com.verizon.emp.dao;

import java.util.List;

import com.verizon.emp.model.Employee;

public interface EmpDao {


	Employee addEmp(Employee emp);
	Employee updateEmp(Employee emp);
	Employee getEmpById(int empId);
	boolean deleteEmpById(int empId);
	List<Employee> getAllEmp();
}
