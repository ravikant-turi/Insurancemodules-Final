package com.infinite.jsf.insurance.model;


public class InsuranceCoverageOption {
	
    public String coverageId;
    
    public InsurancePlan insurancePlan; // FK (planId)

    public double premiumAmount;
    
    public double coverageAmount;
    
    public String status = "INACTIVE";
    

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

	@Override
	public String toString() {
		return "InsuranceCoverageOption [coverageId=" + coverageId + ", insurancePlan=" + insurancePlan
				+ ", premiumAmount=" + premiumAmount + ", coverageAmount=" + coverageAmount + ", status=" + status
				+ "]";
	}

	public InsuranceCoverageOption(String coverageId, InsurancePlan insurancePlan, double premiumAmount,
			double coverageAmount, String status) {
		super();
		this.coverageId = coverageId;
		this.insurancePlan = insurancePlan;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.status = status;
	}

	public InsuranceCoverageOption() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}
	
