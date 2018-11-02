package com.training.jdbc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.jdbc.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
