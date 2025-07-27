package com.infinite.jsf.insurance.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.dao.InsuranceSubscribeDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceSubscribeDaoImpl;
import com.infinite.jsf.insurance.model.Gender;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.PlanType;
import com.infinite.jsf.insurance.model.Relation;
import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.insurance.model.SubscriptionStatus;
import com.infinite.jsf.insurance.model.SubscriptionType;
import com.infinite.jsf.recipient.model.Recipient;

public class InsuranceSubscribedController {
	InsurancePlan insurancePlan;
	InsuranceCompany insuranceCompany;
	InsuranceCoverageOption coverageOption;
	InsuranceCoverageOption coverageOption1;
	InsuranceCoverageOption coverageOption2;
	InsuranceCoverageOption coverageOption3;
	String searchRecipeintId;
	Subscribe Subscribe;
	SubscribedMember subscribedMember;
	SubscribedMember subscribedMember1;
	SubscribedMember subscribedMember2;
	SubscribedMember subscribedMember3;
	SubscribedMember subscribedMember4;
	SubscribedMember subscribedMember5;
	SubscribedMember subscribedMember6;
	SubscribedMember subscribedMember7;
	SubscribedMember subscribedMember8;

	InsuranceSubscribeDao insuranceSubscribeDao = new InsuranceSubscribeDaoImpl();
	List<SubscribedMember> subscribedMemberList;
	List<InsuranceCoverageOption> coverageOptionsList;

	private PlanType selectedPlanType;
//	private InsuranceSubscribeDao insuranceSubscribeao;

	public PlanType getSelectedPlanType() {
		return selectedPlanType;
	}

	public void setSelectedPlanType(PlanType selectedPlanType) {
		this.selectedPlanType = selectedPlanType;
	}

	public List<InsuranceCoverageOption> getFilteredCoverageOptions() {
		if (selectedPlanType == null) {
			return exploreInsurancePlan(); // return all
		}

		return coverageOptionsList.stream()
				.filter(option -> option.getInsurancePlan().getPlanType() == selectedPlanType)
				.collect(Collectors.toList());
	}

	public List<InsuranceCoverageOption> exploreInsurancePlan() {

		coverageOptionsList = insuranceSubscribeDao.exploreInsurancePlan();

		return coverageOptionsList;
	}

	public String fetchRecipientDetailsIndividual(SubscribedMember subscribedMember, String searchRecipeintId) {
		FacesContext context = FacesContext.getCurrentInstance();
		Recipient recipient = insuranceSubscribeDao.searchRecipientById(searchRecipeintId);
		subscribedMember.setRecipient(recipient);

		if (recipient != null) {
			if (recipient.getDob() != null) {
				subscribedMember.setAge(calculateAge(recipient.getDob()));
			} else {
				subscribedMember.setAge(0); // Or handle appropriately
			}

			subscribedMember.setFullName(recipient.getFirstName());
			System.out.println(
					recipient.getFirstName() + "===========inside recipent to set " + subscribedMember.getFullName());
			subscribedMember.setGender(recipient.getGender().toString());
			Subscribe subscribe = new Subscribe();
			InsuranceCoverageOption policy = (InsuranceCoverageOption) context.getExternalContext().getSessionMap()
					.get("coverageOption");

			subscribe = subscribeMemberTosubscribe(subscribedMember, coverageOption);
			subscribe.setAmountPaid(coverageOption.getPremiumAmount());
			insuranceSubscribeDao.addIndividualSuscribeMember(subscribe);

		} else {
			context.addMessage("form:hid",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "You are not a Registerd Member.", null));
		}

		System.out.println("-------------fetch is clicked------------");
		System.out.println("-------------subscribedMember1 :" + subscribedMember1);
		System.out.println("----------------------Recipient: " + recipient);
		System.out.println("------------------subscribedMember :" + subscribedMember);

		return "InsurancePlanExplore.jsp?faces-redirect=true";
	}

	public String fetchRecipientDetailsFamily(SubscribedMember subscribedMember, String searchRecipeintId) {
		System.out.println("----------------------this is id :"+searchRecipeintId);
//		FacesContext context = FacesContext.getCurrentInstance();
		Recipient recipient = insuranceSubscribeDao.searchRecipientById(searchRecipeintId);
		System.out.println(searchRecipeintId+""+recipient);
		subscribedMember.setRecipient(recipient);

//		if (recipient != null) {
//			if (recipient.getDob() != null) {
//				subscribedMember.setAge(calculateAge(recipient.getDob()));
//			} else {
//				subscribedMember.setAge(0); // Or handle appropriately
//			}
//
//			subscribedMember.setFullName(recipient.getFirstName());
//			System.out.println(
//					recipient.getFirstName() + "===========inside recipent to set " + subscribedMember.getFullName());
//			subscribedMember.setGender(recipient.getGender().toString());
//			Subscribe subscribe = new Subscribe();
//			InsuranceCoverageOption policy = (InsuranceCoverageOption) context.getExternalContext().getSessionMap()
//					.get("coverageOption");

//			subscribe = subscribeMemberTosubscribe(subscribedMember, coverageOption);
//			subscribe.setAmountPaid(coverageOption.getPremiumAmount());
//			insuranceSubscribeDao.addIndividualSuscribeMember(subscribe);

//		} else {
//			context.addMessage("form:hid",
//					new FacesMessage(FacesMessage.SEVERITY_ERROR, "You are not a Registerd Member.", null));
//		}

//		subscribedMemberList.add(subscribedMember);
		subscribedMember.setRecipient(recipient);
		System.out.println("-------------Family is clicked------------");
		System.out.println("-------------subscribedMember1 :" + subscribedMember);
		System.out.println("----------------------Recipient: " + recipient);
		System.out.println("------------------subscribedMember :" + subscribedMember);

//		subscribedMemberList.forEach(System.out::println);
        searchRecipeintId=null;
		return "null";
	}

	public String subscribeToPlanButton() {
		System.out.println("______________________in controller");
		FacesContext context = FacesContext.getCurrentInstance();
		InsuranceCoverageOption policy = (InsuranceCoverageOption) context.getExternalContext().getSessionMap()
				.get("coverageOption");

		System.out.println("=============\n coverage============= : ");
		SubscribedMember[] meberlist = { subscribedMember1, subscribedMember2, subscribedMember3, subscribedMember4,
				subscribedMember5, subscribedMember6, subscribedMember7, subscribedMember8 };
		System.out.println(policy.getInsurancePlan().getInsuranceCompany());
		System.out.println(policy.getInsurancePlan());
		System.out.println(policy);

		for (SubscribedMember member : meberlist) {
			System.out.println(member);
		}

		if (policy.getInsurancePlan().getPlanType() == PlanType.valueOf("FAMILY")) {
			Subscribe isPrimeMember = null;
			for (SubscribedMember member : meberlist) {
				if (member.getRelationWithProposer() == Relation.FATHER
						|| member.getRelationWithProposer() == Relation.MOTHER
						|| member.getRelationWithProposer() == Relation.HUSBAND
						|| member.getRelationWithProposer() == Relation.WIFE) {

					Subscribe subscribePrime = subscribeMemberTosubscribe(member, policy);
					String backGeneratedId = insuranceSubscribeDao.addIndividualSuscribeMember(subscribePrime);
					subscribePrime.setSubscribeId(backGeneratedId);
					isPrimeMember = subscribePrime;
				}
			}
			for (SubscribedMember member : meberlist) {
				if (member != null && isPrimeMember != null) {
					member.setSubscribe(isPrimeMember);
					insuranceSubscribeDao.addFamilySubscribeMember(member);
				}

			}

		} else {
			Subscribe subscribePrime = subscribeMemberTosubscribe(subscribedMember1, policy);
			insuranceSubscribeDao.addIndividualSuscribeMember(subscribePrime);
		}

		return "InsurancePlanExplore.jsp?faces-redirect=true";

	}

	public int calculateAge(Date dateOfBirth) {
		Calendar birthCal = Calendar.getInstance();
		birthCal.setTime(dateOfBirth);

		Calendar todayCal = Calendar.getInstance();

		int age = todayCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);

		// Agar birthday abhi tak nahi aaya hai is saal, to age se 1 ghata do
		if (todayCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}

		return age;
	}

	public Subscribe subscribeMemberTosubscribe(SubscribedMember subscribedMember, InsuranceCoverageOption coverage) {
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime(); // current date

		cal.add(Calendar.MONTH, 1); // add 1 month
		Date nextMonthDate = cal.getTime();

		cal.add(Calendar.YEAR, 1);
		Date nextDateAfterOneYear = cal.getTime();

		// private String subscribeId; //autogenerate
		Subscribe subscribe = new Subscribe();

//		private Recipient recipient;// auto

		subscribe.setRecipient(subscribedMember.getRecipient());
//	    private InsuranceCoverageOption coverage; //g
		subscribe.setCoverage(coverage);
//	    private Date subscribeDate;//enrollmentDate
		subscribe.setSubscribeDate(currentDate);
//	    private Date StartDate;//subscription startDate
		subscribe.setStartDate(nextMonthDate);
//	    private Date expiryDate;//subcription endDate
		subscribe.setExpiryDate(nextDateAfterOneYear);
//	    private SubscriptionType type;

		String type = coverage.getInsurancePlan().getPlanType().toString();

		if (type.equalsIgnoreCase("FAMILY")) {
			subscribe.setType(SubscriptionType.FAMILY);
		}

		subscribe.setType(SubscriptionType.INDIVIDUAL);
//	    private SubscriptionStatus status;
		if (subscribe.getSubscribeDate().after(subscribe.getExpiryDate())) {
			subscribe.setStatus(SubscriptionStatus.EXPIRED);

		} else {
			subscribe.setStatus(SubscriptionStatus.ACTIVE);

		}
//	    private double totalPremium;
		subscribe.setAmountPaid(coverage.getCoverageAmount());
//	    private double amountPaid;
		subscribe.setAmountPaid(coverage.getPremiumAmount());
//	   List<SubscribedMember> subscribedMember;

		return subscribe;
	}

	public String showPlicyDetailsToSuscribe(String policyId) {
		coverageOption = insuranceSubscribeDao.getInsurancePolicyById(policyId);
		System.out.println("show plicy by id  :" + coverageOption);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("coverageOption", coverageOption);

		return "ShowPlanDetailsToBeSuscribe?faces-redirect=true";
	}

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

	public Subscribe getSubscribe() {
		return Subscribe;
	}

	public void setSubscribe(Subscribe subscribe) {
		this.Subscribe = Subscribe;
	}

	public SubscribedMember getSubscribedMember() {
		return subscribedMember;
	}

	public void setSubscribedMember(SubscribedMember SubscribedMember) {
		this.subscribedMember = SubscribedMember;
	}

	public List<SubscribedMember> getSubscribedMemberList() {
		return subscribedMemberList;
	}

	public void setSubscribedMemberList(List<SubscribedMember> subscribedMemberList) {
		this.subscribedMemberList = subscribedMemberList;
	}

	public List<InsuranceCoverageOption> getCoverageOptionsList() {
		return coverageOptionsList;
	}

	public void setCoverageOptionsList(List<InsuranceCoverageOption> coverageOptionsList) {
		this.coverageOptionsList = coverageOptionsList;
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

	public SubscribedMember getSubscribedMember1() {
		return subscribedMember1;
	}

	public String getSearchRecipeintId() {
		return searchRecipeintId;
	}

	public void setSearchRecipeintId(String searchRecipeintId) {
		this.searchRecipeintId = searchRecipeintId;
	}

	public SubscribedMember getSubscribedMember2() {
		return subscribedMember2;
	}

	public SubscribedMember getSubscribedMember4() {
		return subscribedMember4;
	}

	public InsuranceSubscribeDao getInsuranceSubscribeao() {
		return getInsuranceSubscribeao();
	}

	public SubscribedMember getSubscribedMember3() {
		return subscribedMember3;
	}

	public void setSubscribedMember3(SubscribedMember subscribedMember3) {
		this.subscribedMember3 = subscribedMember3;
	}

	public SubscribedMember getSubscribedMember5() {
		return subscribedMember5;
	}

	public void setSubscribedMember5(SubscribedMember subscribedMember5) {
		this.subscribedMember5 = subscribedMember5;
	}

	public SubscribedMember getSubscribedMember6() {
		return subscribedMember6;
	}

	public void setSubscribedMember6(SubscribedMember subscribedMember6) {
		this.subscribedMember6 = subscribedMember6;
	}

	public InsuranceSubscribeDao getInsuranceSubscribeDao() {
		return insuranceSubscribeDao;
	}

	public void setInsuranceSubscribeDao(InsuranceSubscribeDao insuranceSubscribeDao) {
		this.insuranceSubscribeDao = insuranceSubscribeDao;
	}

	public void setSubscribedMember1(SubscribedMember subscribedMember1) {
		this.subscribedMember1 = subscribedMember1;
	}

	public void setSubscribedMember2(SubscribedMember subscribedMember2) {
		this.subscribedMember2 = subscribedMember2;
	}

	public void setSubscribedMember4(SubscribedMember subscribedMember4) {
		this.subscribedMember4 = subscribedMember4;
	}

	public void setInsuranceSubscribeao(InsuranceSubscribeDao insuranceSubscribeao) {
		this.insuranceSubscribeDao = insuranceSubscribeao;
	}

	public SubscribedMember getSubscribedMember7() {
		return subscribedMember7;
	}

	public void setSubscribedMember7(SubscribedMember subscribedMember7) {
		this.subscribedMember7 = subscribedMember7;
	}

	public SubscribedMember getSubscribedMember8() {
		return subscribedMember8;
	}

	public void setSubscribedMember8(SubscribedMember subscribedMember8) {
		this.subscribedMember8 = subscribedMember8;
	}

	public InsuranceSubscribedController() {
		super();
	}

}
