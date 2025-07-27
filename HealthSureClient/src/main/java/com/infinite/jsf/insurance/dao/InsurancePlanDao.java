/**
 * InsurancePlanDao.java
 *
 * This interface defines the contract for CRUD operations related to
 * InsurancePlan entities.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

package com.infinite.jsf.insurance.dao;

import java.util.List;
import com.infinite.jsf.insurance.model.InsurancePlan;

public interface InsurancePlanDao {

    /**
     * Adds a new insurance plan to the database.
     *
     * @param insurancePlan the insurance plan to be added
     * @return status message
     */
    String addInsurancePlan(InsurancePlan insurancePlan);

    /**
     * Finds an insurance plan by its ID.
     *
     * @param planId the ID of the insurance plan
     * @return the InsurancePlan object if found
     */
    InsurancePlan findInsuranceById(String planId);

    /**
     * Retrieves all insurance plans.
     *
     * @return list of all insurance plans
     */
    List<InsurancePlan> showAllPlan();

    /**
     * Updates an existing insurance plan.
     *
     * @param insurancePlan the insurance plan with updated data
     * @return status message
     */
	String updateInsurancePlan(InsurancePlan insurancePlan);
    
    
    
    
}
