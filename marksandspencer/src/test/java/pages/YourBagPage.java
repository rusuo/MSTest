package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourBagPage {
	 
	/**
	 * @return the list of items in the basket
	 */
	public static List<WebElement> basketList(WebDriver driver){
		 List<WebElement> listOfItems = driver.findElements(By.className("basket-list"));
		 return listOfItems;
	 }
	
}
