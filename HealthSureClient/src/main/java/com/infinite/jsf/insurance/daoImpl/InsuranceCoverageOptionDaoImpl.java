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
	public String addInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		coverageOption.setCoverageId(generateNextInsuranceCoverageOptionId());
		Transaction trans = session.beginTransaction();
		session.save(coverageOption);
		trans.commit();
		session.close();
		return "success";
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

		return String.format("COV%03d", nextNum); // e.g., COM002
	}

	@Override
	public String deleteInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {

		// TODO Auto-generated method stub
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(coverageOption);

		trans.commit();
		session.close();
		return "deleted";
	}

	@Override
	public List<InsuranceCoverageOption> findAllCoverageOption() {
		// TODO Auto-generated method stub

		session = factory.openSession();

		Transaction trans = session.beginTransaction();

		Criteria criteria = session.createCriteria(InsuranceCoverageOption.class);

		List<InsuranceCoverageOption> coverageOptions = criteria.list();

		trans.commit();
		session.close();
		return coverageOptions;
	}

	@Override
	public String updateInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
		// TODO Auto-generated method stub
		session = factory.openSession();

		Transaction trans = session.beginTransaction();
		session.update(coverageOption);
		trans.commit();
		session.close();
		return " updated ";
	}

	@Override
	public InsuranceCoverageOption searchInsuranceCoverageOption(String coverageId) {
		return null;

	}
	@SuppressWarnings("unchecked")

	@Override
	public List<InsuranceCoverageOption> searchInsuranceCoverageOptionByPlanType(String planType) {
		session = factory.openSession();
		List<InsuranceCoverageOption> coverageOptions;
		Transaction trans = session.beginTransaction();
		String sql = "SELECT c.* FROM insurance_coverage_option c " + "JOIN insurance_plan p ON p.plan_id = c.plan_id "
				+ "WHERE p.plan_type = :planType";

		coverageOptions = session.createSQLQuery(sql).addEntity(InsuranceCoverageOption.class)
				.setParameter("planType", planType.toUpperCase()) // adjust as needed
				.list();
		trans.commit();
		session.close();

		return coverageOptions;
	}

	@Override
	public InsuranceCoverageOption searchInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
		session = factory.openSession();

		Transaction trans = session.beginTransaction();
		InsuranceCoverageOption foundCoverageOption = (InsuranceCoverageOption) session
				.get(InsuranceCoverageOption.class, coverageOption.getCoverageId());
		trans.commit();
		session.close();
		return foundCoverageOption;
	}
	@SuppressWarnings("unchecked")

	@Override
	public List<InsuranceCoverageOption> searchInsuranceCoverageOptionByPlanId(String planId) {
		List<InsuranceCoverageOption> covrageOptionsList = null;
		session = factory.openSession();
		Transaction trans = session.beginTransaction();

		String sql = "SELECT c.* FROM insurance_coverage_option c JOIN insurance_plan p ON p.plan_id = c.plan_id WHERE c.plan_id = :plan_id";
		covrageOptionsList = session.createSQLQuery(sql).addEntity(InsuranceCoverageOption.class)
				.setParameter("plan_id", planId).list();

		return covrageOptionsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InsuranceCoverageOption> getInsuranceCoverageOptionsByPlanType(String planTypeStr) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();

		String hql = "FROM InsuranceCoverageOption c " + "JOIN FETCH c.insurancePlan p "
				+ "WHERE p.planTypeString = :planType";

		List<InsuranceCoverageOption> options = session.createQuery(hql)
				.setParameter("planType", planTypeStr.toUpperCase()).list(); // Use list() instead of uniqueResult()

		trans.commit();
		session.close();

		return options;
	}

}
