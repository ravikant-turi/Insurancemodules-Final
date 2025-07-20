package com.infinite.jsf.insurance.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;

//this controller for coverageOption
public class InsuranceCoverageOptionController {

	private InsuranceCoverageOption coverageOption;
	

	private InsuranceCoverageOptionDao coverageOptionDao = new InsuranceCoverageOptionDaoImpl();;

	private InsurancePlan insurancePlan;

	private String showSuccessMessage;

	private String planId;

	List<InsuranceCoverageOption> coverageOptionsType;

	// get All coverageOptions
	public List<InsuranceCoverageOption> findAllcoverageOption() {
		return coverageOptionDao.findAllCoverageOption();
	}

	// add coverageOption
	public String addcoverageOption(InsuranceCoverageOption coverageOption) {

		if (validateInsuranceCoverageOptionWithFacesMessage(coverageOption)) {

			this.coverageOption.setInsurancePlan(insurancePlan);
			coverageOptionDao.addInsuranceCoverageOption(this.coverageOption);
			showSuccessMessage = "added successfully!";
			return "showInsuranceCoverageOption?faces-redirect=true";
		}
		return null;
	}

	// This is method is called from showPlan to add coverage
	public String addcoverageOptionToPlan(InsurancePlan plan) {
		insurancePlan = plan;
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("insurancePlan", plan);
		return "addCoverageOptionToPlan?faces-redirect=true";

	}

	// Add the coverageOption and return to the showPlan
	public String addcoverageOptionToPlanHelper() {
		FacesContext context = FacesContext.getCurrentInstance();

		insurancePlan = (InsurancePlan) context.getExternalContext().getSessionMap().get("insurancePlan");
		coverageOption.setInsurancePlan(insurancePlan);
		if (validateInsuranceCoverageOptionWithFacesMessage(coverageOption)) {

			this.coverageOption.setInsurancePlan(insurancePlan);
			coverageOptionDao.addInsuranceCoverageOption(this.coverageOption);
			showSuccessMessage = "added successfully!";
			return "showplan?faces-redirect=true";
		}
		return null;
	}

	// helper method
	public String showFullPlan(InsuranceCoverageOption cov) {

		coverageOption = cov;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selectedCoverage", cov);
		return "searchcoveragedetails";
	}

	// helper method
	public String getCoverageDetail() {

		coverageOption = (InsuranceCoverageOption) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("selectedCoverage");
		System.out.println("get map : " + coverageOption.getCoverageId());
		return "searchcoveragedetails";
	}

	// searchInsurancePlanByPlanType
	public String searchInsuranceCoverageOptionByPlanType(String planType) {

		coverageOptionsType = coverageOptionDao.searchInsuranceCoverageOptionByPlanType(planType);
		System.out.println("================");
		System.out.println(coverageOptionsType);
		return "showcoverageplanbyplantype.jsp?faces-redirect=true";

	}

	// delete CoverageOptions method
	public String deleteCoverageOptions(InsuranceCoverageOption coverageOption) {

		FacesContext context = FacesContext.getCurrentInstance();
		coverageOption = coverageOptionDao.searchInsuranceCoverageOption(coverageOption.getCoverageId());

		if (coverageOption != null) {
			showSuccessMessage = "deleted succssfully";
			coverageOptionDao.deleteInsuranceCoverageOption(coverageOption);
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CoverageId is not found", null));
		return null;
	}

	// searchCoverageByid
	public String searchCoverageOptionById(String coverageId) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.getExternalContext().getSessionMap().put("coverageId", coverageId);

		coverageOption = coverageOptionDao.searchInsuranceCoverageOption(coverageId);
		if (coverageOption == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"coverage option is not found with this id : " + coverageId, null));
		}

		return "updateCoverageOption?faces-redirect=true";

	}

//helper method to update
	public String helpUpdatemethod(InsuranceCoverageOption coverageOption) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.getExternalContext().getSessionMap().put("coverageId", coverageOption.getCoverageId());

		this.coverageOption = coverageOption;
		return "updateCoverageOption?faces-redirect=true";

	}
	// update method

	public String updateCoverageOption(InsuranceCoverageOption coverageOption) {
		FacesContext context = FacesContext.getCurrentInstance();

		if (coverageOption == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "coverage not foudn", null));
		}
		String coveragId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("coverageId");
		coverageOption.setCoverageId(coveragId);
		if (validateInsuranceCoverageOptionWithFacesMessage(coverageOption)) {

			coverageOptionDao.updateInsuranceCoverageOption(coverageOption);
			showSuccessMessage = "update successfully!";

			return "showInsuranceCoverageOption?faces-redirect=true";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "validation fails!", null));

		return null;

	}

	// searchCoverageOptionById

	public String searchCoverageOptionById(InsuranceCoverageOption coverageOption) {

		this.coverageOption = coverageOptionDao.searchInsuranceCoverageOption(coverageOption);
		return null;

	}

	// validation CaverageOptions
	public boolean validateInsuranceCoverageOptionWithFacesMessage(InsuranceCoverageOption option) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Validate plan
		if (option.insurancePlan == null || option.insurancePlan.getPlanId() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Linked Insurance Plan is required.", null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.premiumAmount < 500 || option.premiumAmount > 100000) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Premium amount must be between ₹500 and ₹100,000.", null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.coverageAmount < 100000 || option.coverageAmount > 50000000) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be between ₹1,00,000 (1L) and ₹5,00,00,000 (5Cr).", null));
			isValid = false;
		}

		// Validate status
		if (option.status == null || option.status.trim().isEmpty()) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status is required.", null));
			isValid = false;
		}

		return isValid;
	}
	// GETTER AND SETTER

	public InsuranceCoverageOption getCoverageOption() {
		return coverageOption;
	}

	public void setCoverageOption(InsuranceCoverageOption coverageOption) {
		this.coverageOption = coverageOption;
	}

	public InsuranceCoverageOptionDao getCoverageOptionDao() {
		return coverageOptionDao;
	}

	public void setCoverageOptionDao(InsuranceCoverageOptionDao coverageOptionDao) {
		this.coverageOptionDao = coverageOptionDao;
	}

	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	public String getShowSuccessMessage() {
		return showSuccessMessage;
	}

	public void setShowSuccessMessage(String showSuccessMessage) {
		this.showSuccessMessage = showSuccessMessage;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public List<InsuranceCoverageOption> getCoverageOptionsType() {
		return coverageOptionsType;
	}

	public void setCoverageOptionsType(List<InsuranceCoverageOption> coverageOptionsType) {
		this.coverageOptionsType = coverageOptionsType;
	}

	

	


}



//<h:messages globalOnly="true" style="color:red" />

