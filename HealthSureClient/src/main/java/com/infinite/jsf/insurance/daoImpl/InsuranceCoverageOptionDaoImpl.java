/**
 * InsuranceCoverageOptionDaoImpl.java
 *
 * This class provides the implementation of the InsuranceCoverageOptionDao
 * interface. It handles CRUD operations for InsuranceCoverageOption entities
 * using Hibernate ORM.
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

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.model.CoveragePlanStatus;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.util.SessionHelper;

/**
 * Implementation of InsuranceCoverageOptionDao interface.
 * Provides methods to perform database operations on InsuranceCoverageOption entities.
 */
public class InsuranceCoverageOptionDaoImpl implements InsuranceCoverageOptionDao {

    private static final SessionFactory factory = SessionHelper.getSessionFactory();
    private static final Logger logger = Logger.getLogger(InsuranceCoverageOptionDaoImpl.class);

    /**
     * Adds a new InsuranceCoverageOption to the database.
     *
     * @param coverageOption the InsuranceCoverageOption object to be added
     * @return "success" if the operation is successful
     */
    @Override
    public String addCoveragePlan(InsuranceCoverageOption coverageOption) {
        Session session = null;
        Transaction trans = null;
        String coverageId = generateNextInsuranceCoverageOptionId();
        coverageOption.setCoverageId(coverageId);
        coverageOption.setStatus(CoveragePlanStatus.INACTIVE);
        logger.info("Generated Coverage ID: " + coverageId);

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.save(coverageOption);
            trans.commit();
            logger.info("Coverage option saved successfully with ID: " + coverageId);
            return "success";
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while saving coverage option", e);
            return "failure";
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     * Generates the next coverage ID in the format COV###.
     *
     * @return the next generated coverage ID
     */
    public String generateNextInsuranceCoverageOptionId() {
        Session session = null;
        String lastId = null;

        try {
            session = factory.openSession();
            lastId = (String) session.createQuery(
                "SELECT c.coverageId FROM InsuranceCoverageOption c ORDER BY c.coverageId DESC")
                .setMaxResults(1)
                .uniqueResult();
            logger.debug("Last coverage ID fetched: " + lastId);
        } catch (Exception e) {
            logger.error("Error generating next coverage ID", e);
        } finally {
            if (session != null) session.close();
        }

        int nextNum = 1;
        if (lastId != null && lastId.toUpperCase().startsWith("COV") && lastId.length() == 6) {
            String numPart = lastId.substring(3);
            if (numPart.matches("\\d{3}")) {
                nextNum = Integer.parseInt(numPart) + 1;
            }
        }

        String nextId = String.format("COV%03d", nextNum);
        logger.debug("Next generated coverage ID: " + nextId);
        return nextId;
    }

    /**
     * Retrieves all InsuranceCoverageOption records from the database.
     *
     * @return list of InsuranceCoverageOption objects
     */
    @Override
    public List<InsuranceCoverageOption> findAllInsuranceCoverageOptions() {
        List<InsuranceCoverageOption> coverageOptionsList = null;
        Session session = null;
        Transaction trans = null;

        try {
            logger.debug("Opening session to fetch all insurance coverage options.");
            session = factory.openSession();
            trans = session.beginTransaction();
            coverageOptionsList = session.createQuery("FROM InsuranceCoverageOption").list();
            trans.commit();
            logger.info("Fetched all insurance coverage options. Total: " +
                (coverageOptionsList != null ? coverageOptionsList.size() : 0));
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while fetching insurance coverage options", e);
        } finally {
            if (session != null) session.close();
            logger.debug("Session closed after fetching insurance coverage options.");
        }

        return coverageOptionsList;
    }

    /**
     * Retrieves all InsuranceCoverageOption records by plan ID.
     *
     * @param planId the plan ID to filter by
     * @return list of InsuranceCoverageOption objects
     */
    @Override
    public List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanId(String planId) {
        List<InsuranceCoverageOption> coverageOptionsList = null;
        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            String hql = "FROM InsuranceCoverageOption c WHERE c.insurancePlan.planId = :planId";
            Query query = session.createQuery(hql);
            query.setParameter("planId", planId);
            coverageOptionsList = query.list();
            trans.commit();
            logger.info("Fetched coverage options for plan ID: " + planId);
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error fetching coverage options by plan ID", e);
        } finally {
            if (session != null) session.close();
        }

        return coverageOptionsList;
    }

    /**
     * Retrieves all InsuranceCoverageOption records by plan type.
     * (Currently not implemented)
     *
     * @param planType the plan type to filter by
     * @return list of InsuranceCoverageOption objects or null
     */
    @Override
    public List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanType(String planType) {
        logger.warn("findAllInsuranceCoverageOptionsByPlanType method is not yet implemented.");
        return null;
    }

    /**
     * Finds an InsuranceCoverageOption by its ID.
     * (Currently not implemented)
     *
     * @param coverageId the coverage ID
     * @return InsuranceCoverageOption object if found, otherwise null
     */
    @Override
    public InsuranceCoverageOption findInsuranceCoverageById(String coverageId) {
        logger.warn("findInsuranceCoverageById method is not yet implemented.");
        return null;
    }

    /**
     * Updates an existing InsuranceCoverageOption in the database.
     *
     * @param coverageOption the InsuranceCoverageOption object with updated data
     * @return "updated" if successful
     */
    @Override
    public String updateInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.update(coverageOption);
            trans.commit();
            logger.info("Coverage option updated successfully for ID: " + coverageOption.getCoverageId());
            return "updated";
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while updating coverage option", e);
            return "update_failed";
        } finally {
            if (session != null) session.close();
        }
    }
}
