<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Insurance Plan</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-box {
            background-color: #fff;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 500px;
            margin-top:50px;
        }

        h2 {
            text-align: center;
            color: #007BFF;
            margin-bottom: 30px; /* Space between header and form */
            margin-top: 180px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
            margin-bottom: 5px;
        }

        input[type="text"], textarea, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .error {
            color: red;
            font-size: 12px;
        }

        .submit-button {
            background-color: #007BFF;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 15px;
            cursor: pointer;
            width: 100%;
            margin-top: 20px;
        }

        .submit-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="form-box">
        <h2>Add Insurance Plan</h2>

        <h:form id="companyForm">

            <label>Company ID:</label>
            <h:inputText id="companyId" value="#{insuranceCompany.companyId}" />
            <h:message for="companyId" styleClass="error" /><br />

            <label>Plan Name:</label>
            <h:inputText id="planName" value="#{insurancePlan.planName}" />
            <h:message for="planName" styleClass="error" /><br />

            <label>Plan Type:</label>
            <h:selectOneMenu id="planType" value="#{insurancePlan.planType}">
                <f:selectItem itemLabel="--Select--" itemValue="" />
                <f:selectItem itemLabel="SELF" itemValue="INDIVIDUAL" />
                <f:selectItem itemLabel="FAMILY" itemValue="FAMILY" />
                <f:selectItem itemLabel="SENIOR" itemValue="SENIOR" />
                <f:selectItem itemLabel="SELF" itemValue="CRITICAL_ILLNESS" />
                <f:selectItem itemLabel="FAMILY" itemValue="EPIDEMIC_PROTECT" />
                <f:selectItem itemLabel="SENIOR" itemValue="SUPER_ELITE" />
            </h:selectOneMenu>
            <h:message for="planType" styleClass="error" /><br />

            <label>Min Entry Age:</label>
            <h:inputText id="minAge" value="#{insurancePlan.minEntryAge}" />
            <h:message for="minAge" styleClass="error" /><br />

            <label>Max Entry Age:</label>
            <h:inputText id="maxAge" value="#{insurancePlan.maxEntryAge}" />
            <h:message for="maxAge" styleClass="error" /><br />

            <label>Description:</label>
            <h:inputTextarea id="description" value="#{insurancePlan.description}" rows="3" cols="30" />
            <h:message for="description" styleClass="error" /><br />

            <label>Cover Amounts:</label>
            <h:inputText id="cover" value="#{insurancePlan.availableCoverAmounts}" />
            <h:message for="cover" styleClass="error" /><br />

            <label>Waiting Period:</label>
            <h:inputText id="waitingPeriod" value="#{insurancePlan.waitingPeriod}" />
            <h:message for="waitingPeriod" styleClass="error" /><br />

            <label>Active On (yyyy-MM-dd):</label>
            <h:inputText id="activeOn" value="#{insurancePlan.activeOn}">
                <f:convertDateTime pattern="yyyy-MM-dd" />
            </h:inputText>
            <h:message for="activeOn" styleClass="error" /><br />

            <label>Periodic Diseases:</label>
            <h:selectOneMenu id="periodicDiseases" value="#{insurancePlan.periodicDiseases}">
                <f:selectItem itemLabel="--Select--" itemValue="" />
                <f:selectItem itemLabel="YES" itemValue="YES" />
                <f:selectItem itemLabel="NO" itemValue="NO" />
            </h:selectOneMenu>
            <h:message for="periodicDiseases" styleClass="error" /><br />

            <h:commandButton value="Add Plan" action="#{insurancePlanController.addPlan(insurancePlan)}" styleClass="submit-button" />

        </h:form>
    </div>

</body>
</html>
</f:view>
