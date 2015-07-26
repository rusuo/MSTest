package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndividualItemPage {
	private static WebElement element = null;
	
	/**
	 * In the search page, there are three elements with the className = basket.
	 * Search through the items and click on the one that has the type submit.
	 */
	public static void addToBag(WebDriver driver){
		 List<WebElement> allBaskets = driver.findElements(By.className("basket"));
		 for(int i = 0;i < allBaskets.size();i++) {
			if (allBaskets.get(i).getAttribute("type").equals("submit")){
				 allBaskets.get(i).click();;
			}
		 }
		 
	 }
	 
	/**
	 * @return the view bag button at the bottom of the page
	 */
	 public static WebElement viewBagButton(WebDriver driver){
		element = driver.findElement(By.cssSelector("#glbFloatDuck > ul > li.basket > a"));
		return element;
	 }
		 
	 /**
	  * Select the first available size for the product
	  */
	 public static void selectSize(WebDriver driver) {
	        List<WebElement> listOfSizes = driver.findElements(By.xpath("//div[@class='size-table-wrapper']/table/tbody/tr/td"));
	        for (int i = 0; i < listOfSizes.size(); i++)
	        {
	        	WebElement size = listOfSizes.get(i);
	        	if (!size.getAttribute("title").equals("Out of stock")){
	        		size.findElement(By.xpath(".//label")).click();
	        	}
	        }
	} 

	 public static void addItemToBag(WebDriver driver) throws InterruptedException{
		 selectSize(driver);
		 addToBag(driver);
	 }
}
