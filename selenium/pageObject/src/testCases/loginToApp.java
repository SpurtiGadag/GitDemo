package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectrepo.RediffLoginPage;
import objectrepo.RediffLoginPF;
public class loginToApp {

	@Test
	public void login()
	{
	System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	RediffLoginPF rd=new RediffLoginPF(driver);
	rd.emailid().sendKeys("Hello");
	rd.password().sendKeys("Hello");
	rd.submit().click();
	}

}
