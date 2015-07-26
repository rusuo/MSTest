package com.marksandspencer.app;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;
import utility.*;

public class BasketSteps {

	private WebDriver driver = Setup.driver;

	public void setUpWebDriver() throws Exception {
		Setup.setUp();
	    Setup.driver.get(Config.URL);
	}
 
	public void tidyUp() {
		Setup.tearDown();
	}

	
	@Given("^I have added a shirt to my bag$")
	public void I_have_added_a_shirt_to_my_bag() throws Throwable {
	   setUpWebDriver();
	   SearchPage.searchFor(driver, "summer shirt");
	   IndividualItemPage.addItemToBag(driver);
	}

	@When("^I view the contents of my bag$")
	public void I_view_the_contents_of_my_bag()  {
	    IndividualItemPage.viewBagButton(driver).click();
	}

	@Then("^I can see the contents of the bag include a shirt$")
	public void I_can_see_the_contents_of_the_bag_include_a_shirt() {
		List<WebElement> listOfItems = YourBagPage.basketList(driver);
		for (int i = 0; i < listOfItems.size(); i++)
	    {
	        WebElement item = listOfItems.get(i);
	        Assert.assertTrue(item.getText().contains(IndividualItemPage.itemName(driver).getText())); 
	     }
	}

}
