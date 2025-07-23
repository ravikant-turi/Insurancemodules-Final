package com.infinite.jsf.insurance.dao;

import java.util.List;

import com.google.common.eventbus.Subscribe;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.SubscribedMember;

public interface InsuranceSubscribedDao {
	List<InsuranceCoverageOption> exploreInsurancePlan();

	String addSubscribedPlanMember(SubscribedMember members);

	String addSubscribe(Subscribe subscribe);

	InsuranceCoverageOption getInsurancePolicyById(String policyId);

	List<SubscribedMember> getSubscribeMeberByPolicyId(String policyId);
}