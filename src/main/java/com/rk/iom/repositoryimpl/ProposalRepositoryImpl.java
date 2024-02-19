package com.rk.iom.repositoryimpl; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rk.iom.exception.InvalidProposalException;
import com.rk.iom.model.Proposal;
import com.rk.iom.repository.ProposalRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository 
public class ProposalRepositoryImpl implements ProposalRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Proposal saveProposal(Proposal prop) {
		em.persist(prop);					  
		return prop;
	}

	@Override
	public Proposal updateProposal(Proposal prop) {
		 em.merge(prop);    
		 return prop;		
	}

	@Override
	public Proposal fetchProposal(int propId) throws InvalidProposalException {
		if(em.find(Proposal.class, propId) == null){
			throw new InvalidProposalException("Cannot be Feteched, Invalid Proposal Id : " + propId);
		}
		else {
			Proposal pr = em.find(Proposal.class, propId);	
			return pr;
		}
		
	}

	@Override
	public void deleteProposal(int propId) throws InvalidProposalException {
		if(em.find(Proposal.class, propId) == null){
			
			throw new InvalidProposalException("Cannot be Deleted, Invalid Proposal Id : " + propId);
		}
		else {
			Proposal proposal = em.find(Proposal.class, propId);
			em.remove(proposal);
		}									
	}

	@Override
	public List<Proposal> fetchAllProposals() {
		List<Proposal> list = new ArrayList<Proposal>();			
		 Query q = em.createQuery("select prop from Proposal prop");
		    list = q.getResultList();
		    return list; 
	}
	
	
	
}
 