package com.sml.testcases;

import org.testng.annotations.Test;

import com.sml.classes.SettingsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifySettingsAddResourcesScenarios {
	SettingsPage settingsPage = new SettingsPage();
  @Test(priority = 1)
  public void verifyAddRespurcesLaunch() throws Exception {
	  settingsPage.checkBadgeCount();
	  settingsPage.clickOnAddResources();
	  settingsPage.countNumberOfResources();
  }
  @BeforeTest
  public void beforeSettingsAddResources() throws Exception {
	  settingsPage.verifySettingsLaunch();
  }

  @AfterTest
  public void afterTest() throws Exception {
	  settingsPage.verifySettingsLaunch();
  }

}
