package pages;

import org.openqa.selenium.By;

import utils.WebUtils;

public class CartPage extends WebUtils{
	
	// LOCATORS
	By checkOut_btn = By.xpath("//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvTitle\" and @text=\"FEATURED PRODUCTS\"]");
	By checkOutAsGuest_btn = By.xpath(
			"//android.widget.Button[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout\"]");
	
	public void clickOnCheckout() {
		try {
			clickOnEle(checkOut_btn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public AddressDetails checkoutAsGuest() throws InterruptedException {
		clickOnEle(checkOutAsGuest_btn);
		threadSleep(10);
		System.out.println("Passed Cart Page");
		return new AddressDetails();
	}

}
