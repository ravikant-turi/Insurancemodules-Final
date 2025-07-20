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
<!-- Success Message Div -->
	<h:outputText value="#{insuranceCoverageOptionController.showSuccessMessage}"
		style="display: block; color: green; font-weight: bold; 
                     text-align: center; margin: 20px auto; font-size: 16px;"
		id="successBox" />
	<!-- JavaScript to auto-hide after 2 seconds -->
	<script>
		window.addEventListener('load', function() {
			var box = document.getElementById('successBox');
			if (box && box.style.display !== 'none') {
				setTimeout(function() {
					box.style.display = 'none';
				}, 2000);
			}
		});
	</script>
	<h:form>
		<h:dataTable
			value="#{insuranceCoverageOptionController.findAllcoverageOption()}"
			var="cov" border="1">

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Coverage ID" />
				</f:facet>
				<h:outputText value="#{cov.coverageId}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Plan ID" />
				</f:facet>
				<h:outputText value="#{cov.insurancePlan.planId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Plan ID" />
				</f:facet>
				<h:outputText value="#{cov.insurancePlan.planName}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Premium Amount" />
				</f:facet>
				<h:outputText value="#{cov.premiumAmount}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Coverage Amount" />
				</f:facet>
				<h:outputText value="#{cov.coverageAmount}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Status" />
				</f:facet>
				<h:outputText value="#{cov.status}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="DETAILS" />
				</f:facet>
				<h:commandButton value="Search"
					action="#{insuranceCoverageOptionController.searchStatus(cov)}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="DELETE" />
				</f:facet>
				<h:commandButton value="DELETE"
					action="#{insuranceCoverageOptionController.deleteCoverageOptions(cov)}"
					onclick="return confirm('Are you sure you want to delete this company?');" />
				
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="UPDATE" />
				</f:facet>
				<h:commandButton value="UPDATE"
					action="#{insuranceCoverageOptionController.helpUpdatemethod(cov)}" />
			</h:column>

		</h:dataTable>
	</h:form>
	<div>
		<f:facet name="header">
			<h:outputLabel value="Add" />
		</f:facet>
		<h:form>
			<h:commandButton value="Add" action="addcoverageOption?faces-redirect=true" />

		</h:form>
	</div>



	<h:messages globalOnly="true" style="color:red" />
</body>
	</html>
</f:view>
