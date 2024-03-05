package com.rk.iom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.iom.model.Employee;
import com.rk.iom.model.Offer;
import com.rk.iom.model.Proposal;
import com.rk.iom.model.Requirement;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

	public Employee findEmployeeByEmpId(int empId);

	
//	List<Offer> findByEmployeeId(int empId);

//	Employee saveEmployee(Employee emp);
//
//	Employee updateEmployee(Employee emp);
//
//	Employee fetchEmployee(int empId);
//
//	Offer statusUpdate(Offer offer);
//
//	Requirement statusUpdate(Requirement req);
//
//	Proposal statusUpdate(Proposal prop);
//
//	List<Offer> fetchAllOffers(int empId);
//
//	List<Requirement> fetchAllRequirements(int empId);
//
//	List<Proposal> fetchAllProposals(int empId);
}
