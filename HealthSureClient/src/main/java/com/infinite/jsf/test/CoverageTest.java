package com.infinite.jsf.test;

import java.util.List;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;

public class CoverageTest {

	public static void main(String[] args) {
		
		 List<InsuranceCoverageOption> planwithCovrageDetailsList=null;
   
		
		
		InsuranceCoverageOptionDao insuranceCoverageOptionDao=new InsuranceCoverageOptionDaoImpl();
		 
		planwithCovrageDetailsList = insuranceCoverageOptionDao.findAllInsuranceCoverageOptions();

		for(InsuranceCoverageOption coverageOption:planwithCovrageDetailsList) {
			System.out.println(coverageOption);
		}
	}
}
