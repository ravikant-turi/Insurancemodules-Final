<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Add Company</title>
<style>
.coverage-box form {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.coverage-box label {
	width: 100%;
	text-align: left;
}

.coverage-box input[type="text"] {
	width: 100%;
	margin-bottom: 10px;
}
.error {
	color: red;
	font-size: 12px;
}
</style>
</head>
<body>

<!-- Coverage Option 2 -->
					<div class="coverage-box">
						<h3>Add Gold Option</h3>
						<label>Premium Amount:</label>
						<h:inputText
							value="#{createInsuranceController.coverageOption2.premiumAmount}" />

						<label>Coverage Amount:</label>
						<h:inputText
							value="#{createInsuranceController.coverageOption2.coverageAmount}" />
						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>MaximumMemberAllowed :" />
						<h:inputText id="maximumMemberAllowed2"
							value="#{createInsuranceController.coverageOption2.maximumMemberAllowed}" />
						<h:message for="maximumMemberAllowed2" styleClass="error" />

						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>MinimumMeberAllowed: :" />
						<h:inputText id="minimumMeberAllowed2"
							value="#{createInsuranceController.coverageOption2.minimumMeberAllowed}" />
						<h:message for="minimumMeberAllowed2" styleClass="error" />

						<h:outputLabel escape="false"
							value=" <span style='color:red'>*</span>CoverageType " />
						<h:selectOneMenu id="coverageType2"
							value="#{createInsuranceController.coverageOption2.coverageType}">
							<f:selectItem itemLabel="--Select--" itemValue="" />
							<f:selectItem itemLabel="SILVER" itemValue="SILVER" />
							<f:selectItem itemLabel="GOLD" itemValue="GOLD" />
							<f:selectItem itemLabel="PLATINUM" itemValue="PLATINUM" />
						</h:selectOneMenu>
						<h:message for="coverageType2" styleClass="error" />


					</div>
</body>
</html>
</f:view>