package StepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageActions.login;

public class login_stepDef extends BaseClass{
	
	login loginTest = new login();
	
	@Given("^I launch '(.*)' url$")
	public void launchApplicationURL(String url) {
		launchApplication(url);
	}
	
	@Then("^I verify that user is on login page$")
	public void i_verify_that_user_is_on_login_page() {
		loginTest.verifyLoginPageIsDisplayed();
	}

	@Then("^I enter '(.*)' in username field$")
	public void i_enter_in_username_field(String string) {
	    loginTest.enterUserName(string);
	}

	@Then("^I enter '(.*)' in password field$")
	public void i_enter_in_password_field(String string) {
	   loginTest.enterPassword(string);
	}

	@When("^I click on Login button$")
	public void i_click_on_login_button() {
	    loginTest.clickOnLoginButton();
	}

	@Then("^I should be on Inventory page$")
	public void i_should_be_on_inventory_page() {
	    loginTest.inventoryPageIsDisplayed();
	}
	
	
}
