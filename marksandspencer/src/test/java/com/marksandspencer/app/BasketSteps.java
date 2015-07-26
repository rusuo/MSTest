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

	public void setUpWebDriver() throws Exception {
		Setup.setUp();
	    Setup.driver.get(Config.URL);
	}
 
	public void tidyUp() {
		Setup.tearDown();
	}

	@Given("^I have added \"([^\"]*)\" item to my bag$")
	public void I_have_added_item_to_my_bag(String itemToSearchFor) throws Throwable {
		 setUpWebDriver();
		   SearchPage.searchFor(Setup.driver, itemToSearchFor);
		   IndividualItemPage.addItemToBag(Setup.driver);
	}

	@When("^I view the contents of my bag$")
	public void I_view_the_contents_of_my_bag()  {
	    IndividualItemPage.viewBagButton(Setup.driver).click();
	}

	  @Then("^I can see the contents of the bag include \"([^\"]*)\"$")
	  public void I_can_see_the_contents_of_the_bag_include(String itemName) throws Throwable {
		  List<WebElement> listOfItems = YourBagPage.basketList(Setup.driver);
		  for (int i = 0; i < listOfItems.size(); i++)
	      {
	          WebElement item = listOfItems.get(i);
	          Assert.assertTrue(item.getText().contains(itemName));
	      }
		  tidyUp();
	  }



}
