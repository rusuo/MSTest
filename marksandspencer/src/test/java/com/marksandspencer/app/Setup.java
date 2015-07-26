package com.marksandspencer.app;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utility.Config;

public class Setup {
	public static WebDriver driver;

	@Before
	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Config.URL);
	 }
	
	@After
	public static void tearDown() {
		driver.quit();
	}

}
