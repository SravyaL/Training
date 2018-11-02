package com.verizon.emp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.verizon.emp.model.Emplyoee;
@Repository
public class EmpDaoInMemoryimpl implements EmpDao {

	Map<Integer,Emplyoee> emps;
	
	public EmpDaoInMemoryimpl() {
		// TODO Auto-generated constructor stub
		emps = new TreeMap<>();
		emps.put(101, new Emplyoee(101,"Sravya",10000,12,"CLOUD"));
		emps.put(102, new Emplyoee(102,"Mayukha",200044,13,"IT"));
		emps.put(103, new Emplyoee(103,"Meher",15000,15,"COMM"));
		
	}
	@Override
	public Emplyoee addEmp(Emplyoee emp) {
		// TODO Auto-generated method stub
		return emps.put(emp.getEmpId(), emp);
	}

	@Override
	public Emplyoee updateEmp(Emplyoee emp) {
		// TODO Auto-generated method stub
		return emps.replace(emp.getEmpId(),emp);
	}

	@Override
	public Emplyoee getEmpById(int empId) {
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
	public List<Emplyoee> getAllEmp() {
		// TODO Auto-generated method stub
		return new ArrayList<Emplyoee>(emps.values());
	}

}
