package pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.sdk.metrics.internal.view.DropAggregation;
import utils.WebUtils;
import utils.readExcel;

public class AddressDetails extends WebUtils {

	// Input Field Locators
	By firstName = By.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName");
	By lastName = By.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName");
	By email = By.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail");
	By countryDropDownMenu = By.id("com.nopstation.nopcommerce.nopstationcart:id/countrySpinner");
	By countryName = By.xpath("(//android.widget.TextView[@text=\"Bangladesh\"])[1]");
	By stateDropDownMenu = By.id("com.nopstation.nopcommerce.nopstationcart:id/stateSpinner");
	By stateName = By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"ঢাকা\"]");
	By company = By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName");
	By city = By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity");
	By streetAddress01 = By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress");
	By streetAddress02 = By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress2");
	By zipCode = By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode");
	By phoneNumber = By.id("com.nopstation.nopcommerce.nopstationcart:id/etPhone");
	By fax = By.id("com.nopstation.nopcommerce.nopstationcart:id/etFax");

	// Button Locators
	By btn_continue = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");

	// Ids
	String Container = "//android.widget.ListView";
	String country;
	String stateName01 = "android:id/text1";

	public ShippingDetails clickOnContinue() throws InterruptedException {

		clickOnEle(btn_continue);
		return new ShippingDetails();
	}

	public void fillupAddress() throws Exception {
		Map<String, String> data;

		readExcel rd = new readExcel();
		data = rd.getAllData(1);
		System.out.println("2nd Sheet Data:" + data);

		textInput(firstName, data.get("FirstName").strip());
		textInput(lastName, data.get("LastName").strip());
		textInput(email, data.get("Email").strip());
		country = data.get("Country").strip();
		String state = data.get("State").strip();
		clickOnEle(countryDropDownMenu);
		scrollToView(country);
		clickOnEle(countryName);
		clickOnEle(stateDropDownMenu);
		clickOnEle(stateName);
		scrollToBottom();
		textInput(company, data.get("Company").strip());
		textInput(city, data.get("City").strip());
		textInput(streetAddress01, data.get("StreetAddress01").strip());
		textInput(streetAddress02, data.get("StreetAddress02").strip());
		textInput(zipCode, data.get("ZipCode").strip());
		textInput(phoneNumber, data.get("Phone").strip());
		textInput(fax, data.get("Fax").strip());
	}

}
