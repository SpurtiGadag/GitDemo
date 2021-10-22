import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class cleatrip {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]"))
				.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[5]/div[3]/div[1]/div[1]"))
				.click();

		// driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/select[1]")).click();

		List<WebElement> agegrp = driver.findElements(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/select[1]"));
		Thread.sleep(10000);
		for (WebElement option : agegrp) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("2"))
				option.click();
			break;
		}
		WebElement StaticDropdown2 = driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[5]/select[1]"));

		Select dropdown2 = new Select(StaticDropdown2);

		dropdown2.selectByIndex(1);

		driver.findElement(
				By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[2]/button[1]"))
				.click();

		System.out.println(
				driver.findElement(By.xpath("//span[contains(text(),'Select Departure and Arrival airports/cities.')]"))
						.getText());

	}
}