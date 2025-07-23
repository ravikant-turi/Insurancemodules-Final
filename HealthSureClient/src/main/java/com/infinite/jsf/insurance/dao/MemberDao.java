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
import com.infinite.jsf.insurance.model.Member;

public interface MemberDao {

    /**
     * Adds a new member to the database.
     *
     * @param member the Member object to be added
     * @return status message
     */
    String addMember(Member member);

    /**
     * Retrieves all members associated with a specific coverage ID.
     *
     * @param coverageId the coverage ID to filter members
     * @return list of Member objects
     */
    List<Member> findAllMeberByCoverageId(String coverageId);

    /**
     * Updates an existing member record.
     *
     * @param member the Member object with updated data
     * @return status message
     */
    String updateMember(Member member);
    
   List< Member> searchMemberByPlanId(String planId);
}
