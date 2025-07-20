package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceCompanyDao;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.util.SessionHelper;

public class InsuranceCompanyDaoImpl implements InsuranceCompanyDao{
	
	static SessionFactory factory;
	
	static Session session;
	
	static {
		factory=SessionHelper.getSessionFactory();
	}
	@Override
	public String addCompany(InsuranceCompany company) {
		
		company.setCompanyId(generateNextCompanyId());
		
		System.out.println(company);
		
		session=factory.openSession();
		
		
		Transaction trans=session.beginTransaction();
		
		
		session.save(company);
		
		trans.commit();
		
		session.close();
		
		return "success";
	}

	@Override
	public InsuranceCompany findCompanyById(String companyId) {
		
		session=factory.openSession();
		
		Transaction trans=session.beginTransaction();
		
		System.out.println("method is has been called : "+session);
		
		InsuranceCompany company=(InsuranceCompany) session.get(InsuranceCompany.class, companyId);
		
		trans.commit();
		
		session.close();
		return company;
	}

	@Override
	public List<InsuranceCompany> findAllCompany() {
		session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Criteria criteria=session.createCriteria(InsuranceCompany.class);
		List<InsuranceCompany> companies=criteria.list();
		trans.commit();
		session.close();
		return companies;
	}

	@Override
	public String deleteCompanyById(InsuranceCompany company) {
		System.out.println("delete method is called ");
		System.out.println("delete method is calledSystem.out.println(\"===========contoller method is called==========\");\r\n"
				+ "		System.out.println(\"===========contoller method is called==========\");\r\n"
				+ "		System.out.println(\"===========contoller method is called==========\"); ");

		session=factory.openSession();
		
		Transaction trans=session.beginTransaction();
		
		session.delete(company);
		
		trans.commit();
		
		session.close();
		
		return "deleted";
	}

	

	public String generateNextCompanyId() {
	    Session session = factory.openSession();

	    String lastId = (String) session.createQuery(
	        "SELECT c.companyId FROM InsuranceCompany c ORDER BY c.companyId DESC")
	        .setMaxResults(1)
	        .uniqueResult();

	    session.close();

	    int nextNum = 1;

	    if (lastId != null && lastId.toUpperCase().startsWith("COM") && lastId.length() == 6) {
	        String numPart = lastId.substring(3); // "001"
	        if (numPart.matches("\\d{3}")) {
	            nextNum = Integer.parseInt(numPart) + 1;
	        }
	    }

	    return String.format("COM%03d", nextNum); // e.g., COM002
	}

	@Override
	public String updateCompany(InsuranceCompany company) {
		session =factory.openSession();
		Transaction trans=session.beginTransaction();
		
		session.update(company);
		
		
		trans.commit();
		session.close();
		return  "updated";
	}


}
