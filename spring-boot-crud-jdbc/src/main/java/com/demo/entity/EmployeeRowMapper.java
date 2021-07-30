package com.demo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee theEmployee = new Employee();
		
		theEmployee.setId(rs.getInt("id"));
		  theEmployee.setFirstName(rs.getString("first_name"));
		  theEmployee.setLastName(rs.getString("last_name"));
		  theEmployee.setEmail(rs.getString("email"));
		
		return theEmployee;
	}

}
