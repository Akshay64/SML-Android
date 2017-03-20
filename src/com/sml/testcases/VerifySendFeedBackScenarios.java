package com.sml.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.sml.classes.SettingsPage;
import com.sml.util.SetUpAndLaunch;

public class VerifySendFeedBackScenarios{
	
	SettingsPage settingsPage = new SettingsPage();
	@Test(priority = 1)
	public void verifyFeedBackLaunch() throws Exception{
		settingsPage.clickFeedBack();
		settingsPage.verifyFeedBackLaunch();
	}
	@Test(priority = 2)
	public void verifySendInvalidFeedback() throws Exception{
		settingsPage.clickDirectOnSendFeedBackButton();
	}
	@Test(priority = 3)
	public void verifySendFeedBack() throws Exception{
		settingsPage.enterFeedBackText();
		settingsPage.clickOnSendFeedBack();
		settingsPage.verifySuccessfulFeedbackSent();
	}
	@AfterTest
	public void afterFeedBack() throws Exception {
		settingsPage.verifySettingsLaunch();
	}
  
}
