package com.sml.testcases;

import org.testng.annotations.Test;

import com.sml.classes.SettingsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyUpdatesScenario{
	SettingsPage settingsPage = new SettingsPage();
	@Test(priority = 1)
	public void launchUpdatesScreen() throws Exception {
		settingsPage.clickOnUpdatesOption();
		settingsPage.verifyUpdatesLaunch();
	}
	@BeforeTest
	public void beforeUpdatesLaunch() throws Exception {
		settingsPage.verifySettingsLaunch();
	}
	@AfterTest
	public void afterUpdatesLaunch() throws Exception {
		settingsPage.verifySettingsLaunch();
	}

}
