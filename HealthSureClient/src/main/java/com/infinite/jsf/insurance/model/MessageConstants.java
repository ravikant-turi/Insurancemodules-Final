package com.infinite.jsf.insurance.model;

/**
 * MessageConstants.java
 *
 * Singleton class to hold all application-wide message constants.
 * Ensures only one instance is created and accessed in a thread-safe manner.
 *
 * Copyright © 2025 Infinite Computer Solution. All rights reserved.
 */
public class MessageConstants {

    // Singleton instance
    private static MessageConstants instance;

    // Private constructor
    private MessageConstants() {}

    // Synchronized method to get the singleton instance
    public static synchronized MessageConstants getInstance() {
        if (instance == null) {
            instance = new MessageConstants();
        }
        return instance;
    }

    // Private message fields
    private final String MEMBER_ADDED_SUCCESS = "Member added successfully.";
    private final String MEMBER_ADD_FAILED = "Failed to add member.";

    private final String PLAN_ADDED_SUCCESS = "Insurance plan added successfully.";
    private final String PLAN_ADD_FAILED = "Failed to add insurance plan.";

    private final String COVERAGE_ADDED_SUCCESS = "Coverage option added successfully.";
    private final String COVERAGE_ADD_FAILED = "Failed to add coverage option.";

    private final String UPDATE_SUCCESS = "Update successful.";
    private final String UPDATE_FAILED = "Update failed.";

    private final String DATA_NOT_FOUND = "Requested data not found.";
    
    private final String PLAN_NAME_REQUIRED="Plan name is required.";

    // Public getters
    public String getMemberAddedSuccess() {
        return MEMBER_ADDED_SUCCESS;
    }

    public String getMemberAddFailed() {
        return MEMBER_ADD_FAILED;
    }

    public String getPlanAddedSuccess() {
        return PLAN_ADDED_SUCCESS;
    }

    public String getPlanAddFailed() {
        return PLAN_ADD_FAILED;
    }

    public String getCoverageAddedSuccess() {
        return COVERAGE_ADDED_SUCCESS;
    }

    public String getCoverageAddFailed() {
        return COVERAGE_ADD_FAILED;
    }

    public String getUpdateSuccess() {
        return UPDATE_SUCCESS;
    }

    public String getUpdateFailed() {
        return UPDATE_FAILED;
    }

    public String getDataNotFound() {
        return DATA_NOT_FOUND;
    }

	public String getMEMBER_ADDED_SUCCESS() {
		return MEMBER_ADDED_SUCCESS;
	}

	public String getMEMBER_ADD_FAILED() {
		return MEMBER_ADD_FAILED;
	}

	public String getPLAN_ADDED_SUCCESS() {
		return PLAN_ADDED_SUCCESS;
	}

	public String getPLAN_ADD_FAILED() {
		return PLAN_ADD_FAILED;
	}

	public String getCOVERAGE_ADDED_SUCCESS() {
		return COVERAGE_ADDED_SUCCESS;
	}

	public String getCOVERAGE_ADD_FAILED() {
		return COVERAGE_ADD_FAILED;
	}

	public String getUPDATE_SUCCESS() {
		return UPDATE_SUCCESS;
	}

	public String getUPDATE_FAILED() {
		return UPDATE_FAILED;
	}

	public String getDATA_NOT_FOUND() {
		return DATA_NOT_FOUND;
	}

	public String getPLAN_NAME_REQUIRED() {
		return PLAN_NAME_REQUIRED;
	}

	public static void setInstance(MessageConstants instance) {
		MessageConstants.instance = instance;
	}
    
}
