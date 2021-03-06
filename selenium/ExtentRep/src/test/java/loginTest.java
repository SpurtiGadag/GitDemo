import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class loginTest {
	ExtentReports extent=new ExtentReports();
	@BeforeTest
	public void config()
	{
		String Path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
		reporter.config().setReportName("WebAutomation Results");
		reporter.config().setDocumentTitle("TestResults");
	
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "SPKU");
	}

	@Test
	public void login()
	{
		ExtentTest Test=extent.createTest("LoginTest");
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.getTitle());
		driver.close();
		Test.fail("Test failed!!!");
		extent.flush();
	}
		

}
