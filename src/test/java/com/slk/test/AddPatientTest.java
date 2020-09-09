package com.slk.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.slk.base.WebDriverWrapper;
import com.slk.pages.HomePage;

public class AddPatientTest extends WebDriverWrapper {
	
	@Test
	public void createNewPatientTest()
	{
		
//		for(int i=1;i<=10;i++)
//		{
//			//write xpath to gettext the CAT-2172
//			String ticket ="CAT-2172";	
//			String txt = ticket.replace("CAT-", "");		
//			int num = Integer.parseInt(txt)-i;
//			System.out.println("//span[contains(text(),'CAT-"+num+"')");
//		}
		
		HomePage.sendUsername(driver, "admin");
		HomePage.sendPassword(driver, "pass");	
		HomePage.selectLanguage(driver, "English (Indian)");
		HomePage.clickOnLogin(driver);
		
		//assertion
		
	}
}
