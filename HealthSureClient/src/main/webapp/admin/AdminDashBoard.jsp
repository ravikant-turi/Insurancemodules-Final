<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Insurance Company Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
 
<body class="bg-gray-100 pt-20 font-sans">
 
<f:view>
 
    <%-- Assuming you have a navigation bar for the insurance company --%>
    <jsp:include page="/navbar/NavAdmin.jsp" />
 
    <div class="max-w-5xl mx-auto px-4 pt-6 pb-2">
        <h2 class="text-2xl font-bold text-blue-800">
            Welcome, <h:outputText value="#{insuranceDashboardController.companyName}" /> Ravikant Turi 📊
        </h2>
        <p class="text-gray-600 mt-1">Your comprehensive overview of operations is below.</p>
    </div>
 
    <div class="max-w-5xl mx-auto px-4 mt-4 mb-12">
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
            
            <%-- Total Policies --%>
            <h:form>
                <h:commandLink action="Show" styleClass="block bg-white p-5 rounded-xl shadow-md text-center hover:shadow-xl transition">
                    <h3 class="text-md font-semibold text-blue-500 uppercase tracking-wide">Total Policies</h3>
                    <p class="mt-2 text-4xl font-bold text-gray-800">
                        <h:outputText value="#{insuranceDashboardBean.totalPolicies}" />
                    </p>
                    <p class="text-xs text-gray-500 mt-1">Active policies in force</p>
                </h:commandLink>
            </h:form>
 
            <%-- New Policies Issued --%>
            <h:form>
                <h:commandLink action="/insurance/showInsuranceCoverageOption.jsp" styleClass="block bg-white p-5 rounded-xl shadow-md text-center hover:shadow-xl transition">
                    <h3 class="text-md font-semibold text-purple-600 uppercase tracking-wide">Show Insurance</h3>
                    <p class="mt-2 text-4xl font-bold text-gray-800">
                        <h:outputText value="#{insuranceDashboardBean.newPoliciesIssuedToday}" />
                    </p>
                    <p class="text-xs text-gray-500 mt-1">Issued today</p>
                </h:commandLink>
            </h:form>
 
            <%-- Claims Processed --%>
            <h:form>
                <h:commandLink action="/insurance/companymenu.jsp" styleClass="block bg-white p-5 rounded-xl shadow-md text-center hover:shadow-xl transition">
                    <h3 class="text-md font-semibold text-green-600 uppercase tracking-wide">Show Coverage</h3>
                    <p class="mt-2 text-4xl font-bold text-gray-800">
                        <h:outputText value="#{insuranceDashboardBean.claimsProcessedThisMonth}" />
                    </p>
                    <p class="text-xs text-gray-500 mt-1">This month</p>
                </h:commandLink>
            </h:form>
 
            <%-- Pending Claims --%>
            <h:form>
                <h:commandLink action="#{insuranceDashboardBean.viewPendingClaims}" styleClass="block bg-white p-5 rounded-xl shadow-md text-center hover:shadow-xl transition">
                    <h3 class="text-md font-semibold text-red-500 uppercase tracking-wide">Pending Claims</h3>
                    <p class="mt-2 text-4xl font-bold text-gray-800">
                        <h:outputText value="#{insuranceDashboardBean.pendingClaims}" />
                    </p>
                    <p class="text-xs text-gray-500 mt-1">Awaiting review</p>
                </h:commandLink>
            </h:form>
        </div>
    </div>
 
    <div class="max-w-4xl mx-auto mb-10 px-4">
        <div class="bg-blue-50 border-l-4 border-blue-400 p-4 rounded-lg shadow-sm">
            <p class="text-sm text-blue-900 italic">
                "Insurance is a financial safety net that catches you when you fall."
            </p>
        </div>
    </div>
 
    <div class="max-w-4xl mx-auto px-4 text-center mb-20">
        <h3 class="text-xl font-semibold text-gray-700 mb-4">Quick Actions</h3>
        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
            <h:form>
                <h:commandButton value="➕ New Policy Application" action="#{insuranceDashboardBean.createNewPolicy}"
                    styleClass="w-full py-3 bg-gradient-to-r from-blue-500 to-blue-700 text-white rounded-xl font-semibold shadow-md hover:shadow-lg transition" />
            </h:form>
            <h:form>
                <h:commandButton value="🔍 Search Policies" action="#{insuranceDashboardBean.searchPolicies}"
                    styleClass="w-full py-3 bg-gradient-to-r from-purple-500 to-purple-700 text-white rounded-xl font-semibold shadow-md hover:shadow-lg transition" />
            </h:form>
            <h:form>
                <h:commandButton value="💲 Manage Claims" action="#{insuranceDashboardBean.manageClaims}"
                    styleClass="w-full py-3 bg-gradient-to-r from-teal-500 to-teal-700 text-white rounded-xl font-semibold shadow-md hover:shadow-lg transition" />
            </h:form>
            <h:form>
                <h:commandButton value="📞 Customer Support Tickets" action="#{insuranceDashboardBean.viewSupportTickets}"
                    styleClass="w-full py-3 bg-gradient-to-r from-pink-500 to-pink-700 text-white rounded-xl font-semibold shadow-md hover:shadow-lg transition" />
            </h:form>
        </div>
    </div>
 
    <%-- Assuming you have a footer for the insurance company --%>
    <jsp:include page="/footer/Footer.jsp" />
 
</f:view>
</body>
</html>