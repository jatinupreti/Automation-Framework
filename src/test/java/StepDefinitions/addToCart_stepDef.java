package StepDefinitions;

import io.cucumber.java.en.Then;
import pageActions.AddToCart;

public class addToCart_stepDef {
	
	AddToCart addToCartTest = new AddToCart();
	
	@Then("^I apply '(.*)' filter to sort products$")
	public void i_apply_filter_to_sort_products(String string) throws Exception {
	   addToCartTest.selectFilterToProducts(string);
	}

	@Then("I click on Add to Cart button")
	public void i_click_on_add_to_cart_button() throws Exception {
	    addToCartTest.clickOnAddToCartButton();
	}
}
