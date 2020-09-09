package com.slk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private static By flowboardLocator=By.xpath("//div[text()='Flow Board']");
	
	
	public static void waitForPresenceOfFlowBoard(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(flowboardLocator));
	}
	
	
	public static String getCurrentTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public static void mouseHoverOnPatientClient()
	{
		
	}
	
	//clickonpatient

}
