package com.infinite.jsf.insurance.daoImpl;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.MessageConstants;
import com.infinite.jsf.util.SessionHelper;

/**
 * InsurancePlanDaoImpl.java
 *
 * This class provides the implementation of the InsurancePlanDao interface. It
 * handles CRUD operations for InsurancePlan entities using Hibernate ORM.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

public class InsurancePlanDaoImpl implements InsurancePlanDao {

	static SessionFactory factory;
	static Session session;
	private static final Logger logger = Logger.getLogger(InsurancePlanDaoImpl.class);
	static MessageConstants msg;

	static {
		factory = SessionHelper.getSessionFactory();
		msg = MessageConstants.getInstance();

	}

	/**
	 * Adds a new InsurancePlan to the database.
	 *
	 * @param insurancePlan the InsurancePlan object to be added
	 * @return "succuss" if the operation is successful
	 */
	@Override
	public String addInsurancePlan(InsurancePlan insurancePlan) {
		String planId = generateNextPlanId();
		logger.info(planId + " : planId is generated");
		insurancePlan.setPlanId(planId);
		insurancePlan.setActiveOn(new Date());
		session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();
			session.save(insurancePlan);
			trans.commit();
			logger.info(msg.getPLAN_ADDED_SUCCESS() + planId);
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			logger.error(msg.getPLAN_ADD_FAILED() + e.getMessage(), e);
		} finally {
			if (session != null)
				session.close();
		}

		return planId;
	}

	/**
	 * Generates the next plan ID in the format PLA###.
	 *
	 * @return the next plan ID
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
			logger.error("Error generating next plan ID: " + e.getMessage(), e);
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
		session = null;
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
			logger.error("Error fetching insurance plan by ID: " + e.getMessage(), e);
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
		session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();
			planList = session.createQuery("from InsurancePlan").list();
			trans.commit();
			logger.info("Fetched all insurance plans. Total: " + (planList != null ? planList.size() : 0));
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			logger.error("Error fetching all insurance plans: " + e.getMessage(), e);
		} finally {
			if (session != null)
				session.close();
		}

		return planList;
	}

	/**
	 * Updates an existing InsurancePlan.
	 *
	 * @param insurancePlan the InsurancePlan object with updated data
	 * @return null (method not yet implemented)
	 */
	@Override
	public String updateInsurancePlan(InsurancePlan insurancePlan) {
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(insurancePlan);
		trans.commit();
		session.close();
		return null;
	}

}
