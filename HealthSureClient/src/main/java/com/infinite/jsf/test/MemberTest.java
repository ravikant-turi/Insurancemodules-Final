package com.infinite.jsf.test;

import com.infinite.jsf.insurance.dao.MemberPlanRuleDao;
import com.infinite.jsf.insurance.daoImpl.MemberPlanRuleDaoImpl;

public class MemberTest {
	public static void main(String[] args) {
             MemberPlanRuleDao dao=new MemberPlanRuleDaoImpl();
             
//             dao.searchMemberByPlanId("PLA014").forEach(System.out::println);
	}
}
