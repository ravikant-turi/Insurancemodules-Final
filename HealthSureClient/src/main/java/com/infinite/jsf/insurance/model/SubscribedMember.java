package com.infinite.jsf.insurance.model;

import java.sql.Date;

import com.infinite.jsf.recipient.model.Recipient;

public class SubscribedMember {

	private String subscribeMeberId; // sub001

	private Recipient recipient; // HID001

	private InsuranceCoverageOption coverage; // COO1

	private Date subscriptionStartDate;// plan subscribeDate

	private Date subscriptionEndDate; // plan subscribe endDate

	private Date enrolledDate;

	private SubscriptionStatus status; // dynamically calculate by expired date [ACTIVE,INACTIVE] BY DEFALUT ACTIVE

	private double coverageAmount; //

	private double amountPaid; //

	private String name;

	private int age;

	private Gender gender;


}