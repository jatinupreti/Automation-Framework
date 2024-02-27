package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class AddToCart extends BaseClass{
	
	By FilterOption = By.className("product_sort_container");
	By AddToCartBtn = By.xpath("//button[@data-test='add-to-cart-sauce-labs-onesie']");
	
	public void selectFilterToProducts(String filter) {
		Select select = new Select(element(FilterOption));
		select.selectByVisibleText(filter);
		logMessage("user selected filter: "+filter);
	}
	
	public void clickOnAddToCartButton() {
		clickOnElement(element(AddToCartBtn));
		logMessage("user clicked on add to cart button");
	}

}
