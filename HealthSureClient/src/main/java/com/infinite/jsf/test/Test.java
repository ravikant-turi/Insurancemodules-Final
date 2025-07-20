package com.infinite.jsf.test;

import com.infinite.jsf.util.MailSend;

class Parent {
    void show() { System.out.print("Parent "); }
}
class Child extends Parent {
    void show() { System.out.print("Child "); }
}
public class Test {
    public static void main(String[] args) {

      MailSend.sendInfo("turiravikant@gmail.com","subject" , "this is otp");
    } 
    }