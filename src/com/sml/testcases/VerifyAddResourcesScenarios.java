package com.sml.testcases;

import org.testng.annotations.Test;

import com.sml.classes.AddResources;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyAddResourcesScenarios {
	
	AddResources addResources = new AddResources();
	@Test(priority = 1)
	public void verifyDeSelectEnable() throws Exception {
		addResources.isDeSelectEnabled();
	}
	@Test(priority = 2)
	public void verifyInstalButtonDisabled() throws Exception {
		addResources.clickDeSelectAllButton();
		addResources.isInstallDisabled();
	}
	@Test(priority = 3)
	public void verifySelectAllEnable() throws Exception {
		addResources.isSelectAllButtonClickable();
	}	
	@Test(priority = 4)
	public void verifyInstallButtonEnabled() throws Exception {
		addResources.clickSelectAllButton();
		addResources.isInstallEnabled();
	}
	@BeforeTest
	public void beforeResourcesScenarios() throws Exception {
		addResources.verifyAddResourcesLaunch();	  
	}
	@Test(priority = 5)
	public void installResource() throws Exception{
		addResources.clickDeSelectAllButton();
		addResources.selectResource();
		addResources.clickInstallButton();
		addResources.waitTillDowdloadCompletes();
		addResources.verifyDownloadedResource();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		System.out.println("Resource Download was successful");
		Thread.sleep(3000);
	}

}
