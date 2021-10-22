package is;
import org.openqa.selenium.By;

import com.intuit.karate.driver.Keys;

import commonlib.BaseScreenLib;
import commonlib.ConstantsLib;

public class ISLoginPage extends BaseScreenLib {
	By IS_USERNAME = By.xpath("//*[@id='isac_usernameElementRef']");
	By IS_PASSWORD = By.xpath("//*[@id='isac_passwordFieldRef']");
	By IS_LOGIN_BUTTON =By.xpath ("//button[contains(text(),'Log in')]");
	By Check_logged_In = By.xpath("//*[@id=\"monitor-link\"]");


private void enterUsername(String username) {
	try {
		type(IS_USERNAME,username);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}
private void enterPassword(String password) {
	try {
		type(IS_PASSWORD,password);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
public void clickLoginButton() {
    try {
		click(IS_LOGIN_BUTTON);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
public void loginToIS(String url,String username,String password) {
	
	try {
		openURL(url);
		waitForElementToBePresent(IS_LOGIN_BUTTON, ConstantsLib.DEFAULT_TIMEOUT_IN_MILLISECONDS);
		if(isElementPresent(IS_LOGIN_BUTTON) == true) {
			enterUsername(username);
			enterPassword(password);
			clickLoginButton();
			waitForElementToBeVisible(Check_logged_In, DEFAULT_TIMEOUT_FOR_FIND_ELEMENT_IN_MILLISECONDS);
				System.out.println("*************** Successfully logged in to Integration Server! ***************");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("*************** Failed to Login to Integration Server. May be sever is not up or DataStore is down! ***************");
	} 		


}

}