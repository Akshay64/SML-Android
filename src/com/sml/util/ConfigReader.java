package com.sml.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ConfigReader {
	Properties pro;
	
	public ConfigReader(){
		
		pro = new Properties();
		try{
		File propFile = new File("./Configuration/Object.properties");
		FileInputStream inputStream = new FileInputStream(propFile);
		pro.load(inputStream);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public By getLocator(String strPath) throws Exception{
		String locator = pro.getProperty(strPath);
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		if(locatorType.toString().equals("id"))
			return By.id(locatorValue);
		else if(locatorType.toString().equals("name"))
			return By.name(locatorValue);
		else if(locatorType.toString().equals("xpath"))
			return By.xpath(locatorValue);
		else if(locatorType.toString().equals("linktext"))
			return By.linkText(locatorValue);
		else if(locatorType.toString().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if(locatorType.toString().equals("className"))
			return By.className(locatorValue);
		else throw new Exception("Invalid Locator");
			
	}

}
