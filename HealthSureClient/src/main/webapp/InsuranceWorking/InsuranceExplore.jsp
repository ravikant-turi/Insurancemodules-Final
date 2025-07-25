<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
<f:view>
	<head>
<title>Explore Insurance Plans</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0f2f5;
	margin: 0;
	padding: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

h2, h3 {
	color: #2c3e50;
	text-align: center;
}

.filter-links {
	margin-bottom: 20px;
	text-align: center;
}

.filter-links .filter-button {
	background-color: #3498db;
	color: white;
	border: none;
	padding: 10px 16px;
	margin: 6px;
	border-radius: 6px;
	cursor: pointer;
	font-weight: bold;
	text-decoration: none;
	display: inline-block;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
	transition: background-color 0.3s, transform 0.2s;
}

.filter-links .filter-button:hover {
	background-color: #2980b9;
	transform: translateY(-2px);
}

.card-container {
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 30px; /* More space between cards */
	width: 100%;
	max-width: 1000px;
}

.card {
	width: 100%;
	border: 1px solid #e0e0e0;
	border-radius: 16px; /* More rounded corners */
	padding: 25px;
	background-color: #ffffff; /* Brighter white */
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
	transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.card:hover {
	box-shadow:  rgba(0, 0, 0, 0.12);
}

.card-columns {
	display: flex;
	gap: 40px;
	flex-wrap: wrap;
}

.card-column {
	flex: 1;
	min-width: 300px;
}

.card-item {
	margin-bottom: 16px;
}

.card-label {
	font-weight: 600;
	color: #34495e;
	display: inline-block;
	width: 150px;
}

.card-button {
	text-align: right;
	margin-top: 20px;
}

.card-button input[type="submit"] {
	background-color: #27ae60;
	color: white;
	border: none;
	padding: 12px 20px;
	border-radius: 6px;
	cursor: pointer;
	font-weight: bold;
	font-size: 15px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
	transition: background-color 0.3s, transform 0.2s;
}

.card-button input[type="submit"]:hover {
	background-color: #219150;
	transform: translateY(-2px);
}
</style>



	</head>
	<body>

		<h:form>
			<h2>EXPLORE INSURANCE POLICY</h2>
			<div class="filter-links">
				<h:commandLink value="FAMILY"
					action="#{insuranceSubscribedController.setSelectedPlanType('FAMILY')}"
					styleClass="filter-button" />
				<h:commandLink value="SELF"
					action="#{insuranceSubscribedController.setSelectedPlanType('SELF')}"
					styleClass="filter-button" />
				<h:commandLink value="SENIOR"
					action="#{insuranceSubscribedController.setSelectedPlanType('SENIOR')}"
					styleClass="filter-button" />
				<h:commandLink value="CRITICAL_ILLNESS"
					action="#{insuranceSubscribedController.setSelectedPlanType('CRITICAL_ILLNESS')}"
					styleClass="filter-button" />
				<h:commandLink value="EPIDEMIC_PROTECT"
					action="#{insuranceSubscribedController.setSelectedPlanType('EPIDEMIC_PROTECT')}"
					styleClass="filter-button" />
				<h:commandLink value="SUPER_ELITE"
					action="#{insuranceSubscribedController.setSelectedPlanType('SUPER_ELITE')}"
					styleClass="filter-button" />
				<h:commandLink value="Show All"
					action="#{insuranceSubscribedController.setSelectedPlanType(null)}"
					styleClass="filter-button" />
			</div>


			<h3>

				<h:outputText
					value="#{insuranceSubscribedController.selectedPlanType}" />
			</h3>

			<div class="card-container">
				<h:dataTable
					value="#{insuranceSubscribedController.filteredCoverageOptions}"
					var="option">
					<h:column>
						<div class="card">
							<div class="card-columns">
								<div class="card-column">
									<div class="card-item">
										<span class="card-label"> Policy Id:</span>
										<h:outputText value="#{option.coverageId}" />
									</div>
									<div class="card-item">
										<span class="card-label">CoverageType:</span>
										<h:outputText value="#{option.coverageType}" />
									</div>
									<div class="card-item">
										<span class="card-label">Premium Amount:</span>
										<h:outputText value="#{option.premiumAmount}" />
									</div>
									<div class="card-item">
										<span class="card-label">Coverage Amount:</span>
										<h:outputText value="#{option.coverageAmount}" />
									</div>

									<div class="card-item">
										<span class="card-label">Active On:</span>
										<h:outputText value="#{option.insurancePlan.activeOn}" />
									</div>
								</div>
								<div class="card-column">
									<div class="card-item">
										<span class="card-label">Plan Name:</span>
										<h:outputText value="#{option.insurancePlan.planName}" />
									</div>
									<div class="card-item">
										<span class="card-label">Plan Type:</span>
										<h:outputText value="#{option.insurancePlan.planType}" />
									</div>
									<div class="card-item">
										<span class="card-label">Company Name:</span>
										<h:outputText
											value="#{option.insurancePlan.insuranceCompany.name}" />
									</div>
									<div class="card-item">
										<span class="card-label">ExpireDate :</span>
										<h:outputText value="#{option.insurancePlan.expireDate}" />
									</div>
									<div class="card-item">
										<span class="card-label">Waiting Month :</span>
										<h:outputText value="#{option.insurancePlan.waitingPeriod}" />
									</div>
								</div>
							</div>
							<div class="card-button">
								<h:commandButton value="View Details"
									action="#{insuranceSubscribedController.showPlicyDetailsToSuscribe(option.coverageId)}" />
							</div>
						</div>

					</h:column>
				</h:dataTable>
			</div>
		</h:form>


	</body>
</f:view>
</html>