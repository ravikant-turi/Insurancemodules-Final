package com.infinite.jsf.insurance.dao;

import java.util.List;

import com.infinite.jsf.insurance.model.InsuranceCompany;

public interface InsuranceCompanyDao {
	
	//add company
	
    String addCompany(InsuranceCompany company);
    
    //searchByID
    
    InsuranceCompany findCompanyById(String companyId);
    
    //searchAllCompany
    
    List<InsuranceCompany> findAllCompany();
    
    //delete company by Id
    
    String deleteCompanyById(InsuranceCompany company);
    
    //update company by id
    
    String updateCompany(InsuranceCompany company);
    
    
    
}