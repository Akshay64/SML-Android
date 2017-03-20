package com.sml.classes;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sml.util.SetUpAndLaunch;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class LaunchApp extends SetUpAndLaunch{
	
	public void launch() throws Exception{
		AndroidElement checkLink = (AndroidElement) driver.findElement(config.getLocator("WelcomePageLicense"));
		Assert.assertEquals(checkLink.getText(), "View License Agreement");
	}
}
