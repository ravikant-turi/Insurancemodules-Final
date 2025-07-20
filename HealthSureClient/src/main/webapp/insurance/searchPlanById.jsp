<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Add Insurance Plan</title>
<style>
.error {
	color: red;
	font-size: 12px;
}
</style>
</head>
F
<body>

	<h:outputText value="update Plan to Insurance"
		style="font-weight:bold; font-size:16px;" />
	<br />
	<br />

	<h:form id="companyForm">



		<h:outputText value="Company ID:" />
		<h:inputText id="companyId"
			value="#{insurancePlanController.insurancePlan.insuranceCompany.companyId}" />
		<h:message for="companyId" style="color:red" />
		<br />
		<br />

		<h:outputText value="Enter the Plan Name: " />
		<h:inputText id="planName"
			value="#{insurancePlanController.insurancePlan.planName}" />
		<h:message for="planName" style="color:red" />
		<br />
		<br />

		<h:outputText value="Select Plan Type: " />
		<h:selectOneMenu id="planType"
			value="#{insurancePlanController.insurancePlan.planType}">
			<f:selectItem itemLabel="--Select--" itemValue="" />
			<f:selectItem itemLabel="SELF" itemValue="SELF" />
			<f:selectItem itemLabel="FAMILY" itemValue="FAMILY" />
			<f:selectItem itemLabel="SENIOR" itemValue="SENIOR" />
		</h:selectOneMenu>
		<h:message for="planType" style="color:red" />

		<br />
		<br />

		<h:outputText value="Min Entry Age: " />
		<h:inputText id="minAge"
			value="#{insurancePlanController.insurancePlan.minEntryAge}" />
		<h:message for="minAge" style="color:red" />
		<br />
		<br />

		<h:outputText value="Max Entry Age: " />
		<h:inputText id="maxAge"
			value="#{insurancePlanController.insurancePlan.maxEntryAge}" />
		<h:message for="maxAge" style="color:red" />
		<br />
		<br />

		<h:outputText value="Description: " />
		<h:inputTextarea id="description"
			value="#{insurancePlanController.insurancePlan.description}" rows="3"
			cols="30" />
		<h:message for="description" style="color:red" />
		<br />
		<br />

		<h:outputText value="Available Cover Amounts: " />
		<h:inputText id="cover"
			value="#{insurancePlanController.insurancePlan.availableCoverAmounts}" />
		<h:message for="cover" style="color:red" />
		<br />
		<br />

		<h:outputText value="Waiting Period: " />
		<h:inputText id="waitingPeriod"
			value="#{insurancePlanController.insurancePlan.waitingPeriod}" />
		<h:message for="waitingPeriod" style="color:red" />
		<br />
		<br />

		<h:outputText value="Active On (yyyy-MM-dd): " />
		<h:inputText id="activeOn"
			value="#{insurancePlanController.insurancePlan.activeOn}">
			<f:convertDateTime pattern="yyyy-MM-dd" />
		</h:inputText>
		<h:message for="activeOn" style="color:red" />
		<br />
		<br />

		<h:outputText value="Periodic Diseases (YES/NO): " />
		<h:selectOneMenu id="periodicDiseases"
			value="#{insurancePlanController.insurancePlan.periodicDiseases}">
			<f:selectItem itemLabel="--Select--" itemValue="" />
			<f:selectItem itemLabel="YES" itemValue="YES" />
			<f:selectItem itemLabel="NO" itemValue="NO" />
		</h:selectOneMenu>
		<h:message for="periodicDiseases" style="color:red" />
		<br />
		<br />

		<!-- Corrected command button -->
		<h:commandButton value=" update Plan"
			action="#{insurancePlanController.updateInsurancePlan(insurancePlanController.insurancePlan)}" />

	</h:form>

	<h:messages globalOnly="true" style="color:red" />

</body>
	</html>
</f:view>
