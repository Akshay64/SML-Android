package com.sml.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sml.classes.SettingsPage;
import com.sml.util.SetUpAndLaunch;

public class VerifySettingsLaunch {
	SettingsPage settingsPage = new SettingsPage(); 
  @Test(priority = 1)
  public void launchSettings() throws Exception {
	  settingsPage.clickOnSettingsIcon();
  }
  @BeforeTest
  public void beforeSettingsOperations() throws Exception{
	  settingsPage.verifyOnHomeScreen();	  
  }
  @AfterTest
  public void verifySettingsLaunch() throws Exception{
	  settingsPage.verifySettingsLaunch();
  }
}
