package Test_Runner.Steps;

import NopecommerceProject.Utilities.DriverManager;
import NopecommerceProject.Utilities.LoadProperties;
import NopecommerceProject.Page.Registrationpage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by kaival on 30/11/2016.
 */
public class RegisterSteps extends DriverManager {



@Given("^I open browser and goto Nopecommerce website$")
public void i_open_browser_and_goto_Nopecommerce_website() throws Throwable {
    DriverManager.openBrowser(LoadProperties.getProperty("Browser"));

}

    @Given("^I click on register link to open register page$")
    public void i_click_on_register_link_to_open_register_page() throws Throwable {
        Registrationpage registration = new Registrationpage();
        registration.clickonregistrationlink();

    }

    @Given("^I enter register details$")
    public void i_enter_register_details() throws Throwable {
        Registrationpage registration = new Registrationpage();
        Assert.assertEquals(registration.registrationPage(),"Register");
        registration.register();

    }

    @When("^I click on register button$")
    public void i_click_on_register_button() throws Throwable {
        Registrationpage registration = new Registrationpage();
        registration.clickOnRegisterBtn();

    }

    @Then("^I see successfully registered message$")
    public void i_see_successfully_registered_message() throws Throwable {
        Registrationpage registration = new Registrationpage();
        Assert.assertTrue(registration.registrationSuccessfulMessage(),"Your registration completed");
        registration.logout();
        DriverManager.closeBrowser();

    }
}
