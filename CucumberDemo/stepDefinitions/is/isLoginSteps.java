package is;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.intuit.karate.driver.WebDriver;


//import is.ISLoginPage;
//import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class isLoginSteps {
	WebDriver driver;
	private is.ISLoginPage isLoginPage;
		


@Given(": Login to Integration Server using {},{},{}")
public void login_to_integration_server(String url,String isusername, String isPassword) throws Exception {
	isLoginPage.loginToIS(url, isusername, isPassword);

  
}

}
