package com.interbanking.testcases;

import org.testng.annotations.Test;

import com.interbanking.pageobjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	public void login(){
		LoginPage lp=new LoginPage(driver);
		
		//Enter Username
		lp.usn(UserID);
		
		//Enter Password
		lp.pwd(password);
		
		//click on login button
		lp.loginbutton();
		
	}

}
