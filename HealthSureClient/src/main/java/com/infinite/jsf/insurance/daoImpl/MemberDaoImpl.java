/**
 * MemberDaoImpl.java
 *
 * This class provides the implementation of the MemberDao interface.
 * It handles operations related to Member entities such as adding and updating members.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.MemberDao;
import com.infinite.jsf.insurance.model.Member;
import com.infinite.jsf.util.SessionHelper;

public class MemberDaoImpl implements MemberDao {

    static SessionFactory factory;
    static Session session;
    private static final Logger logger = Logger.getLogger(MemberDaoImpl.class);

    static {
        factory = SessionHelper.getSessionFactory();
    }

    /**
     * Adds a new Member to the database.
     *
     * @param member the Member object to be added
     * @return "succuss" if the operation is successful
     */
    @Override
    public String addMember(Member member) {
        session = null;
        Transaction trans = null;
        String memberId = generateNextMemberId();
        logger.info(memberId + " : memberId is generated");
        member.setMeberId(memberId);
        logger.info("Member details: " + member);

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.save(member);
            trans.commit();
            logger.info("Member saved successfully with ID: " + memberId);
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error while saving member: " + e.getMessage(), e);
        } finally {
            if (session != null) session.close();
        }

        return "succuss";
    }

    /**
     * Generates the next member ID in the format MEM###.
     *
     * @return the next member ID
     */
    public String generateNextMemberId() {
        Session session = null;
        String lastId = null;

        try {
            session = factory.openSession();
            lastId = (String) session.createQuery(
                "SELECT m.meberId FROM Member m ORDER BY m.meberId DESC")
                .setMaxResults(1)
                .uniqueResult();
            logger.debug("Last member ID fetched: " + lastId);
        } catch (Exception e) {
            logger.error("Error generating next member ID: " + e.getMessage(), e);
        } finally {
            if (session != null) session.close();
        }

        int nextNum = 1;

        if (lastId != null && lastId.toUpperCase().startsWith("MEM") && lastId.length() == 6) {
            String numPart = lastId.substring(3); // "001"
            if (numPart.matches("\\d{3}")) {
                nextNum = Integer.parseInt(numPart) + 1;
            }
        }

        String nextId = String.format("MEM%03d", nextNum);
        logger.debug("Next generated member ID: " + nextId);
        return nextId;
    }

    /**
     * Retrieves all members associated with a specific coverage ID.
     *
     * @param coverageId the coverage ID to filter members
     * @return list of Member objects
     */
    @Override
    public List<Member> findAllMeberByCoverageId(String coverageId) {
        logger.debug("findAllMeberByCoverageId method is not yet implemented.");
        return null;
    }

    /**
     * Updates an existing Member record.
     *
     * @param member the Member object with updated data
     * @return null (method not yet implemented)
     */
    @Override
    public String updateMember(Member member) {
        logger.debug("updateMember method is not yet implemented.");
        return null;
    }

	@Override
	public List<Member> searchMemberByPlanId(String planId) {
		List<Member> memberList=null;
		session =factory.openSession();
		Transaction trans=session.beginTransaction();

	    String hql = "FROM Member m WHERE m.insurancePlan.planId = :planId";
	    Query query = session.createQuery(hql);
	    query.setParameter("planId", planId);
	    memberList=query.list();
		trans.commit();
		session.clear();
	    return memberList;
	}
}
