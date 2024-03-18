package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/appFeatures", glue = { "stepDefinitions",
		"AppHooks" }, monochrome = true, plugin = { "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","json:target/cucumber-report/cucumber.json" })
public class AllTestRunner {

}
