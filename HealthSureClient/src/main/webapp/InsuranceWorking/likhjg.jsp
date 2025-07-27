
<!-- Dynamic Input Fields Based on Plan Type -->
			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.planType eq 'FAMILY'}">

				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 1}">
				>
				<h4>Member 1</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember1.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember1.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember1.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember1.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 2}">
				>
				<h4>Member 2</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember2.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember2.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember2.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember2.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 3}">
				>
				<h4>Member 3</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember2.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember2.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember2.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember2.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 4}">
				>
				<h4>Member 4</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember4.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember4.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember4.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember4.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 5}">
				>
				<h4>Member 5</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember5.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember5.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember5.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember5.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 6}">
				>
				<h4>Member 6</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember6.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember6.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember6.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember6.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed gt 7}">
				>
				<h4>Member 7</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember7.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember7.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember7.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember7.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				<h:panelGroup
					rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.maximumMemberAllowed eq 8}">
				>
				<h4>Member 8</h4>
					<div class="member-card">

						<div class="form-field">
							<span class="form-label">fullName:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember8.fullName}" />
						</div>

						<div class="form-field">
							<span class="form-label">Age:</span>
							<h:inputText
								value="#{insuranceSubscribedController.subscribedMember8.age}" />
						</div>

						<div class="form-field">
							<span class="form-label">Gender:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember8.gender}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Male" itemValue="MALE" />
								<f:selectItem itemLabel="Female" itemValue="FEMALE" />
							</h:selectOneMenu>
						</div>

						<div class="form-field">
							<span class="form-label">relationWithProposer:</span>
							<h:selectOneMenu
								value="#{insuranceSubscribedController.subscribedMember8.relationWithProposer}">
								<f:selectItem itemLabel="Select" itemValue="" />
								<f:selectItem itemLabel="Son" itemValue="SON" />
								<f:selectItem itemLabel="Daughter" itemValue="DAUGHTER" />
								<f:selectItem itemLabel="Mother" itemValue="MOTHER" />
								<f:selectItem itemLabel="Father" itemValue="FATHER" />
								<f:selectItem itemLabel="Husband" itemValue="HUSBAND" />
								<f:selectItem itemLabel="Wife" itemValue="WIFE" />
							</h:selectOneMenu>
						</div>
					</div>
				</h:panelGroup>
				</h:panelGroup>
				


			<h:panelGroup
				rendered="#{insuranceSubscribedController.coverageOption.insurancePlan.planType ne 'FAMILY'}">
				<h4>INDIVIDUAL</h4>
				<div class="member-card">

					<div class="form-field">
						<span class="form-label">fullName:</span>
						<h:inputText
							value="#{insuranceSubscribedController.subscribedMember1.fullName}" />
					</div>

					<div class="form-field">
						<span class="form-label">Age:</span>
						<h:inputText
							value="#{insuranceSubscribedController.subscribedMember1.age}" />
					</div>

					<div class="form-field">
						<span class="form-label">Gender:</span>
						<h:selectOneMenu
							value="#{insuranceSubscribedController.subscribedMember1.gender}">
							<f:selectItem itemLabel="Select" itemValue="" />
							<f:selectItem itemLabel="Male" itemValue="MALE" />
							<f:selectItem itemLabel="Female" itemValue="FEMALE" />
						</h:selectOneMenu>
					</div>

					<div class="form-field">
						<span class="form-label">relationWithProposer:</span>
						<h:selectOneMenu
							value="#{insuranceSubscribedController.subscribedMember1.relationWithProposer}">
							<f:selectItem itemLabel="INDIVIDUAL" itemValue="INDIVIDUAL" />

						</h:selectOneMenu>
					</div>
				</div>

			</h:panelGroup>
			
			
			
			
			
			
			
			
			
			
			
			
			=============.form-group {
    flex: 1;
    min-width: 280px;
    margin-right: 20px;
}

label {
    font-weight: 600;
    display: block;
    margin-bottom: 6px;
    color: #333;
}

h\:outputText {
    display: block;
    padding: 10px 14px;
    background-color: #f8f9fa;
    border: 1px solid #ddd;
    border-radius: 6px;
    color: #555;
    font-size: 15px;
}

.coverage-box {
    background-color: #fdfdfd;
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 20px;
    margin: 20px 0;
    width: 100%;
}

.coverage-box h3 {
    margin-top: 0;
    color: #2c