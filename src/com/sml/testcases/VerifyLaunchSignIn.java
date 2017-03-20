package com.sml.testcases;

import org.testng.annotations.Test;

import com.sml.classes.SignIn;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyLaunchSignIn {
	SignIn signin = new SignIn();
  @Test(priority = 1)
  public void verifySignInLaunch() throws Exception {
	  
	  signin.verifySignInLaunch();
  }
  @BeforeTest
  public void beforeSignInLaunch() throws Exception {
	  
	  signin.clickSignInButton();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("SignIn Successful");
  }

}
