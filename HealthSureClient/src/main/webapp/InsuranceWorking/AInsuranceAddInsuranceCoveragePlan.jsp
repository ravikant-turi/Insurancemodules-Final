<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<!DOCTYPE html>
	<html>
<head>
<title>Insurance Plan and Coverage Options</title>
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

.center-button-container {
	display: flex;
	justify-content: center;
	margin-top: 1px;
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

.button-row {
	display: flex;
	justify-content: space-between;
	margin-top: 10px;
}

.action-btn {
	padding: 10px 20px;
	font-size: 14px;
	cursor: pointer;
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
</style>

</head>
<body>
	<div class="main-container">

		<!-- Add Insurance Plan Form -->
		<div class="header-container">
			<h3 class="section-title">Add Insurance Plan</h3>
		</div>

		<h:form id="companyForm">
			<div class="form-box">

				<!-- Row 1 -->
				<div class="form-row">
					<div class="form-group">
						<label>Company ID:</label>
						<h:inputText id="companyId"
							value="#{createInsuranceController.insuranceCompany.companyId}" />
						<br />
						<h:message for="companyId" styleClass="error" />

					</div>
					<div class="form-group">
						<label>Plan Name:</label>
						<h:inputText id="planName"
							value="#{createInsuranceController.insurancePlan.planName}" />
						<h:message for="planName" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<h:outputLabel escape="false"
							value=" <span style='color:red'>*</span>PlanType: " />
						<h:selectOneMenu id="planType"
							value="#{createInsuranceController.insurancePlan.planType}">
							<f:selectItem itemLabel="--Select--" itemValue="" />
							<f:selectItem itemLabel="INDIVIDUAL" itemValue="SELF" />
							<f:selectItem itemLabel="FAMILY" itemValue="FAMILY" />
							<f:selectItem itemLabel="SENIOR" itemValue="SENIOR" />
							<f:selectItem itemLabel="SELF" itemValue="CRITICAL_ILLNESS" />
							<f:selectItem itemLabel="EPIDEMIC_PROTECT"
								itemValue="EPIDEMIC_PROTECT" />
							<f:selectItem itemLabel="SUPER_ELITE" itemValue="SUPER_ELITE" />
						</h:selectOneMenu>
						<br />
						<h:message for="planType" styleClass="error" />

					</div>


				</div>

				<!-- Row 2 -->
				<div class="form-row">
					<div class="form-group">
						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Min Age: " />
						<h:inputText id="minAge"
							value="#{createInsuranceController.insurancePlan.minEntryAge}" />
						<h:message for="minAge" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Max Age: " />
						<h:inputText id="maxAge"
							value="#{createInsuranceController.insurancePlan.maxEntryAge}" />
						<h:message for="maxAge" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Description: " />
						<h:inputTextarea id="description"
							value="#{createInsuranceController.insurancePlan.description}"
							rows="2" cols="20" />
						<h:message for="description" styleClass="error" />
						<br />

					</div>
				</div>

				<!-- Row 3 -->
				<div class="form-row">
					<div class="form-group">
						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Available Amount: " />
						<h:inputText id="cover"
							value="#{createInsuranceController.insurancePlan.availableCoverAmounts}" />
						<h:message for="cover" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Waiting Period: " />
						<h:inputText id="waitingPeriod"
							value="#{createInsuranceController.insurancePlan.waitingPeriod}" />
						<h:message for="waitingPeriod" styleClass="error" />
						<br />

					</div>
					<div class="form-group">
						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Active On: " />
						<h:inputText id="activeOn"
							value="#{createInsuranceController.insurancePlan.activeOn}">
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
						<h:selectOneMenu id="periodicDiseases"
							value="#{createInsuranceController.insurancePlan.periodicDiseases}">
							<f:selectItem itemLabel="--Select--" itemValue="" />
							<f:selectItem itemLabel="YES" itemValue="YES" />
							<f:selectItem itemLabel="NO" itemValue="NO" />
						</h:selectOneMenu>
						<br />
						<h:message for="periodicDiseases" styleClass="error" />
					</div>
					<br />
					<div class="form-group">
						<h:outputLabel escape="false"
							value=" <span style='color:red'>*</span>DURATION: " />
						<h:selectOneMenu id="yearsToAdd"
							value="#{createInsuranceController.yearsToAdd}">
							<f:selectItem itemLabel="--Select--" itemValue="0" />
							<f:selectItem itemLabel="1 Years" itemValue="1" />
							<f:selectItem itemLabel="2 Years" itemValue="2" />
							<f:selectItem itemLabel="3 Years" itemValue="3" />
							<f:selectItem itemLabel="5 Years" itemValue="5" />
							<f:selectItem itemLabel="10 Years" itemValue="10" />
							<f:selectItem itemLabel="12 Years" itemValue="12" />
						</h:selectOneMenu>
						<br />
						<h:message for="yearsToAdd" styleClass="error" />

					</div>
				</div>

				<!-- Coverage Options -->
				<h3>Add Coverage Options</h3>
				<div class="form-row">

					<!-- Coverage Option 1 -->
					<div class="coverage-box">

						<h3>Add Silver Option</h3>

						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Premium Amount: " />
						<h:inputText id="PremiumAmount"
							value="#{createInsuranceController.coverageOption1.premiumAmount}" />
						<h:message for="PremiumAmount" styleClass="error" />

						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>Coverage Amount: :" />
						<h:inputText id="CoverageAmount"
							value="#{createInsuranceController.coverageOption1.coverageAmount}" />
						<h:message for="CoverageAmount" styleClass="error" />

						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>MaximumMemberAllowed :" />
						<h:inputText id="maximumMemberAllowed"
							value="#{createInsuranceController.coverageOption1.maximumMemberAllowed}" />
						<h:message for="maximumMemberAllowed" styleClass="error" />

						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>MinimumMeberAllowed: :" />
						<h:inputText id="minimumMeberAllowed"
							value="#{createInsuranceController.coverageOption1.minimumMeberAllowed}" />
						<h:message for="minimumMeberAllowed" styleClass="error" />

						<h:outputLabel escape="false"
							value=" <span style='color:red'>*</span>CoverageType " />
						<h:selectOneMenu id="coverageType"
							value="#{createInsuranceController.coverageOption1.coverageType}">
							<f:selectItem itemLabel="--Select--" itemValue="" />
							<f:selectItem itemLabel="SILVER" itemValue="SILVER" />
							<f:selectItem itemLabel="GOLD" itemValue="GOLD" />
							<f:selectItem itemLabel="PLATINUM" itemValue="PLATINUM" />
						</h:selectOneMenu>
						<h:message for="coverageType" styleClass="error" />

						<br /> <br />
						<!-- Multiple selection for Members -->
						

  <h:outputLabel value="Select Members:" />
<br/>
  <div style="display: flex; flex-wrap: wrap; justify-content: space-between;  gap: 10px; width: 240px;">
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['DAUGHTER1']}" /> Daughter</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['DAUGHTER2']}" /> Daughter</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['SON1']}" /> Son</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['SON2']}" /> Son</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['FATHER']}" /> Father</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['MOTHER']}" /> Mother</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['HUSBAND']}" /> Husband</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['WIFE']}" /> Wife</label></div>
  </div>






					</div>

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
								<!-- Multiple selection for Members -->
						
<br/><br/>
  <h:outputLabel value="Select Members:" />
<br/>
  <div style="display: flex; flex-wrap: wrap; justify-content: space-between; gap: 10px; width: 240px;">
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['DAUGHTER1']}" /> Daughter</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['DAUGHTER2']}" /> Daughter</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['SON1']}" /> Son</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['SON2']}" /> Son</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['FATHER']}" /> Father</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['MOTHER']}" /> Mother</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['HUSBAND']}" /> Husband</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['WIFE']}" /> Wife</label></div>
  </div>

					</div>

					<!-- Coverage Option 3 -->
					<div class="coverage-box">
						<h3>Add Platinum Option</h3>
						<label>Premium Amount:</label>
						<h:inputText
							value="#{createInsuranceController.coverageOption3.premiumAmount}" />

						<label>Coverage Amount:</label>
						<h:inputText
							value="#{createInsuranceController.coverageOption3.coverageAmount}" />

						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>MaximumMemberAllowed :" />
						<h:inputText id="maximumMemberAllowed3"
							value="#{createInsuranceController.coverageOption3.maximumMemberAllowed}" />
						<h:message for="maximumMemberAllowed3" styleClass="error" />

						<h:outputLabel escape="false"
							value="<span style='color:red'>*</span>MinimumMeberAllowed: :" />
						<h:inputText id="minimumMeberAllowed3"
							value="#{createInsuranceController.coverageOption3.minimumMeberAllowed}" />
						<h:message for="minimumMeberAllowed3" styleClass="error" />

						<h:outputLabel escape="false"
							value=" <span style='color:red'>*</span>CoverageType " />
						<h:selectOneMenu id="coverageType3"
							value="#{createInsuranceController.coverageOption3.coverageType}">
							<f:selectItem itemLabel="--Select--" itemValue="" />
							<f:selectItem itemLabel="SILVER" itemValue="SILVER" />
							<f:selectItem itemLabel="GOLD" itemValue="GOLD" />
							<f:selectItem itemLabel="PLATINUM" itemValue="PLATINUM" />
						</h:selectOneMenu>
						<h:message for="coverageType3" styleClass="error" />
						<br /> <br />
								<!-- Multiple selection for Members -->
						

  <h:outputLabel value="Select Members:" />
<br/>
  <div style="display: flex; flex-wrap: wrap; justify-content: space-between;  gap: 10px; width: 240px;">
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['DAUGHTER1']}" /> Daughter</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['DAUGHTER2']}" /> Daughter</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['SON1']}" /> Son</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['SON2']}" /> Son</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['FATHER']}" /> Father</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['MOTHER']}" /> Mother</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['HUSBAND']}" /> Husband</label></div>
    <div style="width: 100px;"><label><h:selectBooleanCheckbox value="#{createInsuranceController.relationMap['WIFE']}" /> Wife</label></div>
  </div>

					</div>
				</div>


			</div>
			<!-- Submit Button -->

			<div class="button-row">

				<h:commandButton value="Cncel" action="InsuranceAdminDashBoard.jsp"
					styleClass="action-btn right-btn" />
				<h:commandButton value="Add"
					action="#{createInsuranceController.addInsurancePlanWithCoveragePlan}"
					styleClass="action-btn" />
			</div>
		</h:form>
	</div>
	<h:messages globalOnly="true" style="color:red" />
</body>

	</html>
</f:view>


