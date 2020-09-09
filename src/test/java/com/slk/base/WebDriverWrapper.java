package com.slk.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebDriverWrapper {
	protected WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(@Optional("ff") String browserName) {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
		System.setProperty("webdriver.ie.driver", "driver/iedriverserver");

		if (browserName.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/b/openemr/index.php");
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
