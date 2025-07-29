package com.infinite.jsf.insurance.model;

/**
 * MessageConstants.java
 *
 * Singleton class to hold all application-wide message constants. Ensures only
 * one instance is created and accessed in a thread-safe manner.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */
public class CreateInsuranceMessageConstants {

	public final String PLAN_NAME_REQUIRED = "Plan name is required.";
	public final String PLAN_NAME_TOO_SHORT = "Plan name must be at least 4 characters.";
	public final String PLAN_NAME_INVALID = "Plan name must contain only alphabetic characters (no digits or special characters).";
	public final String COMPANY_REQUIRED = "Insurance company is required.";
	public final String DESCRIPTION_REQUIRED = "Description is required.";
	public final String DESCRIPTION_TOO_SHORT = "Description must be more than 5 characters.";
	public final String DESCRIPTION_INVALID = "Only alphabetic characters are allowed (no digits or special characters).";
	public final String COVER_AMOUNT_REQUIRED = "Cover amount is required.";
	public final String COVER_AMOUNT_INVALID_FORMAT = "Cover amount must contain only digits (no letters or special characters).";
	public final String COVER_AMOUNT_NEGATIVE = "Cover amount must be greater than zero.";
	public final String COVER_AMOUNT_PARSE_ERROR = "Invalid number format for cover amount.";
	public final String MIN_AGE_REQUIRED = "Minimum age is required.";
	public final String MIN_AGE_INVALID = "Minimum age must be greater than 0.";
	public final String MAX_AGE_REQUIRED = "Maximum age is required.";
	public final String MAX_AGE_INVALID = "Maximum age must be greater than 0.";
	public final String MAX_AGE_LESS_THAN_MIN = "Maximum age must be greater than or equal to minimum age.";
	public final String MAX_AGE_TOO_HIGH = "Maximum age must not be greater than 70.";
	public final String WAITING_PERIOD_INVALID = "Invalid waiting period.";
	public final String WAITING_PERIOD_OUT_OF_RANGE = "Waiting period must be between 0 and 12 months.";
	public final String PERIODIC_DISEASES_REQUIRED = "Periodic diseases field is required.";
	public final String PLAN_TYPE_REQUIRED = "Plan Type field is required.";
	public final String ACTIVE_ON_REQUIRED = "Active On date is required.";
	public final String ACTIVE_ON_BEFORE_CREATED = "Active On date cannot be before Created On date.";
	public final String ACTIVE_ON_AFTER_EXPIRE = "Active On date cannot be after Expire date.";
	public final String DURATION_REQUIRED = "You must choose a duration.";
	public final String LINKED_PLAN_REQUIRED = "Linked Insurance Plan is required.";
	public final String PREMIUM_AMOUNT_RANGE = "Premium amount must be between ₹500 and ₹100,000.";
	public final String COVERAGE_AMOUNT_RANGE = "Coverage amount must be between ₹1,00,000 (1L) and ₹5,00,00,000 (5Cr).";
	public final String COVERAGE_GREATER_THAN_PREMIUM = "Coverage amount must be greater than premiumAmount.";

}
