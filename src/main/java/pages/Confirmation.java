package pages;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Map;

import org.openqa.selenium.By;

import utils.WebUtils;
import utils.readExcel;

public class Confirmation extends WebUtils {

	By btn_confirmation = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");
	By confirmationMsg = By.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message");
	By btn_continue = By.id("com.nopstation.nopcommerce.nopstationcart:id/md_button_positive");

	public void clickOnConfirm() {
		try {
			clickOnEle(btn_confirmation);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean IsConfirmationMsgDisplayed() throws InterruptedException, IOException {

		Map<String, String> data;
		readExcel re = new readExcel();
		data = re.getAllData(0);
		return elementIsDisplayed(confirmationMsg);
	}

	public void clickOnMsgContinueBtn() {
		try {
			clickOnEle(btn_continue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
