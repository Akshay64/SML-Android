package com.sml.testcases;

import org.testng.annotations.Test;
import com.sml.classes.Registration;
import com.sml.util.SetUpAndLaunch;

import org.testng.annotations.BeforeTest;

import java.util.Set;

import org.testng.annotations.AfterTest;

public class VerifyRegistration extends SetUpAndLaunch{
	Registration register = new Registration();
	
	@Test(priority = 1)
	public void verifyRegistration() throws Exception {
		register.verifyProgress();
		Thread.sleep(3000);
		register.enterRegistrationDetails();
		register.clickSignInButton();
		register.verifyRegisterProgress();
		
		
	  
	}
	@BeforeTest
	public void beforeRegistrationPage() throws Exception {
		register.verifyRegistrationLaunch();
	}

	@AfterTest
	public void afterTest() throws Exception {
		register.clickOnContinueButton();
		Thread.sleep(3000);
		System.out.println("Registration successful!");
	}

}
