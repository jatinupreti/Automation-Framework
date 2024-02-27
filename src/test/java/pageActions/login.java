package pageActions;

import org.junit.Assert;
import org.openqa.selenium.By;
import base.BaseClass;

public class login extends BaseClass {
	
	By usernameField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");
	By inventoryPageHeader = By.xpath("//div[@class='app_logo']");
	
	public void verifyLoginPageIsDisplayed() {
		waitForElementToAppear(element(usernameField));
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		Assert.assertTrue(element(usernameField).isDisplayed());
		Assert.assertTrue(element(passwordField).isDisplayed());
		logMessage("User is on Login page");
	}
	
	public void enterUserName(String username) {
		SendKeys(element(usernameField),username);
		logMessage("user has entered username: "+username);
	}
	
	public void enterPassword(String password) {
		SendKeys(element(passwordField),password);
		logMessage("user has entered password: "+password);
	}
	
	public void clickOnLoginButton() {
		clickOnElement(element(loginButton));
		logMessage("User clicked on login button");
	}
	
	public void inventoryPageIsDisplayed() {
		waitForElementToAppear(element(inventoryPageHeader));
		Assert.assertEquals(element(inventoryPageHeader).getText(), "Swag Labs");
		Assert.assertTrue((getCurrentURL().contains("inventory")));
		logMessage("User is on Inventory page");
	}

}
