package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceCompanyDao;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.util.SessionHelper;

public class InsuranceCompanyDaoImpl implements InsuranceCompanyDao {

    private static final Logger logger = Logger.getLogger(InsuranceCompanyDaoImpl.class);

    static SessionFactory factory = SessionHelper.getSessionFactory();

    @Override
    public String addCompany(InsuranceCompany company) {
        company.setCompanyId(generateNextCompanyId());
        logger.info("Adding company: " + company);

        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.save(company);
            trans.commit();
            logger.info("Company added successfully.");
            return "success";
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error adding company", e);
            return "error";
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public InsuranceCompany findCompanyById(String companyId) {
        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            logger.info("Finding company by ID: " + companyId);
            InsuranceCompany company = (InsuranceCompany) session.get(InsuranceCompany.class, companyId);
            trans.commit();
            return company;
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error finding company by ID", e);
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public List<InsuranceCompany> findAllCompany() {
        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            Criteria criteria = session.createCriteria(InsuranceCompany.class);
            List<InsuranceCompany> companies = criteria.list();
            trans.commit();
            logger.info("Retrieved all companies.");
            return companies;
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error retrieving all companies", e);
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public String deleteCompanyById(InsuranceCompany company) {
        logger.info("Deleting company: " + company.getCompanyId());

        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.delete(company);
            trans.commit();
            logger.info("Company deleted successfully.");
            return "deleted";
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error deleting company", e);
            return "error";
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public String updateCompany(InsuranceCompany company) {
        logger.info("Updating company: " + company.getCompanyId());

        Session session = null;
        Transaction trans = null;

        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.update(company);
            trans.commit();
            logger.info("Company updated successfully.");
            return "updated";
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error updating company", e);
            return "error";
        } finally {
            if (session != null) session.close();
        }
    }

    public String generateNextCompanyId() {
        Session session = null;

        try {
            session = factory.openSession();
            String lastId = (String) session.createQuery(
                    "SELECT c.companyId FROM InsuranceCompany c ORDER BY c.companyId DESC")
                    .setMaxResults(1)
                    .uniqueResult();

            int nextNum = 1;

            if (lastId != null && lastId.toUpperCase().startsWith("COM") && lastId.length() == 6) {
                String numPart = lastId.substring(3); // "001"
                if (numPart.matches("\\d{3}")) {
                    nextNum = Integer.parseInt(numPart) + 1;
                }
            }

            String nextId = String.format("COM%03d", nextNum);
            logger.info("Generated next company ID: " + nextId);
            return nextId;
        } catch (Exception e) {
            logger.error("Error generating next company ID", e);
            return "COM001"; // fallback
        } finally {
            if (session != null) session.close();
        }
    }
}
