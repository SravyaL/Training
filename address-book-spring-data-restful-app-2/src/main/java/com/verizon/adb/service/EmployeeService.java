package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(long eid);
	List<Employee> getAllEmployees();
	Employee addEmployee(Employee emp);
	Employee updateEmployee(Employee emp);
	boolean deleteEmployee(long eid);
	
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String emailId);
	
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmailId(String emailId);
	
	List<Employee> findAllByLastName(String lastName);
	
}
