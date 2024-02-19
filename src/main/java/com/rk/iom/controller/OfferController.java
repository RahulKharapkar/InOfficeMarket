package com.rk.iom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.iom.exception.InvalidOfferException;
import com.rk.iom.model.Offer;
import com.rk.iom.service.OfferService;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OfferController {
	
	@Autowired
	OfferService  offerService;
	
	@GetMapping("/offer/{offerId}")
	public ResponseEntity<Offer> findOffer(@PathVariable("offerId") Integer offerId) throws InvalidOfferException{
		Offer offer = offerService.getOffer(offerId);
		return new ResponseEntity<Offer>(offer, HttpStatus.OK);
	}
	
	@PostMapping("/offer/addOffer")
	public ResponseEntity<Offer> saveOffer(@RequestBody Offer offer) {
		Offer off = offerService.addOffer(offer);
		if (off == null) {
			return new ResponseEntity("Sorry! No Offer Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Offer>(off, HttpStatus.OK);
		}
	}
	
	@PutMapping("/offer/editOffer")
	public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer) {
		Offer off = offerService.editOffer(offer);
		if (off == null) {
			return new ResponseEntity("Sorry! Offer not editied!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Offer>(off, HttpStatus.OK);
		}
	}
	
	@GetMapping("/offer/allOffers")
	public ResponseEntity<List<Offer>> allOffers() {
		List<Offer> off = offerService.getAllOffers();
		if (off == null) {
			return new ResponseEntity("Sorry! No Offers Found!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Offer>>(off, HttpStatus.OK);
		}
	}
	
	@GetMapping("/offer/alloffers/{category}/{resType}")
	public ResponseEntity<List<Offer>> allOffers(@PathVariable("category") String category, @PathVariable("resType") String resType){
		List<Offer> off = offerService.getAllOffers(category, resType);
		if (off == null) {
			return new ResponseEntity("Sorry! No Offers Found!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Offer>>(off, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/offer/deleteOffer/{offerId}")
	public ResponseEntity<List<Offer>> deleteOffer(@PathVariable("offerId") Integer offId) throws InvalidOfferException {
		List<Offer> offer = offerService.removeOffer(offId);
		System.out.println(offId);
		return new ResponseEntity<List<Offer>>(offer, HttpStatus.OK);
	}
	

}


	


