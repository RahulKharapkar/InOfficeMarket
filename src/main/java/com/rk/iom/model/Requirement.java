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
@DiscriminatorValue("R")
public class Requirement extends Resource {
	
	@Column(name="req_id", unique = true)
	private int reqId;
	@Column(name="is_fulfilled") //column name added
	private boolean isFulfilled;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name="fulfilled_on")
	private LocalDate fulfilledOn;
	
	@JsonIgnore
	@OneToOne(mappedBy = "requirement",cascade = CascadeType.ALL)
	private Proposal proposal;
	
	public Requirement() {
		
	}


	public Requirement(int reqId, boolean isFulfilled, LocalDate fulfilledOn, Proposal proposal) {
		super();
		this.reqId = reqId;
		this.isFulfilled = isFulfilled;
		this.fulfilledOn = fulfilledOn;
		this.proposal = proposal;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public boolean isFulfilled() {
		return isFulfilled;
	}

	public void setFulfilled(boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}

	public LocalDate getFulfilledOn() {
		return fulfilledOn;
	}

	public void setFulfilledOn(LocalDate fulfilledOn) {
		this.fulfilledOn = fulfilledOn;
	}
	

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}


	@Override
	public String toString() {
		return "Requirement [reqId=" + reqId + ", isFulfilled=" + isFulfilled + ", fulfilledOn=" + fulfilledOn
				+ ", proposal=" + proposal + "]";
	}
	
	
}

