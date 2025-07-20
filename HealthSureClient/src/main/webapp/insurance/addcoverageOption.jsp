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
    }
    h1 {
        text-align: center;
        color: white;
        background-color: #27ae60;
        padding: 10px;
        border-radius: 5px;
    }
    table {
        margin: 0 auto;
        background-color: #ecf0f1;
        padding: 15px;
        border-radius: 5px;
    }
    td {
        padding: 5px;
    }
</style>
</head>
<body>

    <h1>Add Insurance Coverage Option</h1>

    <h:form>
        <table>
            <tr>
                <td>Coverage ID:</td>
                <td>
                    <h:inputText value="#{insuranceCoverageOptionController.coverageOption.coverageId}" />
                </td>
            </tr>
            
            <tr>
                <td>Plan ID:</td>
                <td>
                    <h:inputText value="#{insurancePlan.planId}" />
                </td>
            </tr>
            
            <tr>
                <td>Premium Amount:</td>
                <td>
                    <h:inputText value="#{insuranceCoverageOptionController.coverageOption.premiumAmount}" />
                </td>
            </tr>
            
            <tr>
                <td>Coverage Amount:</td>
                <td>
                    <h:inputText value="#{insuranceCoverageOptionController.coverageOption.coverageAmount}" />
                </td>
            </tr>

            <tr>
                <td>Status:</td>
                <td>
                    <h:inputText value="#{insuranceCoverageOptionController.coverageOption.status}" />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <h:commandButton value="Add Coverage Option"
                        action="#{insuranceCoverageOptionController.addcoverageOption(coverageOption)}" />
                </td>
            </tr>
        </table>
    </h:form>

</body>
</html>
</f:view>
