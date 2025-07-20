package com.infinite.jsf.insurance.daoImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.PlanType;
import com.infinite.jsf.util.SessionHelper;

/**
 * Implementation of the InsurancePlanDao interface.
 * <p>
 * This class provides actual persistence logic for managing InsurancePlan
 * entities. Currently, the methods are placeholders and need to be implemented
 * with database operations.
 * </p>
 * 
 * @author Ravikant Turi
 * @version 1.0
 */
public class InsurancePlanDaoImpl implements InsurancePlanDao {

	static SessionFactory factory;
	static Session session;

	static {
		factory = SessionHelper.getSessionFactory();
	}

	/**
	 * Adds a new insurance plan to the database.
	 *
	 * @param plan the InsurancePlan to be added
	 * @return success message or status
	 */
	@Override
	public String addInsurancePlan(InsurancePlan plan) {
		// TODO: Implement logic to save InsurancePlan to database
		String planId=generateNextPlanId();
		System.out.println("============testing add==========");
		System.out.println("planId : " + planId);
		System.out.println(plan);
		plan.setPlanId(planId);
		Session	session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(plan);
		trans.commit();
		session.close();
		return "success";
	}
	
	public String generateNextPlanId() {
	    Session session = factory.openSession();

	    String lastId = (String) session.createQuery(
	        "SELECT p.planId FROM InsurancePlan p ORDER BY p.planId DESC")
	        .setMaxResults(1)
	        .uniqueResult();

	    session.close();

	    int nextNum = 1;

	    if (lastId != null && lastId.toUpperCase().startsWith("PLA") && lastId.length() == 6) {
	        String numPart = lastId.substring(3); // e.g., "001"
	        if (numPart.matches("\\d{3}")) {
	            nextNum = Integer.parseInt(numPart) + 1;
	        }
	    }

	    return String.format("PLA%03d", nextNum); // e.g., PLA002
	}



	/**
	 * Searches for an insurance plan by its plan ID.
	 *
	 * @param planId the ID of the plan to search
	 * @return the InsurancePlan if found, or null if not found
	 */
	@Override
	public InsurancePlan searchInsurancePlanById(String planId) {
        
		session=factory.openSession();
		Transaction trans=session.beginTransaction();
        InsurancePlan plan=(InsurancePlan) session.get(InsurancePlan.class, planId);
        trans.commit();
        session.close();
		return plan;
	}

	/**
	 * Retrieves all insurance plans from the database.
	 *
	 * @return list of InsurancePlan objects
	 */
	@Override
	public List<InsurancePlan> showAllPlans() {
		// TODO: Implement logic to fetch all InsurancePlans
		 Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
//		String hql = "FROM InsurancePlan p JOIN FETCH p.insuranceCompany";
//        Query query = session.createQuery(hql);
//        List<InsurancePlan> plans=query.list();
		
		Criteria criteria=session.createCriteria(InsurancePlan.class);
      List<InsurancePlan> plans=criteria.list();

		trans.commit();
		session.close();
		return  plans;
	}

	/**
	 * Updates the details of an existing insurance plan.
	 *
	 * @param plan the InsurancePlan with updated information
	 * @return success message or status
	 */
	@Override
	public String updateInsurancePlan(InsurancePlan plan) {
		// TODO: Implement logic to update InsurancePlan in database
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
         session.update(plan);
		trans.commit();
		session.close();
		return "updated";
	}

	/**
	 * Deletes an insurance plan by its plan ID.
	 *
	 * @param planId the ID of the plan to delete
	 * @return success message or status
	 */
	@Override
	public String deleteInsurancePlan(InsurancePlan plan) {
		// TODO: Implement logic to delete InsurancePlan from database

		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
        session.delete(plan);
		trans.commit();
		session.close();

		return "deleted";
	}

	@Override
	public List<InsurancePlan> searchByPlanType(String planType) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Criteria criteria = session.createCriteria(InsurancePlan.class);

        // Convert string to PlanType enum
        PlanType planTypeEnum = PlanType.valueOf(planType.toUpperCase());

        // Add restriction on planType field
        criteria.add(Restrictions.eq("planTypeString", planType.toUpperCase()));
        
		List<InsurancePlan> planTypeList=criteria.list();
		trans.commit();
		session.close();
		return planTypeList;
	}

    

}
