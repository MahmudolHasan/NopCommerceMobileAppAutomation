package AppHooks;

import java.net.URI;
import java.net.URL;

import org.checkerframework.checker.units.qual.Acceleration;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;

import factory.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import pages.Acceptance;
import utils.ConfigReader;

public class Hooks {
	private static String path = "src/test/resources/config.properties";
	private static AndroidDriver driver;
	private static URL url;

	@BeforeAll
	public static void beforeAll(){
		// Reading Configurations
		ConfigReader reader = new ConfigReader(path);
		

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "uiAutomator2");
		caps.setCapability("deviceName", reader.readConfig("deviceName"));
		caps.setCapability("udid", reader.readConfig("udid"));
		caps.setCapability("appPackage", reader.readConfig("appPackage"));
		caps.setCapability("appActivity", reader.readConfig("appActivity"));
		try {
			url = new URI(reader.readConfig("default-url")).toURL();
			driver = new AndroidDriver(url, caps);
			System.out.println(caps);
			System.out.println(url);
			DriverFactory.setLocalDriver(driver);
			Acceptance acceptance = new Acceptance();
			acceptance.clickOnAcceptButton();

		} catch (SessionNotCreatedException e) {

			System.out.println(
					"Appium server is not created! Run 'appium` from terminal or set `allure-run = true` in config.properties!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Problem in BeforeMethod!Check script \"Hooks.java\"");
			e.printStackTrace();
		}

	}

	@AfterAll
	public static void afterAll() {
		if (driver != null) {
			driver.quit();
		}
	}

}
