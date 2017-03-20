package com.sml.classes;

import org.openqa.selenium.support.CacheLookup;
import com.sml.util.SetUpAndLaunch;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.Connection;
import junit.framework.Assert;


public class AddResources extends SetUpAndLaunch{
	static AndroidElement list;
	Boolean clickableDeSelect, clickableSelect, enabled;
	@CacheLookup
	static AndroidElement deSelectButton, enabledInstall, selectAllButton, findResource, startButton, closeButton, homeResourceName;
	public void verifyAddResourcesLaunch() throws Exception{
		Assert.assertEquals("Deselect all", driver.findElement(config.getLocator("AddResourcesDeselectAll")).getText());
	}
	public void isSelectAllButtonClickable() throws Exception{
		selectAllButton = (AndroidElement) driver.findElement(config.getLocator("AddResourcesSelectAll"));
		clickableSelect = selectAllButton.isEnabled();
		Assert.assertTrue(clickableSelect);
		
	}
	public void clickDeSelectAllButton() throws Exception{
		deSelectButton.click();						
	}
	public void clickSelectAllButton() throws Exception{
		selectAllButton.click();						
	}
	public void clickInstallButton() throws Exception{
		if(driver.getConnection() != null){
			System.out.println(driver.getConnection());
			enabledInstall.click();	
		}
		else{
			driver.setConnection(Connection.WIFI);
			driver.getConnection();
			enabledInstall.click();	
		}
							
	}
	public void isDeSelectEnabled() throws Exception{
		deSelectButton = (AndroidElement) driver.findElement(config.getLocator("AddResourcesDeselectAll"));
		clickableDeSelect = deSelectButton.isEnabled();
		Assert.assertTrue(clickableDeSelect);
		
	}
	public void isInstallEnabled() throws Exception{
		enabled = enabledInstall.isEnabled();
		Assert.assertTrue(enabled);		
	}
	public void isInstallDisabled() throws Exception{
		enabledInstall = (AndroidElement) driver.findElement(config.getLocator("AddResourcesInstall"));
		enabled = enabledInstall.isEnabled();
		Assert.assertTrue(!enabled);		
	}
	public void selectResource() throws Exception {
		findResource = (AndroidElement) driver.findElement(config.getLocator("AddResourcesFmcc"));
		findResource.click();
		
	}
	public void waitTillDowdloadCompletes() throws Exception {
		
		try{
			for(;;){
				if(deSelectButton.isDisplayed()){
					continue;
				}
				else{
					
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());			
		}	
		startButton = (AndroidElement) driver.findElement(config.getLocator("HomeGetStarted"));
		startButton.click();
		closeButton = (AndroidElement) driver.findElement(config.getLocator("HoemClose"));	
		closeButton.click();
	}
	public void verifyDownloadedResource() throws Exception {		
		homeResourceName = (AndroidElement) driver.findElement(config.getLocator("HomeResourceName"));
		System.out.println(homeResourceName.getText());
		Assert.assertEquals("5-Minute Clinical Consult 2017", homeResourceName.getText());
	}        

}
