package com.sml.classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.sml.util.SetUpAndLaunch;
import io.appium.java_client.android.AndroidElement;

public class Registration extends SetUpAndLaunch{

	public void clickRegistrationButton() throws Exception{
		
		driver.findElement(config.getLocator("WelcomePageRegister")).click();		
	}
	
	public void verifyRegistrationLaunch() throws Exception{
		
		AndroidElement pageHeader = (AndroidElement) driver.findElement(config.getLocator("RegisterPageHeader"));
		Assert.assertEquals("New Account", pageHeader.getText());
	}
	public boolean pageLoadProgress()throws Exception{
		
		driver.findElement(config.getLocator("RegisterPageHeader"));
		return false;
	}
	public void verifyProgress(){
		try{
			for(;;){
				if(pageLoadProgress()){
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

	public void enterRegistrationDetails() throws Exception {
		AndroidElement firstName = (AndroidElement) driver.findElement(config.getLocator("RegistrationFirstName"));
		firstName.clear();
		firstName.sendKeys("Test");
		
		WebElement lastName = driver.findElement(config.getLocator("RegistrationLastName"));
		lastName.clear();
		lastName.sendKeys("Test");
		
		WebElement country = driver.findElement(config.getLocator("RegistrationCountry"));
		country.click();
		Select dropdownCountry = new Select(driver.findElement(config.getLocator("RegistrationDropDown")));
		dropdownCountry.selectByIndex(1);
		
		WebElement address1 = driver.findElement(config.getLocator("RegistrationAddress1"));
		address1.clear();
		address1.sendKeys("Test");
		
		WebElement state = driver.findElement(config.getLocator("RegstrationState"));
		state.click();
		Select dropdownState = new Select(driver.findElement(config.getLocator("RegistrationDropDown")));
		dropdownState.selectByIndex(1);
		
		WebElement city = driver.findElement(config.getLocator("RegistrationCity"));
		city.clear();
		city.sendKeys("Test");
		
		WebElement zipcode =  driver.findElement(config.getLocator("RegistrationZipCode"));
		zipcode.clear();
		zipcode.sendKeys("Test");
		
		WebElement profession = driver.findElement(config.getLocator("RegistrationProfession"));
		profession.click();
		Select dropdownProfession = new Select(driver.findElement(config.getLocator("RegistrationDropDown")));
		dropdownProfession.selectByIndex(1);
		
		WebElement specialty = driver.findElement(config.getLocator("RegistrationSpecialty"));
		specialty.clear();
		Select dropdownSpecialty = new Select(driver.findElement(config.getLocator("RegistrationDropDown")));
		dropdownSpecialty.selectByIndex(1);
		
		WebElement email = driver.findElement(config.getLocator("RegistrationEmail"));
		email.clear();
		email.sendKeys("testnewmobiuso26@gmail.com");
		
		WebElement password = (AndroidElement) driver.findElement(config.getLocator("RegistrationPassword"));
		password.clear();
		password.sendKeys("tester123");
		
		WebElement verify = driver.findElement(config.getLocator("RegistrationVerify"));
		verify.clear();
		verify.sendKeys("tester123");
			
	}
	
	public void clickSignInButton() throws Exception{
		driver.findElement(config.getLocator("RegistrationCreateAccount")).click();
	}
	public boolean VerifyRegistrationProgress()throws Exception{
		
		driver.findElement(config.getLocator("RegistrationLoading"));
		return false;
	}
	public void verifyRegisterProgress(){
		try{
			for(;;){
				if(pageLoadProgress()){
					System.out.println("In Loop");
					continue;
				}
				else{
					System.out.println("Ou From Lop");
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void clickOnContinueButton() throws Exception {
		driver.findElement(config.getLocator("RegistrationContinue")).click();
		
	}

}
