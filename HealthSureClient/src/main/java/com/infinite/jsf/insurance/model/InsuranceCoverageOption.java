package com.infinite.jsf.insurance.model;


public class InsuranceCoverageOption {

	private String coverageId;

	private InsurancePlan insurancePlan; // FK (planId)

	private double premiumAmount;

	private double coverageAmount;

	private String status;

	

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

	
	
	public InsuranceCoverageOption(String coverageId, InsurancePlan insurancePlan, double premiumAmount,
			double coverageAmount, String status, CoverageType coverageType) {
		super();
		this.coverageId = coverageId;
		this.insurancePlan = insurancePlan;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.status = status;
		this.coverageType = coverageType;
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
