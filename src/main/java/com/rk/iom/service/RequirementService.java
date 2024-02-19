
package com.rk.iom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.iom.exception.InvalidRequirementException;
import com.rk.iom.model.Requirement;
import com.rk.iom.repository.RequirementRepository;

/**
 * Implementation of the IRequirementService interface.
 * This class provides methods to perform CRUD operations on Requirement entities.
 */
@Service
public class RequirementService {
    
    @Autowired
    private RequirementRepository reqRepo;

    /**
     * Adds a new Requirement.
     * 
     * @param req The Requirement object to be added.
     * @return The added Requirement object.
     */
    
    @Transactional
    public Requirement addRequirement(Requirement req) {
        return reqRepo.saveRequirement(req);
    }

    /**
     * Edits an existing Requirement.
     * 
     * @param req The Requirement object to be edited.
     * @return The edited Requirement object.
     */
    
    @Transactional
    public Requirement editRequirement(Requirement req) {
        return reqRepo.updateRequirement(req);
    }

    /**
     * Retrieves a Requirement by its ID.
     * 
     * @param reqId The ID of the Requirement to retrieve.
     * @return The Requirement object corresponding to the given ID.
     * @throws InvalidRequirementException If the Requirement with the given ID does not exist.
     */
    
    public Requirement getRequirement(int reqId) throws InvalidRequirementException {
        return reqRepo.fetchRequirement(reqId);
    }

    /**
     * Retrieves all Requirements.
     * 
     * @return A list of all Requirement objects.
     */
    
    public List<Requirement> getAllRequirements() {
        return reqRepo.fetchAllRequirements();
    }

    /**
     * Retrieves all Requirements based on category and resource type.
     * 
     * @param category The category of the Requirement.
     * @param resType The resource type of the Requirement.
     * @return A list of Requirement objects matching the given category and resource type
    **/
    public List<Requirement> getAllRequirements(String category, String resType) {
        return reqRepo.fetchAllRequirements(category, resType);
    }

    /**
     * Removes a Requirement by its ID.
     * 
     * @param reqId The ID of the Requirement to remove.
     * @return A list of all remaining Requirement objects after removal.
     * @throws InvalidRequirementException If the Requirement with the given ID does not exist.
     */
    
    @Transactional
    public List<Requirement> removeRequirement(int reqId) throws InvalidRequirementException {
        reqRepo.deleteRequirement(reqId);
        return reqRepo.fetchAllRequirements();
    }
}