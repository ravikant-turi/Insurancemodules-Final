package com.infinite.jsf.insurance.model;

import java.util.Set;

public class InsuranceCoverageOption {

	private String coverageId;

	private InsurancePlan insurancePlan; // FK (planId)

	private double premiumAmount;

	private double coverageAmount;

	private String status;

	private Set<Member> members;

	private int maximumMemberAllowed;

	private int minimumMeberAllowed;

	private CoverageType coverageType;

	public String getCoverageId() {
		return coverageId;
	}

	public void setCoverageId(String coverageId) {
		this.coverageId = coverageId;
	}

	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	public int getMaximumMemberAllowed() {
		return maximumMemberAllowed;
	}

	public void setMaximumMemberAllowed(int maximumMemberAllowed) {
		this.maximumMemberAllowed = maximumMemberAllowed;
	}

	public int getMinimumMeberAllowed() {
		return minimumMeberAllowed;
	}

	public void setMinimumMeberAllowed(int minimumMeberAllowed) {
		this.minimumMeberAllowed = minimumMeberAllowed;
	}

	public InsuranceCoverageOption(String coverageId, InsurancePlan insurancePlan, double premiumAmount,
			double coverageAmount, String status, Set<Member> members, int maximumMemberAllowed,
			int minimumMeberAllowed, CoverageType coverageType) {
		super();
		this.coverageId = coverageId;
		this.insurancePlan = insurancePlan;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.status = status;
		this.members = members;
		this.maximumMemberAllowed = maximumMemberAllowed;
		this.minimumMeberAllowed = minimumMeberAllowed;
		this.coverageType = coverageType;
	}

	@Override
	public String toString() {
		return "InsuranceCoverageOption [coverageId=" + coverageId + ", insurancePlan=" + insurancePlan
				+ ", premiumAmount=" + premiumAmount + ", coverageAmount=" + coverageAmount + ", status=" + status
				+ ", members=" + members + ", maximumMemberAllowed=" + maximumMemberAllowed + ", minimumMeberAllowed="
				+ minimumMeberAllowed + ", coverageType=" + coverageType + "]";
	}

	

	public CoverageType getCoverageType() {
		return coverageType;
	}

	public void setCoverageType(CoverageType coverageType) {
		this.coverageType = coverageType;
	}
	

	public InsuranceCoverageOption() {
		super();
		// TODO Auto-generated constructor stub
	}

}
