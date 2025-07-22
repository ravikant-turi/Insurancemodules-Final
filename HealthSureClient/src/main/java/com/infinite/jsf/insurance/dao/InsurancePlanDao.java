package com.infinite.jsf.insurance.dao;

import java.util.List;
import com.infinite.jsf.insurance.model.InsurancePlan;


public interface InsurancePlanDao {

	String addInsurancePlan(InsurancePlan insurancPlan);

	InsurancePlan findInsuranceById(String planId);
	
	List<InsurancePlan> showAllPlan();
}
