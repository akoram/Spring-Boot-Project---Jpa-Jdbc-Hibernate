package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeServiceImpl;


/*@RestController is combination of @Controller and @ResponseBody
It is used to create restful web Service  Using Spring MVC*/
@RestController
//@RequestMapping - it response All request Comes from user starting at /jdbc
@RequestMapping("/jdbc")
public class EmployeeController {

 @Autowired
 private EmployeeServiceImpl employeeService;
 
 //@RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
 @GetMapping("/employees")//get all
 public List<Employee> getAllEmployees() {

	  return employeeService.findAll();
	 }
 	
 	
 	@GetMapping("/employees/{id}")
 	//@PathVariable - It is used to pass the value through URL,Used to Extract the Value From URL
	public Employee getEmployee(@PathVariable int id) {
		
		Employee theEmployee = employeeService.findById(id);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		
		return theEmployee;
	}
 
 
 //@RequestMapping(value="/add", method=RequestMethod.GET)
 @PostMapping("/employees")
//@RequestBody - used to pass mandatory variable to parameter
 public Employee addEmployee(@RequestBody Employee theEmployee) {

	 theEmployee.setId(0);

	 employeeService.save(theEmployee);
  return theEmployee;
 }
 
// @RequestMapping(value="/save", method=RequestMethod.POST)
 @PutMapping("/employees")
//@RequestBody - used to pass mandatory variable to parameter
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.update(theEmployee);
		
		return theEmployee;
	}
 
// @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
 @DeleteMapping("/employees/{id}")
//@PathVariable - It is used to pass the value through URL,Used to Extract the Value From URL
 public String deleteEmployee(@PathVariable("id") int id) {
  employeeService.delete(id);
  
  return "Employee Id is deleted"+id;
 }
}
