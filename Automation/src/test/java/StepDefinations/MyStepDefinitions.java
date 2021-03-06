package StepDefinations;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class MyStepDefinitions {

    @Given("^User is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
    	System.out.println("Landing page code");
       
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
    	System.out.println("Uname and Password code");
    }

    @Then("^home page is populated$")
    public void home_page_is_populated() throws Throwable
    {
    	System.out.println("Home page code");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable
    {
    	System.out.println("cards page code");
    }
}