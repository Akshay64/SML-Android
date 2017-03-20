package com.sml.classes;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sml.util.SetUpAndLaunch;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class SignIn extends SetUpAndLaunch{
	
	public void clickSignInButton() throws Exception{
		
		driver.findElement(config.getLocator("WelcomePageSignIn")).click();
	}
	public void verifySignInLaunch() throws Exception{
		
		Assert.assertEquals(driver.findElement(config.getLocator("LogInSignIn")).getText(), "Sign In");
	}
	public void enterInvalidLogInDetails(String userName, String password) throws Exception{
		AndroidElement userEmail = (AndroidElement) driver.findElement(config.getLocator("LogInEmail"));
		userEmail.clear();
		userEmail.sendKeys(userName);
		
		AndroidElement userPassword = (AndroidElement) driver.findElement(config.getLocator("LogInPassword"));
		userPassword.clear();
		userPassword.sendKeys(password);
	}
	public void enterValidLogInDetails() throws Exception{
		AndroidElement userEmail = (AndroidElement) driver.findElement(config.getLocator("LogInEmail"));
		userEmail.clear();
		userEmail.sendKeys("ajit@mobiuso.com");
		
		AndroidElement userPassword = (AndroidElement) driver.findElement(config.getLocator("LogInPassword"));
		userPassword.clear();
		userPassword.sendKeys("tester123");
	}
	public void hideKeyboard(){
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
	public void clickLogInButton() throws Exception{
		driver.findElement(config.getLocator("LogInSignIn")).click();
	}
	public void verifySuccessfulSignIn() throws Exception{
		try{
			for(;;){
				if(driver.findElement(config.getLocator("AddResourcesProgress")).isDisplayed()){
					System.out.println("In Loop");
					continue;
				}
				else{
					driver.findElement(config.getLocator("AddResourcesDeselectAll"));
					System.out.println("Out from loop");
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		driver.findElement(config.getLocator("AddResourcesDeselectAll")).click();

	}
	public void verifyInvalidSignIn() throws Exception {
		AndroidElement buttonSignInCaption = (AndroidElement) driver.findElement(config.getLocator("LogInSignIn"));
		Assert.assertEquals("Sign In", buttonSignInCaption.getText());
		
	}

}
