package com.infinite.jsf.insurance.model;

import java.util.Date;
import java.util.List;

import com.infinite.jsf.recipient.model.Recipient;

public class Subscribe {
   
	private String subscribeId;
	private Recipient recipient;
    private InsuranceCoverageOption coverage;
    private Date subscribeDate;//enrollmentDate
    private Date StartDate;//subscription startDate
    private Date expiryDate;//subcription endDate
    private SubscriptionType type;
    private SubscriptionStatus status;
    private double totalPremium;
    private double amountPaid;
   List<SubscribedMember> subscribedMember;

	public String getSubscribeId() {
		return subscribeId;
	}

	public void setSubscribeId(String subscribeId) {
		this.subscribeId = subscribeId;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public InsuranceCoverageOption getCoverage() {
		return coverage;
	}

	public void setCoverage(InsuranceCoverageOption coverage) {
		this.coverage = coverage;
	}

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public SubscriptionType getType() {
		return type;
	}

	public void setType(SubscriptionType type) {
		this.type = type;
	}

	public SubscriptionStatus getStatus() {
		return status;
	}

	public void setStatus(SubscriptionStatus status) {
		this.status = status;
	}

	public double getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(double totalPremium) {
		this.totalPremium = totalPremium;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public List<SubscribedMember> getSubscribedMember() {
		return subscribedMember;
	}

	public void setSubscribedMember(List<SubscribedMember> subscribedMember) {
		this.subscribedMember = subscribedMember;
	}

	public Subscribe(String subscribeId, Recipient recipient, InsuranceCoverageOption coverage, Date subscribeDate,
			Date startDate, Date expiryDate, SubscriptionType type, SubscriptionStatus status, double totalPremium,
			double amountPaid, List<SubscribedMember> subscribedMember) {
		super();
		this.subscribeId = subscribeId;
		this.recipient = recipient;
		this.coverage = coverage;
		this.subscribeDate = subscribeDate;
		StartDate = startDate;
		this.expiryDate = expiryDate;
		this.type = type;
		this.status = status;
		this.totalPremium = totalPremium;
		this.amountPaid = amountPaid;
		this.subscribedMember = subscribedMember;
	}

	public Subscribe() {
		super();
	}

	@Override
	public String toString() {
		return "Subscribe [subscribeId=" + subscribeId + ", recipient=" + recipient + ", coverage=" + coverage
				+ ", subscribeDate=" + subscribeDate + ", StartDate=" + StartDate + ", expiryDate=" + expiryDate
				+ ", type=" + type + ", status=" + status + ", totalPremium=" + totalPremium + ", amountPaid="
				+ amountPaid + ", subscribedMember=" + subscribedMember + "]";
	}
	
	
	
	
	

}