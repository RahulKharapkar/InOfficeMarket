package com.rk.iom.repositoryimpl; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rk.iom.exception.InvalidOfferException;
import com.rk.iom.model.Offer;
import com.rk.iom.repository.OfferRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class OfferRepositoryImpl implements OfferRepository {
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Offer saveOffer(Offer offer) {
		em.persist(offer);
		return offer;
	}

	@Override
	public Offer updateOffer(Offer offer) {
		em.merge(offer);
		return offer;
	}
	
	@Override
	public Offer fetchOffer(int offerId) throws InvalidOfferException {
		try {
			String q = "select off from Offer off where off.offerId = :pofferId";
			TypedQuery<Offer> query = em.createQuery(q,Offer.class);
			query.setParameter("pofferId", offerId);
			Offer off = query.getSingleResult();
			return off;
		}
		catch(Exception e){
			
			throw new InvalidOfferException("Cannot be fetched, Invalid Offer Id : " + offerId);
		}
	}
	
	@Override
	public List<Offer> fetchAllOffers() {
		
		List<Offer> list = new ArrayList<>();
		Query q = em.createQuery("select o from Offer o");
		list = q.getResultList();
		return list;
	}

	
	@Override
	public List<Offer> fetchAllOffers(String category, String resType) {
		String qr = "Select off from Offer off where off.category = :pcategory AND off.resType = :presType ";
		TypedQuery<Offer> query = em.createQuery(qr,Offer.class);
		query.setParameter("pcategory", category);
		query.setParameter("presType", resType);
		List<Offer> off = query.getResultList();
		return off;
	}
	
	
	@Override
	public void deleteOffer(int offerId) throws InvalidOfferException {
		
		try {
			String q2 = "select off from Offer off where off.offerId = :pofferId";
			TypedQuery<Offer> query2 = em.createQuery(q2,Offer.class);
			query2.setParameter("pofferId", offerId);
			Offer off = query2.getSingleResult();
			em.remove(off);
		}
		catch(Exception e){
			throw new InvalidOfferException("Cannot be Deleted, InvalidOffer Id : "+offerId);
		}	
	}
	
		
}

	
  
 