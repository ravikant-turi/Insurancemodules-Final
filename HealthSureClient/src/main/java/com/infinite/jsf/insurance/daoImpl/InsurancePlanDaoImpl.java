package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.util.SessionHelper;

public class InsurancePlanDaoImpl implements InsurancePlanDao {

	static SessionFactory factory;
	static Session session;
    private static final Logger logger = Logger.getLogger(InsuranceCompanyDaoImpl.class);

	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public String addInsurancePlan(InsurancePlan insurancePlan) {
		String planId=generateNextPlanId();
		logger.info(planId+" : plaId is generated");
		insurancePlan.setPlanId(planId);
		session = null;
		Transaction trans = null;
		session = factory.openSession();
		trans = session.beginTransaction();
        session.save(insurancePlan);
		trans.commit();
		session.close();
		return "succuss";
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

	@Override
	public InsurancePlan findInsuranceById(String planId) {
		// TODO Auto-generated method stub
		session = null;
		Transaction trans = null;
		session = factory.openSession();
		trans = session.beginTransaction();

		trans.commit();
		session.close();
		return null;
	}

	@Override
	public List<InsurancePlan> showAllPlan() {
		List<InsurancePlan> planList;
		session = null;
		Transaction trans = null;
		session = factory.openSession();
		trans = session.beginTransaction();
		planList = session.createQuery("from InsurancePlan").list();
		trans.commit();
		session.close();
		return planList;
	}

}
