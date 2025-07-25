package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceSubscribeDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.recipient.model.Recipient;
import com.infinite.jsf.util.SessionHelper;

public class InsuranceSubscribeDaoImpl implements InsuranceSubscribeDao {
	static SessionFactory factory;
	static Session session;
	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public InsuranceCoverageOption getInsurancePolicyById(String policyId) {
		InsuranceCoverageOption coverageOption = null;
		policyId = policyId.toUpperCase();
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		coverageOption = (InsuranceCoverageOption) session.get(InsuranceCoverageOption.class, policyId);
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

	public String generateNextsubscribeId() {
		Session session = factory.openSession();

		String lastId = (String) session
				.createQuery("SELECT c.subscribeId FROM Subscribe c ORDER BY c.subscribeId DESC").setMaxResults(1)
				.uniqueResult();

		session.close();

		int nextNum = 1;

		if (lastId != null && lastId.toUpperCase().startsWith("SUB") && lastId.length() == 6) {
			String numPart = lastId.substring(3); // "001"
			if (numPart.matches("\\d{3}")) {
				nextNum = Integer.parseInt(numPart) + 1;
			}
		}

		return String.format("SUB%03d", nextNum); // e.g., SUB002
	}

	public String generateNextSubscribedMemberId() {
		Session session = factory.openSession();

		String lastId = (String) session
				.createQuery("SELECT c.memberId FROM SubscribedMember c ORDER BY c.memberId DESC").setMaxResults(1)
				.uniqueResult();

		session.close();

		int nextNum = 1;

		if (lastId != null && lastId.toUpperCase().startsWith("SUM") && lastId.length() == 6) {
			String numPart = lastId.substring(3); // "001"
			if (numPart.matches("\\d{3}")) {
				nextNum = Integer.parseInt(numPart) + 1;
			}
		}

		return String.format("SUM%03d", nextNum); // e.g., SUM002
	}

	@Override
	public String addIndividualSuscribeMember(Subscribe individualMember) {
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		individualMember.setSubscribeId(generateNextsubscribeId());

		session.save(individualMember);
		trans.commit();
		session.close();
		System.out.println("==============================");
		System.out.println("==============================");
		System.out.println("==============================");
		System.out.println("==============================");
		System.out.println(individualMember.getSubscribeId());
		return individualMember.getSubscribeId();
	}

	@Override
	public String addFamilySubscribeMember(SubscribedMember familySubscribedMember) {
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		familySubscribedMember.setMemberId(generateNextSubscribedMemberId());

		session.save(familySubscribedMember);
		trans.commit();
		session.close();
		return familySubscribedMember.getMemberId();
	}

	@Override
	public Recipient searchRecipientById(String id) {
		session = factory.openSession();
		Transaction trans = session.beginTransaction();

		Recipient recipient = (Recipient) session.get(Recipient.class, id);

		trans.commit();
		session.close();
		return recipient;
	}

}