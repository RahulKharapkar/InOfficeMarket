package com.rk.iom.repository;

import java.util.List;

import com.rk.iom.exception.InvalidProposalException;
import com.rk.iom.model.Proposal;

public interface ProposalRepository {
	
	Proposal saveProposal(Proposal prop);
  
	Proposal updateProposal(Proposal prop);
  
	Proposal fetchProposal(int propId) throws InvalidProposalException;
	
	void deleteProposal(int propId) throws InvalidProposalException;
	
	List<Proposal> fetchAllProposals(); 
	
}
 