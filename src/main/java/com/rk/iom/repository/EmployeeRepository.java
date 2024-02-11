package com.rk.iom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.iom.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee ,Integer>{

	public Employee findEmployeeByEmpId(int empId);

}
