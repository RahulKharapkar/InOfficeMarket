package com.rk.iom.model;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("O")
public class Offer extends Resource {
	
	@Column(name = "offer_Id", unique = true)
	private int offerId;
	@Column(name = "is_Available") //master
	private boolean isAvailable;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "available_Upto")
	private LocalDate availableUpto;

	@JsonIgnore
	@OneToOne(mappedBy = "offer",cascade = CascadeType.ALL)
	private Proposal proposal;
	
	public Offer() {
		
	}

	
	public Offer(int offerId, boolean isAvailable, LocalDate availableUpto, Proposal proposal) {
		super();
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableUpto = availableUpto;
		this.proposal = proposal;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public LocalDate getAvailableUpto() {
		return availableUpto;
	}

	public void setAvailableUpto(LocalDate availableUpto) {
		this.availableUpto = availableUpto;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}


	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", isAvailable=" + isAvailable + ", availableUpto=" + availableUpto
				+ ", proposal=" + proposal + "]";
	}

}

