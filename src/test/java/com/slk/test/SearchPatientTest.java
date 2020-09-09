package com.slk.test;

import org.testng.annotations.Test;

import com.slk.base.WebDriverWrapper;
import com.slk.pages.HomePage;

public class SearchPatientTest extends WebDriverWrapper {
	
	@Test
	public void searchPatientTest()
	{
		HomePage.sendUsername(driver, "admin");
		HomePage.sendPassword(driver, "pass");	
		HomePage.selectLanguage(driver, "English (Indian)");
		HomePage.clickOnLogin(driver);
		
		//assertion
	}

}
