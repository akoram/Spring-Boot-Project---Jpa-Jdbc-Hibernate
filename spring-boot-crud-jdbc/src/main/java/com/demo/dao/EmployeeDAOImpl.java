package com.demo.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Employee;
import com.demo.entity.EmployeeRowMapper;

/*@Transactional - It create proxy for this method and it allow the framework to
inject the Transactional Logic before and after the Running mrthod*/
@Transactional
/*@Repository annotation is used to indicate the Class Or Interface
provides the mechanism for storing,retrieving,searching,updating,deleting operations on objects.*/
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

		//JdbcTemplate is a central class of jdbc core package - 
	//it is powerful tool to connect with database and execute SQL queries 
	@Autowired
	public JdbcTemplate jdbcTemplate;	
	
	//RowMapper is a interface used by jdbcTemplate. used to map the resultset in row basis
	@Override
	public List<Employee> findAll() {
		 String query = "SELECT * from employee";
		  RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		  List<Employee> employee = jdbcTemplate.query(query, rowMapper);
		  
		  return employee;
	}

	@Override
	public Employee findById(int id) {
		String query = "SELECT * FROM employee WHERE id = ?";
		  RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		  Employee employee = jdbcTemplate.queryForObject(query, rowMapper, id);
		  
		  return employee;
	}

	@Override
	public void save(Employee employee) {
		 String query = "INSERT INTO employee(id, first_name, last_name, email) VALUES(?, ?, ?, ?)";
		  jdbcTemplate.update(query, employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
		  
	}

	@Override
	public void update(Employee employee) {
		String query = "UPDATE employee SET first_name=?, last_name=?, email=? WHERE id=?";
		  jdbcTemplate.update(query, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getId());
		  
	}

	@Override
	public void delete(int id) {
		 String query = "DELETE FROM employee WHERE id=?";
		  jdbcTemplate.update(query,id);
		 }




}

