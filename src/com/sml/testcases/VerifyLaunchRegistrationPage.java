package com.sml.testcases;

import org.testng.annotations.Test;
import com.sml.classes.Registration;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class VerifyLaunchRegistrationPage extends Registration{
	Registration register = new Registration();
	VerifyLaunch verifyLaunch = new VerifyLaunch();
	
  @Test(priority = 1)
  public void verifyLaunchRegistrationPage() throws Exception {
	  register.clickRegistrationButton();
	  register.verifyRegistrationLaunch();
	  Thread.sleep(2000);
	    
  }
  @BeforeTest
  public void beforeRegistrationLaunch() throws Exception{
	  	verifyLaunch.verifyLaunch();
	  
  }
  
  @AfterTest
  public void afterTest() {
	  System.out.println("Registration page launched!");
	  driver.pressKeyCode(AndroidKeyCode.BACK);
  }

}
