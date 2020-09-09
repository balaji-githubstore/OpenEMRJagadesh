package com.slk.test;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.slk.base.WebDriverWrapper;
import com.slk.pages.DashboardPage;
import com.slk.pages.HomePage;
import com.slk.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper{
	
	@DataProvider
	public Object[][] validCredentialData() throws IOException
	{
		Object[][] main = ExcelUtils.getSheetIntoObjectArray("testdata/OpenEmrData.xlsx", "validCredentialData");
		return main;
	}
	
	@Test(priority = 1,dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String language,String expectedValue) {
		
		HomePage.sendUsername(driver, username);
		HomePage.sendPassword(driver, password);	
		HomePage.selectLanguage(driver, language);
		HomePage.clickOnLogin(driver);
		
		DashboardPage.waitForPresenceOfFlowBoard(driver);	
		String actualValue=DashboardPage.getCurrentTitle(driver);
		
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	@DataProvider
	public Object[][] invalidCredentialData() throws IOException
	{
		Object[][] main = ExcelUtils.getSheetIntoObjectArray("testdata/OpenEmrData.xlsx", "invalidCredentialData");
		return main;
	}
	
	
	@Test(priority = 2,dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username,String password,String language,String expectedValue)
	{
		
		HomePage.sendUsername(driver, username);
		HomePage.sendPassword(driver, password);	
		HomePage.selectLanguage(driver, language);
		HomePage.clickOnLogin(driver);
		
		String actualValue = HomePage.getInvalidErrorMessage(driver);
		//Assert.assertEquals(actualValue, "Invalid username or password");
		
		//expected value is true
		Assert.assertTrue(actualValue.contains(expectedValue));
	}

	
}



