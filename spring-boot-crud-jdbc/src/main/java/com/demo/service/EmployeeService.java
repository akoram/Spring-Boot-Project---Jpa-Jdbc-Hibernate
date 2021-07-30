package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.Employee;


public interface EmployeeService {

 public List<Employee> findAll();
	 
	 public Employee findById(int id);
	 

	 public void save(Employee employee);
	 
	 public void update(Employee employee);
	 
	 public void delete(int id);
}
