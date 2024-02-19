package com.rk.iom.repository; 
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.rk.iom.exception.InvalidOfferException;
import com.rk.iom.model.Offer; 


public interface OfferRepository{
	
	Offer saveOffer(Offer offer);
  
	Offer updateOffer(Offer offer);
  
	Offer fetchOffer(int offerId) throws InvalidOfferException;
  
	List<Offer> fetchAllOffers();
  
	List<Offer> fetchAllOffers(String category, String type);
	
	void deleteOffer(int offerId) throws InvalidOfferException;
	
//	  @Query("SELECT o FROM Offer o WHERE o.emp.empId = :empId")
//	  List<Offer> findOffersForEmployeeId(int empId);
	

	
}
  
 