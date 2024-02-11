package com.rk.iom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	    return  ResponseEntity.ok(employee);
	}
	
	@GetMapping("/check")
	public String checkHello() {
		return "check Hello";
	}
	
}
