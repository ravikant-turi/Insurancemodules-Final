package com.infinite.jsf.test;

import com.infinite.jsf.insurance.controller.CreateInsuranceController;
import com.mysql.cj.xdevapi.Schema.CreateCollectionOptions;

public class ControllerTest {
public static void main(String[] args) {
	
	CreateInsuranceController controller=new CreateInsuranceController();
	
	controller.findAllPlanDetailsByPlanId("PLA014");
}
}
