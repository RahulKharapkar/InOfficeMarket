package com.rk.iom.repositoryimpl; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rk.iom.model.Resource;
import com.rk.iom.repository.ResourceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery; 

@Repository
public class ResourceRepositoryImpl implements ResourceRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Resource> fetchAllResources(String category, String resType) {
		
		String qr = "Select res from Resource res where res.category = :pcategory AND res.resType = :presType ";
		TypedQuery<Resource> query = em.createQuery(qr,Resource.class);
		query.setParameter("pcategory", category);
		query.setParameter("presType", resType);
		List<Resource> allRes = query.getResultList();
		return allRes;
	}
	
	@Override
	public List<Resource> fetchAllResources(int empId) {
		
			List<Resource> Resources = new ArrayList<>();
			Query query2 = em.createQuery("Select res from Resource res where res.emp.empId = :pempId");
			query2.setParameter("pempId", empId);
			Resources = query2.getResultList();
			return Resources;
	}

	@Override
	public List<Resource> fetchAllResources() {
		
		List<Resource> list = new ArrayList<Resource>();
		Query q = em.createQuery("Select res from Resource res");
		list = q.getResultList();
		return list; 	
	}
}
	

