package com.sml.testcases;

import org.testng.annotations.Test;

import com.sml.classes.SignIn;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class VerifySignIn {
	static int totalRows;
	static int totalCols;
	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	static XSSFRow row;
	static XSSFCell cell;
	SignIn signin = new SignIn();
	
  @Test(dataProvider = "SignIn", retryAnalyzer = com.sml.util.RetryAnalyzer.class, alwaysRun = true, priority =1)
  public void verifyInvalidSignInProcess(String userName, String password) throws Exception {
	  signin.enterInvalidLogInDetails(userName, password);
	  signin.hideKeyboard();
	  signin.clickLogInButton();
	  signin.verifyInvalidSignIn();
  }
  @Test(priority =2)
  public void verifyValidSignIn() throws Exception{
	  signin.enterValidLogInDetails();
	  signin.hideKeyboard();
	  signin.clickLogInButton();
	  signin.verifySuccessfulSignIn();
  }
  @BeforeTest
  public void beforeSignIn() throws Exception {
	  signin.verifySignInLaunch();
  }

  @AfterTest
  public void afterTest() throws Exception {
	  
	  System.out.println("LogIn Successful");
	  Thread.sleep(3000);
  }
  @DataProvider(name="SignIn")
  public Object[][] checkSignInScenario() throws IOException{
	return new Object[][] {{"",""},
						   {"ajit@mobiuo.com",""},
						   {"","tester123"}};
	  
  }
  private Object[][] getExceclData(String fileName, String sheetName) throws IOException {
	  
	String[][] data = null; 
	try{
		FileInputStream inputStream = new FileInputStream("");
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
		int ci=0, cj=0;
		totalRows = sheet.getLastRowNum();
		totalCols = sheet.getRow(0).getLastCellNum();
		data= new String[totalRows][totalCols];
		for(int i=1;i<=totalRows;i++, ci++){			
			for(int j=1;j<totalCols;j++,cj++){				
				cell=sheet.getRow(i).getCell(j);
				if(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK){
					break;
				}
				else{
					data[ci][cj] = cell.getStringCellValue();
					
				}
			}
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	System.out.println(data);
	  return data;
  }

}
