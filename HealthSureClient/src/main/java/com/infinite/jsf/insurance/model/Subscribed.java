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

	private SubscriptionStatus status; // dynamically calculate by expired date [ACTIVE,INACTIVE] BY DEFALUT ACTIVE

	private double CoverageAmount; //

	private double amountPaid; //

	private String name;

	private int age;

	private Gender gender;

	private Relation relation;

	private boolean isPrime;

	List<SubscribedMember> subscribedMember;

}