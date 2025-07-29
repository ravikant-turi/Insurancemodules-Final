<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<link rel="stylesheet" href="/HealthSureClient/resources/css/navProvider.css" />
 
<nav id="navbar" class="navbar navbar-scrolled"> <!-- Removed navbar-transparent -->
    <div class="navbar-container">
 
        <!-- LOGO + NAME -->
        <div class="navbar-logo">
        	<a href="/HealthSureClient/home/Home.jsf" class="logo-link">
            <h:graphicImage library="media" name="images/Logo.jpg" alt="HealthSure Logo" styleClass="logo-img" />
            </a>
            <span class="brand-name">LifeCure Inc.</span>
        </div>
 
        <!-- PROVIDER NAV LINKS -->
        <ul class="nav-links">
        
            <li><a href="RecipientDashBoard.jsf" class="nav-link">DashBoard</a></li>
            <li><a href="/insurance/addplan.jsf" class="nav-link">Create Plans</a></li>
            <li><a href="addCoverageOptionToPlan.jsf" class="nav-link">Add Coverage</a></li>
            <li><a href="updateCoverageOption.jsf" class="nav-link">Update Coverage</a></li>
			<li><a href="companymenu.jsf" class="nav-link">Menu</a></li>
			<li><a href="Home.jsf" class="nav-link">About Us</a></li>
        </ul>
 
        <!-- LOGOUT BUTTON -->
        <div class="auth-buttons">
			<h:form>
				<h:commandButton value="Logout" action="#{showincController.logout}"
					styleClass="logout-btn" />
			</h:form>
 
		</div>
    </div>
</nav>