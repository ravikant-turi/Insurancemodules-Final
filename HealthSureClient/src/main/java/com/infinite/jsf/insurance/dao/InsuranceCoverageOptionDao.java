package com.infinite.jsf.insurance.dao;

import java.util.List;

import com.infinite.jsf.insurance.model.InsuranceCoverageOption;

public interface InsuranceCoverageOptionDao {

	String addCoveragePlan(InsuranceCoverageOption coverageOption);

	List<InsuranceCoverageOption> findAllInsuranceCoverageOptions();

	List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanId(String planId);

	List<InsuranceCoverageOption> findAllInsuranceCoverageOptionsByPlanType(String PlanType);

	InsuranceCoverageOption findInsuranceCoverageById(String coverageId);

}
