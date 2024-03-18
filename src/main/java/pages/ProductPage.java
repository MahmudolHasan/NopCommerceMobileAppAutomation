package pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;

import utils.WebUtils;
import utils.readExcel;

public class ProductPage extends WebUtils{
	
	Map<String, String> data;
	readExcel re = new readExcel()	;
	
	// Product Locators 
	By mattressBedroom = By.xpath("//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Mattress Bedroom\"]");
	
	String productContainer_rcrsId = "com.nopstation.nopcommerce.nopstationcart:id/rvProductList";
	public MattressBedroomDetails clickOnMattressDetails() throws IOException {

		Map<String, String> data;
		readExcel re = new readExcel();
		data = re.getAllData(0);
		System.out.println(data);
		String product = data.get("Product").strip();
		try {
			System.out.println("starting try...");

			scrollToElement(productContainer_rcrsId,product);
			clickOnEle(mattressBedroom);
			System.out.println("clicked on product");
			threadSleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("from product catch!");
			e.printStackTrace();
		}
		return new MattressBedroomDetails();
	}

}
