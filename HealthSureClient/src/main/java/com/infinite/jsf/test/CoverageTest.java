package com.infinite.jsf.test;

import java.util.List;

import com.infinite.jsf.insurance.controller.InsuranceCoverageOptionController;
import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;

public class CoverageTest {

	public static void main(String[] args) {

		InsuranceCoverageOptionController controller = new InsuranceCoverageOptionController();

//		controller.findAllcoverageOption().forEach(System.out::println);

		InsuranceCoverageOptionDao dao = new InsuranceCoverageOptionDaoImpl();

		System.out.println("====================Family=================");
//		controller.searchInsuranceCoverageOptionByPlanType("SELF").forEach(System.out::println);

//		dao.searchInsuranceCoverageOptionByPlanId("PLA006").forEach(System.out::println);

//		List<InsuranceCoverageOption> list = dao.searchInsuranceCoverageOptionByPlanId("PLA001");
//		list.forEach(System.out::println);
//		System.out.println("=================\n" + list.get(0).getCoverageId());
//		System.out.println("=================\n" + list.get(1).getCoverageId());
//		System.out.println("=================\n" + list.get(2).getCoverageId());
//		for (InsuranceCoverageOption opt : list) {
//			System.out.println(opt.getInsurancePlan().getPlanId());
//			System.out.println(opt.getInsurancePlan().getInsuranceCompany().getCompanyId());
//
//			System.out.println(opt.getCoverageId());
//		}

		List<InsuranceCoverageOption> list = dao.getInsuranceCoverageOptionsByPlanType("SELF");
		for (InsuranceCoverageOption options : list) {
			System.out.println("===========");
			System.out.println(options.getInsurancePlan());
			System.out.println(options.getInsurancePlan().getInsuranceCompany());
			System.out.println(options);
			System.out.println("===========");
		}
	}

}
