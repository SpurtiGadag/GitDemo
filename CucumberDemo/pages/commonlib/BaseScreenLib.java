package commonlib;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
//import org.apache.tools.ant.Project;
//import org.apache.tools.ant.ProjectHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hook;


public class BaseScreenLib {

	WebDriverWait wait = null;
	protected Logger logger = Logger.getLogger(getClass());
	
	protected static WebDriver driver=Hook.getDriver();
	
	
	public By toBy(String selector) {
		By by = null;
		if (selector == null || selector.isEmpty()) {
			throw new IllegalArgumentException(
					"Argument can not be empty or null");
		}
		if (selector.startsWith("xpath=") || selector.startsWith("//")) {
			if (selector.startsWith("xpath=")) {
				selector = stripFirstSegment(selector, "=");
			}
			by = By.xpath(selector);
		} else if (selector.startsWith("css=")) {
			selector = stripFirstSegment(selector, "=");
			by = By.cssSelector(selector);
		} else if (selector.startsWith("link=")) {
			selector = stripFirstSegment(selector, "=");
			by = By.linkText(selector);
		} else if (selector.startsWith("id=")) {
			selector = stripFirstSegment(selector, "=");
			by = By.id(selector);
		} else if (selector.startsWith("linkText=")) {
			selector = stripFirstSegment(selector, "=");
			by = By.linkText(selector);
		} else {
			by = By.id(selector);
		}
		return by;
	}
	

	public By getBy(String selector) {
		try {
			return toBy(selector);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	 
	
    public static String stripFirstSegment(String value, String separator) {
        if (value == null) {
            return null;
        }

        int pos = value.indexOf(separator);
        return pos >= 0 ? value.substring(pos + separator.length()) : value;
    }


	public void click(String locator) {
		try {
			this.click(getBy(locator));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void click(By by) throws Exception {
		if (driver.findElements(by).isEmpty()) {
			wait = new WebDriverWait(driver, 50);
		}
		if (driver.findElements(by).isEmpty()) {
			throw new Exception(
					(driver.findElement(by) + " Element is not present"));
		}
		if (driver.findElement(by).isDisplayed()) {
			driver.findElement(by).click();
		} else {
			throw new Exception(
					(driver.findElement(by) + " Element is not displayed"));
		}
	}

	
	public void doubleClick(String locator) {
		try {
			this.doubleClick(getBy(locator));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doubleClick(By by) throws Exception {
		if (driver.findElements(by).isEmpty()) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		}
		if (driver.findElements(by).isEmpty()) {
			throw new Exception(
					(driver.findElement(by) + " Element is not present"));
		}
		if (driver.findElement(by).isDisplayed()) {
			Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(by)).build().perform();
		} else {
			throw new Exception(
					(driver.findElement(by) + " Element is not displayed"));
		}
	}
	
	/******************************************************************************************************* SELECT FUNCTION *************************************************************************/

	public static void selectOption(WebElement select, String optionLocator) {
		// select the item
		Select sel = new Select(select);
		if (optionLocator.startsWith("value=")) {
			String part = stripFirstSegment(optionLocator, "=");
			sel.selectByValue(part);
		} else if (optionLocator.startsWith("index=")) {
			String part = stripFirstSegment(optionLocator, "=");
			sel.selectByIndex(Integer.parseInt(part));
		} else {
			if (optionLocator.startsWith("label=")) {
				optionLocator = stripFirstSegment(optionLocator,
						"=");
			}
			sel.selectByVisibleText(optionLocator);
		}
	}

	public void selectOption(By toSelect, String optionLocator) {
		WebElement element = driver.findElement(toSelect);
		selectOption(element, optionLocator);
	}

	public void select(String selectLocator, String optionLocator)
			throws Exception {
		if (optionLocator == null || optionLocator.isEmpty()) {
			this.select(selectLocator, 0);
		} else {
			this.select(getBy(selectLocator), optionLocator);
		}
	}

	public void select(String selectorLocator, int index) throws Exception {
		if (driver.findElements(getBy(selectorLocator)).isEmpty()) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		}
		if (driver.findElements(getBy(selectorLocator)).isEmpty()) {
			throw new Exception(
					(driver.findElements(getBy(selectorLocator)) + " Element is not present"));
		}
		if (driver.findElement(getBy(selectorLocator)).isDisplayed()) {
			Select sel = new Select(driver.findElement(getBy(selectorLocator)));
			sel.selectByIndex(index);
		} else {
			throw new Exception(
					(driver.findElement(getBy(selectorLocator)) + " Element is not displayed"));
		}
	}

	public void select(By by, String optionLocator) throws Exception {
		if (driver.findElements(by).isEmpty()) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		}
		if (driver.findElements(by).isEmpty()) {
			throw new Exception(
					(driver.findElement(by) + " Element is not present"));
		}
		if (driver.findElement(by).isDisplayed()) {
			selectOption(by, optionLocator);
		} else {
			throw new Exception(
					(driver.findElement(by) + " Element is not displayed"));
		}

	}

	/******************************************************************************************************* TYPE FUNCTION *************************************************************************/

	public static void simulateJsEvent(WebDriver driver, WebElement forElement,
			String eventType) {
		// and simulate firing the change event
		String simulateEventJs = "(function fireEvent(element,event) {\r\n"
				+ "    if (document.createEventObject) {\r\n"
				+ // dispatch for IE
				"        var evt = document.createEventObject();\r\n"
				+ "        return element.fireEvent('on'+event,evt)\r\n"
				+ "    } else {\r\n"
				+ // dispatch for firefox + others
				"        var evt = document.createEvent('HTMLEvents');\r\n"
				+ "        evt.initEvent(event, true, true );\r\n"
				+ "        return !element.dispatchEvent(evt);\r\n"
				+ "    }\r\n" + "})(arguments[0], arguments[1]);";
		((JavascriptExecutor) driver).executeScript(simulateEventJs,
				forElement, eventType);
	}

	public void clearAndType(WebElement typeIn, String value) {
		if ("input".equals(typeIn.getTagName())) {
			String type = typeIn.getAttribute("type");
			if ("radio".equals(type) || "hidden".equals(type)
					|| "checkbox".equals(type) || "button".equals(type)
					|| "submit".equals(type) || "reset".equals(type)
					|| "image".equals(type)) {
				// can't type into this type of input, so just set the 'value'
				// attribute via javascript
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].value=arguments[1];", typeIn, value);
				// and simulate firing the change event so listeners get
				// notified.
				simulateJsEvent(driver, typeIn, "change");
				return;
			}
		}

		// otherwise do the usual webdriver typing calls.
		typeIn.clear();
		if (value != null) {
			typeIn.sendKeys(value);
			if (!value.equals(typeIn.getAttribute("value"))) {
				// workaround bug in chromedriver just set the 'value' attribute
				// via javascript
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].value=arguments[1];", typeIn, value);
				// and simulate firing the change event so listeners get
				// notified
				simulateJsEvent(driver, typeIn, "change");
			}
		}
	}

	public void clearAndType(WebDriver driver, By toTypeIn, String value) {
		WebElement element = driver.findElement(toTypeIn);
		clearAndType(element, value);
	}
	
	public void clearAndType(By toTypeIn, String value) {
		WebElement element = driver.findElement(toTypeIn);
		clearAndType(element, value);
	}

	public void type(String locator, String value) throws Exception {
		this.type(getBy(locator), value);
	}

	public void type(By by, String value) throws Exception {

		if (driver.findElements(by).isEmpty()) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		}
		if (driver.findElements(by).isEmpty()) {
			throw new Exception(
					(driver.findElement(by) + " Element is not present"));
		}
		if (driver.findElement(by).isDisplayed()) {
			clearAndType(driver, by, value);
		} else {
			throw new Exception(
					(driver.findElement(by) + " Element is not displayed"));
		}

	}

	/******************************************************************************************************* OPEN URL FUNCTION *************************************************************************/
	public static String MWS_ROOT_CONTEXT = "";
	
	 public static boolean notEmpty(String str) 
	 {
	        return ((str != null) && (str.length() > 0));
	    }
	public String toRelativeUrl(String relativePath) throws Exception {
		if (!relativePath.startsWith("/")) {
			return relativePath;
		}

		if (notEmpty(MWS_ROOT_CONTEXT)) {
			if (!relativePath.startsWith(MWS_ROOT_CONTEXT)) {
				relativePath = MWS_ROOT_CONTEXT + relativePath;
			}
		}

		return relativePath;
	}

	
	public void openURL(String url) throws Exception {
		
		driver.get(url);
		waitForPageToBeLoaded("10000");
	}

	/******************************************************************************************************* WAIT FOR ELEMENT TO BE NOT PRESENT *************************************************************************/

	public int convertStringToInt(String timeoutInMilliSeconds) {
		return new Integer(timeoutInMilliSeconds).intValue();

	}

	public void waitForElementToBeNotPresent(String locator,
			String timeoutInMilliSeconds) throws Exception {
		waitForElementToBeNotPresent(getAppropriateBy(locator),
				convertStringToInt(timeoutInMilliSeconds));
	}

	public void waitForElementToBeNotPresent(By by, int timeoutInMilliSeconds)
			throws Exception {

		long startTime = System.currentTimeMillis();
		long endTime = startTime + (timeoutInMilliSeconds * 1000);

		while (System.currentTimeMillis() < endTime) {
			try {
				if (!isElementPresent(by)) {
					return;
				}
			} catch (Throwable t) {
			}
			sleep(500);
		}

		if (isElementPresent(by)) {
			throw new Exception("Timed out waiting for element to disappear: "
					+ by.toString());
		}
	}

	/******************************************************************************************************* WAIT FOR ELEMENT TO BE NOT PRESENT *************************************************************************/

	public void waitForElementToBePresent(String locator,
			String timeoutInMilliSeconds) throws Exception {
		waitForElementToBePresent(getAppropriateBy(locator),
				convertStringToInt(timeoutInMilliSeconds));
	}

	public void waitForElementToBePresent(By by, int timeoutInMilliSeconds)
			throws Exception {
		System.out.println("timeout passed in milli seconds"+timeoutInMilliSeconds);

		WebDriverWait wait = new WebDriverWait(driver,
				timeoutInMilliSeconds / 1000);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Throwable t) {

		}
		if (!isElementPresent(by)) {
			throw new Exception("Timed out waiting for element: "
					+ by.toString());
		}
	}

	/******************************************************************************************************* WAIT FOR ELEMENT TO BE VISIBLE *************************************************************************/

	public void waitForElementToBeVisible(String waitLocator,
			String timeoutInMilliSeconds) throws NumberFormatException,
			Exception {

		waitForElementToBeVisible(getAppropriateBy(waitLocator), new Integer(
				timeoutInMilliSeconds).intValue());

	}

	public void waitForElementToBeVisible(By by, int timeoutInMilliSeconds)
			throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,
				timeoutInMilliSeconds / 1000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Throwable t) {
			if (!driver.findElement(by).isEnabled()) {
				throw new Exception("Element: " + by.toString()
						+ " is present but not visible");
			} else {
				throw new Exception("Element: " + by.toString()
						+ " is not present");
			}
		}
	}

	/******************************************************************************************************* WAIT FOR ELEMNT TO BE NOT VISIBLE *************************************************************************/

	public void waitForElementToBeNotVisible(String locator,
			String timeoutInMilliSeconds) throws Exception {
		waitForElementToBeNotVisible(getAppropriateBy(locator),
				convertStringToInt(timeoutInMilliSeconds));
	}

	public void waitForElementToBeNotVisible(By by, int timeoutInMilliSeconds)
			throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,
				timeoutInMilliSeconds / 1000);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Throwable t) {
		}
		if (isVisible(driver, by)) {
			throw new Exception(
					"Timed out waiting for element to become invisible: "
							+ by.toString());
		}
	}

	/******************************************************************************************************* CLICK AND WAIT FUNCTION *************************************************************************/

	public void clickAndWait(String clickLocator, String waitLocator,
			String retryInterval) throws Exception {
		
		click(clickLocator);
		waitForElementToBeVisible(waitLocator, retryInterval);
	}

	/******************************************************************************************************* CHECK IS ELEMENT PRESENT *************************************************************************/

	public boolean isElementPresent(String locator) {
		return isElementPresent(getAppropriateBy(locator));
	}

	public boolean isElementPresent(By by) {
		try {
			/*
			 * // this will make sure that we select the frame if
			 * (findElementsAcrossFrames) { findElementAcrossFrames(by,
			 * SAGTargetLocator.TOP_LEVEL_FRMAE_ID,
			 * SAGTargetLocator.TOP_LEVEL_FRMAE_ID); }
			 */
			WebElement findElement = driver.findElement(by);
			System.out.println("In isElementPresent for " + by.toString()
					+ " isDisplayed " + findElement.isDisplayed()
					+ " isEnabled " + findElement.isEnabled());
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	/******************************************************************************************************* HANDLE ALERT *************************************************************************/
	public void handleAlert(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException ex) {
		}
	}

	public String getConfirmation(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		// Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;
		// return getConfirmation();
	}

	public boolean isConfirmationPresent(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			/*
			 * if(selenium.isAlertPresent()){ Alert alert =
			 * driver.switchTo().alert(); return true; }
			 */
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}

	public void sleep(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}

	/******************************************************************************************************* WAIT FOR PAGE TO BE LOADED *************************************************************************/
	public void waitForPageToBeLoaded(String timeoutInMilli)
			throws Exception {
		int timeoutInMilliSeconds = Integer.parseInt(timeoutInMilli);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				String readyState = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.readyState");
				boolean test = readyState.equalsIgnoreCase("complete");
				if (test) {
					System.out.println("Page is loaded");
				} else {
					System.out.println("Waiting for page to load");
				}
				return test;
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(this.driver,
				timeoutInMilliSeconds / 1000);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Error while waiting for page to laod "
					+ error.getMessage());
		}
	}

	/******************************************************************************************************* IS VISIBLE *************************************************************************/

	public boolean isElementVisible(String locator) {

		return isElementVisible(getAppropriateBy(locator));
	}

	public boolean isElementVisible(By by) {
		System.out.println("Entering SAGEventFiringWebDriver.isVisible "
				+ by.toString());
		try {
			WebElement findElement = driver.findElement(by);
			System.out.println("Found the element in isVisible "
					+ by.toString());
			return findElement.isDisplayed();
		} catch (Throwable t) {
			// t.printStackTrace();
			return false;
		}
	}

	public By getAppropriateBy(String locator) {
		if (null == locator) {
			return null;
		} else if (locator.contains("//")) {
			return By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			// if the css is using "contains" then try to convert it to xpath
			if (locator.indexOf(":contains(") != -1) {

				String convertedXpath = "//"
						+ getTagNameFromCss(locator)
						+ "[contains(concat(descendant-or-self::text()[1], descendant-or-self::text()[2], descendant-or-self::text()[3], descendant-or-self::text()[4], descendant-or-self::text()[5]), "
						+ getQoutes(locator)
						+ getVisibleTextToSearchFromCss(locator)
						+ getQoutes(locator) + ")]";
				return By.xpath(convertedXpath);
			} else {
				return By.cssSelector(locator.substring("css=".length()));
			}
		} else if (locator.startsWith("link=")) {
			// return By.linkText(locator.substring("link=".length()));
			return By.xpath("//a[contains(text(), '"
					+ locator.substring("link=".length()) + "')]");
			// a[contains(text(), 'Users')]
		} else if (locator.startsWith("id=")) {
			return By.id(locator.substring("id=".length()));
		} else {
			return By.id(locator);
			// System.out.println("*******************************************************");
			// System.out.println("Specified locator type is not recognized " +
			// locator);
			// System.out.println("*******************************************************");
			// throw new
			// RuntimeException("Specified locator type is not recognized " +
			// locator);
		}
	}

	private String getVisibleTextToSearchFromCss(String locator) {
		int startIndex = locator.indexOf("(") + 1;
		int endIndex = locator.lastIndexOf(")");
		return locator.substring(startIndex, endIndex);
	}

	private String getTagNameFromCss(String locator) {
		int startIndex = "css=".length();
		int endIndex = locator.indexOf(":");
		return locator.substring(startIndex, endIndex);
	}

	private String getQoutes(String locator) {
		String qoute = null;
		if (locator.contains("\'")) {
			qoute = "\"";
		} else {
			qoute = "\'";
		}
		return qoute;
	}

	/**
	 * Returns true if the specified element is present, false otherwise.
	 *
	 * @param by
	 * @return
	 */

	/**
	 * Returns true if the specified element is visible, false otherwise.
	 *
	 * @param by
	 * @return
	 */
	public boolean isVisible(WebDriver driver, By by) {
		System.out.println("Entering SAGEventFiringWebDriver.isVisible "
				+ by.toString());
		try {
			WebElement findElement = driver.findElement(by);
			System.out.println("Found the element in isVisible "
					+ by.toString());
			return findElement.isDisplayed();
		} catch (Throwable t) {
			// t.printStackTrace();
			return false;
		}
	}

	public WebElement findElement(WebDriver driver, String locator) {
		return findElement(driver, getAppropriateBy(locator));
	}
	public static int DEFAULT_TIMEOUT_FOR_FIND_ELEMENT_IN_MILLISECONDS = 30000;
	public static int DEFAULT_TIMEOUT_FOR_FIND_ELEMENT_IN_SECONDS = 5;
	
	public WebElement findElement(WebDriver driver, By appropriateBy) {
		// log.info("Entering findElement for locator = "
		// + appropriateBy.toString());
		WebElement ele = null;
		long endTime = System.currentTimeMillis()
				+ (DEFAULT_TIMEOUT_FOR_FIND_ELEMENT_IN_SECONDS * 1000);
		int i = 0;
		while (System.currentTimeMillis() < endTime) {
			// log.debug("iteration " + i + " trying to find element");
			try {
				List<WebElement> findElements = driver
						.findElements(appropriateBy);
				if (findElements.size() == 1) {
				/*
					 * log.info(i + " iteration found element for locator = " +
					 * appropriateBy.toString() + " isVisible =" +
					 * ele.isDisplayed() + " isEnabled=" + ele.isEnabled() +
					 * " isSelected=" + ele.isSelected());
					 */
					return ele;
				} else if (findElements.size() > 1) {
					// log.info(i + " iteration found " + findElements.size()
					// + " elements. Refine Xpath ");
					return findElements.get(0);
				} /*
				 * else if (findElements.size() == 0 &&
				 * findElementsAcrossFrames) { // if we did not find any element
				 * in the current frame and // user has specified to search
				 * across frames, then do so // now
				 * findElementAcrossFrames(appropriateBy, "relative=top",
				 * "relative=top"); }
				 */
			} catch (StaleElementReferenceException e) {
				// e.printStackTrace();
			}
			i++;
		}
		return ele;
	}

	public void checkUncheck(String locator,
			String checkUncheck) {

		if (null == checkUncheck) {
			return;
		}

		WebElement findElement = findElement(driver, locator);
		if (checkUncheck.equalsIgnoreCase("ON")
				|| checkUncheck.equalsIgnoreCase("YES")
				|| checkUncheck.equalsIgnoreCase("TRUE")
				|| checkUncheck.equalsIgnoreCase("ENABLE")) {
			if (!findElement.isSelected()) {
				findElement.click();
			}
		} else {
			if (findElement.isSelected()) {
				findElement.click();
			}
		}

	}

	/**
	 * It will close all the opened Tabs on the MWS Page.
	 *
	 * @throws ScreenActionFailedException
	 *
	 */

	// set timeout to old value
	// selenium.setTimeout(Constants.DEFAULT_TIMEOUT);

	// if tab close button and blank page title are not present then
	// login again
	/*
	 * if (!selenium.isVisible(BLANK_PAGE_TITLE) &&
	 * !selenium.isVisible(TAB_CLOSE_BUTTON)) { MWSLoginScreen mwslogin = new
	 * MWSLoginScreen(driver, selenium); mwslogin.l }
	 */

	public void chooseOkOnNextConfirmation(WebDriver driver) {
		getConfirmation(driver);
	}

	public void handleAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			// exception handling
		}
	}

	

	public void closeAllOpenedTabsThroughMenu(WebDriver driver) throws NumberFormatException, Exception {
		if (!driver.findElements(
				By.xpath("//li[2][contains(@class,'noodle_tabBar_user_tab')]"))
				.isEmpty()) {

			WebElement we = driver
					.findElement(By
							.xpath("//li[contains(@id,'tab') and contains(@class,'selected')]//img[contains(@src,'Tools')]"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//li[contains(@id,'tab') and contains(@class,'selected')]//img[contains(@src,'Tools')]")));
			Thread.sleep(1000);

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].click();", we);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[div[contains(@class,'caf-popup')]]//a[text()='Close All Others']")));
			Actions oAction = new Actions(driver);
			WebElement closeAllOthers = driver
					.findElement(By
							.xpath("//div[div[contains(@class,'caf-popup')]]//a[text()='Close All Others']"));
			oAction.moveToElement(closeAllOthers).build().perform();
			oAction.click(closeAllOthers).build().perform();
			Thread.sleep(4000);
			waitForElementToBeVisible("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]", "20000");
			
			oAction.moveToElement(
					driver.findElement(By
							.xpath("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]")))
							.build().perform();
			
			oAction.click(driver.findElement(By.xpath("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]"))).build().perform();
			waitForElementToBeNotVisible("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]", "20000");
			waitForPageToBeLoaded("5000");
			
		}
		Thread.sleep(3500);
		if (!driver.findElements(
				By.xpath("//li[contains(@class,'noodle_tabBar_user_tab')]"))
				.isEmpty()) {

			WebElement we = driver
					.findElement(By
							.xpath("//li[contains(@id,'tab') and contains(@class,'selected')]//img[contains(@src,'Tools')]"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//li[contains(@id,'tab') and contains(@class,'selected')]//img[contains(@src,'Tools')]")));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].click();", we);

			Actions oAction = new Actions(driver);
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[div[contains(@class,'caf-popup')]]//a[text()='Close' or text()='Close Workspace']")));
			oAction = new Actions(driver);

			WebElement close = driver
					.findElement(By
							.xpath("//div[div[contains(@class,'caf-popup')]]//a[text()='Close' or text()='Close Workspace']"));

			Thread.sleep(1000);

			oAction.moveToElement(
					driver.findElement(By
							.xpath("//div[div[contains(@class,'caf-popup')]]//a[text()='Close' or text()='Close Workspace']")))
							.build().perform();
			Thread.sleep(1000);
			oAction.click(
					driver.findElement(By
							.xpath("//div[div[contains(@class,'caf-popup')]]//a[text()='Close' or text()='Close Workspace']")))
							.build().perform();
			Thread.sleep(1000);
			if (!driver
					.findElements(
							By.xpath("//li[contains(@class,'noodle_tabBar_user_tab')]"))
							.isEmpty()) {
				Thread.sleep(1000);
				WebElement closeImage = driver
						.findElement(By
								.xpath("//li[contains(@id,'tab') and contains(@class,'selected')]//img[contains(@src,'DeletePortlet')]"));
				Thread.sleep(1000);

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].click();", closeImage);
				// oAction.moveToElement(driver.findElement(By.xpath("//li[contains(@id,'tab') and contains(@class,'selected')]//img[contains(@src,'DeletePortlet')]"))).build().perform();
				// oAction.click(driver.findElement(By.xpath("//li[contains(@id,'tab') and contains(@class,'selected')]//img[contains(@src,'DeletePortlet')]"))).build().perform();

			}
			Thread.sleep(2000);
			if (isElementPresent("//button//span[text()='Close']")) {
				click("//button//span[text()='Close']");
				waitForElementToBeNotVisible("//button//span[text()='Close']",
						"5000");
				try{
					waitForElementToBeVisible("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]", "3000");
				}
				catch(Exception e){
					
				}
			}
			if (!driver
					.findElements(
							By.xpath("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]"))
							.isEmpty()) {
				Thread.sleep(1000);
				oAction.moveToElement(
						driver.findElement(By
								.xpath("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]")))
								.build().perform();
				Thread.sleep(1000);
				oAction.click(driver.findElement(By
								.xpath("//div[@class='caf-dialog-submit']//button[span[span[text()='Close']]]"))).build().perform();
				Thread.sleep(2000);
				if (isElementPresent("//button//span[text()='Close']")) {
					click("//button//span[text()='Close']");
					waitForElementToBeNotVisible("//button//span[text()='Close']",
							"5000");
				}

				wait = new WebDriverWait(driver, 4);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By
						.xpath("//li[contains(@class,'noodle_tabBar_user_tab')]")));
			}

			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//li[contains(@class,'noodle_tabBar_user_tab')]")));
			waitForElementToBeVisible("//a[text()='Navigate']", "18000");
			click("//a[text()='Navigate']");
			waitForElementToBeVisible("//span[text()='Applications']", "15000");
		}
	}
	
	 private boolean isSeleniumServerRunning = true;
	private void checkSeleniumServerStatus() {
        if (!isSeleniumServerRunning) {
            System.out.println("********** SELENIUM SERVER has stopped, throwing RuntimeException to stop any further selenium rc command execution");
            throw new RuntimeException(
                "Selenium Server has been stopped. Cant perform any selenium action now");
        }
    }

	public void selectWindow(String windowID) {
        System.out.println("Entering: selectWindow");
        checkSeleniumServerStatus();
        sleep(2000);
        driver.switchTo().window(windowID);
    }
	
	 public void selectPopUp(String windowID) {
	        checkSeleniumServerStatus();
	        ((BaseScreenLib) driver).selectWindow(windowID);
	    }
	 
	 private String BROWSER = null;
	 public static final String BROWSER_IE = "*iexplore";

		/**
		 * Execute tests on firefox browser
		 */
		public static final String BROWSER_FIREFOX = "*firefox";

		public static final String BROWSER_GOOGLE_CHROME = "*googlechrome";

		public static final String BROWSER_CHROME = "*chrome";
	 public void killBrowser() {
	       System.out.println("Entering: killBrowser for browser = " + this.BROWSER);
	        checkSeleniumServerStatus();
	        String[] command = null;
	        if (isWin()) {
	            System.out.println("It is a windows machine and browser is "
	                + this.BROWSER);
	            if (this.BROWSER.startsWith(BROWSER_IE)) {
	                command = new String[] { "cmd", "/c", "taskkill", "/F", "/IM",
	                    "iexplore.exe" };
	                System.out.println("Killing All IE browser instances");
	            } else if (this.BROWSER.startsWith(BROWSER_FIREFOX)) {
	                command = new String[] { "cmd", "/c", "taskkill", "/F", "/IM",
	                    "firefox.exe" };
	                System.out.println("Killing All Firefox browser instances");
	            } else if (this.BROWSER.startsWith(BROWSER_GOOGLE_CHROME)) {
	                command = new String[] { "cmd", "/c", "taskkill", "/F", "/IM",
	                    "chrome.exe" };
	                System.out.println("Killing All Chrome browser instances");
	            }
	        } else {
	            System.out.println("It is a unix machine and browser is "
	                + this.BROWSER);
	            if (this.BROWSER.startsWith(BROWSER_FIREFOX)) {
	                command = new String[] { "pkill", "firefox" };
	                System.out.println("Killing All Firefox browser instances");
	            }
	        }
	        System.out.println("Common to kill = " + command);

	        try {
	            Runtime.getRuntime().exec(command, null, null);
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	    }

	 public boolean isWin() {
	        if (File.separatorChar == '\\') {
	            return true;
	        } else
	            return false;
	    }
	 
	 public void clickAt(String locator, String coOrd) throws InterruptedException {
			click(locator);
			Thread.sleep(500);
		
	}
	 
	 
	 /***********************************************************************************/
	 public void attachFile(By by,String attachFile) {
			try {
				
				driver.findElement(by).sendKeys(attachFile);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	 /***********************************************************************************/
	 
	 public String constructBracktes(String value) {
			
			String result = "${"+value+"}";
			return result;
		}
	 /**********************************************************************************/

	 public By containsLocator(String value) {
		 
		 By result = By.xpath("//*[contains(text(),'"+value+"')]");
		 return result;
	 }
	 /**********************************************************************************/		 

    // use this method in case of error "Element has Zero size"
    public void mouseHoverAndClick(By element) {
    	Actions actions = new Actions(driver);
    	WebElement menu = driver.findElement(element);
    	actions.moveToElement(menu);
     	actions.click().build().perform();
    }

    
}


