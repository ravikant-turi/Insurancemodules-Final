<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Coverage Option</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: linear-gradient(135deg, #e0f7fa, #ffffff);
	margin: 0;
	padding: 40px;
	color: #333;
	display: flex;
	justify-content: center;
	align-items: flex-start;
	min-height: 100vh;
}
h1 {
	color: #007acc;
	margin-bottom: 30px;
	font-weight: 700;
	font-size: 32px;
	text-align: center;
}
.details-container {
	background: #fff;
	padding: 30px 40px;
	border-radius: 12px;
	box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 600px;
}
.detail-block {
	display: flex;
	justify-content: space-between;
	padding: 12px 0;
	border-bottom: 1px solid #e0e0e0;
}
.detail-block:last-child {
	border-bottom: none;
}
.label {
	font-weight: 600;
	color: #555;
	width: 45%;
}
.value {
	width: 50%;
	text-align: right;
}
.buttons {
	margin-top: 30px;
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>

<div class="details-container">
	<h1>Update Coverage Option</h1>
	<h:form>
		<!-- CoverageOption fields -->
		

		<div class="detail-block">
			<span class="label">Premium Amount:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.premiumAmount}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Coverage Amount:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.coverageAmount}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Status:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.status}" styleClass="value" />
		</div>

		<!-- InsurancePlan fields -->
		<div class="detail-block">
			<span class="label">Plan ID:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planId}" readonly="true" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Plan Name:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planName}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Available Cover Amounts:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.availableCoverAmounts}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Plan Type:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planType}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Max Entry Age:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.maxEntryAge}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Min Entry Age:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.minEntryAge}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Periodic Diseases:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.periodicDiseases}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Active On:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.activeOn}" styleClass="value">
				<f:convertDateTime pattern="yyyy-MM-dd" />
			</h:inputText>
		</div>

		<div class="detail-block">
			<span class="label">Expire Date:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.expireDate}" styleClass="value">
				<f:convertDateTime pattern="yyyy-MM-dd" />
			</h:inputText>
		</div>

		<div class="detail-block">
			<span class="label">Created On:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.createdOn}" styleClass="value">
				<f:convertDateTime pattern="yyyy-MM-dd" />
			</h:inputText>
		</div>

		<div class="detail-block">
			<span class="label">Waiting Period:</span>
			<h:inputText value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.waitingPeriod}" styleClass="value" />
		</div>

		<div class="detail-block">
			<span class="label">Description:</span>
			<h:inputTextarea value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.description}" rows="3" cols="25" styleClass="value" />
		</div>

		<!-- Action buttons -->
		<div class="buttons">
			<h:commandButton value="Update"
				action="#{insuranceCoverageOptionController.updateCoverageOption(insuranceCoverageOptionController.coverageOption)}" />

			<h:commandButton value="Cancel"
				action="showInsuranceCoverageOption?faces-redirect=true"
				immediate="true" />
		</div>

		<h:messages globalOnly="true" style="color:red;" />

	</h:form>
</div>

</body>
</html>
</f:view>
