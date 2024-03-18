package pages;

import org.openqa.selenium.By;

import utils.WebUtils;

public class ShippingDetails extends WebUtils {

	// Locators

	By nextDayShip = By.xpath("(//android.widget.TextView[@text=\"Next Day Air\"])[1]");
	By btn_continue = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");

	public void selectNextDayAirShipping() throws InterruptedException {

		clickOnEle(nextDayShip);
		scrollToBottom();
	}

	public PaymentDetails clickOnContinue() throws InterruptedException {
		clickOnEle(btn_continue);

		return new PaymentDetails();
	}

}
