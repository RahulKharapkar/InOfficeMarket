package com.rk.iom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rk.iom.exception.InvalidProposalException;
import com.rk.iom.model.Offer;
import com.rk.iom.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal , Integer>{
	
//	Proposal saveProposal(Proposal prop);
//  
//	Proposal updateProposal(Proposal prop);
//  
//	Proposal fetchProposal(int propId) throws InvalidProposalException;
	
//	void deleteProposal(int propId) throws InvalidProposalException;
	
//	List<Proposal> fetchAllProposals(); 
	
	@Query("Select prop from Proposal prop where prop.emp.empId = :empId")
	  List<Proposal> findProposalByEmpId(int empId);

	Proposal findProposalByPropId(int propId);
	
}
 