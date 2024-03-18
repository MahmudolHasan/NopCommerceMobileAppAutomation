package pages;

import org.openqa.selenium.By;

import utils.WebUtils;

public class Acceptance extends WebUtils {

	// Locators
	By acceptance_btn = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept");

	public void clickOnAcceptButton() {
		try {
			clickOnEle(acceptance_btn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
