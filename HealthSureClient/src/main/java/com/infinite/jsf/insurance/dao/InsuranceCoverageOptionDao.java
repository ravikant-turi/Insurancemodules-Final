/**
 * InsuranceCoverageOptionDao.java
 *
 * This interface defines the contract for CRUD operations related to
 * InsuranceCoverageOption entities.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

package com.infinite.jsf.insurance.dao;

import java.util.List;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;

public interface InsuranceCoverageOptionDao {

    /**
     * Adds a new coverage plan to the database.
     *
     * @param coverageOption the coverage option to be added
     * @return status message
     */
    String addCoveragePlan(InsuranceCoverageOption coverageOption);

    /**
     * Retrieves all insurance coverage options.
     *
     * @return list of all coverage options
     */
    List<InsuranceCoverageOption> findAllInsuranceCoverageOptions();

    /**
     * Retrieves coverage options by plan ID.
     *
     * @param planId the plan ID to filter coverage options
     * @return list of coverage options for the given plan ID
     */
    List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanId(String planId);

    /**
     * Retrieves coverage options by plan type.
     *
     * @param planType the plan type to filter coverage options
     * @return list of coverage options for the given plan type
     */
    List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanType(String planType);

    /**
     * Finds a specific coverage option by its ID.
     *
     * @param coverageId the ID of the coverage option
     * @return the coverage option object
     */
    InsuranceCoverageOption findInsuranceCoverageById(String coverageId);

    /**
     * Updates an existing coverage option.
     *
     * @param coverageOption the coverage option with updated data
     * @return status message
     */
    String updateInsuranceCoverageOption(InsuranceCoverageOption coverageOption);
}
