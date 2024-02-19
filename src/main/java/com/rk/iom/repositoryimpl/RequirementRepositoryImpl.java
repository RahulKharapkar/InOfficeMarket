package com.rk.iom.repositoryimpl; 
import java.util.ArrayList;
import java.util.List;
//import java.util.*;

import org.springframework.stereotype.Repository;

import com.rk.iom.exception.InvalidRequirementException;
import com.rk.iom.model.Requirement;
import com.rk.iom.repository.RequirementRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class RequirementRepositoryImpl implements RequirementRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Requirement saveRequirement(Requirement req) {
		em.persist(req);
		return req;
	}

	@Override
	public Requirement updateRequirement(Requirement req) {	
		em.merge(req);
		return req;
	}

	
	@Override
	public Requirement fetchRequirement(int reqId) throws InvalidRequirementException {
		try {
			String q = "select req from Requirement req where req.reqId = : preqId";
			TypedQuery<Requirement> query = em.createQuery(q,Requirement.class);
			query.setParameter("preqId", reqId);
			Requirement req = query.getSingleResult();
			return req;
		}
		catch(Exception e){
		
			throw new InvalidRequirementException("Cannot Fetch, Invalid Requirement Id : "+reqId );
		}
		
	}

	@Override
	public List<Requirement> fetchAllRequirements() {

		List<Requirement> list=new ArrayList<Requirement>();
		 Query q = em.createQuery("select req from Requirement req");
		    list = q.getResultList();
		    return list; 
	}

	@Override
	public List<Requirement> fetchAllRequirements(String category, String resType) {

		String qr = "Select req from Requirement req where req.category = :pcategory AND req.resType = :presType ";
		TypedQuery<Requirement> query2 = em.createQuery(qr,Requirement.class);
		query2.setParameter("pcategory", category);
		query2.setParameter("presType", resType);
		List<Requirement> allReq = query2.getResultList();
		return allReq;
	
	}
	
	
	@Override
	public void deleteRequirement(int reqId) throws InvalidRequirementException {
		try {
			String q2 = "select req from Requirement req where req.reqId = : preqId";
			TypedQuery<Requirement> query2 = em.createQuery(q2,Requirement.class);
			query2.setParameter("preqId", reqId);
			Requirement req = query2.getSingleResult();
			em.remove(req);
		}
		catch(Exception e){
			throw new InvalidRequirementException("Cannot be Deleted, Invalid Requirement Id : "+reqId);
		}	
	}
	
	
}
 