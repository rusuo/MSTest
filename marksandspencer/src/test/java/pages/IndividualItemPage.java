package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndividualItemPage {
	private static WebElement element = null;
	
	public static WebElement itemName(WebDriver driver){
	    element = driver.findElement(By.cssSelector("#product-detail-page > li.box.g12.fix > div > div.product-title.cf > h1"));
	    return element;
	 }
	
	 public static void addToBag(WebDriver driver){
		 List<WebElement> allBaskets = driver.findElements(By.className("basket"));
		 for(int i = 0;i < allBaskets.size();i++) {
			if (allBaskets.get(i).getAttribute("type").equals("submit")){
				 allBaskets.get(i).click();;
			}
		 }
		 
	 }
	 
	 public static WebElement viewBagButton(WebDriver driver){
		element = driver.findElement(By.cssSelector("#glbFloatDuck > ul > li.basket > a"));
		return element;
	 }
		  
	 public static void selectSize(WebDriver driver) throws InterruptedException{
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
