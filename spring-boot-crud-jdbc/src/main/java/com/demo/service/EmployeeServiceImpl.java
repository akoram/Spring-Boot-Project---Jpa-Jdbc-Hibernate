package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDAOImpl;
import com.demo.entity.Employee;
//@Service Annotation with class that contains business logics
@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeDAOImpl employeeDao;
	
	 @Override
	 public List<Employee> findAll() {
	  return employeeDao.findAll();
	 }

	 @Override
	 public Employee findById(int id) {
	  return employeeDao.findById(id);
	 }

	 @Override
	 public void save(Employee employee) {
	  employeeDao.save(employee);
	 }

	 @Override
	 public void update(Employee employee) {
	  employeeDao.update(employee);
	 }

	 @Override
	 public void delete(int id) {
	  employeeDao.delete(id);
	 }


}
