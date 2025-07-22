package com.infinite.jsf.insurance.dao;

import java.util.List;

import com.infinite.jsf.insurance.model.Member;

public interface MemberDao {

	String addMember(Member meber);

	List<Member> findAllMeberByCoverageId(String coverageId);

}
