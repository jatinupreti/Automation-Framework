package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected static WebDriver driver;
	protected WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	public static Properties prop = new Properties();
	public static FileInputStream fr;
	public static File file;
	public static String locatorType;
	public static String locatorValue;
	public static String pageName;
	public static String ele;
	
	public BaseClass(String pageName) {
		BaseClass.pageName = pageName;
	}
	
	
/* Initiates chrome driver and maximize current window */
	public void tearUp() {
		logMessage("***********Starting chrome driver*************");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	
/* Closes chrome driver session */
	public void tearDown() {
		driver.quit();
		logMessage("***********Browser closed***************");
	}

/* used to launch URL
* @param takes valid input string to launch
*/
	public void launchApplication(String url) {
		driver.get(url);
	}
	
/*
 * click on WebElement
 * @param takes WebElement on which we want to click
 */
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
/*
 * send value to WebElement
 * @param takes WebElement and the value which we want to send
 */
	public void SendKeys(WebElement element, String keyToSend) {
		element.sendKeys(keyToSend);
	}

/*
 *  log messages in console
 *  Reporter is a class from TestNG
 */
	public void logMessage(String message) {
		Reporter.log(message, true);
	}

/*
 * get the current URL of browser
 * @return current browser URL
 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

/*
 * wait for an WebElement visiblity (Explicit wait)
 * @param takes the WebElement we want to locate
 * @Thows NoSuchElementException when the element doesn't meet the condition within the specified timeout
 */
	public void waitForElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

/*
 * wait for a certain measure of time before throwing an exception
 * @param takes integer seconds 
 * @Throws NoSuchElementException when the WebDriver cannot find the element within the specified timeout
 */
	public void waitForSync(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
/*
 * this methods reads properties
 * @param takes string that we want to read
 * @return the value of string
 */
	public static String readfile(String property) throws Exception{
		file= new File("src\\test\\resources\\Locators\\"+pageName+".properties");
		FileReader fr = new FileReader(file);
		prop.load(fr);
		String value = prop.getProperty(property);
		return value;
	}
	
/*
 * reads the value of xpath and css from properties and finds WebElement
 * @param takes String element we want to locate
 * @returns WebElement
 */
	public WebElement getElement(String key) {
		try {
			ele = readfile(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[]= ele.split(":");
		locatorValue= arr[1];
		locatorType = StringUtils.substringBetween(ele, "", ":");
		
		switch(locatorType) {
		case "xpath":
			return driver.findElement(By.xpath(locatorValue));
		case "css":
			return driver.findElement(By.cssSelector(locatorValue));
		case "classname":
			return driver.findElement(By.className(locatorValue));
		case "linkText":
			return driver.findElement(By.linkText(locatorValue));
		default:
			return driver.findElement(By.id(locatorValue));
		}		
	}

}
