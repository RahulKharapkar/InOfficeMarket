package com.rk.iom.repository; 
import java.util.List;

import com.rk.iom.exception.InvalidRequirementException;
import com.rk.iom.model.Requirement; 


public interface RequirementRepository {
	
	Requirement saveRequirement(Requirement req);
  
	Requirement updateRequirement(Requirement req);
  
	Requirement fetchRequirement(int reqId) throws InvalidRequirementException;
  
	List<Requirement> fetchAllRequirements();
  
	List<Requirement> fetchAllRequirements(String category, String resType); 
	
	void deleteRequirement(int reqId) throws InvalidRequirementException;
	
}
 