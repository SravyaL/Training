package com.verizon.emp.dao;

import java.util.List;

import com.verizon.emp.model.Emplyoee;

public interface EmpDao {


	Emplyoee addEmp(Emplyoee emp);
	Emplyoee updateEmp(Emplyoee emp);
	Emplyoee getEmpById(int empId);
	boolean deleteEmpById(int empId);
	List<Emplyoee> getAllEmp();
}
