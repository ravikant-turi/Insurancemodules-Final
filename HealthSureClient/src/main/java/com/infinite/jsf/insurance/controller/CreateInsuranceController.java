package com.infinite.jsf.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.dao.MemberDao;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.Member;
import com.infinite.jsf.insurance.model.Relation;

public class CreateInsuranceController {
	private InsuranceCompany insuranceCompany;
	private InsurancePlan insurancePlan;
	private InsuranceCoverageOption coverageOption;
	private InsuranceCoverageOption coverageOption1;
	private InsuranceCoverageOption coverageOption2;
	private InsuranceCoverageOption coverageOption3;
	private Member member;
	private InsuranceCoverageOptionDao insuranceCoverageOptionDao;
	private InsurancePlanDao insurancplanDao = new InsurancePlanDaoImpl();
	private MemberDao memberDao;
	private List<InsuranceCoverageOption> planwithCovrageDetailsList;
	private int yearsToAdd;
	private List<Member> members;
	private List<InsurancePlan> planList;
	List<Relation>relationList;
	private Map<String, Boolean> relationMap = new HashMap<>();

	// show plans on dashBoard
	public List<InsurancePlan> showAllPlan() {
		planList = insurancplanDao.showAllPlan();
		return planList;
	}

	

	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	public InsuranceCoverageOption getCoverageOption() {
		return coverageOption;
	}

	public void setCoverageOption(InsuranceCoverageOption coverageOption) {
		this.coverageOption = coverageOption;
	}

	public InsuranceCoverageOption getCoverageOption1() {
		return coverageOption1;
	}

	public void setCoverageOption1(InsuranceCoverageOption coverageOption1) {
		this.coverageOption1 = coverageOption1;
	}

	public InsuranceCoverageOption getCoverageOption2() {
		return coverageOption2;
	}

	public void setCoverageOption2(InsuranceCoverageOption coverageOption2) {
		this.coverageOption2 = coverageOption2;
	}

	public InsuranceCoverageOption getCoverageOption3() {
		return coverageOption3;
	}

	public void setCoverageOption3(InsuranceCoverageOption coverageOption3) {
		this.coverageOption3 = coverageOption3;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public InsuranceCoverageOptionDao getInsuranceCoverageOptionDao() {
		return insuranceCoverageOptionDao;
	}

	public void setInsuranceCoverageOptionDao(InsuranceCoverageOptionDao insuranceCoverageOptionDao) {
		this.insuranceCoverageOptionDao = insuranceCoverageOptionDao;
	}

	public InsurancePlanDao getInsurancplanDao() {
		return insurancplanDao;
	}

	public void setInsurancplanDao(InsurancePlanDao insurancplanDao) {
		this.insurancplanDao = insurancplanDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public List<InsuranceCoverageOption> getPlanwithCovrageDetailsList() {
		return planwithCovrageDetailsList;
	}

	public void setPlanwithCovrageDetailsList(List<InsuranceCoverageOption> planwithCovrageDetailsList) {
		this.planwithCovrageDetailsList = planwithCovrageDetailsList;
	}

	public int getYearsToAdd() {
		return yearsToAdd;
	}

	public void setYearsToAdd(int yearsToAdd) {
		this.yearsToAdd = yearsToAdd;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<InsurancePlan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<InsurancePlan> planList) {
		this.planList = planList;
	}



	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}



	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}



	public List<Relation> getRelationList() {
		return relationList;
	}



	public void setRelationList(List<Relation> relationList) {
		this.relationList = relationList;
	}
	
	
	public Map<String, Boolean> getRelationMap() {
		return relationMap;
	}



	public void setRelationMap(Map<String, Boolean> relationMap) {
		this.relationMap = relationMap;
	}



	@PostConstruct
	public void init() {
	    relationMap.put("SON1", false);
	    relationMap.put("SON2", false);
	    relationMap.put("DAUGHTER1", false);
	    relationMap.put("DAUGHTER2", false);
	    relationMap.put("FATHER", false);
	    relationMap.put("MOTHER", false);
	    relationMap.put("HUSBAND", false);
	    relationMap.put("WIFE", false);
	    relationMap.put("SELF", false);
	}


}
