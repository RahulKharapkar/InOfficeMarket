package com.rk.iom.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rk.iom.model.Employee;
import com.rk.iom.model.Offer;
import com.rk.iom.model.Proposal;
import com.rk.iom.model.Requirement;
import com.rk.iom.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

//	@Autowired
//	EmployeeRepository empRepo;
	
//	public Employee addEmployee(Employee employee) {
//		return empRepo.save(employee);
//	};
	
	@PersistenceContext        
	private EntityManager em;

	@Override
	public Employee saveEmployee(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		em.merge(emp);
		return emp;
	}

	@Override
	public Employee fetchEmployee(int empId) {
		return em.find(Employee.class,empId);
	}

	@Override
	public Offer statusUpdate(Offer offer) {
			em.merge(offer);
			return offer;
		}
	

	@Override
	public Requirement statusUpdate(Requirement req) {
		em.merge(req);
		return req;
	}

	@Override
	public Proposal statusUpdate(Proposal prop) {
		em.merge(prop);
		return prop;
	}

	@Override
	public List<Offer> fetchAllOffers(int empId) {
		List<Offer> offers = new ArrayList<>();
		String qr = "Select offer from Offer offer where offer.emp.empId = :pempId";
		TypedQuery<Offer> query = em.createQuery(qr,Offer.class);
		query.setParameter("pempId", empId);
		offers = query.getResultList();
		return offers;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Requirement> fetchAllRequirements(int empId){
		List<Requirement> requirements;
		Query query2 = em.createQuery("Select req from Requirement req where req.emp.empId = :pempId");
		query2.setParameter("pempId", empId);
		requirements = query2.getResultList();
		return requirements;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Proposal> fetchAllProposals(int empId) {
		List<Proposal> proposals = new ArrayList<>();
		Query query3 = em.createQuery("Select prop from Proposal prop where prop.emp.empId = :pempId");
		query3.setParameter("pempId", empId);
		proposals = query3.getResultList();
		return proposals;
	}
	

}
