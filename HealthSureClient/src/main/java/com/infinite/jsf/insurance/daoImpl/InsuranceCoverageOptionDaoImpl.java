package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger.getLogger(InsuranceCompanyDaoImpl.class);

	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public String addCoveragePlan(InsuranceCoverageOption coverageOption) {
		session = null;
		Transaction trans = null;
		String coverageId = generateNextInsuranceCoverageOptionId();
		logger.info(coverageId + " : plaId is generated");
		coverageOption.setCoverageId(coverageId);

		session = factory.openSession();
		trans = session.beginTransaction();
		session.save(coverageOption);
		trans.commit();
		session.close();
		return "succuss";
	}

	public String generateNextInsuranceCoverageOptionId() {
		Session session = factory.openSession();

		String lastId = (String) session
				.createQuery("SELECT c.coverageId FROM InsuranceCoverageOption c ORDER BY c.coverageId DESC")
				.setMaxResults(1).uniqueResult();

		session.close();

		int nextNum = 1;

		if (lastId != null && lastId.toUpperCase().startsWith("COV") && lastId.length() == 6) {
			String numPart = lastId.substring(3); // "001"
			if (numPart.matches("\\d{3}")) {
				nextNum = Integer.parseInt(numPart) + 1;
			}
		}

		return String.format("COV%03d", nextNum); // e.g., COV002
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
