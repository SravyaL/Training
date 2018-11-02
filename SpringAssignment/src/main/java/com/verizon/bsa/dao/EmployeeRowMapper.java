package com.verizon.bsa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.verizon.bsa.model.Employee;

import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee book = new Employee();

		book.setEid(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setBasic(rs.getDouble(3));
		book.setHra(rs.getDouble(4));
		book.setDept(rs.getString(5));

		return book;
	}

}
