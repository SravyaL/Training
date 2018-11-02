package com.verizon.adb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.adb.dao.EmployeeRepository;
import com.verizon.adb.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee getEmployeeById(long eid) {
		Employee emp=null;
		
		/*if(contactRepo.existsById(contactId)) {
			contact = contactRepo.findById(contactId).get();
		}*/
		
		Optional<Employee> optEmployee =empRepo.findById(eid);
		if(optEmployee.isPresent()) {
			emp = optEmployee.get();
		}
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee eid) {
		return empRepo.save(eid);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public boolean deleteEmployee(long eid) {
		boolean isDeleted=false;
		if(empRepo.existsById(eid)) {
			empRepo.deleteById(eid);
			isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public boolean existsByMobileNumber(String mobileNumber) {
		return empRepo.existsByMobileNumber(mobileNumber);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		return empRepo.existsByEmailId(emailId);
	}

	@Override
	public Employee findByMobileNumber(String mobileNumber) {
		return empRepo.findByMobileNumber(mobileNumber);
	}

	@Override
	public Employee findByEmailId(String emailId) {
		return empRepo.findByEmailId(emailId);
	}

	@Override
	public List<Employee> findAllByLastName(String lastName) {
		return empRepo.findAllByLastName(lastName);
	}

}
