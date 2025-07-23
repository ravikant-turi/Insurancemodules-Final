package com.infinite.jsf.insurance.model;


/**
 * Member.java
 * 
 * This class represents a member enrolled template or rule in an insurance plan.
 * It includes property of member such as name, age, gender, and relation to the policyholder.
 * 
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */

public class Member {
	
	private String meberId;
	private String name;
	private int age;
	private Gender gender;
	private Relation relation;
	private InsurancePlan insurancePlan;

	


	public Member(String meberId, String name, int age, Gender gender, Relation relation, InsurancePlan insurancePlan) {
		super();
		this.meberId = meberId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.relation = relation;
		this.insurancePlan = insurancePlan;
	}




	@Override
	public String toString() {
		return "Member [meberId=" + meberId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", relation="
				+ relation + ", insurancePlan=" + insurancePlan + "]";
	}




	public String getMeberId() {
		return meberId;
	}




	public void setMeberId(String meberId) {
		this.meberId = meberId;
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




	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}




	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}




	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


}
