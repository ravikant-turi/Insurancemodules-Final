package com.infinite.jsf.test;

import com.infinite.jsf.insurance.dao.InsuranceSubscribeDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceSubscribeDaoImpl;
import com.infinite.jsf.recipient.controller.SubscriptionController;
import com.infinite.jsf.recipient.daoImpl.SubscriptionDAOImpl;
import com.infinite.jsf.recipient.model.Subscription;

import java.util.List;

public class MainTesting {

    public static void main(String[] args) {
    	
    	InsuranceSubscribeDao dao=new InsuranceSubscribeDaoImpl();
    	
    	System.out.println(dao.searchRecipientById("HID001"));
    
    }

  
}
