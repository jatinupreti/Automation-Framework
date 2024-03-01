package pageActions;

import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class AddToCart extends BaseClass{
	
	public AddToCart() {
		super("AddToCart");
	}
	
	
/*
 * This method is used to select product filter on Inventory page
 * @param takes the filter that we want to apply
 */
	public void selectFilterToProducts(String filter) throws Exception {
		Select select = new Select(getElement("FilterOptionField"));
		select.selectByVisibleText(filter);
		logMessage("user selected filter: "+filter);
	}

/*
 * clicks on Add to Cart button on Inventory page
 */
	
	public void clickOnAddToCartButton() throws Exception {
		clickOnElement(getElement("addToCartButton"));
		logMessage("user clicked on add to cart button");
	}

}
