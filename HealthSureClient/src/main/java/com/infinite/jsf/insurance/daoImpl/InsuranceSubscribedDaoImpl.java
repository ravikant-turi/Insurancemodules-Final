package com.infinite.jsf.insurance.daoImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.google.common.eventbus.Subscribe;
import com.infinite.jsf.insurance.dao.InsuranceSubscribedDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.util.SessionHelper;

public class InsuranceSubscribedDaoImpl implements InsuranceSubscribedDao {
	static SessionFactory factory;
	static Session session;
	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public String addSubscribedPlanMember(SubscribedMember members) {
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
//		members.setMemberId(generateNextSubscribedMemberId());
		session.save(members);
		trans.commit();
		session.close();
		return "success";
	}

	@Override
	public InsuranceCoverageOption getInsurancePolicyById(String policyId) {
		InsuranceCoverageOption coverageOption = null;
		policyId=policyId.toUpperCase();
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		coverageOption = (InsuranceCoverageOption) session.get( InsuranceCoverageOption.class,policyId);
		trans.commit();
		session.close();
		return coverageOption;
	}

	@Override
	public List<InsuranceCoverageOption> exploreInsurancePlan() {
		List<InsuranceCoverageOption> optionsList;
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from InsuranceCoverageOption");
		optionsList = query.list();
		trans.commit();
		session.close();
		return optionsList;
	}

	@Override
	public List<SubscribedMember> getSubscribeMeberByPolicyId(String policyId) {
		List<SubscribedMember> optionsList;
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from SubscribedMember where SubscribedMember");
		optionsList = query.list();
		trans.commit();
		session.close();
		return optionsList;
	}

	@Override
	public String addSubscribe(Subscribe subscribe) {
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
//		subscribe.setSubscribeId("SIM002");
//		subscribe.setRecipientId("H001");
//         session.save(subscribe);
		trans.commit();
		session.close();
		return "success";
	}
	public String generateNextsubscribeId() {
	    Session session = factory.openSession();

	    String lastId = (String) session.createQuery(
	        "SELECT c.subscribeId FROM subscribe c ORDER BY c.subscribeId DESC")
	        .setMaxResults(1)
	        .uniqueResult();

	    session.close();

	    int nextNum = 1;

	    if (lastId != null && lastId.toUpperCase().startsWith("SUB") && lastId.length() == 6) {
	        String numPart = lastId.substring(3); // "001"
	        if (numPart.matches("\\d{3}")) {
	            nextNum = Integer.parseInt(numPart) + 1;
	        }
	    }

	    return String.format("SUB%03d", nextNum); // e.g., COM002
	}
	public String generateNextSubscribedMemberId() {
	    Session session = factory.openSession();

	    String lastId = (String) session.createQuery(
	        "SELECT c.memberId FROM SubscribedMember c ORDER BY c.memberId DESC")
	        .setMaxResults(1)
	        .uniqueResult();

	    session.close();

	    int nextNum = 1;

	    if (lastId != null && lastId.toUpperCase().startsWith("SIM") && lastId.length() == 6) {
	        String numPart = lastId.substring(3); // "001"
	        if (numPart.matches("\\d{3}")) {
	            nextNum = Integer.parseInt(numPart) + 1;
	        }
	    }

	    return String.format("SIM%03d", nextNum); // e.g., COM002
	}

	


}