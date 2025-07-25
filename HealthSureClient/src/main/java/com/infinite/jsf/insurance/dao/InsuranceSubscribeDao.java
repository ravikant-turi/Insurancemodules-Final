package com.infinite.jsf.insurance.dao;

import java.util.List;

import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.recipient.model.Recipient;

public interface InsuranceSubscribeDao {
	List<InsuranceCoverageOption> exploreInsurancePlan();

	InsuranceCoverageOption getInsurancePolicyById(String policyId);

	List<SubscribedMember> getSubscribeMeberByPolicyId(String policyId);

	String addIndividualSuscribeMember(Subscribe suscribedMember);

	String addFamilySubscribeMember(SubscribedMember familySubscribedMember);
	
	Recipient searchRecipientById(String id);
}