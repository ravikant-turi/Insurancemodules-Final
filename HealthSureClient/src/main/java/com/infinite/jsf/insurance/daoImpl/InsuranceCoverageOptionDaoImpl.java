package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.util.SessionHelper;

public class InsuranceCoverageOptionDaoImpl implements InsuranceCoverageOptionDao {

	static SessionFactory factory;
	static Session session;
	static {
		factory = SessionHelper.getSessionFactory();
	}
	@Override
	public String addCoveragePlan(InsuranceCoverageOption coverageOption) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<InsuranceCoverageOption> findAllInsuranceCoverageOptions() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanId(String planId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanType(String PlanType) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public InsuranceCoverageOption findInsuranceCoverageById(String coverageId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
