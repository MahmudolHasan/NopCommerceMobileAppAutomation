package pages;

import org.openqa.selenium.By;

import utils.WebUtils;

public class MattressBedroomDetails extends WebUtils {

	// Locators
	By addToCart_btn = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart");
	By cartItem = By.id("com.nopstation.nopcommerce.nopstationcart:id/tvQuantity");
	By plusBtn = By
			.xpath("//android.widget.Button[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/btnPlus\"]");

	String productDetails_rcrsId = "com.nopstation.nopcommerce.nopstationcart:id/detailsScrollview";
	By menuCart = By.id("com.nopstation.nopcommerce.nopstationcart:id/menu_cart");

	public void increaseQuantity() throws InterruptedException {
		scrollToElement(productDetails_rcrsId, "+");
		clickOnEle(plusBtn);
	}

	public void addToCart() throws InterruptedException {

		clickOnEle(addToCart_btn);
		threadSleep(2);
	}

	public CartPage goToCart() throws InterruptedException {
		clickOnEle(menuCart);
		return new CartPage();
	}
}
