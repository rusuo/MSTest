package com.marksandspencer.app;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasketSteps {

	private SeleniumTest script;

	public void setUpWebDriver() throws Exception {

	   script = new SeleniumTest();

	   script.setUp();

	   script.goToHomePage();

	}

	public void tidyUp() {

	script.tearDown();

	}

	@Given("^I have added a shirt to my bag$")
	public void I_have_added_a_shirt_to_my_bag() throws Throwable {
	   setUpWebDriver();
	}

	@When("^I view the contents of my bag$")
	public void I_view_the_contents_of_my_bag() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I can see the contents of the bag include a shirt$")
	public void I_can_see_the_contents_of_the_bag_include_a_shirt() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
