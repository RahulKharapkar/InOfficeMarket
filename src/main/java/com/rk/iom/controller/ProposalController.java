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

import com.rk.iom.exception.InvalidProposalException;
import com.rk.iom.model.Proposal;
import com.rk.iom.service.ProposalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/proposal")
public class ProposalController {
	@Autowired
	ProposalService propService;
	
	
		// get proposal by id
	@GetMapping("/{proposalId}")
	public ResponseEntity<Proposal> findProposal(@PathVariable("proposalId") Integer propId)
			throws InvalidProposalException {
		Proposal proposal = propService.getProposal(propId);
		return new ResponseEntity<Proposal>(proposal, HttpStatus.OK);
	}
	
		//	get all proposals 
	@GetMapping("/allProposals")
	public ResponseEntity<List<Proposal>> fetchAllProposals() {
		List<Proposal> props = propService.getAllProposals();

		if (props.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Proposal>>(props, HttpStatus.OK);
	}

//		add proposal
	@PostMapping("/addProposal")
	public ResponseEntity<Proposal> saveProposal(@RequestBody Proposal proposal) {
		Proposal prop = propService.addProposal(proposal);
		if (prop == null) {
			return new ResponseEntity("Sorry! No Proposals Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Proposal>(prop, HttpStatus.OK);
		}
	}

//	edit proposal
	@PutMapping("/editProposal")
	public ResponseEntity<Proposal> updateProposal(@RequestBody Proposal proposal) {
		Proposal prop = propService.editProposal(proposal);
		if (prop == null) {
			return new ResponseEntity("Sorry! Employee not editied!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Proposal>(prop, HttpStatus.OK);
		}
	}

//	delete proposal by id
	@DeleteMapping("/{proposalId}")
	public ResponseEntity<List<Proposal>> deleteProposal(@PathVariable("proposalId") Integer propId)
			throws InvalidProposalException {
		List<Proposal>proposal = propService.removeProposal(propId);
		return new ResponseEntity<List<Proposal>>(proposal, HttpStatus.OK);
	}

	
}