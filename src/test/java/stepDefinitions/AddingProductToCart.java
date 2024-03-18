package stepDefinitions;

import java.io.IOException;

import javax.security.auth.callback.ConfirmationCallback;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddressDetails;
import pages.CartPage;
import pages.Confirmation;
import pages.HomePage;
import pages.MattressBedroomDetails;
import pages.PaymentDetails;
import pages.ProductPage;
import pages.ShippingDetails;

public class AddingProductToCart {
	HomePage homePage;
	ProductPage productPage;
	MattressBedroomDetails mattress;
	CartPage cartPage;
	AddressDetails add;
	ShippingDetails ship;
	PaymentDetails pay;
	Confirmation conf;

	@Given("Mike on home page after opening nopCart mobile app")
	public void mike_on_home_page_after_opening_nop_cart_mobile_app() {
		homePage = new HomePage();
		Assert.assertTrue("Mike isn't on homepage!", homePage.isOnHomePage());
	}

	@When("Mike click {string} from {string} list from home page")
	public void mike_click_from_list_from_home_page(String string, String string2) throws IOException {
		homePage = new HomePage();
		productPage = homePage.clickOnElectronics();
	}

	@When("Mike click to {string} product details page")
	public void mike_click_to_product_details_page(String string) throws IOException{
		 mattress=  productPage.clickOnMattressDetails();

	}

	@When("Mike click plus button to increase Qty by {string}")
	public void mike_click_plus_button_to_increase_qty_by(String string) {
		try {
			mattress.increaseQuantity();;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
	}

	@Then("Mike click add to cart button to add the product in his cart")
	public void mike_click_add_to_cart_button_to_add_the_product_in_his_cart() throws InterruptedException {
		mattress.addToCart();
		
	}

	@Given("Mike go to shopping cart by clicking top cart icon")
	public void mike_go_to_shopping_cart_by_clicking_top_cart_icon() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException(); 
		mattress = new MattressBedroomDetails();
		cartPage = mattress.goToCart();
		
	}

	@When("Mike click checkout button from shopping cart page")
	public void mike_click_checkout_button_from_shopping_cart_page() {
		// Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		cartPage.clickOnCheckout();
		
	}

	@When("Mike select checkout as guest from shopping cart page")
	public void mike_select_checkout_as_guest_from_shopping_cart_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		add = cartPage.checkoutAsGuest();
	}

	@Then("Mike input all the details in checkout billing details page and click continue")
	public void mike_input_all_the_details_in_checkout_billing_details_page_and_click_continue() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		add.fillupAddress();
		ship = add.clickOnContinue();
		
		
	}

	
	@Then("Mike select {string} as shipping method and click continue")
	public void mike_select_as_shipping_method_and_click_continue(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		ship.selectNextDayAirShipping();
		pay= ship.clickOnContinue();
	}

	@Then("Mike select {string} as payment method and click continue")
	public void mike_select_as_payment_method_and_click_continue(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		pay.selectpaymentMethod();
		
	}

	@Then("Mike click next button on payment information page")
	public void mike_click_next_button_on_payment_information_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		conf = pay.confirmationNextAfterPayPayment();
	}

	@Then("Mike click confirm button to place the order")
	public void mike_click_confirm_button_to_place_the_order() {
		// Write code here that turns the phrase above into concrete actions
		// new io.cucumber.java.PendingException();
		conf.clickOnConfirm();
	}

	@Then("Verify order place successfully with popup message {string}")
	public void verify_order_place_successfully_with_popup_message(String string) throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		// new io.cucumber.java.PendingException();
		Assert.assertTrue(conf.IsConfirmationMsgDisplayed());
		//conf.clickOnMsgContinueBtn();
	}

}
