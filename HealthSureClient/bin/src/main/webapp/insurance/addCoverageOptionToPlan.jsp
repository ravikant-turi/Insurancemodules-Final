<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Insurance Coverage Option</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    .form-container {
        width: 500px;
        margin: 40px auto;
        background-color: #ecf0f1;
        padding: 30px 40px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    .form-title {
        text-align: center;
        background-color: #27ae60;
        color: white;
        padding: 12px;
        border-radius: 6px;
        font-size: 22px;
        margin-bottom: 30px;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-label {
        font-weight: bold;
        display: block;
        margin-bottom: 6px;
        color: #333;
    }

    .form-input {
        width: 100%;
    }

    .form-button {
        text-align: center;
        margin-top: 30px;
    }

    .submit-btn {
        background-color: #3498db;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        font-size: 14px;
        cursor: pointer;
    }

    .submit-btn:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>

    <div class="form-container">
        <div class="form-title">
            <h:outputText value="Add Insurance Coverage Option" />
        </div>

        <h:form>

            <!-- Plan ID Display -->
            <div class="form-group">
                <label class="form-label">Plan ID:</label>
                <h:outputText value="#{insuranceCoverageOptionController.insurancePlan.planId}" />
            </div>

            <!-- Premium Amount -->
            <div class="form-group">
                <label class="form-label">Premium Amount:</label>
                <h:inputText value="#{insuranceCoverageOptionController.coverageOption.premiumAmount}" styleClass="form-input" />
            </div>

            <!-- Coverage Amount -->
            <div class="form-group">
                <label class="form-label">Coverage Amount:</label>
                <h:inputText value="#{insuranceCoverageOptionController.coverageOption.coverageAmount}" styleClass="form-input" />
            </div>

            <!-- Status -->
            <div class="form-group">
                <label class="form-label">Status:</label>
                <h:inputText value="#{insuranceCoverageOptionController.coverageOption.status}" styleClass="form-input" />
            </div>

            <!-- Submit Button -->
            <div class="form-button">
                <h:commandButton value="Add Coverage Option"
                    action="#{insuranceCoverageOptionController.addcoverageOptionToPlanHelper}"
                    styleClass="submit-btn" />
            </div>

        </h:form>
        <h:messages globalOnly="true" layout="list" style="color: green; font-weight: bold; margin-bottom: 20px;" />
        
    </div>

</body>
</html>
</f:view>
