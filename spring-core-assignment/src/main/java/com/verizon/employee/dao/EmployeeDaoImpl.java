package com.verizon.employee.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.verizon.employee.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	Map<Integer, Employee> emps;

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
		emps = new TreeMap<>();
		emps.put(2606773, new Employee(2606778, "Sravya", 10000, 12, "DF"));
		emps.put(2606772, new Employee(2606779, "Manoj", 200044, 13, "VES"));
		emps.put(2606769, new Employee(2606769, "Meher", 150000, 15, "VCM"));

	}

	@Override
	public Employee addEmp(Employee emp) {
		// TODO Auto-generated method stub
		return emps.put(emp.getEid(), emp);
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return emps.replace(emp.getEid(), emp);
	}

	@Override
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return emps.get(empId);
	}

	@Override
	public boolean deleteEmpById(int empId) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		if (emps.containsKey(empId)) {
			emps.remove(empId);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return new ArrayList<Employee>(emps.values());
	}

}
