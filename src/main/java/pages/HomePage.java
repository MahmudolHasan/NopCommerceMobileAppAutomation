package pages;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.ExcelReader02;
import utils.WebUtils;
import utils.readExcel;

public class HomePage extends WebUtils {

	// Locators
	By logo = By.id("com.nopstation.nopcommerce.nopstationcart:id/topLogo");

	// Resource ID
	String resrs_Header; // = "com.nopstation.nopcommerce.nopstationcart:id/rvHomeCategories";
	String resrs_productCategory; // = "Electronics";

	// Categories
	By electonicsBy = By.xpath(
			"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Electronics\"]");

	public boolean isOnHomePage() {
		return elementExist(logo);
	}

	public ProductPage clickOnElectronics() throws IOException {

		Map<String, String> data;
		readExcel re = new readExcel();
		data = re.getAllData(0);
		resrs_Header = data.get("Header").strip();
		//System.out.println(resrs_Header);

		resrs_productCategory = (data.get("Category")).strip();
		System.out.println(resrs_productCategory);

		scrollToElement(resrs_Header, resrs_productCategory, "horizontal");
		try {
			clickOnEle(electonicsBy);
			threadSleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return new ProductPage();
	}
}
