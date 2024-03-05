package com.rk.iom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rk.iom.model.Resource;


public interface ResourceRepository extends JpaRepository<Resource, Integer>{
	
	@Query("Select res from Resource res where res.category = :category AND res.resType = :resType")
	List<Resource> fetchAllResources(String category, String resType);
  
	@Query("Select res from Resource res where res.emp.empId = :empId")
	List<Resource> findResourceByEmpId(int empId);
	
//	List<Resource> fetchAllResources();
	
}
 