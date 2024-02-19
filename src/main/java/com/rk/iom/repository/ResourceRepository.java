package com.rk.iom.repository;

import java.util.List;

import com.rk.iom.model.Resource;


public interface ResourceRepository {
	
	List<Resource> fetchAllResources(String category, String resType);
  
	List<Resource> fetchAllResources(int empId);
	
	List<Resource> fetchAllResources();
	
}
 