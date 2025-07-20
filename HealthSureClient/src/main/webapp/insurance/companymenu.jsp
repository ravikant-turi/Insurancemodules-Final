<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>HealthSure Insurance</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background: #f0f2f5;
}

.wrapper {
	min-height: 100%;
	display: flex;
	flex-direction: column;
}

.header {
	background: #004080;
	color: #fff;
	padding: 15px 20px;
	display: flex;
	align-items: center;
}

.header img {
	width: 50px;
	height: 50px;
	margin-right: 15px;
	border-radius: 5px;
}

.header h1 {
	font-size: 24px;
	margin: 0;
}

.welcome-title {
	text-align: center;
	margin-top: 20px;
	font-size: 22px;
	color: #004080;
}

.container {
	flex: 1;
	max-width: 1000px;
	margin: 20px auto;
	padding: 0 20px;
}

.plans-grid {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	gap: 20px;
}

.plan-box {
	background: #fff;
	padding: 15px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
	cursor: pointer;
	transition: transform 0.3s, box-shadow 0.3s;
	text-decoration: none;
}

.plan-box:hover {
	transform: translateY(-5px);
	box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
}

.plan-title {
	font-size: 18px;
	color: #007bff;
	margin: 10px 0 5px 0;
}

.plan-desc {
	font-size: 14px;
	color: #555;
	line-height: 1.4;
}

.plan-image {
	width: 100%;
	height: 120px;
	object-fit: cover;
	border-radius: 8px;
}

.footer {
	background: #004080;
	color: #fff;
	padding: 15px 20px;
	text-align: center;
}

.footer p {
	margin: 5px 0;
}
.header {
    position: relative;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 10px 20px;
}

.header img {
    height: 60px;
    width: auto;
}

.header h1 {
    flex-grow: 1;
    text-align: center;
    margin: 0;
    font-size: 24px;
}

.button-container {
    position: absolute;
    top: 10px;
    right: 20px;
}

.create-btn {
    height: 40px;
    width: 100px;
    font-size: 16px;
    border-radius: 10px;
}

</style>
</head>
<body>
	<div class="wrapper">
	<h:form>
        <div class="button-container">
            <h:commandButton value="create" action="showplan.jsp" styleClass="action-btn create-btn" />
        </div>
    </h:form>
		<div class="header">
    <img src="/HealthSureClient/resources/media/images/Insurance/comapany.png" alt="Company Logo" />
    <h1>LifeSecure Health</h1>
    <h:form>
        <div class="button-container">
            <h:commandButton value="create" action="showplan.jsp" styleClass="action-btn create-btn" />
        </div>
    </h:form>
    
     
</div>
		

		<div class="welcome-title">Welcome to Our Insurance Company</div>

		<div class="container">
			<h:form>
				<div class="plans-grid">
					<h:commandLink
						action="#{insuranceCoverageOptionController.searchInsuranceCoverageOptionByPlanType('SELF')}"
						styleClass="plan-box">
						<div>
							<img
								src="/HealthSureClient/resources/media/images/Insurance/professional.jpg"
								class="plan-image" />
							<div class="plan-title">SELF HealthPlus Basic</div>
							<div class="plan-desc">
								A simple plan for individuals.<br /> Covers basic health needs.
							</div>
						</div>
					</h:commandLink>

					<h:commandLink
						action="#{insuranceCoverageOptionController.searchInsuranceCoverageOptionByPlanType('FAMILY')}"
						styleClass="plan-box">
						<div>
							<img
								src="/HealthSureClient/resources/media/images/departments/fam.png"
								class="plan-image" />
							<div class="plan-title">FAMILYCare Shield</div>
							<div class="plan-desc">
								Designed for the whole family.<br /> Affordable and reliable
								protection.
							</div>
						</div>
					</h:commandLink>

					<h:commandLink
						action="#{insuranceCoverageOptionController.searchInsuranceCoverageOptionByPlanType('SENIOR')}"
						styleClass="plan-box">
						<div>
							<img
								src="/HealthSureClient/resources/media/images/Insurance/seniorCitizen.jpg"
								class="plan-image" />
							<div class="plan-title">SENIOR Secure</div>
							<div class="plan-desc">
								Tailored for senior citizens.<br /> Extra care and higher
								coverage.
							</div>
						</div>
					</h:commandLink>

					<h:commandLink
						action="#{insuranceCoverageOptionController.searchInsuranceCoverageOptionByPlanType('CRITICAL_ILLNESS')}"
						styleClass="plan-box">
						<div>
							<img
								src="/HealthSureClient/resources/media/images/Insurance/criticalillness.jpg"
								class="plan-image" />
							<div class="plan-title">CRITICAL ILLNESS</div>
							<div class="plan-desc">
								Support during major illnesses.<br /> Focus on prior disease
								cover.
							</div>
						</div>
					</h:commandLink>

					<h:commandLink
						action="#{insuranceCoverageOptionController.searchInsuranceCoverageOptionByPlanType('SUPER_ELITE')}"
						styleClass="plan-box">
						<div>
							<img
								src="/HealthSureClient/resources/media/images/Insurance/fit.jpg"
								class="plan-image" />
							<div class="plan-title">Super Health Elite</div>
							<div class="plan-desc">
								Premium plan for high earners.<br /> Comprehensive and top-tier
								cover.
							</div>
						</div>
					</h:commandLink>

					<h:commandLink
						action="#{insuranceCoverageOptionController.searchInsuranceCoverageOptionByPlanType('EPIDEMIC_PROTECT')}"
						styleClass="plan-box">
						<div>
							<img
								src="/HealthSureClient/resources/media/images/Insurance/covid2.jpg"
								class="plan-image" />
							<div class="plan-title">SUPER Comprehensive</div>
							<div class="plan-desc">
								All-in-one protection plan.<br /> Maximum security for all
								needs.
							</div>
						</div>
					</h:commandLink>
				</div>
			</h:form>
		</div>

		<div class="footer">
			<p>&copy; 2025 HealthSure Insurance Company. All rights reserved.</p>
			<p>We offer reliable, affordable, and comprehensive plans
				tailored for everyone.</p>
		</div>
	</div>
</body>
	</html>
</f:view>
