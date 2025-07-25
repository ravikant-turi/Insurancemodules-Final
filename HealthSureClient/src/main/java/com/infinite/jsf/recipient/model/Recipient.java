package com.infinite.jsf.recipient.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.infinite.jsf.admin.model.PaymentHistory;
import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.pharmacy.model.DispensedEquipment;
import com.infinite.jsf.pharmacy.model.DispensedMedicine;
import com.infinite.jsf.provider.model.Appointment;
import com.infinite.jsf.provider.model.Claims;
import com.infinite.jsf.provider.model.MedicalProcedure;
import com.infinite.jsf.provider.model.Prescription;

public class Recipient implements Serializable {
	private String hId; // Health ID
	private String firstName;
	private String lastName;
	private String fullName;
	private String mobile;
	private String userName;
	private Gender gender;
	private Date dob;
	private String address;
	private Date createdAt;
	private String password;
	private String email;
	private RecipientStatus status;

	// Constructors
	public Recipient() {
	}

	public Recipient(String hId, String firstName, String lastName, String mobile, String userName, Gender gender,
			Date dob, String address, String password, String email) {
		this.hId = hId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.userName = userName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.password = password;
		this.email = email;
		this.status = RecipientStatus.ACTIVE;
		this.createdAt = new Date(System.currentTimeMillis());
	}

	// Getters and Setters
	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String firstName, String lastName) {
		this.fullName = getFirstName() + " " + getLastName();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RecipientStatus getStatus() {
		return status;
	}

	public void setStatus(RecipientStatus status) {
		this.status = status;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Recipient(String hId, String firstName, String lastName, String fullName, String mobile, String userName,
			Gender gender, Date dob, String address, Date createdAt, String password, String email,
			RecipientStatus status) {
		super();
		this.hId = hId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.mobile = mobile;
		this.userName = userName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.createdAt = createdAt;
		this.password = password;
		this.email = email;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Recipient [hId=" + hId + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", mobile=" + mobile + ", userName=" + userName + ", gender=" + gender + ", dob=" + dob
				+ ", address=" + address + ", createdAt=" + createdAt + ", password=" + password + ", email=" + email
				+ ", status=" + status + "]";
	}

	// Relationship getters and setters
	
}