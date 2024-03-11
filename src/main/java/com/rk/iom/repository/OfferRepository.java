package com.rk.iom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rk.iom.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {


	@Query("Select off from Offer off where off.category = :category AND off.resType = :resType")
	List<Offer> findOffersByCategoryAndResType(String category, String resType);

	@Query("SELECT o FROM Offer o WHERE o.emp.empId = :empId")
	List<Offer> findOffersForEmployeeId(int empId);

	Offer getOfferByOfferId(int offerId);

}
