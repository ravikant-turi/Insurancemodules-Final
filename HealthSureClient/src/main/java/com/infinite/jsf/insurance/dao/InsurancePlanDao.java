package com.infinite.jsf.insurance.dao;

import java.util.List;
import com.infinite.jsf.insurance.model.InsurancePlan;

/**
 * DAO interface for performing CRUD operations on InsurancePlan entities.
 * <p>
 * Provides methods to add, search, update, delete, and list insurance plans.
 * </p>
 * 
 * @author Ravikant Trui
 * @version 1.0
 */
public interface InsurancePlanDao {

    /**
     * Adds a new insurance plan to the database.
     *
     * @param plan the InsurancePlan object containing plan details
     * @return a success message 
     */
    String addInsurancePlan(InsurancePlan plan);

    /**
     * Searches for an insurance plan by its plan ID.
     *
     * @param planId the ID of the insurance plan to search
     * @return the matching InsurancePlan if found, or null if not found
     */
    InsurancePlan searchInsurancePlanById(String planId);

    /**
     * Retrieves all insurance plans available in the database.
     *
     * @return a list of InsurancePlan objects
     */
    List<InsurancePlan> showAllPlans();

    /**
     * Updates the details of an existing insurance plan.
     *
     * @param plan the InsurancePlan object containing updated details
     * @return a success message or status
     */
    String updateInsurancePlan(InsurancePlan plan);

    /**
     * Deletes an insurance plan by its plan ID.
     *
     * @param planId the ID of the insurance plan to delete
     * @return a success message or status
     */
    String deleteInsurancePlan(InsurancePlan planId);
    
    List<InsurancePlan>   searchByPlanType(String planType) ;
    
    
}
