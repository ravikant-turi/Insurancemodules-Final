package com.infinite.jsf.insurance.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.dao.MemberDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.daoImpl.MemberDaoImpl;
import com.infinite.jsf.insurance.model.CoveragePlanStatus;
import com.infinite.jsf.insurance.model.Gender;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.MemberPlanRule;
import com.infinite.jsf.insurance.model.MessageConstants;
import com.infinite.jsf.insurance.model.PlanType;
import com.infinite.jsf.insurance.model.Relation;


public class CreateInsuranceController {	
	private InsuranceCompany insuranceCompany;
	private InsurancePlan insurancePlan;
	private InsuranceCoverageOption coverageOption;
	private InsuranceCoverageOption coverageOption1;
	private InsuranceCoverageOption coverageOption2;
	private InsuranceCoverageOption coverageOption3;
	private MemberPlanRule member;
	private InsuranceCoverageOptionDao insuranceCoverageOptionDao=new InsuranceCoverageOptionDaoImpl();
	private InsurancePlanDao insurancplanDao = new InsurancePlanDaoImpl();
	private MemberDao memberDao=new MemberDaoImpl();
	private List<InsuranceCoverageOption> planwithCovrageDetailsList;
	private int yearsToAdd;
	private List<MemberPlanRule> members;
	private List<InsurancePlan> planList;
	private Map<String, Boolean> relationMap = new HashMap<>();
	List<String> selectedRelations;
	MessageConstants msg;

	// show plans on dashBoard
	public List<InsurancePlan> showAllPlan() {
		planList = insurancplanDao.showAllPlan();
		return planList;
	}

	public String addInsurancePlanWithCoveragePlan() {

		System.out.println("========Details==========");
		insurancePlan.setInsuranceCompany(insuranceCompany);

		if (insurancePlan.getActiveOn() != null) {
			insurancePlan.setExpireDate(calculateExpiryDate(insurancePlan.getActiveOn(), yearsToAdd));
		}
		insurancePlan.setActiveOn(new Date());

		if (validateInsurancePlanWithFacesMessage(insurancePlan) || validateInsurancePlanWithFacesMessage(insurancePlan)
				|| validateInsuranceCoverageOptionWithFacesMessage1(coverageOption1)
				|| validateInsuranceCoverageOptionWithFacesMessage2(coverageOption2)
				|| validateInsuranceCoverageOptionWithFacesMessage3(coverageOption3)
				|| validateInsuranceMeberRelationsWithFacesMessage(insurancePlan)) {

			if (insurancePlan != null && validateInsurancePlanWithFacesMessage(insurancePlan)) {
				if (validateInsuranceMeberRelationsWithFacesMessage(insurancePlan)) {

					if (coverageOption1 != null || coverageOption2 != null || coverageOption3 != null) {
						coverageOption1.setInsurancePlan(insurancePlan);
						coverageOption2.setInsurancePlan(insurancePlan);
						coverageOption3.setInsurancePlan(insurancePlan);

						String planId = insurancplanDao.addInsurancePlan(insurancePlan);
						insurancePlan.setPlanId(planId);
						for (String relations : selectedRelations) {
							MemberPlanRule member = new MemberPlanRule();
							member.setInsurancePlan(insurancePlan);
							member.setRelation(Relation.valueOf(relations));
							if (relations == "SON1" || relations == "SON2" || relations == "FATHER"
									|| relations == "HUSBAND") {
								member.setGender(Gender.MALE);
							} else {
								member.setGender(Gender.FEMALE);

							}

							memberDao.addMember(member);
						}

						if (coverageOption1 != null
								&& validateInsuranceCoverageOptionWithFacesMessage1(coverageOption1)) {
							insuranceCoverageOptionDao.addCoveragePlan(coverageOption1);
						}
						if (coverageOption2 != null
								&& validateInsuranceCoverageOptionWithFacesMessage2(coverageOption2)) {
							insuranceCoverageOptionDao.addCoveragePlan(coverageOption2);

						}
						if (coverageOption3 != null
								&& validateInsuranceCoverageOptionWithFacesMessage3(coverageOption3)) {
							insuranceCoverageOptionDao.addCoveragePlan(coverageOption3);

						}
					} else {
						return null;
					}
				} else {
					return null;
				}

			} else {
				return null;
			}

		} else {

			return null;
		}

		return "AInsuranceAdminDashBoard.jsp";
	}

	public String findAllPlanDetailsByPlanId(String planId) {

		insurancePlan = insurancplanDao.findInsuranceById(planId);
		members = memberDao.searchMemberByPlanId(planId);
		planwithCovrageDetailsList = insuranceCoverageOptionDao.findAllInsuranceCoverageOptionsByPlanId(planId);
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("=====================");
			coverageOption1=planwithCovrageDetailsList.get(0);
			coverageOption2=planwithCovrageDetailsList.get(1);
			coverageOption3=planwithCovrageDetailsList.get(2);
		
		
		System.out.println(insurancePlan);
		members.forEach(System.out::println);
		planwithCovrageDetailsList.forEach(System.out::println);
		
		for(MemberPlanRule member:members) {
			String key=member.getRelation().toString();

			relationMap.put(key, true);

		}
		return "AInsuranceCoverageDetails";
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

	public MemberPlanRule getMember() {
		return member;
	}

	public void setMember(MemberPlanRule member) {
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

	public List<MemberPlanRule> getMembers() {
		return members;
	}

	public void setMembers(List<MemberPlanRule> members) {
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

	public List<String> getSelectedRelations() {
		return selectedRelations;
	}

	public void setSelectedRelations(List<String> selectedRelations) {
		this.selectedRelations = selectedRelations;
	}

	public Map<String, Boolean> getRelationMap() {
		return relationMap;
	}

	public void setRelationMap(Map<String, Boolean> relationMap) {
		this.relationMap = relationMap;
	}

	@PostConstruct
	public void init() {
		msg = MessageConstants.getInstance();

		relationMap.put("SON1", false);
		relationMap.put("SON2", false);
		relationMap.put("DAUGHTER1", false);
		relationMap.put("DAUGHTER2", false);
		relationMap.put("FATHER", false);
		relationMap.put("MOTHER", false);
		relationMap.put("HUSBAND", false);
		relationMap.put("WIFE", false);
		relationMap.put("SELF", false);
//dynamically update the COVERAGEPLAN STATUS : ACTIVE OR INACTIVE
		planwithCovrageDetailsList = insuranceCoverageOptionDao.findAllInsuranceCoverageOptions();
		for (InsuranceCoverageOption options : planwithCovrageDetailsList) {
			if (isActiveBeforeOrEqualToday(options.getInsurancePlan().getActiveOn()))
				options.setStatus(CoveragePlanStatus.ACTIVE);
			insuranceCoverageOptionDao.updateInsuranceCoverageOption(options);
		}
	}

//Coverage plan status dynamically update so 2 date compare
	public static boolean isActiveBeforeOrEqualToday(Date activeOn) {
		try {
			// Format to yyyy-MM-dd
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// Strip time from both dates
			Date today = sdf.parse(sdf.format(new Date()));
			Date activeDate = sdf.parse(sdf.format(activeOn));

			// Compare

			return activeDate.equals(today) || activeDate.before(today);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Dynamically EXPIRYDATE get calculated from activeDate and
	// durations(yearToAdd)
	public static Date calculateExpiryDate(Date activeDate, int yearsToAdd) {
		if (activeDate == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(activeDate);
		calendar.add(Calendar.YEAR, yearsToAdd);
		return calendar.getTime();
	}

//	VALIDATION :: INSURANCEPLAN
	// validation of plan
	public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Plan Name
		if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getPLAN_NAME_REQUIRED(), null));
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
//		FacesContext context1 = FacesContext.getCurrentInstance();
//		UIComponent component = context1.getViewRoot().findComponent("companyForm:minAge");
//
//		if (component instanceof UIInput) {
//			String inputValue = (String) ((UIInput) component).getSubmittedValue();
//
//			if (inputValue == null || !inputValue.matches("\\d+")) {
//				context.addMessage("companyForm:minAge",
//						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Only digits are allowed for Min Age.", null));
//				isValid = false;
//			}
//		}

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

	// VALIDATION :: INSURANCECOVERAGE

	public boolean validateInsuranceCoverageOptionWithFacesMessage1(InsuranceCoverageOption option) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Validate plan
		if (option.getInsurancePlan() == null || option.getInsurancePlan() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Linked Insurance Plan is required.", null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.getPremiumAmount() < 500 || option.getPremiumAmount() > 100000) {
			context.addMessage("companyForm:PremiumAmount", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Premium amount must be between ₹500 and ₹100,000.", null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.getCoverageAmount() < 100000 || option.getCoverageAmount() > 50000000) {
			context.addMessage("companyForm:CoverageAmount", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be between ₹1,00,000 (1L) and ₹5,00,00,000 (5Cr).", null));
			isValid = false;
		}
		// option.premiumAmount > option.coverageAmount
		if (option.getPremiumAmount() > option.getCoverageAmount()) {
			context.addMessage("companyForm:CoverageAmount", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be greater than premiumAmount", null));
			isValid = false;
		}

		return isValid;
	}

	public boolean validateInsuranceCoverageOptionWithFacesMessage2(InsuranceCoverageOption option) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Validate plan
		if (option.getInsurancePlan() == null || option.getInsurancePlan() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Linked Insurance Plan is required.", null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.getPremiumAmount() < 500 || option.getPremiumAmount() > 100000) {
			context.addMessage("companyForm:PremiumAmount2", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Premium amount must be between ₹500 and ₹100,000.", null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.getCoverageAmount() < 100000 || option.getCoverageAmount() > 50000000) {
			context.addMessage("companyForm:CoverageAmount2", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be between ₹1,00,000 (1L) and ₹5,00,00,000 (5Cr).", null));
			isValid = false;
		}
		// option.premiumAmount > option.coverageAmount
		if (option.getPremiumAmount() > option.getCoverageAmount()) {
			context.addMessage("companyForm:CoverageAmount2", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be greater than premiumAmount", null));
			isValid = false;
		}

		return isValid;
	}

	public boolean validateInsuranceCoverageOptionWithFacesMessage3(InsuranceCoverageOption option) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Validate plan
		if (option.getInsurancePlan() == null || option.getInsurancePlan() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Linked Insurance Plan is required.", null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.getPremiumAmount() < 500 || option.getPremiumAmount() > 100000) {
			context.addMessage("companyForm:PremiumAmount3", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Premium amount must be between ₹500 and ₹100,000.", null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.getCoverageAmount() < 100000 || option.getCoverageAmount() > 50000000) {
			context.addMessage("companyForm:CoverageAmount3", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be between ₹1,00,000 (1L) and ₹5,00,00,000 (5Cr).", null));
			isValid = false;
		}
		// option.premiumAmount > option.coverageAmount
		if (option.getPremiumAmount() > option.getCoverageAmount()) {
			context.addMessage("companyForm:CoverageAmount3", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be greater than premiumAmount", null));
			isValid = false;
		}

		return isValid;
	}

	public boolean validateInsuranceMeberRelationsWithFacesMessage(InsurancePlan insurancePlan) {
		FacesContext context = FacesContext.getCurrentInstance();

		selectedRelations = relationMap.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(selectedRelations);

		if (insurancePlan.getPlanType() == PlanType.valueOf("FAMILY")) {
			if (selectedRelations.size() < 2) {
				context.addMessage("companyForm:memberValidation",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Must select 2 meber ATLEAST ", null));
				return false;
			}
		}

		else if (selectedRelations.size() < 0 && selectedRelations.size() > 1) {
			context.addMessage("companyForm:memberValidation",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ONLY one relation is allowed", null));
			return false;
		}
		return true;
	}

}
