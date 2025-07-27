<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<html>

<head>
<title>Insurance Coverage Details</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f6f8;
	margin: 1;
	padding: 21px;
}

.container {
	max-width: 1211px;
	margin: auto;
	background-color: #ffffff;
	padding: 31px;
	border-radius: 11px;
	box-shadow: 1 1 15px rgba(1, 1, 1, 1.1);
}

h2, h3 {
	color: #2c3e51;
	border-bottom: 2px solid #3498db;
	padding-bottom: 5px;
	margin-bottom: 21px;
	text-align: center;
}

.section {
	margin-bottom: 31px;
}

.row {
	display: flex;
	justify-content: space-between;
	margin-bottom: 15px;
	flex-wrap: wrap;
}

.field {
	flex: 1;
	min-width: 31%;
	margin: 11px;
	background-color: #ecf1f1;
	padding: 15px;
	border-radius: 8px;
	box-shadow: 1 1 5px rgba(1, 1, 1, 1.15);
}

.label {
	font-weight: bold;
	color: #34495e;
	display: block;
	margin-bottom: 5px;
	font-size: 14px;
}

.value {
	color: #2c3e51;
	font-size: 15px;
}

img {
	max-height: 51px;
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
	margin-top: 31px;
	display: block;
	width: 211px;
	text-align: center;
}

.subscribe-button:hover {
	background-color: #2981b9;
}

.member-card {
	background-color: #ffffff;
	border: 1px solid #dcdcdc;
	border-radius: 11px;
	padding: 21px;
	margin: 15px;
	box-shadow: 1 2px 8px rgba(1, 1, 1, 1.15);
	transition: transform 1.2s ease-in-out;
	display: flex;
	justify-content: space-between;
}

.member-card:hover {
	transform: scale(1.12);
}

.member-card h4 {
	margin-top: 1;
	margin-bottom: 21px;
	font-size: 18px;
	color: #2c3e51;
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
	width: 121px;
	display: inline-block;
	font-size: 14px;
}

input[type="text"], select {
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 6px;
	width: 111%;
	max-width: 251px;
	font-size: 14px;
	background-color: #fdfdfd;
}

h\:inputText, h\:selectOneMenu {
	width: 111%;
}

h3, h4 {
	text-align: center;
}
</style>


</head>
<body>

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
					<span class="label">Plan fullName:</span> <span class="value"><h:outputText
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
					<span class="label">fullName:</span> <span class="value"><h:outputText
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

			</div>
		</div>
	</div>

	<h:form id="form">

		<h:panelGroup
			rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.planType != 'FAMILY'}">
			<h3>Plan Information - INDIVIDUAL</h3>
			<div class="member-section">
				<label>Enter Register HID:</label>
				<h:inputText id="hid"
					value="#{insuranceSubscribedController.searchRecipeintId}" />

				<h:commandButton value="Subscribe"
					action="#{insuranceSubscribedController.fetchRecipientDetailsIndividual(insuranceSubscribedController.subscribedMember1,insuranceSubscribedController.searchRecipeintId)}" />
				<br />
				<h:message for="hid" style="color:red;" />
				<br /> <br /> <label>Full Name:</label>
				<h:outputText
					value="#{insuranceSubscribedController.subscribedMember1.fullName}" />
				<br /> <label>Age:</label>
				<h:outputText
					value="#{insuranceSubscribedController.subscribedMember1.age}" />
				<br /> <label>Gender:</label>
				<h:outputText
					value="#{insuranceSubscribedController.subscribedMember1.gender}" />
				<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

			</div>
		</h:panelGroup>

		<h:panelGroup
			rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.planType eq 'FAMILY'}">
			<h3>Plan Information - FAMILY</h3>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 1}">

				<h3>MEMBER-1</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid1"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember1,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid1" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember1.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember1.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember1.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 1}">

				<h3>MEMBER-2</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid2"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember2,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid2" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember2.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember2.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember2.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 2}">

				<h3>MEMBER-3</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid3"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember3,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid3" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember3.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember3.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember3.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 3}">

				<h3>MEMBER-4</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid4"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember4,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid4" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember4.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember4.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember4.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 4}">

				<h3>MEMBER-5</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid5"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember5,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid5" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember5.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember5.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember5.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 5}">

				<h3>MEMBER-6</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid6"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember6,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid6" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember6.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember6.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember6.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 6}">

				<h3>MEMBER-7</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid7"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember7,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid7" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember7.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember7.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember7.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 7}">

				<h3>MEMBER-8</h3>

				<div class="member-section">
					<label>Enter Register HID:</label>
					<h:inputText id="hid8"
						value="#{insuranceSubscribedController.searchRecipeintId}" />

					<h:commandButton value="SearchMember"
						action="#{insuranceSubscribedController.fetchRecipientDetailsFamily(insuranceSubscribedController.subscribedMember8,insuranceSubscribedController.searchRecipeintId)}" />
					<br />
					<h:message for="hid8" style="color:red;" />
					<br /> <br /> <label>Full Name:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember8.fullName}" />
					<br /> <label>Age:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember8.age}" />
					<br /> <label>Gender:</label>
					<h:outputText
						value="#{insuranceSubscribedController.subscribedMember8.gender}" />
					<br /> <br /> <label>Relation With Proposer: INDIVIDUAL</label>

				</div>
			</h:panelGroup>
		</h:panelGroup>

	</h:form>

</body>
</f:view>
</html>