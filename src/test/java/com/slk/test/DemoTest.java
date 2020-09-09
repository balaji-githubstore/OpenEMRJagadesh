package com.slk.test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.slk.base.WebDriverWrapper;
import com.slk.pages.HomePage;
import com.slk.utilities.ExcelUtils;

public class DemoTest extends WebDriverWrapper {
	
	@DataProvider
	public Object[][] createNewPatientData() throws IOException
	{
		Object[][] main = ExcelUtils.getSheetIntoObjectArray("testdata/OpenEmrData.xlsx", "createNewPatientData");
		return main;
	}
	
	@Test(dataProvider = "createNewPatientData")
	public void createNewPatientTest(String user,String pass, String lang,String title,String fname,String lname,String exp)
	{
		
	}
	
	//bala,bala123 //
	//dina,dina123 //
	//peter,peter123
	
	@DataProvider
	public Object[][] validInputData()
	{
		Object[][] main = new Object[3][2];
		//i -->No of testcase
		//j -->No of parameter
		main[0][0] = "bala";
		main[0][1]="bala123";
		
		main[1][0]="dina";
		main[1][1]="dina123";
		
		main[2][0]="peter";
		main[2][1]="peter123";
		
		return main;
	}
	
	@Test(dataProvider = "validInputData")
	public void validInputTest(String username,String password)
	{
		HomePage.sendUsername(driver, username);
		HomePage.sendPassword(driver,password);	
	}
}
