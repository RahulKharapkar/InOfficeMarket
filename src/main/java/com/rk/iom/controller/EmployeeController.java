package com.rk.iom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rk.iom.entity.Employee;
import com.rk.iom.exception.InvalidEmployeeException;
import com.rk.iom.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("employeeId") Integer employeeId) throws Exception {
	    Employee employee = empService.getEmployee(employeeId);
	    System.out.println("employee retrieved : ");
	    return  ResponseEntity.ok(employee);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws InvalidEmployeeException{
		Employee emp = empService.addEmployee(employee);
		if(emp == null){
			return new ResponseEntity("Error In Webservice", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
	}
	
	@GetMapping("/check")
	public String checkHello() {
		return "check Hello";
	}
	
}
