package com.infinite.jsf.test;

import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;

public class InsurancePlaneTest {
	
	public static void main(String[] args) {
		
		InsurancePlanDao dao=new InsurancePlanDaoImpl();
		dao.findInsuranceById("PLA014");
		dao.findInsuranceById("PLA004");
		
		
	}

}
