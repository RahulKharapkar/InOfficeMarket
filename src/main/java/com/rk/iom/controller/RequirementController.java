package com.rk.iom.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.iom.exception.InvalidRequirementException;
import com.rk.iom.model.Requirement;
import com.rk.iom.service.RequirementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RequirementController {
	@Autowired
	RequirementService reqService;
	

	@GetMapping("/requirement/getRequirement/{reqId}")
	public ResponseEntity<Requirement> findRequirement(@PathVariable("reqId") Integer reqId ) throws InvalidRequirementException{
		Requirement requirement = reqService.getRequirement(reqId);
		return new ResponseEntity<Requirement>(requirement,HttpStatus.OK);
	}
	
	@GetMapping("/requirement/allrequirements")
	public ResponseEntity<List<Requirement>> allRequirements(){
		
		 List<Requirement> req = reqService.getAllRequirements();
		 if(req == null){
			 return new ResponseEntity("Sorry! Requirements are not available. " , HttpStatus.NOT_FOUND);
		 }
		 else {
			 return new ResponseEntity<List<Requirement>>(req, HttpStatus.OK);
		 }
	}
	
	@GetMapping("/requirement/allrequirements/{category}/{resType}")
	public ResponseEntity<List<Requirement>> allRequirements(@PathVariable("category") String category,@PathVariable("resType") String resType){
		
		List<Requirement> req = reqService.getAllRequirements(category, resType);
		if(req == null){
			 return new ResponseEntity("Sorry! Requirements are not available. " , HttpStatus.NOT_FOUND);
		 }
		 else {
			 return new ResponseEntity<List<Requirement>>(req, HttpStatus.OK);
		 }
		
	}
	
	@PostMapping("/requirement/addRequirement")
		public ResponseEntity<Requirement>  saveRequirement(@RequestBody Requirement requirement){
			Requirement req = reqService.addRequirement(requirement);
			if(req == null) {
				return new ResponseEntity("Sorry! Requirements are not available. " , HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<Requirement>(req,HttpStatus.OK);
			}
	}
	
	@PutMapping("/requirement/editRequirement")
	public ResponseEntity<Requirement> updateRequirement(@RequestBody Requirement requirement){
		Requirement req = reqService.editRequirement(requirement);
		if(req == null) {
			return new ResponseEntity("oops! Requirement caonnot be edited " , HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Requirement>(req,HttpStatus.OK);
		}
		
	}
	
	
	@DeleteMapping("/requirement/deleteRequirements/{reqId}")
	public ResponseEntity<List<Requirement>> deleteRequirement(@PathVariable("reqId")Integer reqId) throws InvalidRequirementException{
		
		List<Requirement> req = reqService.removeRequirement(reqId);
		return new ResponseEntity<List<Requirement>>(req,HttpStatus.OK);	
	}
	
	
	

}
