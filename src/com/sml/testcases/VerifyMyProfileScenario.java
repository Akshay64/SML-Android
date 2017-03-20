package com.sml.testcases;

import org.testng.annotations.Test;

import com.sml.classes.SettingsPage;
import com.sml.util.SetUpAndLaunch;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyMyProfileScenario{
	SettingsPage settingsPage = new SettingsPage();
	@Test(priority = 1)
	 public void verifyMyProfileLaunch() throws Exception {
		settingsPage.clickOnMyProfile();
		settingsPage.verifyMyProfile();
	 }
	 @BeforeTest
	 public void beforeMyProfile() throws Exception {
		  settingsPage.verifySettingsLaunch();
	 }
	 @AfterTest
	 public void afterMyProfile() throws Exception {
		  settingsPage.verifySettingsLaunch();
	  }

}
