<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Insurance Plan List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.header-bar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #3498db;
	padding: 10px 30px;
	border-radius: 5px;
	color: white;
	margin: 20px auto;
	width: 90%;
	box-sizing: border-box;
}

.header-bar h1 {
	margin: 0;
	font-size: 24px;
}

.header-bar form {
	margin: 0;
}

.header-bar .add-btn {
	background-color: #2ecc71;
	color: white;
	border: none;
	padding: 6px 14px;
	border-radius: 4px;
	cursor: pointer;
	font-size: 14px;
}
.header-bar .add-btn:hover {
	background-color: #27ae60;
}
table {
	width: 90%;
	margin: 20px auto;
	border-collapse: collapse;
}
th {
	background-color: #2980b9;
	color: white;
	padding: 8px;
}
td {
	background-color: #ecf0f1;
	padding: 8px;
	text-align: center;
}
tr:nth-child(even) td {
	background-color: #d0e4f7;
}
tr:hover td {
	background-color: #b2bec3;
}
table, th, td {
	border: 1px solid #34495e;
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

</style>
</head>
<body>

	<!-- ✅ Header with Add Button -->
	<div class="header-bar">
		<h1>Insurance Plan List</h1>
		<h:form>
			<h:commandButton value="Add" action="Testing?faces-redirect=true"
				styleClass="action-btn" style="background-color:gray"
				 />
		</h:form>
	</div>

	<!-- ✅ Data Table -->
	<h:dataTable value="#{insurancePlanController.findAllPlan()}"
		var="plan" border="1" styleClass="insuranceTable">


		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Plan Name" />
			</f:facet>
			<h:outputText value="#{plan.planName}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Type" />
			</f:facet>
			<h:outputText value="#{plan.planType}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Covers" />
			</f:facet>
			<h:outputText value="#{plan.availableCoverAmounts}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Waiting Period" />
			</f:facet>
			<h:outputText value="#{plan.waitingPeriod}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Expire Date" />
			</f:facet>
			<h:outputText value="#{plan.expireDate}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Active On" />
			</f:facet>
			<h:outputText value="#{plan.activeOn}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Periodic Diseases" />
			</f:facet>
			<h:outputText value="#{plan.periodicDiseases}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Description" />
			</f:facet>
			<h:outputText value="#{plan.description}" />
		</h:column>

		
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Update" />
			</f:facet>
			<h:form>
				<h:commandButton value="Update" styleClass="action-btn"
					action="#{insurancePlanController.showPlanDetailsToUpdate(plan.planId)}" />
			</h:form>
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Details" />
			</f:facet>
			<h:form>
				<h:commandButton value="Details" styleClass="action-btn"
					action="#{insurancePlanController.showPlanDetailsWithCoveragePlan(plan.planId)}" />
			</h:form>
		</h:column>
		

	</h:dataTable>

	<h:messages globalOnly="true" style="color:red" />

</body>
	</html>
</f:view>
