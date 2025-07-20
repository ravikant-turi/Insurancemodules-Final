package com.infinite.jsf.insurance.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;

//this controller contains all the method related to InsurancePlan
public class InsurancePlanController {

	private InsurancePlan insurancePlan;
	private InsuranceCompany insuranceCompany;
	private String showSuccessMessage;
	private InsuranceCoverageOption coverageOption1 = new InsuranceCoverageOption();
	private InsuranceCoverageOption coverageOption2 = new InsuranceCoverageOption();
	private InsuranceCoverageOption coverageOption3 = new InsuranceCoverageOption();
	private InsuranceCoverageOptionDao insuranceCoverageOptionDao;
	private InsurancePlanDao plandao = new InsurancePlanDaoImpl();
	private List<InsuranceCoverageOption> planwithCovrageDetailsList;
	private int yearsToAdd;

//	=============methods==============

//Show all InsurancePlan
	public List<InsurancePlan> findAllPlan() {
		return plandao.showAllPlans();
	}

//add InsurancePlan
	public String addPlan(InsurancePlan insurancePlan) {
		insurancePlan.setInsuranceCompany(insuranceCompany);
		if (validateInsurancePlanWithFacesMessage(insurancePlan)) {

			plandao.addInsurancePlan(insurancePlan);

			return "showplan?faces-redirect=true";

		}

		return null;

	}

	// addInsurancePlanWithCoveragePlan directly

	public String addInsurancePlanWithCoveragePlan() {
		FacesContext context = FacesContext.getCurrentInstance();
		insurancePlan.setInsuranceCompany(insuranceCompany);
		System.out.println("=============================");
		System.out.println(insuranceCompany);
		System.out.println(insurancePlan);
		System.out.println(coverageOption1);
		System.out.println(coverageOption2);
		System.out.println(coverageOption3);

		if (coverageOption1.coverageId == null && coverageOption2.coverageId == null
				&& coverageOption3.coverageId == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "No coverage options provided", null));

		}

		if (validateInsurancePlanWithFacesMessage(insurancePlan)
				|| validateInsuranceCoverageOptionWithFacesMessage(coverageOption1)) {
			plandao.addInsurancePlan(insurancePlan);

			InsuranceCoverageOption[] options = { coverageOption1, coverageOption2, coverageOption3 };
			for (InsuranceCoverageOption option : options) {
				if (option != null) {
					option.setInsurancePlan(insurancePlan);
					insuranceCoverageOptionDao.addInsuranceCoverageOption(option);
				}
			}

			coverageOption1 = null;
			coverageOption2 = null;
			coverageOption3 = null;
			insuranceCompany = null;
			insurancePlan = null;
			return "showplan?faces-redirect=true";
		}

		return null;
	}

	// CompletePlanDetailsTest.jsp : show full details by planId
	public String showPlanDetailsWithCoveragePlan(String planId) {

		List<InsuranceCoverageOption> list = insuranceCoverageOptionDao.searchInsuranceCoverageOptionByPlanId(planId);
		coverageOption1 = list.get(0);
		coverageOption2 = list.get(1);
		coverageOption3 = list.get(2);
		insurancePlan = list.get(0).insurancePlan;
		insuranceCompany = list.get(0).insurancePlan.getInsuranceCompany();
		System.out.println("=============\n" + coverageOption1);
		System.out.println(coverageOption2);
		System.out.println(coverageOption3);
		System.out.println(insurancePlan);
		System.out.println(insuranceCompany);

		return "InsurancePlanCoverageDetails?faces-redirect=true";
	}

//	CompletePlanUpdateTest.jsp
	public String showPlanDetailsToUpdate(String planId) {
		List<InsuranceCoverageOption> list = insuranceCoverageOptionDao.searchInsuranceCoverageOptionByPlanId(planId);
		coverageOption1 = list.get(0);
		coverageOption2 = list.get(1);
		coverageOption3 = list.get(2);
		insurancePlan = list.get(0).insurancePlan;
		insuranceCompany = list.get(0).insurancePlan.getInsuranceCompany();
		System.out.println("=============\n" + coverageOption1);
		System.out.println(coverageOption2);
		System.out.println(coverageOption3);
		System.out.println(insurancePlan);
		System.out.println(insuranceCompany);
		return "CompletePlanUpdateTest?faces-redirect=true";
	}

//update and back to menu
	public String updatePlanDetailsWithCoveragePlan() {
		FacesContext context = FacesContext.getCurrentInstance();
		insurancePlan.setInsuranceCompany(insuranceCompany);
		System.out.println("=============================");
		System.out.println(insuranceCompany);
		System.out.println(insurancePlan);
		System.out.println(coverageOption1);
		System.out.println(coverageOption2);
		System.out.println(coverageOption3);

		if (coverageOption1.coverageId == null && coverageOption2.coverageId == null
				&& coverageOption3.coverageId == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "No coverage options provided", null));

		}

		if (validateInsurancePlanWithFacesMessage(insurancePlan)
				|| validateInsuranceCoverageOptionWithFacesMessage(coverageOption1)) {
			plandao.updateInsurancePlan(insurancePlan);

			InsuranceCoverageOption[] options = { coverageOption1, coverageOption2, coverageOption3 };
			for (InsuranceCoverageOption option : options) {
				if (option != null) {
					option.setInsurancePlan(insurancePlan);
					insuranceCoverageOptionDao.updateInsuranceCoverageOption(option);
				}
			}
			return "InsuranceUpdateInsurancePlanCoverage?faces-redirect=true";
		}

		return null;

	}

//search Plan By planId
	public String searchPlanById(String planId) {

		FacesContext context = FacesContext.getCurrentInstance();
		insurancePlan = plandao.searchInsurancePlanById(planId);
		System.out.println("=====search method is called==========");
		System.out.println(insurancePlan);

		context.getExternalContext().getSessionMap().put("planId", planId);

		if (insurancePlan == null) {
			context.addMessage(null, new FacesMessage("plan is not found with this id : " + planId, null));
			return null;
		}

		return "searchPlanById?faces-redirect=true";

	}

//delete operation By planId
	public String deletePlaneById(String planId) {
		FacesContext context = FacesContext.getCurrentInstance();
		insurancePlan = plandao.searchInsurancePlanById(planId);
		if (insurancePlan == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "plan is not found with this id : " + planId, null));
			return null;
		}

		plandao.deleteInsurancePlan(insurancePlan);

		showSuccessMessage = "plan deleted showsuccessfully!";

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "company deleted succussfully!", null));

		return "showplan?faces-redirect=true";
	}

//update plan 
	public String updateInsurancePlan(InsurancePlan plan) {
		FacesContext context = FacesContext.getCurrentInstance();
//	  String planId=(String) context.getExternalContext().getSessionMap().get("planId");
//	  plan.setPlanId(planId);
		System.out.println("=====update method is called==========");
		System.out.println(plan);

		if (validateInsurancePlanWithFacesMessage(plan)) {

			plandao.updateInsurancePlan(plan);
			return "showplan?faces-redirect=true";
		}

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "validation Fails", null));
		return null;

	}

	// show plan details

	public String showPlanById(InsurancePlan plan) {
		insurancePlan = plan;
		return "showplanDetails?faces-redirect=true";
	}

	// show all planDetailsandcoverageDetailsbyplanId
	public String showPlanWithCoveragDetailsByplanId(String plaId) {
		planwithCovrageDetailsList = insuranceCoverageOptionDao.searchInsuranceCoverageOptionByPlanId(plaId);
		return "showAllPlanByIdTest??faces-redirect=true";
	}
	// search coverageplanByCategory

	public String showPlanCoverageByPlanDetailsByPlanType(String planType) {

		planwithCovrageDetailsList = insuranceCoverageOptionDao.getInsuranceCoverageOptionsByPlanType(planType);

		for (int i = 0; i < planwithCovrageDetailsList.size(); i++) {
			coverageOption1 = planwithCovrageDetailsList.get(i);
			insurancePlan = coverageOption1.insurancePlan;
			insuranceCompany = insurancePlan.getInsuranceCompany();
			if (coverageOption1 != null)
				coverageOption2 = planwithCovrageDetailsList.get(i);
			if (coverageOption2 != null)
				coverageOption3 = planwithCovrageDetailsList.get(i);
		}

		return "InsurancePlanCoverageDetails.jsp?faces-redirect=true";

	}

//expire date dynamically adding via active date and years

	public static Date calculateExpiryDate(Date activeDate, int yearsToAdd) {
		if (activeDate == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(activeDate);
		calendar.add(Calendar.YEAR, yearsToAdd);
		return calendar.getTime();
	}

	// validation of plan
	public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Plan Name
		if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name is required.", null));
			isValid = false;
		} else if (plan.getPlanName().trim().length() < 4) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name must be at least 4 characters.", null));
			isValid = false;
		}

		// Insurance Company
		if (plan.getInsuranceCompany() == null || plan.getInsuranceCompany().getCompanyId() == null
				|| plan.getInsuranceCompany().getCompanyId().trim().isEmpty()) {
			context.addMessage("companyForm:companyId",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insurance company is required.", null));
			isValid = false;
		}

		// Description
		if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description is required.", null));
			isValid = false;
		} else if (plan.getDescription().trim().length() <= 5) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description must be more than 5 characters.", null));
			isValid = false;
		}

		// Available Cover Amounts (assume it's a String, convert to double if needed)

		// Available Cover Amounts
		String coverAmountStr = plan.getAvailableCoverAmounts();
		if (coverAmountStr == null || coverAmountStr.trim().isEmpty()) {
			context.addMessage("companyForm:cover",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cover amount is required.", null));
			isValid = false;
		} else if (!coverAmountStr.trim().matches("\\d+(\\.\\d+)?")) {
			context.addMessage("companyForm:cover",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cover amount must be a valid number.", null));
			isValid = false;
		} else {
			double coverAmount = Double.parseDouble(coverAmountStr.trim());
			if (coverAmount <= 0) {
				context.addMessage("companyForm:cover",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cover amount must be positive.", null));
				isValid = false;
			}
		}

		// Min Entry Age
		Integer minAge = plan.getMinEntryAge();
		if (minAge == null) {
			context.addMessage("companyForm:minAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Minimum age is required.", null));
			isValid = false;
		} else if (minAge <= 0) {
			context.addMessage("companyForm:minAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Minimum age must be greater than 0.", null));
			isValid = false;
		}

		// Max Entry Age
		Integer maxAge = plan.getMaxEntryAge();
		if (maxAge == null) {
			context.addMessage("companyForm:maxAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maximum age is required.", null));
			isValid = false;
		} else if (maxAge <= 0) {
			context.addMessage("companyForm:maxAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maximum age must be greater than 0.", null));
			isValid = false;
		} else if (minAge != null && maxAge < minAge) {
			context.addMessage("companyForm:maxAge", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Maximum age must be greater than or equal to minimum age.", null));
			isValid = false;
		} else if (maxAge > 70) {
			context.addMessage("companyForm:maxAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maximum age must not be greater than 70.", null));
			isValid = false;
		}

		// Waiting Period (must be between 0 and 12)
		try {
			int waiting = Integer.parseInt(plan.getWaitingPeriod().trim());
			if (waiting < 0 || waiting > 12) {
				context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Waiting period must be between 0 and 12 months.", null));
				isValid = false;
			}
		} catch (Exception e) {
			context.addMessage("companyForm:waitingPeriod",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid waiting period.", null));
			isValid = false;
		}

		// Periodic Diseases
		if (plan.getPeriodicDiseases() == null || plan.getPeriodicDiseases().trim().isEmpty()) {
			context.addMessage("companyForm:periodicDiseases",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Periodic diseases field is required.", null));
			isValid = false;
		}

		// planType
		if (plan.getPlanType() == null || plan.getPlanType().toString().isEmpty()) {
			context.addMessage("companyForm:planType",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan Type  field is required.", null));
			isValid = false;
		}

		// Active On, Created On, Expire Date logic
		Date activeOn = plan.getActiveOn();
		Date createdOn = plan.getCreatedOn();
		Date expireDate = plan.getExpireDate();

		if (activeOn == null) {
			context.addMessage("companyForm:activeOn",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date is required.", null));
			isValid = false;
		} else {
			if (createdOn != null && activeOn.before(createdOn)) {
				context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Active On date cannot be before Created On date.", null));
				isValid = false;
			}
			if (expireDate != null && activeOn.after(expireDate)) {
				context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Active On date cannot be after Expire date.", null));
				isValid = false;
			}
		}
		if (yearsToAdd == 0) {
			context.addMessage("companyForm:yearsToAdd",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "you must chose a duration.", null));
			isValid = false;
		}

		return isValid;
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
			context.addMessage("companyForm:PremiumAmount", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Premium amount must be between ₹500 and ₹100,000.", null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.coverageAmount < 100000 || option.coverageAmount > 50000000) {
			context.addMessage("companyForm:CoverageAmount", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be between ₹1,00,000 (1L) and ₹5,00,00,000 (5Cr).", null));
			isValid = false;
		}
		// option.premiumAmount > option.coverageAmount
		if (option.premiumAmount > option.coverageAmount) {
			context.addMessage("companyForm:CoverageAmount", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be greater than premiumAmount", null));
			isValid = false;
		}

		return isValid;
	}

//Getter and Setters
	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getShowSuccessMessage() {
		return showSuccessMessage;
	}

	public void setShowSuccessMessage(String showSuccessMessage) {
		this.showSuccessMessage = showSuccessMessage;
	}

	public InsurancePlanDao getPlandao() {
		return plandao;
	}

	public void setPlandao(InsurancePlanDao plandao) {
		this.plandao = plandao;
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

	public InsuranceCoverageOptionDao getInsuranceCoverageOptionDao() {
		return insuranceCoverageOptionDao;
	}

	public void setInsuranceCoverageOptionDao(InsuranceCoverageOptionDao insuranceCoverageOptionDao) {
		this.insuranceCoverageOptionDao = insuranceCoverageOptionDao;
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

}
