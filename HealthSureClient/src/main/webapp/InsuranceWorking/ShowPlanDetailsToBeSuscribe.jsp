<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
<f:view>
	<head>
<title>Insurance Coverage Details</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f6f8;
	margin: 0;
	padding: 20px;
}

.container {
	max-width: 1200px;
	margin: auto;
	background-color: #ffffff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

h2, h3 {
	color: #2c3e50;
	border-bottom: 2px solid #3498db;
	padding-bottom: 5px;
	margin-bottom: 20px;
	text-align: center;
}

.section {
	margin-bottom: 30px;
}

.row {
	display: flex;
	justify-content: space-between;
	margin-bottom: 15px;
	flex-wrap: wrap;
}

.field {
	flex: 1;
	min-width: 30%;
	margin: 10px;
	background-color: #ecf0f1;
	padding: 15px;
	border-radius: 8px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.05);
}

.label {
	font-weight: bold;
	color: #34495e;
	display: block;
	margin-bottom: 5px;
	font-size: 14px;
}

.value {
	color: #2c3e50;
	font-size: 15px;
}

img {
	max-height: 50px;
	border-radius: 5px;
}

.subscribe-button {
	background-color: #3498db;
	color: white;
	padding: 12px 24px;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
	margin-top: 30px;
	display: block;
	width: 200px;
	text-align: center;
}

.subscribe-button:hover {
	background-color: #2980b9;
}

.member-card {
	background-color: #ffffff;
	border: 1px solid #dcdcdc;
	border-radius: 10px;
	padding: 20px;
	margin: 15px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
	transition: transform 0.2s ease-in-out;
	display: flex;
	justify-content: space-between;
}

.member-card:hover {
	transform: scale(1.02);
}

.member-card h4 {
	margin-top: 0;
	margin-bottom: 20px;
	font-size: 18px;
	color: #2c3e50;
	border-bottom: 1px solid #3498db;
	padding-bottom: 5px;
}

.form-field {
	margin-bottom: 15px;
	display: flex;
	align-items: center;
}

.form-label {
	font-weight: bold;
	color: #34495e;
	width: 120px;
	display: inline-block;
	font-size: 14px;
}

input[type="text"], select {
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 6px;
	width: 100%;
	max-width: 250px;
	font-size: 14px;
	background-color: #fdfdfd;
}

h\:inputText, h\:selectOneMenu {
	width: 100%;
}

h\:commandButton.subscribe-button {
	background-color: #3498db;
	color: white;
	padding: 12px 24px;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
	margin-top: 30px;
	display: block;
	width: 200px;
	text-align: center;
}

h\:commandButton.subscribe-button:hover {
	background-color: #2980b9;
}

h3, h4 {
	text-align: center;
}
</style>


	</head>
	<body>

		<h:form>
			<div class="container">
				<h2>Insurance Coverage Summary</h2>

				<!-- Coverage Details -->
				<h3>Coverage Details</h3>
				<div class="section">
					<div class="row">
						<div class="field">
							<span class="label">Coverage ID:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.coverageId}" /></span>
						</div>
						<div class="field">
							<span class="label">Premium Amount:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.premiumAmount}" /></span>
						</div>
						<div class="field">
							<span class="label">Coverage Amount:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.coverageAmount}" /></span>
						</div>
					</div>
					<div class="row">
						<div class="field">
							<span class="label">Coverage Type:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.coverageType}" /></span>
						</div>
					</div>
				</div>

				<!-- Plan Information -->
				<h3>Plan Information</h3>
				<div class="section">
					<div class="row">
						<div class="field">
							<span class="label">Plan ID:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.planId}" /></span>
						</div>
						<div class="field">
							<span class="label">Plan Name:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.planName}" /></span>
						</div>
						<div class="field">
							<span class="label">Plan Type:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.planType}" /></span>
						</div>
					</div>
					<div class="row">
						<div class="field">
							<span class="label">Min Entry Age:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.minEntryAge}" /></span>
						</div>
						<div class="field">
							<span class="label">Max Entry Age:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.maxEntryAge}" /></span>
						</div>
						<div class="field">
							<span class="label">Description:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.description}" /></span>
						</div>
					</div>
					<div class="row">
						<div class="field">
							<span class="label">Available Cover Amounts:</span> <span
								class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.availableCoverAmounts}" /></span>
						</div>
						<div class="field">
							<span class="label">Waiting Period:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.waitingPeriod}" />
								months</span>
						</div>
						<div class="field">
							<span class="label">Created On:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.createdOn}" /></span>
						</div>
					</div>
					<div class="row">
						<div class="field">
							<span class="label">Active On:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.activeOn}" /></span>
						</div>
						<div class="field">
							<span class="label">Expire Date:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.expireDate}" /></span>
						</div>
						<div class="field">
							<span class="label">Periodic Diseases:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.periodicDiseases}" /></span>
						</div>
					</div>
					<div class="row">
						<div class="field">
							<span class="label">Minimum Member Allowed:</span> <span
								class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.minimumMeberAllowed}" /></span>
						</div>
						<div class="field">
							<span class="label">Maximum Member Allowed:</span> <span
								class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed}" /></span>
						</div>
					</div>
				</div>

				<!-- Insurance Company -->
				<h3>Insurance Company</h3>
				<div class="section">
					<div class="row">
						<div class="field">
							<span class="label">Company ID:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.insuranceCompany.companyId}" /></span>
						</div>
						<div class="field">
							<span class="label">Name:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.insuranceCompany.name}" /></span>
						</div>
						<div class="field">
							<span class="label">Head Office:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.insuranceCompany.headOffice}" /></span>
						</div>
					</div>
					<div class="row">
						<div class="field">
							<span class="label">Contact Email:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.insuranceCompany.contactEmail}" /></span>
						</div>
						<div class="field">
							<span class="label">Contact Phone:</span> <span class="value"><h:outputText
									value="#{insuranceSubscribedController.coverageOption.insurancePlan.insuranceCompany.contactPhone}" /></span>
						</div>
						<div class="field">
							<span class="label">Logo:</span> <span class="value"> <img
								src="<h:outputText value='#{insuranceSubscribedController.coverageOption.insurancePlan.insuranceCompany.logoUrl}' />" />
							</span>
						</div>
					</div>
				</div>
			</div>


			<!-- Dynamic Input Fields Based on Plan Type -->
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.planType eq 'FAMILY'}">
				<h4>Member 1</h4>
				<div class="member-card">

					<div class="form-field">
						<span class="form-label">Name:</span>
						<h:inputText value="#{yourBean.members[0].name}" />
					</div>

					<div class="form-field">
						<span class="form-label">Age:</span>
						<h:inputText value="#{yourBean.members[0].age}" />
					</div>

					<div class="form-field">
						<span class="form-label">Gender:</span>
						<h:selectOneMenu value="#{yourBean.members[0].gender}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Male" itemValue="MALE" />
							<f:selectItem itemLabel="Female" itemValue="FEMALE" />
						</h:selectOneMenu>
					</div>

					<div class="form-field">
						<span class="form-label">Relation:</span>
						<h:selectOneMenu value="#{yourBean.members[0].relation}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Son" itemValue="SON" />
							<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
							<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
							<f:selectItem itemLabel="Father" itemValue="FATHER" />
							<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
							<f:selectItem itemLabel="Wife" itemValue="WIFE" />
						</h:selectOneMenu>
					</div>
				</div>
				<h4>Member 2</h4>
				<div class="member-card">

					<div class="form-field">
						<span class="form-label">Name:</span>
						<h:inputText value="#{yourBean.members[0].name}" />
					</div>

					<div class="form-field">
						<span class="form-label">Age:</span>
						<h:inputText value="#{yourBean.members[0].age}" />
					</div>

					<div class="form-field">
						<span class="form-label">Gender:</span>
						<h:selectOneMenu value="#{yourBean.members[0].gender}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Male" itemValue="MALE" />
							<f:selectItem itemLabel="Female" itemValue="FEMALE" />
						</h:selectOneMenu>
					</div>

					<div class="form-field">
						<span class="form-label">Relation:</span>
						<h:selectOneMenu value="#{yourBean.members[0].relation}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Son" itemValue="SON" />
							<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
							<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
							<f:selectItem itemLabel="Father" itemValue="FATHER" />
							<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
							<f:selectItem itemLabel="Wife" itemValue="WIFE" />
						</h:selectOneMenu>
					</div>
				</div>
				<h4>Member 3</h4>
				<div class="member-card">

					<div class="form-field">
						<span class="form-label">Name:</span>
						<h:inputText value="#{yourBean.members[0].name}" />
					</div>

					<div class="form-field">
						<span class="form-label">Age:</span>
						<h:inputText value="#{yourBean.members[0].age}" />
					</div>

					<div class="form-field">
						<span class="form-label">Gender:</span>
						<h:selectOneMenu value="#{yourBean.members[0].gender}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Male" itemValue="MALE" />
							<f:selectItem itemLabel="Female" itemValue="FEMALE" />
						</h:selectOneMenu>
					</div>

					<div class="form-field">
						<span class="form-label">Relation:</span>
						<h:selectOneMenu value="#{yourBean.members[0].relation}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Son" itemValue="SON" />
							<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
							<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
							<f:selectItem itemLabel="Father" itemValue="FATHER" />
							<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
							<f:selectItem itemLabel="Wife" itemValue="WIFE" />
						</h:selectOneMenu>
					</div>
				</div>
				<h4>Member 4</h4>
				<div class="member-card">

					<div class="form-field">
						<span class="form-label">Name:</span>
						<h:inputText value="#{yourBean.members[0].name}" />
					</div>

					<div class="form-field">
						<span class="form-label">Age:</span>
						<h:inputText value="#{yourBean.members[0].age}" />
					</div>

					<div class="form-field">
						<span class="form-label">Gender:</span>
						<h:selectOneMenu value="#{yourBean.members[0].gender}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Male" itemValue="MALE" />
							<f:selectItem itemLabel="Female" itemValue="FEMALE" />
						</h:selectOneMenu>
					</div>

					<div class="form-field">
						<span class="form-label">Relation:</span>
						<h:selectOneMenu value="#{yourBean.members[0].relation}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Son" itemValue="SON" />
							<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
							<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
							<f:selectItem itemLabel="Father" itemValue="FATHER" />
							<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
							<f:selectItem itemLabel="Wife" itemValue="WIFE" />
						</h:selectOneMenu>
					</div>
				</div>
			</h:panelGroup>


			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.planType ne 'FAMILY'}">
				<h4>INDIVIDUAL</h4>
				<div class="member-card">

					<div class="form-field">
						<span class="form-label">Name:</span>
						<h:inputText value="#{yourBean.members[0].name}" />
					</div>

					<div class="form-field">
						<span class="form-label">Age:</span>
						<h:inputText value="#{yourBean.members[0].age}" />
					</div>

					<div class="form-field">
						<span class="form-label">Gender:</span>
						<h:selectOneMenu value="#{yourBean.members[0].gender}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Male" itemValue="MALE" />
							<f:selectItem itemLabel="Female" itemValue="FEMALE" />
						</h:selectOneMenu>
					</div>

					<div class="form-field">
						<span class="form-label">Relation:</span>
						<h:selectOneMenu value="#{yourBean.members[0].relation}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Son" itemValue="SON" />
							<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
							<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
							<f:selectItem itemLabel="Father" itemValue="FATHER" />
							<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
							<f:selectItem itemLabel="Wife" itemValue="WIFE" />
						</h:selectOneMenu>
					</div>
				</div>
			</h:panelGroup>




			<div>
				<h:commandButton value="subscribe" action="null" />
			</div>

		</h:form>
	</body>
</f:view>
</html>