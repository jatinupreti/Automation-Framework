package base;

import java.time.Duration;

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
	
	public void tearUp() {
		logMessage("***********Starting chrome driver*************");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	
	public void tearDown() {
		driver.quit();
		logMessage("***********Browser closed***************");
	}
	
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	public WebElement element(By element) {
		return driver.findElement(element);
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void SendKeys(WebElement element, String keyToSend) {
		element.sendKeys(keyToSend);
	}
	
	public void logMessage(String message) {
		Reporter.log(message, true);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public void waitForElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForSync(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	

}
