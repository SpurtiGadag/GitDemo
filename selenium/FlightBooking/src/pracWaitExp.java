import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pracWaitExp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
       driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
       WebDriverWait W= new WebDriverWait(driver,5);
       W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));
       WebElement msg= driver.findElement(By.xpath("//div[@id='results']"));
       Assert.assertTrue(msg.getText().contains("Process completed! This response has been loaded via the Ajax request directly from the web server, without reoading this page."));
	}

}
