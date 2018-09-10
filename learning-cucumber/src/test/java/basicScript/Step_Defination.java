package basicScript;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_Defination {

	@Given("^I open the browser$")
	public void step1() {

		System.out.println("I open the browser");

	}

	@When("^I execute the steps$")
	public void executeSteps() {

		System.out.println("I execute the steps");

	}

	@Then("^My test should pass$")
	public void finalVerification() {

		System.out.println("All Good :-)");

	}

}