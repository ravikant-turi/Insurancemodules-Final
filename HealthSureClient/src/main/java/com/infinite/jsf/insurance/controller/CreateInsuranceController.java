/**
 * CreateInsuranceController.java
 *
 * This controller class is responsible for handling user interactions related to
 * the creation of insurance entities such as plans, coverage options, and associated rules.
 * It acts as a bridge between the JSF view layer and the backend services or DAOs,
 * managing form submissions, validations, and data persistence.
 *
 * Typical responsibilities include:
 * - Initializing form data
 * - Handling user input and triggering business logic
 * - Managing navigation outcomes
 * - Coordinating with DAO classes to persist insurance-related data
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

package com.infinite.jsf.insurance.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.dao.MemberPlanRuleDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCompanyDaoImpl;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.model.CoveragePlanStatus;
import com.infinite.jsf.insurance.model.Gender;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.MemberPlanRule;
import com.infinite.jsf.insurance.model.CreateInsuranceMessageConstants;
import com.infinite.jsf.insurance.model.PlanType;
import com.infinite.jsf.insurance.model.Relation;

public class CreateInsuranceController {
	private InsuranceCompany insuranceCompany;
	private InsurancePlan insurancePlan;
	private InsuranceCoverageOption coverageOption;
	private InsuranceCoverageOption coverageOption1;
	private InsuranceCoverageOption coverageOption2;
	private InsuranceCoverageOption coverageOption3;
	private MemberPlanRule memberPlanRule;
	private InsuranceCoverageOptionDao insuranceCoverageOptionDao = new InsuranceCoverageOptionDaoImpl();
	private InsurancePlanDao insurancplanDao = new InsurancePlanDaoImpl();
	private MemberPlanRuleDao memberPlanRuleDao;
	private List<InsuranceCoverageOption> planwithCovrageDetailsList;
	private int yearsToAdd;
	private List<MemberPlanRule> members;
	private List<InsurancePlan> planList;
	private Map<String, Boolean> relationMap = new HashMap<>();
	List<String> selectedRelations = new ArrayList<String>();
	private boolean isSilver = true;
	private boolean isGold = false;
	private boolean isPlatinum = false;
	private String individualMemberGender;
	CreateInsuranceMessageConstants validationMessages = new CreateInsuranceMessageConstants();
	private static final Logger logger = Logger.getLogger(InsuranceCompanyDaoImpl.class);

	// =======================

	private int pageSize = 5;
	private int currentPage = 0;

	public List<InsurancePlan> getPaginatedPlans() {
		if (planList == null) {
			planList = showAllPlan(); // Load once
		}
		int start = currentPage * pageSize;
		int end = Math.min(start + pageSize, planList.size());
		return planList.subList(start, end);
	}

	public void nextPage() {
		if (isNext()) {
			currentPage++;
		}
	}

	public void previousPage() {
		if (isPrevious()) {
			currentPage--;
		}
	}

	public boolean isNext() {
		return (currentPage + 1) * pageSize < planList.size();
	}

	public boolean isPrevious() {
		return currentPage > 0;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return (int) Math.ceil((double) planList.size() / pageSize);
	}

	public int getPageSize() {
		return pageSize;
	}

	// ===========================
	private String sortField = "planId"; // default sort field
	private boolean sortAscending = true;

	public void sortBy(String field) {
		if (sortField.equals(field)) {
			sortAscending = !sortAscending;
		} else {
			sortField = field;
			sortAscending = true;
		}

		Comparator<InsurancePlan> comparator = null;

		switch (field) {
		case "planName": // Integer
			comparator = Comparator.comparing(InsurancePlan::getPlanName);
			break;
		case "planType": // Enum
			comparator = Comparator.comparing(InsurancePlan::getPlanType);
			break;
		case "waitingPeriod": // Integer
			comparator = Comparator.comparing(InsurancePlan::getWaitingPeriod);
			break;
		case "expireDate": // Date
			comparator = Comparator.comparing(InsurancePlan::getExpireDate);
			break;
		case "activeOn": // Date
			comparator = Comparator.comparing(InsurancePlan::getActiveOn);
			break;
		case "maximumMemberAllowed": // Integer
			comparator = Comparator.comparing(InsurancePlan::getMaximumMemberAllowed);
			break;
		default: // planId (Integer)
			comparator = Comparator.comparing(InsurancePlan::getPlanId);
			break;
		}

		if (comparator != null) {
			if (!sortAscending) {
				comparator = comparator.reversed();
			}
			planList.sort(comparator);
		}
	}

	// ==========================
	/**
	 * Retrieves and returns a list of all available insurance plans to be displayed
	 * on the dashboard. This method delegates the data fetching to the
	 * InsurancePlan DAO layer.
	 *
	 * @return List of InsurancePlan objects representing all available plans.
	 */

	public List<InsurancePlan> showAllPlan() {
		planList = insurancplanDao.showAllPlan();
		return planList;
	}

	/**
	 * Adds a new insurance plan along with predefined coverage options: Silver,
	 * Gold, and Platinum. This method is responsible for creating the base
	 * insurance plan and associating it with standard coverage tiers, each with its
	 * own premium and coverage amount.
	 *
	 * @return Navigation outcome or status string indicating success or failure.
	 */
	public String addSilverOnlyMendatory() {
		insurancePlan.setInsuranceCompany(insuranceCompany);
		if (insurancePlan.getActiveOn() != null) {
			insurancePlan.setExpireDate(calculateExpiryDate(insurancePlan.getActiveOn(), yearsToAdd));
		}
		insurancePlan.setCreatedOn(new Date());
		coverageOption1.setInsurancePlan(insurancePlan);

		System.out.println(insurancePlan);
		System.out.println(coverageOption1);
		System.out.println(coverageOption2);
		System.out.println(coverageOption3);
		System.out.println("good to go");
		// silver(coverage1) is mandatory
		if (isSilver && validateInsurancePlanWithFacesMessage(insurancePlan)
				&& validateInsuranceCoverageOptionWithFacesMessage1(coverageOption1)
				&& validateInsuranceMeberRelationsWithFacesMessage(insurancePlan)) {

			System.out.println("---------we are inside the validation check===");
			insurancplanDao.addInsurancePlan(insurancePlan);
			coverageOption1.setInsurancePlan(insurancePlan);
			insuranceCoverageOptionDao.addCoveragePlan(coverageOption1);

			if (insurancePlan.getPlanType() == PlanType.INDIVIDUAL) {
				logger.info("we are inside individual type to make member object");
				MemberPlanRule member = new MemberPlanRule();
				member.setInsurancePlan(insurancePlan);
				member.setRelation(Relation.INDIVIDUAL);
				member.setGender(Gender.valueOf(individualMemberGender));
				memberPlanRuleDao.addMember(member);

			} else {

				for (String relations : selectedRelations) {
					MemberPlanRule member = new MemberPlanRule();
					member.setInsurancePlan(insurancePlan);
					member.setRelation(Relation.valueOf(relations));
					if (relations == "SON1" || relations == "SON2" || relations == "FATHER" || relations == "HUSBAND") {
						member.setGender(Gender.MALE);
					} else {
						member.setGender(Gender.FEMALE);
					}
					memberPlanRuleDao.addMember(member);
				}
			}
		} else {

			System.out.println("=======validation fails==========");
			return null;
		}
		if (isSilver && isGold && validateInsurancePlanWithFacesMessage(insurancePlan)
				&& validateInsuranceCoverageOptionWithFacesMessage2(coverageOption2)) {
			coverageOption3.setInsurancePlan(insurancePlan);
			insuranceCoverageOptionDao.addCoveragePlan(coverageOption2);
		}
		if (isSilver && isPlatinum && validateInsurancePlanWithFacesMessage(insurancePlan)
				&& validateInsuranceCoverageOptionWithFacesMessage3(coverageOption3)) {
			coverageOption3.setInsurancePlan(insurancePlan);
			insuranceCoverageOptionDao.addCoveragePlan(coverageOption3);
		}

		return "AInsuranceAdminDashBoard.jsp";
	}

	/**
	 * Retrieves detailed information of a specific insurance plan based on the
	 * provided plan ID. This method is typically used to display full plan details
	 * on the dashboard or detail view.
	 *
	 * @param planId The unique identifier of the insurance plan to be retrieved.
	 * @return A status string or navigation outcome indicating the result of the
	 *         operation.
	 */
	public String findAllPlanDetailsByPlanId(String planId) {

		insurancePlan = insurancplanDao.findInsuranceById(planId);
		members = memberPlanRuleDao.searchMemberByPlanId(planId);
		planwithCovrageDetailsList = insuranceCoverageOptionDao.findAllInsuranceCoverageOptionsByPlanId(planId);

		for (int i = 0; i < planwithCovrageDetailsList.size(); i++) {

			if (coverageOption1 == null) {

				coverageOption1 = planwithCovrageDetailsList.get(i);
			} else if (coverageOption1 != null && coverageOption2 == null) {

				coverageOption2 = planwithCovrageDetailsList.get(i);
			} else if (coverageOption3 == null && coverageOption1 != null && coverageOption2 != null) {

				coverageOption3 = planwithCovrageDetailsList.get(i);
			}

		}
		System.out.println(insurancePlan);
		members.forEach(System.out::println);
		planwithCovrageDetailsList.forEach(System.out::println);

		for (MemberPlanRule member : members) {
			String key = member.getRelation().toString();

			relationMap.put(key, true);

		}
		return "AInsuranceCoverageDetails";
	}

	/**
	 * Updates the details of an existing insurance plan identified by the given
	 * plan ID. This method typically fetches the plan, applies modifications, and
	 * persists the changes.
	 *
	 * @param planId The unique identifier of the insurance plan to be updated.
	 * @return A status string or navigation outcome indicating the result of the
	 *         update operation.
	 */
	public String updateInsurancePlan(String planId) {

		insurancePlan = insurancplanDao.findInsuranceById(planId);
		members = memberPlanRuleDao.searchMemberByPlanId(planId);
		planwithCovrageDetailsList = insuranceCoverageOptionDao.findAllInsuranceCoverageOptionsByPlanId(planId);

		for (int i = 0; i < planwithCovrageDetailsList.size(); i++) {

			if (coverageOption1 == null) {

				coverageOption1 = planwithCovrageDetailsList.get(i);
			} else if (coverageOption1 != null && coverageOption2 == null) {

				coverageOption2 = planwithCovrageDetailsList.get(i);
			} else {

				coverageOption3 = planwithCovrageDetailsList.get(i);
			}

		}

		for (MemberPlanRule member : members) {
			String key = member.getRelation().toString();
			relationMap.put(key, true);

		}
		return "AInsuranceUpdate";
	}

	/**
	 * Helper method to perform the actual update logic for an insurance plan. This
	 * method receives the modified InsurancePlan object and applies the necessary
	 * updates to the database or persistence layer.
	 *
	 * @param plan The InsurancePlan object containing updated details.
	 * @return A status string or navigation outcome indicating the result of the
	 *         update operation.
	 */
	public String updateInsurancePlanHelper(InsurancePlan plan) {

		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;
		// Description
		if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.DESCRIPTION_REQUIRED, null));
			isValid = false;
		} else if (plan.getDescription().trim().length() <= 5) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.DESCRIPTION_TOO_SHORT, null));
			isValid = false;
		}
		// Plan Name
		if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PLAN_NAME_REQUIRED, null));
			isValid = false;
		} else if (plan.getPlanName().trim().length() < 4) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PLAN_NAME_TOO_SHORT, null));
			isValid = false;
		}
		if (isValid) {
			insurancplanDao.updateInsurancePlan(plan);
			return "AInsuranceAdminDashBoard.jsp";
		}
		return null;

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

	public InsuranceCoverageOptionDao getInsuranceCoverageOptionDao() {
		return insuranceCoverageOptionDao;
	}

	public void setInsuranceCoverageOptionDao(InsuranceCoverageOptionDao insuranceCoverageOptionDao) {
		this.insuranceCoverageOptionDao = insuranceCoverageOptionDao;
	}

	public InsurancePlanDao getInsurancplanDao() {
		return insurancplanDao;
	}

	public CreateInsuranceMessageConstants getvalidationMessages() {
		return validationMessages;
	}

	public void setInsurancplanDao(InsurancePlanDao insurancplanDao) {
		this.insurancplanDao = insurancplanDao;
	}

	public MemberPlanRule getMemberPlanRule() {
		return memberPlanRule;
	}

	public void setMemberPlanRule(MemberPlanRule memberPlanRule) {
		this.memberPlanRule = memberPlanRule;
	}

	public MemberPlanRuleDao getMemberPlanRuleDao() {
		return memberPlanRuleDao;
	}

	public void setMemberPlanRuleDao(MemberPlanRuleDao memberPlanRuleDao) {
		this.memberPlanRuleDao = memberPlanRuleDao;
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

	public void setSilver(boolean isSilver) {
		this.isSilver = isSilver;
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

	public CreateInsuranceMessageConstants getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(CreateInsuranceMessageConstants validationMessages) {
		this.validationMessages = validationMessages;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getIndividualMemberGender() {
		return individualMemberGender;
	}

	public void setIndividualMemberGender(String individualMemberGender) {
		this.individualMemberGender = individualMemberGender;
	}

	public boolean isSilver() {
		return isSilver;
	}

	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}

	public boolean isPlatinum() {
		return isPlatinum;
	}

	public void setPlatinum(boolean isPlatinum) {
		this.isPlatinum = isPlatinum;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public boolean isSortAscending() {
		return sortAscending;
	}

	public void setSortAscending(boolean sortAscending) {
		this.sortAscending = sortAscending;
	}

	@PostConstruct
	public void init() {

		relationMap.put("SON1", true);
		relationMap.put("SON2", false);
		relationMap.put("DAUGHTER1", true);
		relationMap.put("DAUGHTER2", false);
		relationMap.put("FATHER", false);
		relationMap.put("MOTHER", false);
		relationMap.put("HUSBAND", true);
		relationMap.put("WIFE", true);
		relationMap.put("SELF", false);
		relationMap.put("INDIVIDUAL", false);
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
	@SuppressWarnings("unused")
	public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Plan Name
		if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PLAN_NAME_REQUIRED, null));
			isValid = false;
		} else if (plan.getPlanName().trim().length() < 4) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PLAN_NAME_TOO_SHORT, null));
			isValid = false;
		} else if (!plan.getPlanName().matches("^[A-Za-z\\s]+$")) {

			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PLAN_NAME_INVALID, null));
			isValid = false;
		}

		// Insurance Company
		if (plan.getInsuranceCompany() == null || plan.getInsuranceCompany().getCompanyId() == null
				|| plan.getInsuranceCompany().getCompanyId().trim().isEmpty()) {
			context.addMessage("companyForm:companyId",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.COMPANY_REQUIRED, null));
			isValid = false;
		}

		// Description
		if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.DESCRIPTION_REQUIRED, null));
			isValid = false;
		} else if (plan.getDescription().trim().length() <= 5) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.DESCRIPTION_TOO_SHORT, null));
			isValid = false;
		} else if (!plan.getDescription().matches("^[A-Za-z\\s]+$")) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.DESCRIPTION_INVALID, null));
			isValid = false;
		}

		// Cover Amount
		String coverAmountStr = plan.getAvailableCoverAmounts();
		if (coverAmountStr == null || coverAmountStr.trim().isEmpty()) {
			context.addMessage("companyForm:cover",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.COVER_AMOUNT_REQUIRED, null));
			isValid = false;
		} else if (!coverAmountStr.trim().matches("^[0-9]+(\\.[0-9]+)?$")) {
			context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					validationMessages.COVER_AMOUNT_INVALID_FORMAT, null));
			isValid = false;
		} else {
			try {
				double coverAmount = Double.parseDouble(coverAmountStr.trim());
				if (coverAmount <= 0) {
					context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR,
							validationMessages.COVER_AMOUNT_NEGATIVE, null));
					isValid = false;
				} else {
					plan.setAvailableCoverAmounts(coverAmountStr);
				}
			} catch (NumberFormatException e) {
				context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						validationMessages.COVER_AMOUNT_PARSE_ERROR, null));
				isValid = false;
			}
		}

		// Min Age
		Integer minAge = plan.getMinEntryAge();
		if (minAge == null) {
			context.addMessage("companyForm:minAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.MIN_AGE_REQUIRED, null));
			isValid = false;
		} else if (minAge <= 0) {
			context.addMessage("companyForm:minAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.MIN_AGE_INVALID, null));
			isValid = false;
		}

		// Max Age
		Integer maxAge = plan.getMaxEntryAge();
		if (maxAge == null) {
			context.addMessage("companyForm:maxAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.MAX_AGE_REQUIRED, null));
			isValid = false;
		} else if (maxAge <= 0) {
			context.addMessage("companyForm:maxAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.MAX_AGE_INVALID, null));
			isValid = false;
		} else if (minAge != null && maxAge < minAge) {
			context.addMessage("companyForm:maxAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.MAX_AGE_LESS_THAN_MIN, null));
			isValid = false;
		} else if (maxAge > 70) {
			context.addMessage("companyForm:maxAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.MAX_AGE_TOO_HIGH, null));
			isValid = false;
		}

		// Waiting Period
		try {
			int waiting = Integer.parseInt(plan.getWaitingPeriod().trim());
			if (waiting < 0 || waiting > 12) {
				context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						validationMessages.WAITING_PERIOD_OUT_OF_RANGE, null));
				isValid = false;
			}
		} catch (Exception e) {
			context.addMessage("companyForm:waitingPeriod",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.WAITING_PERIOD_INVALID, null));
			isValid = false;
		}

		// Periodic Diseases
		if (plan.getPeriodicDiseases() == null || plan.getPeriodicDiseases().trim().isEmpty()) {
			context.addMessage("companyForm:periodicDiseases",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PERIODIC_DISEASES_REQUIRED, null));
			isValid = false;
		}

		// Plan Type
		if (plan.getPlanType() == null || plan.getPlanType().toString().isEmpty()) {
			context.addMessage("companyForm:planType",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PLAN_TYPE_REQUIRED, null));
			isValid = false;
		}

		// Dates
		Date activeOn = plan.getActiveOn();
		Date createdOn = plan.getCreatedOn();
		Date expireDate = plan.getExpireDate();

		if (activeOn == null) {
			context.addMessage("companyForm:activeOn",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.ACTIVE_ON_REQUIRED, null));
			isValid = false;
		} else {
			if (createdOn != null && activeOn.before(createdOn)) {
				context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						validationMessages.ACTIVE_ON_BEFORE_CREATED, null));
				isValid = false;
			}
			if (expireDate != null && activeOn.after(expireDate)) {
				context.addMessage("companyForm:activeOn",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.ACTIVE_ON_AFTER_EXPIRE, null));
				isValid = false;
			}
		}

		// Duration
		if (yearsToAdd == 0) {
			context.addMessage("companyForm:yearsToAdd",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.DURATION_REQUIRED, null));
			isValid = false;
		}

		return isValid;
	}

	// VALIDATION :: INSURANCECOVERAGE : SILVER , GOLD , PLATINUM

	public boolean validateInsuranceCoverageOptionWithFacesMessage1(InsuranceCoverageOption option) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Validate plan
		if (option.getInsurancePlan() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.LINKED_PLAN_REQUIRED, null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.getPremiumAmount() < 500 || option.getPremiumAmount() > 100000) {
			context.addMessage("companyForm:PremiumAmount",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PREMIUM_AMOUNT_RANGE, null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.getCoverageAmount() < 100000 || option.getCoverageAmount() > 50000000) {
			context.addMessage("companyForm:CoverageAmount",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.COVERAGE_AMOUNT_RANGE, null));
			isValid = false;
		}

		// Premium should not exceed coverage
		if (option.getPremiumAmount() > option.getCoverageAmount()) {
			context.addMessage("companyForm:CoverageAmount", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					validationMessages.COVERAGE_GREATER_THAN_PREMIUM, null));
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
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.LINKED_PLAN_REQUIRED, null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.getPremiumAmount() < 500 || option.getPremiumAmount() > 100000) {
			context.addMessage("companyForm:PremiumAmount2",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PREMIUM_AMOUNT_RANGE, null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.getCoverageAmount() < 100000 || option.getCoverageAmount() > 50000000) {
			context.addMessage("companyForm:CoverageAmount2",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.COVERAGE_AMOUNT_RANGE, null));
			isValid = false;
		}
		// option.premiumAmount > option.coverageAmount
		if (option.getPremiumAmount() > option.getCoverageAmount()) {
			context.addMessage("companyForm:CoverageAmount2", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					validationMessages.COVERAGE_GREATER_THAN_PREMIUM, null));
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
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.LINKED_PLAN_REQUIRED, null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.getPremiumAmount() < 500 || option.getPremiumAmount() > 100000) {
			context.addMessage("companyForm:PremiumAmount3",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.PREMIUM_AMOUNT_RANGE, null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.getCoverageAmount() < 100000 || option.getCoverageAmount() > 50000000) {
			context.addMessage("companyForm:CoverageAmount3",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessages.COVERAGE_AMOUNT_RANGE, null));
			isValid = false;
		}
		// option.premiumAmount > option.coverageAmount
		if (option.getPremiumAmount() > option.getCoverageAmount()) {
			context.addMessage("companyForm:CoverageAmount3", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					validationMessages.COVERAGE_GREATER_THAN_PREMIUM, null));
			isValid = false;
		}

		return isValid;
	}

	public boolean validateInsuranceMeberRelationsWithFacesMessage(InsurancePlan insurancePlan) {
		FacesContext context = FacesContext.getCurrentInstance();
		logger.info("we inside the member validation");
		logger.info("insurancePlanType : " + insurancePlan.getPlanType());

		// Ensure SON1 is true if SON2 is true and SON1 is false
		if (Boolean.TRUE.equals(relationMap.get("SON2")) && !Boolean.TRUE.equals(relationMap.get("SON1"))) {
			relationMap.put("SON1", true);
			relationMap.put("SON2", false); // Optional: make SON2 false if only one should be selected
		}

		// Ensure DAUGHTER1 is true if DAUGHTER2 is true and DAUGHTER1 is false
		if (Boolean.TRUE.equals(relationMap.get("DAUGHTER2")) && !Boolean.TRUE.equals(relationMap.get("DAUGHTER1"))) {
			relationMap.put("DAUGHTER1", true);
			relationMap.put("DAUGHTER2", false); // Optional
		}

		selectedRelations = relationMap.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(selectedRelations);

		if (insurancePlan.getPlanType() == PlanType.FAMILY) {
			List<String> requiredRelations = Arrays.asList("FATHER", "MOTHER", "HUSBAND", "WIFE");

			boolean hasRequiredRelation = selectedRelations.stream().anyMatch(requiredRelations::contains);

			if (!hasRequiredRelation) {
				context.addMessage("companyForm:memberValidation", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"For FAMILY plan, at least one member must be Father, Mother, Husband, or Wife.", null));

				return false;
			}
		}
		if (insurancePlan.getPlanType() == PlanType.valueOf("FAMILY")) {
			if (selectedRelations.size() < 2) {
				context.addMessage("companyForm:memberValidation",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Must select 2 meber ATLEAST ", null));
				return false;
			}
		}

		if (insurancePlan.getPlanType() == PlanType.valueOf("INDIVIDUAL")) {
			logger.info("we are inside individual Type");
			logger.info("and gender is: " + individualMemberGender);
			relationMap.put("SON1", false);
			relationMap.put("SON2", false);
			relationMap.put("DAUGHTER1", false);
			relationMap.put("DAUGHTER2", false);
			relationMap.put("FATHER", false);
			relationMap.put("MOTHER", false);
			relationMap.put("HUSBAND", false);
			relationMap.put("WIFE", false);
			relationMap.put("SELF", false);
			relationMap.put("INDIVIDUAL", true);
			selectedRelations = relationMap.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey)
					.collect(Collectors.toList());
			System.out.println(selectedRelations);
			if (individualMemberGender == null) {

				context.addMessage("companyForm:individualMemberGender",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "MUST CHOSSE GENDER", null));
				logger.info("genderValidation fails ");
				return false;
			}
		}
		if (insurancePlan.getPlanType() == PlanType.valueOf("INDIVIDUAL")) {
			if (insurancePlan.getMaximumMemberAllowed() != 1 && insurancePlan.getMinimumMeberAllowed() != 1) {
				context.addMessage("companyForm:maximumMemberAllowed",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "MUST CHOSSE GENDER", null));
				logger.info("genderValidation fails ");
				return false;
			}
		}
		return true;
	}

}
