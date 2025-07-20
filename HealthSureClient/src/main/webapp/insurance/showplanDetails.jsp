<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Insurance Plan</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e6f2ff;
            margin: 0;
            padding: 0;
        }

        .page-heading {
            background-color: #007bff;
            color: white;
            text-align: center;
            padding: 20px;
            font-size: 28px;
            font-weight: bold;
            letter-spacing: 1px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .container {
            width: 700px;
            margin: 30px auto;
            background-color: #ffffff;
            padding: 40px 50px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
        }

        .field-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
            padding-bottom: 5px;
            border-bottom: 1px solid #f0f0f0;
        }

        .field-label {
            font-weight: bold;
            color: #333;
            width: 45%;
        }

        .field-value {
            color: #555;
            width: 50%;
            text-align: left;
        }

        .button-center {
            text-align: center;
            margin-top: 40px;
        }
         <div class="button-center">

        .simple-btn {
            background-color: #28a745;
            color: white;
            padding: 10px 22px;
            border: none;
            border-radius: 6px;
            font-size: 15px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .simple-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

    <!-- ✅ Heading Outside Container -->
    <div class="page-heading">
        <h:outputText value="Insurance Plan Details" />
    </div>

    <div class="container">
        <h:form id="companyForm">

            <div class="field-row">
                <h:outputText value="Plan ID:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.planId}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Company ID:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.insuranceCompany.companyId}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Plan Name:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.planName}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Plan Type:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.planType}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Min Entry Age:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.minEntryAge}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Max Entry Age:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.maxEntryAge}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Description:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.description}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Available Cover Amounts:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.availableCoverAmounts}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Waiting Period:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.waitingPeriod}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Active On:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.activeOn}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Expire Date:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.expireDate}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Created On:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.createdOn}" styleClass="field-value" />
            </div>

            <div class="field-row">
                <h:outputText value="Periodic Diseases:" styleClass="field-label" />
                <h:outputText value="#{insurancePlanController.insurancePlan.periodicDiseases}" styleClass="field-value" />
            </div>

            <div class="button-center">
                <h:commandButton value="Back" action="showplan.jsp" styleClass="simple-btn" />
            </div>

        </h:form>
    </div>

</body>
</html>
</f:view>
