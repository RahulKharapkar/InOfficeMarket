package com.rk.iom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.iom.exception.InvalidEmployeeException;
import com.rk.iom.model.Employee;
import com.rk.iom.model.Offer;
import com.rk.iom.model.Proposal;
import com.rk.iom.model.Requirement;
import com.rk.iom.repository.EmployeeRepository;
import com.rk.iom.repository.OfferRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	OfferRepository offerRepo;
	
//	public Employee getEmployee(int empId)  {
//		
//			Employee employee = empRepo.findEmployeeByEmpId(empId);
//			return employee;
//		
//	}

//	@Transactional
//	public Employee addEmployee(Employee employee) {
//		
//		return empRepo.save(employee);
//	}
//	
//	
//	public Employee editEmployee(Employee emp) {
//		return empRepo.save(emp);
//	}
	
//	public Offer updateIsAvailable(Offer offer) {
//		
//	}
	
//	public List<Offer> getAllOffers(int empId) throws InvalidEmployeeException {
//		if(offerRepo.findOffersForEmployeeId(empId).isEmpty()){
//			throw new InvalidEmployeeException("No Offers available for the EmpId : " +empId);
//		}
//		else{
//			return offerRepo.findOffersForEmployeeId(empId);
//		}
//	}
	
	
	@Transactional
	public Employee addEmployee(Employee emp) {
		
		return empRepo.saveEmployee(emp);
	}

	
	@Transactional
	public Employee editEmployee(Employee emp) {
		
		return empRepo.updateEmployee(emp);
	}

	
	public Employee getEmployee(int empId) throws InvalidEmployeeException {
//		if(empRepo.fetchEmployee(empId) == null){
//			
//			throw new InvalidEmployeeException("Invalid Employee Exception, No Employee with Id : " + empId);
//		}
//		else
			Employee employee = empRepo.fetchEmployee(empId);
			return employee;
		
	}

	
	@Transactional
	public Offer updateIsAvailable(Offer offer) {
		
		return empRepo.statusUpdate(offer);
		
	}

	
	@Transactional
	public Requirement updateIsFulfilled(Requirement req) {
		empRepo.statusUpdate(req);
		return req;
	}

	
	@Transactional
	public Proposal updateIsAccepted(Proposal prop) {
		empRepo.statusUpdate(prop);
		return prop;
	}

	
	public List<Offer> getAllOffers(int empId) throws InvalidEmployeeException {
//		if(empRepo.fetchAllOffers(empId).isEmpty())
//			throw new InvalidEmployeeException("No Offers available for the EmpId : " +empId);
//		
//		else
			return empRepo.fetchAllOffers(empId);
		
	}
	
	
	public List<Requirement> getAllRequirements(int empId) throws InvalidEmployeeException {
//		if(empRepo.fetchAllRequirements(empId).isEmpty())
//			throw new InvalidEmployeeException("No requirements available for the EmpId : " +empId);
//		
//		else
			return empRepo.fetchAllRequirements(empId);
		
	}

	
	public List<Proposal> getAllProposals(int empId) throws InvalidEmployeeException {
//		if(empRepo.fetchAllProposals(empId).isEmpty()){
//			throw new InvalidEmployeeException("No Proposals available for the EmpId : " +empId);
//		}
//		else
			return empRepo.fetchAllProposals(empId);
		
	}
	
	

}
