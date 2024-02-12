package com.rk.iom.repositoryimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.rk.iom.entity.Employee;
import com.rk.iom.repository.EmployeeRepository;

public abstract  class EmployeeRepositoryImpl implements EmployeeRepository{

	@Autowired
	EmployeeRepository empRepo;
	
	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	};

}
