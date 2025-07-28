/**
 * InsurancePlanDaoImpl.java
 *
 * This class provides the implementation of the InsurancePlanDao interface.
 * It handles CRUD operations for InsurancePlan entities using Hibernate ORM.
 * Operations include adding, updating, retrieving by ID, and listing all plans.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

package com.infinite.jsf.insurance.daoImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.CreateInsuranceMessageConstants;
import com.infinite.jsf.util.SessionHelper;

/**
 * Implementation of InsurancePlanDao interface. Provides methods to perform
 * database operations on InsurancePlan entities.
 */
public class InsurancePlanDaoImpl implements InsurancePlanDao {

	private static final SessionFactory factory = SessionHelper.getSessionFactory();
	private static final Logger logger = Logger.getLogger(InsurancePlanDaoImpl.class);

	/**
	 * Adds a new InsurancePlan to the database.
	 *
	 * @param insurancePlan the InsurancePlan object to be added
	 * @return the generated plan ID if successful, otherwise null
	 */
	@Override
	public String addInsurancePlan(InsurancePlan insurancePlan) {
		String planId = generateNextPlanId();
		insurancePlan.setPlanId(planId);
		insurancePlan.setActiveOn(new Date());

		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();
			session.save(insurancePlan);
			trans.commit();
			logger.info("Plan is save with this planId :" + planId);
			return planId;
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			logger.error("Plan is not save with this planId :" + e.getMessage(), e);
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

	/**
	 * Generates the next plan ID in the format PLA###.
	 *
	 * @return the next generated plan ID
	 */
	public String generateNextPlanId() {
		Session session = null;
		String lastId = null;

		try {
			session = factory.openSession();
			lastId = (String) session.createQuery("SELECT p.planId FROM InsurancePlan p ORDER BY p.planId DESC")
					.setMaxResults(1).uniqueResult();
			logger.debug("Last plan ID fetched: " + lastId);
		} catch (Exception e) {
			logger.error("Error generating next plan ID", e);
		} finally {
			if (session != null)
				session.close();
		}

		int nextNum = 1;
		if (lastId != null && lastId.toUpperCase().startsWith("PLA") && lastId.length() == 6) {
			String numPart = lastId.substring(3); // e.g., "001"
			if (numPart.matches("\\d{3}")) {
				nextNum = Integer.parseInt(numPart) + 1;
			}
		}

		String nextId = String.format("PLA%03d", nextNum);
		logger.debug("Next generated plan ID: " + nextId);
		return nextId;
	}

	/**
	 * Finds an InsurancePlan by its ID.
	 *
	 * @param planId the ID of the insurance plan
	 * @return the InsurancePlan object if found, otherwise null
	 */
	@Override
	public InsurancePlan findInsuranceById(String planId) {
		Session session = null;
		Transaction trans = null;
		InsurancePlan plan = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();
			plan = (InsurancePlan) session.get(InsurancePlan.class, planId);
			trans.commit();
			logger.info("Insurance plan fetched for ID: " + planId);
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			logger.error("Error fetching insurance plan by ID", e);
		} finally {
			if (session != null)
				session.close();
		}

		return plan;
	}

	/**
	 * Retrieves all insurance plans from the database.
	 *
	 * @return a list of InsurancePlan objects
	 */
	@Override
	public List<InsurancePlan> showAllPlan() {
		List<InsurancePlan> planList = null;
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();
			planList = session.createQuery("FROM InsurancePlan").list();
			trans.commit();
			logger.info("Fetched all insurance plans. Total: " + (planList != null ? planList.size() : 0));
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			logger.error("Error fetching all insurance plans", e);
		} finally {
			if (session != null)
				session.close();
		}

		return planList;
	}

	/**
	 * Updates an existing InsurancePlan in the database.
	 *
	 * @param insurancePlan the InsurancePlan object with updated data
	 * @return "success" if update is successful, otherwise "failure"
	 */
	@Override
	public String updateInsurancePlan(InsurancePlan insurancePlan) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();
			session.update(insurancePlan);
			trans.commit();
			logger.info("Insurance plan updated successfully for ID: " + insurancePlan.getPlanId());
			return "success";
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			logger.error("Error updating insurance plan", e);
			return "failure";
		} finally {
			if (session != null)
				session.close();
		}
	}
}
