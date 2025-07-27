/**
 * MemberDao.java
 *
 * This interface defines the contract for CRUD operations related to
 * Member entities in the insurance system.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

package com.infinite.jsf.insurance.dao;

import java.util.List;
import com.infinite.jsf.insurance.model.MemberPlanRule;

public interface MemberPlanRuleDao {

    /**
     * Adds a new member to the database.
     *
     * @param member the Member object to be added
     * @return status message
     */
    String addMember(MemberPlanRule member);

    /**
     * Retrieves all members associated with a specific coverage ID.
     *
     * @param coverageId the coverage ID to filter members
     * @return list of Member objects
     */
    List<MemberPlanRule> findAllMeberByCoverageId(String coverageId);

    /**
     * Updates an existing member record.
     *
     * @param member the Member object with updated data
     * @return status message
     */
    String updateMember(MemberPlanRule member);
    /**
     * Retrieves all members associated with a specific plan ID.
     *
     * @param planId the plan ID to filter members
     * @return list of MemberPlanRule objects
     */
    List<MemberPlanRule> searchMemberByPlanId(String planId);

}
