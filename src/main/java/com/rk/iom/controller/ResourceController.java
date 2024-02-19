package com.rk.iom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.iom.exception.InvalidEmployeeException;
import com.rk.iom.model.Resource;
import com.rk.iom.service.ResourceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/resource")
public class ResourceController {
	
	@Autowired
	ResourceService resService;
	
	@GetMapping("/allResources/{empId}")
	public ResponseEntity<List<Resource>> findAllResource(@PathVariable("empId") Integer empId) throws InvalidEmployeeException {
		List<Resource> resources = resService.getAllResources(empId);
		return new ResponseEntity<List<Resource>>(resources, HttpStatus.OK);
	}
	
	@GetMapping("/allResources/{category}/{resType}")
	public  ResponseEntity<List<Resource>> findAllResource(@PathVariable("category") String category,@PathVariable("resType") String resType){
		List<Resource> resources = resService.getAllResources(category, resType);
		if(resources.isEmpty()){
			return new ResponseEntity("Sorry! Resource not available!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Resource>>(resources,HttpStatus.OK);
		}
	}	
	
	@GetMapping("/allResources")
	public  ResponseEntity<List<Resource>> findAllResource(){
		List<Resource> resources = resService.getAllResources();
		if(resources.isEmpty())	{
			return new ResponseEntity("Sorry! Resource not available!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Resource>>(resources,HttpStatus.OK);
		}
	}	
	
}
