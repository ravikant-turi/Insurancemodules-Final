package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.MemberDao;
import com.infinite.jsf.insurance.model.Member;
import com.infinite.jsf.util.SessionHelper;

public class MemberDaoImpl implements MemberDao {
	static SessionFactory factory;
	static Session session;
	private static final Logger logger = Logger.getLogger(InsuranceCompanyDaoImpl.class);

	static {
		factory = SessionHelper.getSessionFactory();
	}
	@Override
	public String addMember(Member member) {
		session = null;
		Transaction trans = null;
		String memberId = generateNextMemberId();
		logger.info(memberId + " : plaId is generated");
		member.setMeberId(memberId);
        logger.info(member);
		session = factory.openSession();
		trans = session.beginTransaction();
		session.save(member);
		trans.commit();
		session.close();
		return "succuss";
	}

	public String generateNextMemberId() {
		Session session = factory.openSession();

		String lastId = (String) session
				.createQuery("SELECT m.meberId FROM Member m ORDER BY m.meberId DESC")
				.setMaxResults(1).uniqueResult();

		session.close();

		int nextNum = 1;

		if (lastId != null && lastId.toUpperCase().startsWith("MEM") && lastId.length() == 6) {
			String numPart = lastId.substring(3); // "001"
			if (numPart.matches("\\d{3}")) {
				nextNum = Integer.parseInt(numPart) + 1;
			}
		}

		return String.format("MEM%03d", nextNum); // e.g., MEM002
	}

	@Override
	public List<Member> findAllMeberByCoverageId(String coverageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
