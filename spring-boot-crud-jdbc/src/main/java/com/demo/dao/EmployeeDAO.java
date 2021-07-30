package com.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.entity.Employee;

@Repository
public interface EmployeeDAO {
	
	 public List<Employee> findAll();
	 
	 public Employee findById(int id);
	 

	 public void save(Employee employee);
	 
	 public void update(Employee employee);
	 
	 public void delete(int id);
}
