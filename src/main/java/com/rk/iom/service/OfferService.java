package com.rk.iom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.iom.exception.InvalidOfferException;
import com.rk.iom.model.Offer;
import com.rk.iom.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	OfferRepository offerRepo;

//	Offer CRUD
	@Transactional
	public Offer addOffer(Offer offer) {

		return offerRepo.save(offer);
	}

	@Transactional
	public Offer editOffer(Offer offer) {

		return offerRepo.save(offer);
	}

	public Offer getOffer(int offerId) throws InvalidOfferException {

		return offerRepo.getOfferByOfferId(offerId);
	}

	public List<Offer> getAllOffers() {
		return offerRepo.findAll();
	}

	public List<Offer> getAllOffers(String category, String resType) {
		return offerRepo.findOffersByCategoryAndResType(category, resType);

	}

	@Transactional
	public List<Offer> removeOffer(int offerId) throws InvalidOfferException {
		offerRepo.deleteById(offerId);
		return offerRepo.findAll();
	}

}