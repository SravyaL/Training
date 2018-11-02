package com.verizon.emp.service;

import java.util.List;

import com.verizon.emp.model.Emplyoee;

public interface EmpService {

	Emplyoee addEmp(Emplyoee emp);
	Emplyoee updateEmp(Emplyoee emp);
	Emplyoee getEmpById(int empId);
	boolean deleteEmpById(int empId);
	List<Emplyoee> getAllEmp();
}
