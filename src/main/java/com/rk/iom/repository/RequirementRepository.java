package com.rk.iom.repository; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rk.iom.exception.InvalidRequirementException;
import com.rk.iom.model.Requirement; 


public interface RequirementRepository extends JpaRepository<Requirement ,Integer>{
	
//	Requirement saveRequirement(Requirement req);
//  
//	Requirement updateRequirement(Requirement req);
//  
//	Requirement fetchRequirement(int reqId) throws InvalidRequirementException;
//  
//	List<Requirement> fetchAllRequirements();
  
//	void deleteRequirement(int reqId) throws InvalidRequirementException;
	
	@Query("Select req from Requirement req where req.category = :category AND req.resType = :resType")
	List<Requirement> fetchAllRequirements(String category, String resType); 
	

	@Query("Select req from Requirement req where req.emp.empId = :empId")
	List<Requirement> findRequirementByEmpId(int empId);

	Requirement findRequirementByReqId(int reqId);
	
}
 