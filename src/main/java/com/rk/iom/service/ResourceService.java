package com.rk.iom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.iom.exception.InvalidEmployeeException;
import com.rk.iom.model.Resource;
import com.rk.iom.repository.ResourceRepository;

@Service
public class ResourceService {

	@Autowired
	public ResourceRepository resRepo;

	public List<Resource> getAllResources(String category, String resType) {
		return resRepo.fetchAllResources(category, resType);
	}

	public List<Resource> getAllResources(int empId) throws InvalidEmployeeException {
//		if (resRepo.fetchAllResources(empId).isEmpty())
//			throw new InvalidEmployeeException("No Resources available for the EmpId : " + empId);
//		else
			return resRepo.fetchAllResources(empId);
	}

	public List<Resource> getAllResources() {

		return resRepo.fetchAllResources();
	}
}
