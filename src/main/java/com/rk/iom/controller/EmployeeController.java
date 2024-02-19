package com.rk.iom.controller;

import java.util.List;

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

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("employeeId") Integer employeeId) throws InvalidEmployeeException {
	    Employee employee = empService.getEmployee(employeeId);
	    return ResponseEntity.ok(employee);
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws InvalidEmployeeException{
		Employee emp = empService.addEmployee(employee);
		if(emp == null){
			return new ResponseEntity("Sorry! Employee not available!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
	}
	
	@PutMapping("/editEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee emp = empService.editEmployee(employee);
		if(emp == null){
			return new ResponseEntity("Sorry! Employee not editied!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/allOffers/{employeeId}")
	public ResponseEntity<List<Offer>> allOffers(@PathVariable("employeeId") Integer employeeId) throws InvalidEmployeeException{
		 List<Offer> offers = empService.getAllOffers(employeeId);
		 return new ResponseEntity<>(offers, HttpStatus.OK);
	}
	
	@GetMapping("/allRequirements/{employeeId}")
	public ResponseEntity<List<Requirement>> allRequirements(@PathVariable("employeeId") Integer employeeId) throws InvalidEmployeeException{
		 List<Requirement> requirements = empService.getAllRequirements(employeeId);
		 return new ResponseEntity<>(requirements, HttpStatus.OK);
	}
	
	@GetMapping("/allProposals/{employeeId}")
	public ResponseEntity<List<Proposal>> allProposals(@PathVariable("employeeId") Integer employeeId) throws InvalidEmployeeException{
		 List<Proposal> proposals = empService.getAllProposals(employeeId);
		 return new ResponseEntity<>(proposals, HttpStatus.OK);
	}
	
	
	
//	updates isAvailable field in offer , whether offer is available or not by setting true / false 
	@PutMapping("/updateOffer")
	public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer){
		Offer off = empService.updateIsAvailable(offer);
		if(off == null){
			return new ResponseEntity("Sorry! Offer not editied!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(off,HttpStatus.OK);
		}
	}
	
	@PutMapping("/updateRequirement")
	public ResponseEntity<Requirement> updateRequirement(@RequestBody Requirement requirement){
		Requirement req = empService.updateIsFulfilled(requirement);
		if(req == null){
			return new ResponseEntity("Sorry! Requirement not editied!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(req,HttpStatus.OK);
		}
	}
	
	@PutMapping("/updateProposal")
	public ResponseEntity<Proposal> updateProposal(@RequestBody Proposal proposal){
		Proposal prop = empService.updateIsAccepted(proposal);
		if(prop == null){
			return new ResponseEntity("Sorry! Proposal not editied!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(prop,HttpStatus.OK);
		}
	}
		
	@GetMapping("/check")
	public String checkHello() {
		return "check Hello";
	}
	
}
