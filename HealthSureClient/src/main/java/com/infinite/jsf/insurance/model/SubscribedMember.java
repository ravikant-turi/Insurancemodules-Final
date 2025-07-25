package com.infinite.jsf.insurance.model;

import java.util.Date;

import com.infinite.jsf.recipient.model.Recipient;

public class SubscribedMember {

	private String memberId;
	private Recipient recipient;
	private Subscribe subscribe; // Many-to-One with Subscribe
	private String fullName;
	private Integer age;
	private String gender;
	private Relation relationWithProposer;

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public Subscribe getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public Relation getRelationWithProposer() {
		return relationWithProposer;
	}

	public void setRelationWithProposer(Relation relationWithProposer) {
		this.relationWithProposer = relationWithProposer;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public SubscribedMember(Recipient recipient, Subscribe subscribe, String fullName, Integer age, String gender,
			Relation relationWithProposer) {
		super();
		this.recipient = recipient;
		this.subscribe = subscribe;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.relationWithProposer = relationWithProposer;
	}

	public SubscribedMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SubscribedMember [recipient=" + recipient + ", subscribe=" + subscribe + ", fullName=" + fullName
				+ ", age=" + age + ", gender=" + gender + ", relationWithProposer=" + relationWithProposer + "]";
	}

}