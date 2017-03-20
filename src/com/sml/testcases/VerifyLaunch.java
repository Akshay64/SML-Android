package com.sml.testcases;

import org.testng.annotations.Test;
import com.sml.classes.LaunchApp;
import org.testng.annotations.AfterTest;

public class VerifyLaunch {
	LaunchApp launch = new LaunchApp();
  @Test(priority = 1)
  public void verifyLaunch() {
	 launch.verifyLaunch();
	  
  }
  @AfterTest
  public void afterLaunch(){
	  System.out.println("App launched successfully");
  }

}
