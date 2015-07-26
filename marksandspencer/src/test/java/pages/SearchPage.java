package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	private static WebElement element = null;
	 
	 public static WebElement searchBox(WebDriver driver){
	    element = driver.findElement(By.id("global-search"));
	    return element;
	 }
	 
	 public static void searchFor(WebDriver driver, String item){
		 searchBox(driver).sendKeys(item);
		 searchBox(driver).sendKeys(Keys.RETURN);
	 }

}
