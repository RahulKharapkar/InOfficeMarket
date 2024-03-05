package com.rk.iom.model;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Proposals")
public class Proposal {
	
	@Id
	@Column(name="prop_id")
	private int propId;
	private String proposal;
	private double amount;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name="proposal_date")			//proposal_dates
	private LocalDate proposalDate;
	@Column(name="is_accepted")
	private boolean isAccepted;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name="accepted_On")
	private LocalDate acceptedOn;
	
	@ManyToOne
	@JoinColumn(name = "emp_Id")             
	private Employee emp;
	
	@OneToOne
	@JoinColumn(name = "offerId")
	private Offer offer;
	
	@OneToOne
	@JoinColumn(name = "reqId")
	private Requirement requirement;
	
	
	public Proposal()
	{
		
	}

	public Proposal(int propId, String proposal, double amount, LocalDate proposalDate, boolean isAccepted,
			LocalDate acceptedOn, Employee emp, Offer offer, Requirement requirement) {
		super();
		this.propId = propId;
		this.proposal = proposal;
		this.amount = amount;
		this.proposalDate = proposalDate;
		this.isAccepted = isAccepted;
		this.acceptedOn = acceptedOn;
		this.emp = emp;
		this.offer = offer;
		this.requirement = requirement;
	}



	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getProposalDate() {
		return proposalDate;
	}

	public void setProposalDate(LocalDate proposalDate) {
		this.proposalDate = proposalDate;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public LocalDate getAcceptedOn() {
		return acceptedOn;
	}

	public void setAcceptedOn(LocalDate acceptedOn) {
		this.acceptedOn = acceptedOn;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}


	@Override
	public String toString() {
		return "Proposal [propId=" + propId + ", proposal=" + proposal + ", amount=" + amount + ", proposalDate="
				+ proposalDate + ", isAccepted=" + isAccepted + ", acceptedOn=" + acceptedOn + ", emp=" + emp
				+ ", offer=" + offer + ", requirement=" + requirement + "]";
	}
	
}

