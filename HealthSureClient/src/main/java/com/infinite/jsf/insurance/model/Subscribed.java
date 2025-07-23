package com.infinite.jsf.insurance.model;

import java.sql.Date;
import java.util.List;

import com.infinite.jsf.recipient.model.Recipient;

public class Subscribed {

	private String subscribeId; // SUB001

	private Recipient recipient; // HID001

	private InsuranceCoverageOption coverage; // COO1

	private Date subscriptionStartDate;// plan subscribeDate

	private Date subscriptionEndDate; // plan subscribe endDate

	private Date enrolledDate;

	private SubscriptionType type; // Types [individual/FAMILY]

	private SubscriptionStatus status; // dynamically calculate by expired date [ACTIVE,INACTIVE] BY DEFALUT ACTIVE

	private double CoverageAmount; //

	private double amountPaid; //

	private String name;

	private int age;

	private Gender gender;

	private Relation relation;

	List<SubscribedMember> subscribedMember;

//	private boolean isPrime;

	// Constructors
	public Subscribed() {

	}

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

	public double getCoverageAmount() {
		return CoverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		CoverageAmount = coverageAmount;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	// Getters and Setters

}