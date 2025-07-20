<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
<html>
<head>
    <title>Update Insurance Company</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            background-color: #ffffff;
            margin: 50px auto;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333333;
        }

        .form-row {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #444444;
        }

        input[type="text"] {
            padding: 8px;
            border: 1px solid #cccccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .button-row {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        h\\:commandButton {
            background-color: #007bff;
            color: white;
            padding: 8px 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        h\\:commandButton:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Insurance Company</h2>
        <h:form id="companyForm">

            <div class="form-row">
                <label for="name">Enter Company Name:</label>
                <h:inputText id="name" value="#{insuranceCompanyController.company.name}" />
                <h:message for="name" styleClass="error" />
            </div>

            <div class="form-row">
                <label for="logoUrl">Enter Logo URL:</label>
                <h:inputText id="logoUrl" value="#{insuranceCompanyController.company.logoUrl}" />
                <h:message for="logoUrl" styleClass="error" />
            </div>

            <div class="form-row">
                <label for="headOffice">Enter Head Office:</label>
                <h:inputText id="headOffice" value="#{insuranceCompanyController.company.headOffice}" />
                <h:message for="headOffice" styleClass="error" />
            </div>

            <div class="form-row">
                <label for="email">Enter Contact Email:</label>
                <h:inputText id="email" value="#{insuranceCompanyController.company.contactEmail}" />
                <h:message for="email" styleClass="error" />
            </div>

            <div class="form-row">
                <label for="phone">Enter Contact Phone:</label>
                <h:inputText id="phone" value="#{insuranceCompanyController.company.contactPhone}" />
                <h:message for="phone" styleClass="error" />
            </div>

            <div class="button-row">
                <h:commandButton value="Update Company"
                    action="#{insuranceCompanyController.updateCompanyById(insuranceCompanyController.company)}" />
                <h:commandButton value="Back" action="showcompany?faces-redirect=true" />
            </div>

        </h:form>
    </div>
</body>
</html>
</f:view>
