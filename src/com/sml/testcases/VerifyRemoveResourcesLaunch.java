package com.sml.testcases;

import org.testng.annotations.Test;
import com.sml.classes.SettingsPage;
import com.sml.util.SetUpAndLaunch;

import jxl.read.biff.SetupRecord;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyRemoveResourcesLaunch{
	SettingsPage settingsPage = new SettingsPage();
  @Test(priority = 1)
  public void verifyRemoveResourcesLaunch() throws Exception {
	  settingsPage.clickOnRemoveResources();
	  settingsPage.verifyRemoveResourcesLaunch();
  }
  @BeforeTest
  public void beforeSettingsRemoveResources() throws Exception {
	  settingsPage.verifySettingsLaunch();
  }

  @AfterTest
  public void afterSettingsRemoveResources() throws Exception {
	  settingsPage.verifySettingsLaunch();
  }

}
