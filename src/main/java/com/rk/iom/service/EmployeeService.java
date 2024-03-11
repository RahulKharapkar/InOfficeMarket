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
import com.rk.iom.repository.ProposalRepository;
import com.rk.iom.repository.RequirementRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	OfferRepository offerRepo;

	@Autowired
	RequirementRepository reqRepo;

	@Autowired
	ProposalRepository propRepo;

	public Employee getEmployee(int empId) {

		return empRepo.findEmployeeByEmpId(empId);

	}

	@Transactional
	public Employee addEmployee(Employee employee) {

		return empRepo.save(employee);
	}

	@Transactional
	public Employee editEmployee(Employee emp) {

		return empRepo.save(emp);
	}

//	Employee -- Offer Section

	public List<Offer> getAllOffers(int empId) throws InvalidEmployeeException {
		if (offerRepo.findOffersForEmployeeId(empId).isEmpty()) {
			throw new InvalidEmployeeException("No Offers available for the EmpId : " + empId);
		} else {
			return offerRepo.findOffersForEmployeeId(empId);
		}
	}

	@Transactional
	public Offer updateIsAvailable(Offer offer) {

		return offerRepo.save(offer);

	}

// update isFullfield value to requirement  

	@Transactional
	public Requirement updateIsFulfilled(Requirement req) {
		reqRepo.save(req);
		return req;
	}

// update if proposal is accepted in proposal table of db.	
	@Transactional
	public Proposal updateIsAccepted(Proposal prop) {

		propRepo.save(prop);
		return prop;
	}

// get requirements by employeeId 	
	
	public List<Requirement> getAllRequirements(int empId) throws InvalidEmployeeException {
	    List<Requirement> requirements = reqRepo.findRequirementByEmpId(empId);

	    if (requirements == null || requirements.isEmpty()) {
	        throw new InvalidEmployeeException("No requirements available for the EmpId : " + empId);
	    } else {
	        return requirements;
	    }
	}


// find proposal for a particular employee	
	public List<Proposal> getAllProposals(int empId) throws InvalidEmployeeException {
		if (propRepo.findProposalByEmpId(empId).isEmpty()) {
			throw new InvalidEmployeeException("No Proposals available for the EmpId : " + empId);
		} else
			return propRepo.findProposalByEmpId(empId);

	}

}
