package com.infinite.jsf.test;

import com.infinite.jsf.insurance.controller.InsurancePlanController;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.PlanType;

public class InsurancePlaneTest {
	
	public static void main(String[] args) {
		
		InsurancePlanController controller=new InsurancePlanController();
		
		InsurancePlanDaoImpl daoimpl=new InsurancePlanDaoImpl();
		
//		controller.findAllPlan().forEach(e->{System.out.println(e)};
//		
		
		System.out.println("============this is main method");
		System.out.println("============this is main method");
		System.out.println("============this is main method");
		System.out.println("============this is main method");

		controller.findAllPlan().forEach(System.out::println);
		// Create an InsuranceCompany object (you may already have this from DB or create a dummy one for now)
		
		
		System.out.println("faily plan");
		
//		daoimpl.searchByPlanType("FAMILY").forEach(System.out::println);
		daoimpl.searchByPlanType("SELF").forEach(System.out::println);

	}

}
