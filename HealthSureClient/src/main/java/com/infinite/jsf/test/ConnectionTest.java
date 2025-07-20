package com.infinite.jsf.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.util.SessionHelper;

public class ConnectionTest {
	
	public static void main(String[] args) {
		
		SessionFactory sf=SessionHelper.getSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction trans=session.beginTransaction();
		

		System.out.println("====================connection test is started ============= ");
		
		System.out.println("connection is : "+ session);
		
		System.out.println("====================connection id working fine============= ");

		
		System.out.println("this is ravikant");
		trans.commit();
		
		session.close();

		
	}

}