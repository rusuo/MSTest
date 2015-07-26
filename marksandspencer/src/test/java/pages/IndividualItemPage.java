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
	
	public static void selectSize(WebDriver driver) throws InterruptedException{
        List<WebElement> allSizes = driver.findElements(By.xpath("//div[@class='size-table-wrapper']/table/tbody/tr/td"));
        for (int i = 0; i < allSizes.size(); i++)
        {
        	if (!allSizes.get(i).getAttribute("title").equals("Out of stock")){
        		allSizes.get(i).click();
        	}
        }
	}
	
	 public static WebElement addToBagButton(WebDriver driver){
	    element = driver.findElement(By.className("addbag"));
	    return element;
	 }
	 
	 public static void addItemToBag(WebDriver driver) throws InterruptedException{
		 selectSize(driver);
		 addToBagButton(driver).click();
	 }
}
