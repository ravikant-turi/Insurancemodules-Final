<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Insurance Company List</title>
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

<
style>.success {
	display: block;
	background-color: #d4edda;
	color: #155724;
	font-weight: bold;
	text-align: center;
	margin: 20px auto;
	padding: 12px 20px;
	font-size: 16px;
	border: 1px solid #c3e6cb;
	border-radius: 6px;
	width: 60%;
	animation: fadeIn 0.8s ease-out;
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(-10px);
}

to {
	opacity: 1;
	transform: translateY(0);
}
}
</style>

</style>

</head>
<body>

	<h1>Insurance Company List</h1>

	<!-- Success Message Div -->
	<h:outputText value="#{insuranceCompanyController.showSuccessMessage}"
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



	<h:dataTable value="#{insuranceCompanyController.findAllCompany()}"
		var="company" border="1">

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Company ID" />
			</f:facet>
			<h:outputText value="#{company.companyId}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Company Name" />
			</f:facet>
			<h:outputText value="#{company.name}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Logo URL" />
			</f:facet>
			<h:outputText value="#{company.logoUrl}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Contact Email" />
			</f:facet>
			<h:outputText value="#{company.contactEmail}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Head Office" />
			</f:facet>
			<h:outputText value="#{company.headOffice}" />
		</h:column>

		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Contact Phone" />
			</f:facet>
			<h:outputText value="#{company.contactPhone}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Delete" />
			</f:facet>
			<h:form>
				<h:commandButton value="Delete"
					action="#{insuranceCompanyController.deleteCompanyById(company.companyId)}"
					onclick="return confirm('Are you sure you want to delete this company?');" />

			</h:form>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Update" />
			</f:facet>
			<h:form>
				<h:commandButton value="Update"
					action="#{insuranceCompanyController.findCompnayById(company.companyId)}"
					 />

			</h:form>
		</h:column>

	</h:dataTable>
	<div>
			<f:facet name="header">
				<h:outputLabel value="Add" />
			</f:facet>
			<h:form>
				<h:commandButton value="Add"
					action="addcompany?faces-redirect=true"
					 />

			</h:form>
		</div>
		
		
		  
	<h:messages globalOnly="true" style="color:red" />


</body>
	</html>
</f:view>
