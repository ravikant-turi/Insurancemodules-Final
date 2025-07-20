<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Coverage Option Details</title>
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
.button-center {
            text-align: center;
            margin-top: 40px;
        }
         

h1 {
	color: #007acc;
	margin-bottom: 30px;
	font-weight: 700;
	font-size: 32px;
	position: relative;
	text-align: center;
}

h1::after {
	content: '';
	display: block;
	width: 60px;
	height: 3px;
	background: #007acc;
	margin: 8px auto 0 auto;
	border-radius: 2px;
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
}

.value {
	color: #222;
	text-align: right;
}
</style>
</head>
<body>

	<div class="details-container">
		<h1>Coverage Option Details</h1>

		<h:form>
			<div>

				<div class="detail-block">
					<span class="label">Coverage ID:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.coverageId}" />
				</div>

				<div class="detail-block">
					<span class="label">Plan ID:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planId}" />
				</div>
				

				<div class="detail-block">
					<span class="label">Premium Amount:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.premiumAmount}" />
				</div>

				<div class="detail-block">
					<span class="label">Coverage Amount:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.coverageAmount}" />
				</div>

				<div class="detail-block">
					<span class="label">Status:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.status}" />
				</div>

				<div class="detail-block">
					<span class="label">Plan Name:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planName}" />
				</div>

				<div class="detail-block">
					<span class="label">Available Cover Amounts:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.availableCoverAmounts}" />
				</div>

				<div class="detail-block">
					<span class="label">Plan Type:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planType}" />
				</div>

				<div class="detail-block">
					<span class="label">Max Entry Age:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.maxEntryAge}" />
				</div>

				<div class="detail-block">
					<span class="label">Min Entry Age:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.minEntryAge}" />
				</div>

				<div class="detail-block">
					<span class="label">Periodic Diseases:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.periodicDiseases}" />
				</div>

				<div class="detail-block">
					<span class="label">Active On:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.activeOn}" />
				</div>

				<div class="detail-block">
					<span class="label">Expire Date:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.expireDate}" />
				</div>

				<div class="detail-block">
					<span class="label">Created On:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.createdOn}" />
				</div>

				<div class="detail-block">
					<span class="label">Waiting Period:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.waitingPeriod}" />
				</div>

				<div class="detail-block">
					<span class="label">Description:</span>
					<h:outputText styleClass="value"
						value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.description}" />
				</div>

			</div>
			 <div class="button-center">
			                <h:commandButton value="Back" action="showcoverageplanbyplantype.jsp" styleClass="simple-btn" />
			</div>
		</h:form>
	</div>

</body>
	</html>
</f:view>
