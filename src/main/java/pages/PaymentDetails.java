package pages;

import javax.security.auth.callback.ConfirmationCallback;

import org.openqa.selenium.By;

import utils.WebUtils;

public class PaymentDetails extends WebUtils {

	By btn_continue = By.xpath(
			"(//android.widget.Button[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/btnContinue\"])[2]");
	By btn_next = By.xpath("//android.widget.Button[@text='Next']");
	By check_moneyPayment = By.xpath(
			"//com.bs.ecommerce.customViews.RadioGridGroupforReyMaterial[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/radioGridGroup\"]/android.widget.RelativeLayout[4]");

	String text = "Check / Money Order";

	public void selectpaymentMethod() throws InterruptedException {
		scrollToView(text);
		clickOnEle(check_moneyPayment);
		clickOnEle(btn_continue);
		Thread.sleep(5);
	}

	public Confirmation confirmationNextAfterPayPayment() throws InterruptedException {
		clickOnEle(btn_next);
		return new Confirmation();
	}

}
