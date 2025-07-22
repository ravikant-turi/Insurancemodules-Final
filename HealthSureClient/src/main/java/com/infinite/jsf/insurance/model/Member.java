package com.infinite.jsf.insurance.model;

import com.infinite.jsf.recipient.model.Gender;

public class Member {
	
	private String meberId;
	private String name;
	private int age;
	private Gender gender;
	private Relation relation;
	private InsuranceCoverageOption coverageOption;

	public Member(String meberId, String name, int age, Gender gender, Relation relation,
			InsuranceCoverageOption coverageOption) {
		super();
		this.meberId = meberId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.relation = relation;
		this.coverageOption = coverageOption;
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


	public InsuranceCoverageOption getCoverageOption() {
		return coverageOption;
	}


	public void setCoverageOption(InsuranceCoverageOption coverageOption) {
		this.coverageOption = coverageOption;
	}


	public void setRelation(Relation relation) {
		this.relation = relation;
	}


	@Override
	public String toString() {
		return "Member [meberId=" + meberId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", relation="
				+ relation + ", coverageOption=" + coverageOption + "]";
	}


	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


}
