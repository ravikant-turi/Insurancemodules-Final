package com.infinite.jsf.test;

import com.infinite.jsf.util.MailSend;

public class MailTest {
	public static void main(String[] args) {
		
		MailSend.sendInfo("zy77424@gmail.com", "otp send the mail", "234");
	}

}
