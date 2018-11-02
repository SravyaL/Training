package com.verizon.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.emp.dao.EmpDao;
import com.verizon.emp.model.Emplyoee;
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDao;
	@Override
	public Emplyoee addEmp(Emplyoee emp) {
		// TODO Auto-generated method stub
		return empDao.addEmp(emp);
	}

	@Override
	public Emplyoee updateEmp(Emplyoee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmp(emp);
	}

	@Override
	public Emplyoee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return empDao.getEmpById(empId);
	}

	@Override
	public boolean deleteEmpById(int empId) {
		// TODO Auto-generated method stub
		return empDao.deleteEmpById(empId);
	}

	@Override
	public List<Emplyoee> getAllEmp() {
		// TODO Auto-generated method stub
		return empDao.getAllEmp();
	}

	

}
