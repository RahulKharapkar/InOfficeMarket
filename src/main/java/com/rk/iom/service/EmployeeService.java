package com.rk.iom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.iom.entity.Employee;
import com.rk.iom.exception.InvalidEmployeeException;
import com.rk.iom.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee getEmployee(int empId)  {
		
			Employee employee = empRepo.findEmployeeByEmpId(empId);
			return employee;
		
	}

	@Transactional
	public Employee addEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}
	
	
	
	

}
