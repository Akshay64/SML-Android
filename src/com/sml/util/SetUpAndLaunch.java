package com.sml.util;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class SetUpAndLaunch {
  File apkPath;
  String appPackage = "com.medpresso.android.ui";
  String activityName = "com.medpresso.android.ui.HomeActivity";
  public static AndroidDriver driver;
  WebDriverWait wait;
  public static ConfigReader config = new ConfigReader();
  @BeforeSuite
  public void beforeSuite() throws MalformedURLException, InterruptedException {
	  apkPath = new File("Files/app-release.apk");
	  DesiredCapabilities smlCapabilities = new DesiredCapabilities();
	  
	  smlCapabilities.setCapability("deviceName", "Moto G (4)");
	  smlCapabilities.setCapability(MobileCapabilityType.UDID,"ZY2232T4PJ");//ZY223SQM4D
	  smlCapabilities.setCapability(CapabilityType.BROWSER_NAME,"Android");
	  smlCapabilities.setCapability(CapabilityType.VERSION,"5.1.1");
	  smlCapabilities.setCapability("platformName", "Android");
	  smlCapabilities.setCapability("app","/Users/builduser/Documents/workspace/SMLAndroid/Files/app-release.apk");
	  smlCapabilities.setCapability("appPackage", appPackage);
	  smlCapabilities.setCapability("appActivity", activityName);
	  driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), smlCapabilities);
	  driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	  
	  
	  driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), smlCapabilities);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver,30);
	  Thread.sleep(3000);
  }

  @Test
  public void verifyLaunch(){
	  System.out.println("App Launched !");
  }
  @AfterSuite
  public void afterSuite() {
	  driver.closeApp();
  }

}
