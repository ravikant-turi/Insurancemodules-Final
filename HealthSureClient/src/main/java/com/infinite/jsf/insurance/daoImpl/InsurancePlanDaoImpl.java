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

public class InsurancePlanDaoImpl implements InsurancePlanDao {

	static SessionFactory factory;
	static Session session;

	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public String addInsurancePlan(InsurancePlan insurancPlan) {
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
