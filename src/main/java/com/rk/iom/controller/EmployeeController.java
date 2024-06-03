package com.rk.iom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.iom.exception.InvalidEmployeeException;
import com.rk.iom.model.Employee;
import com.rk.iom.model.Offer;
import com.rk.iom.model.Proposal;
import com.rk.iom.model.Requirement;
import com.rk.iom.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("employeeId") Integer employeeId) {
		logger.info("Request to find employee with ID: {}", employeeId);
		Employee employee = empService.getEmployee(employeeId);
		if (employee == null) {
			logger.warn("Employee with ID: {} not found", employeeId);
			return new ResponseEntity(" Employee not available!", HttpStatus.NOT_FOUND);}
		else {
			
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid Employee employee) {
		int empId = employee.getEmpId();
		Employee emp = empService.addEmployee(employee);
		logger.info("Request to add new employee",empId);

		if (emp == null) {
			logger.error("Error in adding new employee : ",empId);
			return new ResponseEntity("Error in Service", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		}
	}

	@PutMapping("/editEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee) {
		
		int employeeId = employee.getEmpId();
		logger.info("Request to Edit a employee : ", employeeId);
		Employee emp = empService.editEmployee(employee);
		if (emp == null) {
			logger.error("Error in editing an employee", employeeId);
			return new ResponseEntity("Sorry! Employee not editied!", HttpStatus.NOT_FOUND);
		} else {	
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
	}

	@GetMapping("/allOffers/{employeeId}")
	public ResponseEntity<List<Offer>> allOffers(@PathVariable("employeeId") Integer employeeId)
			throws InvalidEmployeeException {
		logger.info(" Request to get an offer based on employeeId : ", employeeId);
		List<Offer> offers = empService.getAllOffers(employeeId);
		return new ResponseEntity<>(offers, HttpStatus.OK);
	}

	@GetMapping("/allRequirements/{employeeId}")
	public ResponseEntity<List<Requirement>> allRequirements(@PathVariable("employeeId") Integer employeeId)
			throws InvalidEmployeeException {
		logger.info(" Request to get a requirement based on employeeId : ",employeeId);
		List<Requirement> requirements = empService.getAllRequirements(employeeId);
		return new ResponseEntity<>(requirements, HttpStatus.OK);
	}
	
	@GetMapping("/allProposals/{employeeId}")
	public ResponseEntity<List<Proposal>> allProposals(@PathVariable("employeeId") Integer employeeId)
			throws InvalidEmployeeException {
		logger.info(" Request to get a proposal based on employeeId : ",employeeId);
		List<Proposal> proposals = empService.getAllProposals(employeeId);
		return new ResponseEntity<>(proposals, HttpStatus.OK);
	}

//	updates isAvailable field in offer , whether offer is available or not by setting true / false 
	@PutMapping("/updateOffer")
	public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer) {
		
		int empId = offer.getEmp().getEmpId();
		Offer off = empService.updateIsAvailable(offer);
		logger.info(" Request recieved in updateOffer to Update isAvailable with empId : ", empId);

		if (off == null) {
			logger.error(" error in updateOffer : ", empId);
			return new ResponseEntity("Sorry! Offer not editied!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(off, HttpStatus.OK);
		}
	}

	@PutMapping("/updateRequirement")
	public ResponseEntity<Requirement> updateRequirement(@RequestBody @Valid Requirement requirement) {
		int empId = requirement.getEmp().getEmpId();
		logger.info("Request to update the requirement with empId : ",empId);
		Requirement req = empService.updateIsFulfilled(requirement);
		if (req == null) {
			logger.error(" Error occured in updateRequirement : ",empId);
			return new ResponseEntity("Sorry! Requirement not editied!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(req, HttpStatus.OK);
		}
	}

	@PutMapping("/updateProposal")
	public ResponseEntity<Proposal> updateProposal(@RequestBody @Valid Proposal proposal) {
		int empId = proposal.getEmp().getEmpId();
		
		logger.info("Request recieved in updateProposal with empId : ", empId);
		Proposal prop = empService.updateIsAccepted(proposal);
		if (prop == null) {
			logger.error(" error in updateProposal with empId : ",empId);
			return new ResponseEntity("Sorry! Proposal cannot editied!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(prop, HttpStatus.OK);
		}
	}

}
