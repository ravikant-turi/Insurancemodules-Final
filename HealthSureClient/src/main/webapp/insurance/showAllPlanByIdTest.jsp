<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Insurance Coverage Option List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.button-center {
	text-align: center;
	margin-top: 40px;
}

h1 {
	text-align: center;
	color: #2c3e50;
	background-color: #3498db;
	padding: 10px;
	border-radius: 5px;
	color: white;
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
</style>
</head>
<body>

	<h1>Insurance Coverage Option List</h1>

	<h:form>
		<h:dataTable
			value="#{insurancePlanController.planwithCovrageDetailsList}"
			var="plan" border="1">

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Coverage ID" />
				</f:facet>
				<h:outputText value="#{plan.coverageId}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Plan ID" />
				</f:facet>
				<h:outputText value="#{plan.insurancePlan.planId}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Premium Amount" />
				</f:facet>
				<h:outputText value="#{plan.premiumAmount}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Coverage Amount" />
				</f:facet>
				<h:outputText value="#{plan.coverageAmount}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Status" />
				</f:facet>
				<h:outputText value="#{plan.status}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Details" />
				</f:facet>
				<h:commandButton value="Details"
					action="searchcoveragedetails.jsp" />
			</h:column>

		</h:dataTable>
		<div class="button-center">

			<h:commandButton value="Back" action="showplan.jsp"
				styleClass="simple-btn" />
		</div>
	</h:form>

</body>
	</html>
</f:view>
