package pageActions;

import org.junit.Assert;
import base.BaseClass;

public class login extends BaseClass {
	
	public login() {
		super("login");
	}

/*
 * method is used to launch URL
 * @param takes the url we want to launch
 */
	public void launchURL(String url) throws Exception {
		driver.get(url);
//		readfile("username");
	}

/*
 * verifies the user is on Login page
 */
	public void verifyLoginPageIsDisplayed() {
		waitForElementToAppear(getElement("username"));
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		Assert.assertTrue(getElement("username").isDisplayed());
		Assert.assertTrue(getElement("passwordField").isDisplayed());
		logMessage("User is on Login page");
	}

/*
 *  enters username in username field
 *  @param takes the username value
 */
	public void enterUserName(String username) {
		SendKeys(getElement("username"),username);
		logMessage("user has entered username: "+username);
	}

/*
 * enter password in password field
 * @param takes the password value
 */
	public void enterPassword(String password) {
		SendKeys(getElement("passwordField"),password);
		logMessage("user has entered password: "+password);
	}

/*
 * clicks on login button 
 */
	public void clickOnLoginButton() {
		clickOnElement(getElement("loginButton"));
		logMessage("User clicked on login button");
	}

	
/*
 * verify inventory page is displayed after entering user id and password
 */
	public void inventoryPageIsDisplayed() {
		waitForElementToAppear(getElement("inventoryPageHeader"));
		Assert.assertEquals(getElement("inventoryPageHeader").getText(), "Swag Labs");
		Assert.assertTrue((getCurrentURL().contains("inventory")));
		logMessage("User is on Inventory page");
	}

}
