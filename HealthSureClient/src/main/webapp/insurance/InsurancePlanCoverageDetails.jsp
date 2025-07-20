<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<!DOCTYPE html>
	<html>
<head>
<title>Insurance Plan & Coverage Options</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f6f8;
	margin: 0;
	padding: 20px;
}

.main-container {
	max-width: 1200px;
	margin: auto;
}

.form-box, .coverage-box {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
	margin-bottom: 30px;
}

.form-row {
	display: flex;
	gap: 20px;
	margin-bottom: 15px;
	flex-wrap: wrap;
}

.form-group {
	flex: 1;
	min-width: 200px;
}

label {
	font-weight: 600;
	display: block;
	margin-bottom: 5px;
	color: #34495e;
}

input[type="text"], textarea, select {
	width: 100%;
	padding: 8px 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	box-sizing: border-box;
	font-size: 14px;
	background-color: #fdfdfd;
}

textarea {
	resize: vertical;
}

.submit-button {
	background-color: #3498db;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 6px;
	font-size: 15px;
	cursor: pointer;
	width: 100%;
	margin-top: 10px;
}

.submit-button:hover {
	background-color: #2980b9;
}

.coverage-box {
	flex: 1;
	text-align: center;
}

.coverage-box h3 {
	margin-bottom: 15px;
	color: #16a085;
}

.section-title {
	background-color: #3498db;
	color: white;
	padding: 10px 15px;
	border-radius: 8px;
	text-align: center;
	margin-bottom: 20px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
	height: 40px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

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

.button-row {
	display: flex;
	justify-content: space-between;
	margin-top: 10px;
}

.left-btn {
	margin-right: auto;
}

.right-btn {
	margin-left: auto;
}

.action-btn {
	background-color: #3498db;
	color: white;
	border: none;
	padding: 8px 12px;
	border-radius: 4px;
	cursor: pointer;
	font-size: 14px;
	width: 90px; /* Fixed width for uniform size */
	text-align: center;
}

.action-btn:hover {
	background-color: #2980b9;
}

h3 {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 20px;
}

.section-title {
	font-size: 22px;
	font-weight: bold;
	margin: 0;
}

form {
	margin-top: 50px;
}

.error {
	color: red;
	font-size: 12px;
}
input[readonly], textarea[readonly] {
    background-color: #f0f0f0; /* Light gray */
    border: 1px solid #ccc;    /* Soft border */
}

</style>

</head>
<body>
	<div class="main-container">
		<h:messages globalOnly="true" style="color:red" />

		<!-- show Insurance Plan Form -->
		<div class="header-container">
			<h3 class="section-title">Show Insurance Plan</h3>
		</div>

		<h:form id="companyForm">
			<div class="form-box">

				<!-- Row 1 -->
				<div class="form-row">
					<div class="form-group">
						<label>Company Name:</label>
						<h:inputText id="companyId"
							value="#{insurancePlanController.insuranceCompany.name}"
							readonly="true" />
						<br />
						<h:message for="companyId" styleClass="error" />

					</div>
					<div class="form-group">
						<label>Plan Name:</label>
						<h:inputText id="planName"
							value="#{insurancePlanController.insurancePlan.planName}"
							readonly="true" />
						<h:message for="planName" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<label>Plan Type:</label>
						<h:inputText id="planType"
							value="#{insurancePlanController.insurancePlan.planType}"
							readonly="true">

						</h:inputText>
						<br />
						<h:message for="planType" styleClass="error" />

					</div>
				</div>

				<!-- Row 2 -->
				<div class="form-row">
					<div class="form-group">
						<label>Min Entry Age:</label>
						<h:inputText id="minAge"
							value="#{insurancePlanController.insurancePlan.minEntryAge}"
							readonly="true" />
						<h:message for="minAge" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<label>Max Entry Age:</label>
						<h:inputText id="maxAge"
							value="#{insurancePlanController.insurancePlan.maxEntryAge}"
							readonly="true" />
						<h:message for="maxAge" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<label>Description:</label>
						<h:inputTextarea id="description"
							value="#{insurancePlanController.insurancePlan.description}"
							rows="2" cols="20" readonly="true" />
						<h:message for="description" styleClass="error" />
						<br />

					</div>
				</div>

				<!-- Row 3 -->
				<div class="form-row">
					<div class="form-group">
						<label>Coverage Amounts:</label>
						<h:inputText id="cover"
							value="#{insurancePlanController.insurancePlan.availableCoverAmounts}"
							readonly="true" />
						<h:message for="cover" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<label>Waiting Period Month:</label>
						<h:inputText id="waitingPeriod"
							value="#{insurancePlanController.insurancePlan.waitingPeriod}"
							readonly="true" />
						<h:message for="waitingPeriod" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<label>Active On (YYYY-MM-dd):</label>
						<h:inputText id="activeOn"
							value="#{insurancePlanController.insurancePlan.activeOn}"
							readonly="true">
							<f:convertDateTime pattern="yyyy-MM-dd" />
						</h:inputText>
						<h:message for="activeOn" styleClass="error" />
						<br />

					</div>
				</div>

				<!-- Row 4 -->
				<div class="form-row">
					<div class="form-group">
						<label>Periodic Diseases:</label>
						<h:inputText id="periodicDiseases"
							value="#{insurancePlanController.insurancePlan.periodicDiseases}"
							readonly="true">
						</h:inputText>
					</div>
					<br />
					<h:message for="periodicDiseases" styleClass="error" />
					<div class="form-group">
						<label>ExpireDate (YYYY-MM-dd):</label>
						<h:inputText id="expireDate"
							value="#{insurancePlanController.insurancePlan.expireDate}"
							readonly="true">
							<f:convertDateTime pattern="yyyy-MM-dd" />
						</h:inputText>
						<h:message for="expireDate" styleClass="error" />
						<br />

					</div>
				</div>

				<!-- Coverage Options -->
				<h3>Show Coverage Options</h3>
				<div class="form-row">

					<!-- Coverage Option 1 -->
					<div class="coverage-box">
						<h3>Silver Option</h3>
						<label>Premium Amount:</label>
						<h:inputText id="PremiumAmount"
							value="#{insurancePlanController.coverageOption1.premiumAmount}"
							readonly="true" />
						<h:message for="PremiumAmount" styleClass="error" />

						<label>Coverage Amount:</label>
						<h:inputText id="CoverageAmount"
							value="#{insurancePlanController.coverageOption1.coverageAmount}"
							readonly="true" />
						<h:message for="CoverageAmount" styleClass="error" />

					</div>

					<!-- Coverage Option 2 -->
					<div class="coverage-box">
						<h3>Gold Option</h3>
						<label>Premium Amount:</label>
						<h:inputText
							value="#{insurancePlanController.coverageOption2.premiumAmount}"
							readonly="true" />

						<label>Coverage Amount:</label>
						<h:inputText
							value="#{insurancePlanController.coverageOption2.coverageAmount}"
							readonly="true" />


					</div>

					<!-- Coverage Option 3 -->
					<div class="coverage-box">
						<h3>Platinum Option</h3>
						<label>Premium Amount:</label>
						<h:inputText
							value="#{insurancePlanController.coverageOption3.premiumAmount}"
							readonly="true" />

						<label>Coverage Amount:</label>
						<h:inputText
							value="#{insurancePlanController.coverageOption3.coverageAmount}"
							readonly="true" />


					</div>
				</div>
		</h:form>

		<div class="button-row">
			<h:commandButton value="Back" action="InsuranceAdminDashBoard.jsp"
				styleClass="action-btn left-btn" />
			<h:commandButton value="Home" action="InsuranceAdminMenu.jsp"
				styleClass="action-btn right-btn" />
		</div>

	</div>

</body>

	</html>
</f:view>


