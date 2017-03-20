package com.sml.classes;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;

import com.sml.util.SetUpAndLaunch;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.Assert;

public class SettingsPage extends SetUpAndLaunch{
	@CacheLookup
	AndroidElement addResourcesBadge, sendButton;
	static String badgeCount;
	public void clickOnSettingsIcon() throws Exception{
		AndroidElement settings = (AndroidElement) driver.findElement(config.getLocator("HomeSettings"));
		settings.click();
	}

	public void verifyOnHomeScreen() throws Exception {
		AndroidElement search = (AndroidElement) driver.findElement(config.getLocator("HomeSmartSearch"));
		String verifyName = search.getText();
		Assert.assertEquals("Smart Search", verifyName);
	}

	public void verifySettingsLaunch() throws Exception {
		AndroidElement settingsLabel = (AndroidElement) driver.findElement(config.getLocator("SettingsLabel"));
		Assert.assertEquals("Settings", settingsLabel.getText());
		
	}

	public void clickOnUpdatesOption() throws Exception {
		AndroidElement updatesButton = (AndroidElement) driver.findElement(config.getLocator("SettingsUpdate"));
		updatesButton.click();
		
		try{
			
			for(;;){
				AndroidElement loadingIcon = (AndroidElement) driver.findElement(config.getLocator("SettingsUpdateLoading"));
				if(loadingIcon.isDisplayed()){
					continue;					
				}
				else{
					break;
				}
			}
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	public void verifyUpdatesLaunch() {
		try{
			AndroidElement welcomeHeader = (AndroidElement) driver.findElement(config.getLocator("UpdatesCheckResources"));
			if(welcomeHeader.isDisplayed()){
				Assert.assertEquals("All resources are up-to-date", welcomeHeader.getText());
			}
			else{
				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}

	public void clickOnAddResources() throws Exception {
	AndroidElement addResources = (AndroidElement) driver.findElement(config.getLocator("SettingsAddResources"));
	addResources.click();
	}
	public void countNumberOfResources() throws Exception {
		try{
			for(;;){
				AndroidElement loadingIcon = (AndroidElement) driver.findElement(config.getLocator("AddResourcesProgress"));
				if(loadingIcon.isDisplayed()){
					continue;
				}
				else{
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
//		List<String> resourceList = driver.findElements(config.getLocator("SettingsAddResourcesList"));
//		List<String> innerList = null, listNames;
//		
//		for(int i=0;i<resourceList.size();i++){
////			innerList = driver.findElements(config.getLocator("SettingsAddResourcesInnerList"));
////			for(int j=0;j<innerList.size();j++){
//				listNames = driver.findElements(config.getLocator("SettingsAddResourcesListNames"));
//				resourceList.addAll(listNames);		
////			}
//			
//		}
//		System.out.println(resourceList.size());
//		Assert.assertEquals(resourceList.size(), badgeCount);
		List<String> resourceList = driver.findElements(config.getLocator("SettingsAddResourcesListNames"));
		int listSize = resourceList.size();
		String.valueOf(listSize);
		Assert.assertEquals(listSize, badgeCount);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		}
	public void checkBadgeCount() throws Exception{
		addResourcesBadge = (AndroidElement) driver.findElement(config.getLocator("SettingsAddResourcesBadge"));
		badgeCount = addResourcesBadge.getText();
		
	}

	public void clickOnRemoveResources() throws Exception {
		AndroidElement removeResources = (AndroidElement) driver.findElement(config.getLocator("SettingsRemoveResources"));
		removeResources.click();
			
	}

	public void verifyRemoveResourcesLaunch() throws Exception {
		AndroidElement removeResourcesLabel = (AndroidElement) driver.findElement(config.getLocator("RemoveResourcesLabel"));
		Assert.assertEquals("Remove Resources", removeResourcesLabel.getText());
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
	}

	public void clickOnMyProfile() throws Exception {
		AndroidElement myProfile = (AndroidElement) driver.findElement(config.getLocator("SettingsMyProfile"));
		myProfile.click();
		Thread.sleep(3000);
	}
	public void verifyMyProfile() throws Exception {
		AndroidElement myProfileLabel = (AndroidElement) driver.findElement(config.getLocator("MyProfileLabel"));
		Assert.assertEquals("My Profile", myProfileLabel.getText());
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
	}

	public void clickFeedBack() throws Exception {
		AndroidElement feedback = (AndroidElement) driver.findElement(config.getLocator("SettingsSendFeedBack"));
		feedback.click();
		Thread.sleep(5000);
		
	}

	public void verifyFeedBackLaunch() throws Exception {
		AndroidElement myProfileLabel = (AndroidElement) driver.findElement(config.getLocator("SendFeedBackLabel"));
		Assert.assertEquals("Send Feedback", myProfileLabel.getText());
		
	}

	public void enterFeedBackText() throws Exception {
		AndroidElement feedback = (AndroidElement) driver.findElement(config.getLocator("SendFeedBackEditText"));
		feedback.sendKeys("Test Feedback");
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
	}

	public void clickOnSendFeedBack() throws Exception {
		sendButton.click();	
	}

	public void verifySuccessfulFeedbackSent() throws Exception{
		try{
			AndroidElement feedbackLoading = (AndroidElement) driver.findElement(config.getLocator("SendFeedBackLoading")) ;
			for(;;){
				if(feedbackLoading.isDisplayed()){
					continue;
				}
				else{
					break;
				}
			}
		}catch(Exception e){
			
		}
		AndroidElement closeIcon = (AndroidElement) driver.findElement(config.getLocator("SendFeedBackClose"));
		closeIcon.click();
	}

	public void clickDirectOnSendFeedBackButton() throws Exception {
		sendButton = (AndroidElement) driver.findElement(config.getLocator("SendFeedBackButton"));
		sendButton.click();
		try{
			AndroidElement error = (AndroidElement) driver.findElement(config.getLocator("SendFeedBackError"));
			if(error.getAttribute("name").equalsIgnoreCase("      Please provide your feedback below:")){
				return;
			}
			System.out.println(error.getAttribute("name"));
			
		}catch(Exception e){
			System.out.println("There is no error");
		}
		
	}
	

}
