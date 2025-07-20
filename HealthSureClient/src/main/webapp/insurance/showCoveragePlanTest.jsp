<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coverage Option Details</title>
<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f4f6f9;
    margin: 0;
    padding: 40px;
    color: #333;
    display: flex;
    justify-content: center;
   -items: flex-start;
    min-height: 100vh;
}

h1 {
    color: #2c3e50;
    margin-bottom: 30px;
    font-weight: 700;
    font-size: 32px;
    text-align: center;
    position: relative;
}

h1::after {
    content: '';
    display: block;
    width: 60px;
    height: 3px;
    background: #3498db;
    margin: 8px auto 0 auto;
    border-radius: 2px;
}

.details-container {
    background: #fff;
    padding: 30px 40px;
    border-radius: 12px;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 1200px;
}

.details-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 20px;
}

.detail-block {
    background-color: #ffffff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
    display: flex;
    flex-direction: column;
    justify-content: center;
    min-height: 100px;
}

.label {
    font-weight: 600;
    color: #555;
    margin-bottom: 8px;
    font-size: 14px;
}

.value {
    color: #2c3e50;
    font-size: 16px;
    font-weight: 500;
}

.button-center {
    text-align: center;
    margin-top: 40px;
}
</style>
</head>
<body>

    <div class="details-container">
        <h1>Coverage Option Details</h1>

        <h:form>
            <div class="details-grid">

                <div class="detail-block">
                    <span class="label">Coverage ID</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.coverageId}" />
                </div>

                <div class="detail-block">
                    <span class="label">Plan ID</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planId}" />
                </div>

                <div class="detail-block">
                    <span class="label">Premium Amount</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.premiumAmount}" />
                </div>

                <div class="detail-block">
                    <span class="label">Coverage Amount</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.coverageAmount}" />
                </div>

                <div class="detail-block">
                    <span class="label">Status</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.status}" />
                </div>

                <div class="detail-block">
                    <span class="label">Plan Name</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planName}" />
                </div>

                <div class="detail-block">
                    <span class="label">Available Cover Amounts</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.availableCoverAmounts}" />
                </div>

                <div class="detail-block">
                    <span class="label">Plan Type</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.planType}" />
                </div>

                <div class="detail-block">
                    <span class="label">Max Entry Age</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.maxEntryAge}" />
                </div>

                <div class="detail-block">
                    <span class="label">Min Entry Age</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.minEntryAge}" />
                </div>

                <div class="detail-block">
                    <span class="label">Periodic Diseases</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.periodicDiseases}" />
                </div>

                <div class="detail-block">
                    <span class="label">Active On</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.activeOn}" />
                </div>

                <div class="detail-block">
                    <span class="label">Expire Date</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.expireDate}" />
                </div>

                <div class="detail-block">
                    <span class="label">Created On</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.createdOn}" />
                </div>

                <div class="detail-block">
                    <span class="label">Waiting Period</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.waitingPeriod}" />
                </div>

                <div class="detail-block" style="grid-column: span 3;">
                    <span class="label">Description</span>
                    <h:outputText styleClass="value" value="#{insuranceCoverageOptionController.coverageOption.insurancePlan.description}" />
                </div>

            </div>

            <div class="button-center">
                <h:commandButton value="Back" action="showAllPlanByIdTest.jsp" />
            </div>
        </h:form>
    </div>

</body>
</html>
</f:view>
