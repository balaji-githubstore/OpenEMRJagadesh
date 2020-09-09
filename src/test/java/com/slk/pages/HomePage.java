package com.slk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private static By usernameLocator = By.xpath("//input[@id='authUser']");
	private static By passwordLocator=By.name("clearPass");
	private static By languageLocator=By.name("languageChoice");
	private static By loginLocator=By.xpath("//button[@type='submit']");
	private static By errorLocator= By.xpath("//div[contains(text(),'Invalid')]");
	
	
	
	public static void sendUsername(WebDriver driver, String username) 
	{
		driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public static void sendPassword(WebDriver driver,String password)
	{
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public static void selectLanguage(WebDriver driver,String languageText)
	{
		Select selectLanguage=new Select(driver.findElement(languageLocator));
		selectLanguage.selectByVisibleText(languageText);
	}
	
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(loginLocator).click();
	}
	
	public static String getInvalidErrorMessage(WebDriver driver)
	{
		return  driver.findElement(errorLocator).getText();
	}

}
