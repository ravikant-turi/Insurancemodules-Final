package com.infinite.jsf.test;

import com.infinite.jsf.insurance.dao.MemberDao;
import com.infinite.jsf.insurance.daoImpl.MemberDaoImpl;

public class MemberTest {
	public static void main(String[] args) {
             MemberDao dao=new MemberDaoImpl();
             
             dao.searchMemberByPlanId("PLA014").forEach(System.out::println);
	}
}
