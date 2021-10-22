package stepDefinations;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class step {
	
	@Given("^Open browser$")
	public void Open_browser() throws Throwable
	{
		System.out.println("Step to open google chrome browser");
	}

	@When("^Enter Valid Username and Password$")
	public void Enter_Valid_Username_and_Password() throws Throwable
	{
		System.out.println("Step to Enter valid username and password");
	}
	@Then("^Verify logout button is visible$")
	public void Verify_logout_button_is_visible() throws Throwable
	{
		System.out.println("Verify Logout Button is visible");
	}
}
