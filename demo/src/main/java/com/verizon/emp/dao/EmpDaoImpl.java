package com.verizon.emp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.verizon.emp.model.Employee;

@Repository
public class EmpDaoImpl implements EmpDao {

	Map<Integer,Employee> emps;
	
	public EmpDaoImpl() {
		// TODO Auto-generated constructor stub
		emps = new TreeMap<>();
		emps.put(101, new Employee(522,"Srinivasan",678876,12,"CLOUD"));
		emps.put(102, new Employee(5252,"Manoj",468726,13,"IT"));
		emps.put(103, new Employee(645,"Srinivasan",75837,15,"COMM"));
		
	}
	@Override
	public Employee addEmp(Employee emp) {
		// TODO Auto-generated method stub
		return emps.put(emp.getEmpId(), emp);
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return emps.replace(emp.getEmpId(),emp);
	}

	@Override
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return emps.get(empId);
	}

	@Override
	public boolean deleteEmpById(int empId) {
		// TODO Auto-generated method stub
		boolean isDeleted=false;
		if(emps.containsKey(empId))
		{
			emps.remove(empId);
			isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return new ArrayList<Employee>(emps.values());
	}

}
