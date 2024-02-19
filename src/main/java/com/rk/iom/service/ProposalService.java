package com.rk.iom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.iom.exception.InvalidProposalException;
import com.rk.iom.model.Proposal;
import com.rk.iom.repository.ProposalRepository;

import jakarta.transaction.Transactional;

@Service
public class ProposalService {

	@Autowired
	private ProposalRepository propRepo;

	
	@Transactional
	public Proposal addProposal(Proposal prop) {

		return propRepo.save(prop);
	}

	@Transactional
	public Proposal editProposal(Proposal prop) {

		return propRepo.save(prop);

	}
	public Proposal getProposal(int propId) throws InvalidProposalException {

		return propRepo.findProposalByPropId(propId);
	}
	@Transactional
	public List<Proposal> removeProposal(int propId) throws InvalidProposalException {

		propRepo.deleteById(propId);
		return propRepo.findAll();
	}

	
	public List<Proposal> getAllProposals() {

		return propRepo.findAll();
	}

}
