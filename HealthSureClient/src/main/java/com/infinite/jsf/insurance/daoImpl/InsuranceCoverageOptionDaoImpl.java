package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.util.SessionHelper;

/**
 * InsuranceCoverageOptionDaoImpl.java
 *
 * This class provides the implementation of the InsuranceCoverageOptionDao interface.
 * It handles CRUD operations for InsuranceCoverageOption entities using Hibernate ORM.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */


public class InsuranceCoverageOptionDaoImpl implements InsuranceCoverageOptionDao {

    static SessionFactory factory;
    static Session session;
    private static final Logger logger = Logger.getLogger(InsuranceCoverageOptionDaoImpl.class);

    static {
        factory = SessionHelper.getSessionFactory();
    }

    /**
     * Adds a new InsuranceCoverageOption to the database.
     *
     * @param coverageOption the InsuranceCoverageOption object to be added
     * @return "succuss" if the operation is successful
     */
    @Override
    public String addCoveragePlan(InsuranceCoverageOption coverageOption) {
        session = null;
        Transaction trans = null;
        String coverageId = generateNextInsuranceCoverageOptionId();
        logger.info(coverageId + " : coverageId is generated");
        coverageOption.setCoverageId(coverageId);

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.save(coverageOption);
            trans.commit();
            logger.info("Coverage option saved successfully with ID: " + coverageId);
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while saving coverage option: " + e.getMessage(), e);
        } finally {
            if (session != null) session.close();
        }

        return "succuss";
    }

    /**
     * Generates the next coverage ID in the format COV###.
     *
     * @return the next coverage ID
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
            logger.error("Error generating next coverage ID: " + e.getMessage(), e);
        } finally {
            if (session != null) session.close();
        }

        int nextNum = 1;

        if (lastId != null && lastId.toUpperCase().startsWith("COV") && lastId.length() == 6) {
            String numPart = lastId.substring(3); // "001"
            if (numPart.matches("\\d{3}")) {
                nextNum = Integer.parseInt(numPart) + 1;
            }
        }

        String nextId = String.format("COV%03d", nextNum);
        logger.debug("Next generated coverage ID: " + nextId);
        return nextId;
    }

    /**
     * Retrieves all InsuranceCoverageOption records.
     *
     * @return list of InsuranceCoverageOption
     */
    
    @Override
    public List<InsuranceCoverageOption> findAllInsuranceCoverageOptions() {
        List<InsuranceCoverageOption> coverageOptionsList = null;
        session = null;
        Transaction trans = null;

        try {
            logger.debug("Opening session to fetch all insurance coverage options.");
            session = factory.openSession();
            trans = session.beginTransaction();

            coverageOptionsList = session.createQuery("from InsuranceCoverageOption").list();
            trans.commit();

            logger.info("Successfully fetched all insurance coverage options. Total: " 
                        + (coverageOptionsList != null ? coverageOptionsList.size() : 0));
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while fetching insurance coverage options: " + e.getMessage(), e);
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
     * @return list of InsuranceCoverageOption
     */
    @Override
    public List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanId(String planId) {
        logger.debug("findAllInsuranceCoverageOptionsByPlanId method is not yet implemented.");
        return null;
    }

    /**
     * Retrieves all InsuranceCoverageOption records by plan type.
     *
     * @param planType the plan type to filter by
     * @return list of InsuranceCoverageOption
     */
    @Override
    public List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanType(String planType) {
        logger.debug("findAllInsuranceCoverageOptionsByPlanType method is not yet implemented.");
        return null;
    }

    /**
     * Finds an InsuranceCoverageOption by its ID.
     *
     * @param coverageId the coverage ID
     * @return InsuranceCoverageOption object if found, otherwise null
     */
    @Override
    public InsuranceCoverageOption findInsuranceCoverageById(String coverageId) {
        logger.debug("findInsuranceCoverageById method is not yet implemented.");
        return null;
    }

    /**
     * Updates an existing InsuranceCoverageOption.
     *
     * @param coverageOption the InsuranceCoverageOption object with updated data
     * @return String message(update Success or failed message)
     */
    @Override
    public String updateInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
    	session = null;
        Transaction trans = null;
       
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.update(coverageOption);
            trans.commit();
            logger.info("Coverage option update successfully");
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while update coverage option: " + e.getMessage(), e);
        } finally {
            if (session != null) session.close();
        }

        return "updated";
    }
}
