/**
 * MemberPlanRuleDaoImpl.java
 *
 * This class provides the implementation of the MemberPlanRuleDao interface.
 * It handles operations related to MemberPlanRule entities such as adding members,
 * generating member IDs, searching members by plan ID, and updating member records.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.MemberPlanRuleDao;
import com.infinite.jsf.insurance.model.MemberPlanRule;
import com.infinite.jsf.util.SessionHelper;

/**
 * Implementation of MemberPlanRuleDao interface.
 * Provides CRUD operations and search functionalities for MemberPlanRule entities.
 */
public class MemberPlanRuleDaoImpl implements MemberPlanRuleDao {

    private static final SessionFactory factory = SessionHelper.getSessionFactory();
    private static final Logger logger = Logger.getLogger(MemberPlanRuleDaoImpl.class);

    /**
     * Adds a new MemberPlanRule to the database.
     *
     * @param member the MemberPlanRule object to be added
     * @return "success" if the operation is successful
     */
    @Override
    public String addMember(MemberPlanRule member) {
        Transaction trans = null;
        Session session = null;
        String memberId = generateNextMemberId();
        member.setMeberId(memberId);
        logger.info("Generated Member ID: " + memberId);
        logger.debug("Member details to be saved: " + member);

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.save(member);
            trans.commit();
            logger.info("Member saved successfully with ID: " + memberId);
            return "success";
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while saving member", e);
            return "failure";
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     * Generates the next member ID in the format MEM###.
     *
     * @return the next generated member ID
     */
    public String generateNextMemberId() {
        Session session = null;
        String lastId = null;

        try {
            session = factory.openSession();
            lastId = (String) session.createQuery(
                "SELECT m.meberId FROM MemberPlanRule m ORDER BY m.meberId DESC")
                .setMaxResults(1)
                .uniqueResult();
            logger.debug("Last member ID fetched: " + lastId);
        } catch (Exception e) {
            logger.error("Error fetching last member ID", e);
        } finally {
            if (session != null) session.close();
        }

        int nextNum = 1;
        if (lastId != null && lastId.toUpperCase().startsWith("MEM") && lastId.length() == 6) {
            String numPart = lastId.substring(3);
            if (numPart.matches("\\d{3}")) {
                nextNum = Integer.parseInt(numPart) + 1;
            }
        }

        String nextId = String.format("MEM%03d", nextNum);
        logger.debug("Next generated member ID: " + nextId);
        return nextId;
    }

    /**
     * Retrieves all MemberPlanRule records associated with a specific coverage ID.
     * (Currently not implemented)
     *
     * @param coverageId the coverage ID to filter members
     * @return list of MemberPlanRule objects or null
     */
    @Override
    public List<MemberPlanRule> findAllMeberByCoverageId(String coverageId) {
        logger.warn("findAllMeberByCoverageId method is not yet implemented.");
        return null;
    }

    /**
     * Updates an existing MemberPlanRule record in the database.
     * (Currently not implemented)
     *
     * @param member the MemberPlanRule object with updated data
     * @return null
     */
    @Override
    public String updateMember(MemberPlanRule member) {
        logger.warn("updateMember method is not yet implemented.");
        return null;
    }

    /**
     * Searches and retrieves all MemberPlanRule records associated with a specific plan ID.
     *
     * @param planId the insurance plan ID to filter members
     * @return list of MemberPlanRule objects
     */
    @Override
    public List<MemberPlanRule> searchMemberByPlanId(String planId) {
        List<MemberPlanRule> memberList = null;
        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();

            String hql = "FROM MemberPlanRule m WHERE m.insurancePlan.planId = :planId";
            Query query = session.createQuery(hql);
            query.setParameter("planId", planId);
            memberList = query.list();

            trans.commit();
            logger.info("Members retrieved for plan ID: " + planId);
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error retrieving members by plan ID", e);
        } finally {
            if (session != null) session.clear();
        }

        return memberList;
    }
}
