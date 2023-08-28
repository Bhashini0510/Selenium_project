package defenitions;


import java.io.IOException;


import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObject.PageObjectManager;
import pageObject.RegisterPage;
import utilities.DriverSetUp;
import utilities.TestSetUp;

public class Register extends TestSetUp {

	String alertText;
	String expectedUrl, actualUrl;
	WebDriver driver;
	String name;
	public String message;
	
	TestSetUp setUp;
	public PageObjectManager pageObjectManager;
	public RegisterPage registerPage;
	public String url="https://dsportalapp.herokuapp.com";
	
	public Register() throws IOException {
		
		registerPage=new RegisterPage(DriverSetUp.getDriver());
	}
	
	@Given("User is in Register page")
	public void user_is_in_register_page() throws IOException {
	
		registerPage.navigateToRegisterPage();

	}

	@When("User enters credentials and click on Register button")
	public void user_enters_credentials_and_click_on_Register_button(DataTable table) throws IOException {
		
		registerPage.register(table);	
	}
	
	@Then("Navigates to home page")
	public void navigates_to_home_page() {
		
		registerPage.assertUrl("home");

	}

	@Then("User able to register successfully")
	public void user_able_to_register_successfully() {
		
		registerPage.assertName();

	}

	@Before(value="@failure")
	public void beforeScenarioFailure() throws IOException {
		
		registerPage.navigateToRegisterPage();
		
	}
	
	@When("User fills credentials and click on Register button")
	public void user_fills_credentials_and_click_on_register_button(DataTable dataTable) throws IOException {
		
		registerPage.register(dataTable);
	}

	@Then("User is not able to register and alert is displayed")
	public void user_is_not_able_to_register_and_alert_is_displayed() {
			
		registerPage.assertUrl("register");
	}

	@When("User click Login button")
	public void user_click_login_button() throws IOException {
		
		registerPage.navigateToLoginPage();

	}

	@Then("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		registerPage.assertUrl("login");

	}

	@Given("User is in home page with valid {string} and {string}")
	public void loginSuccess(String userName, String password) throws IOException {
		
		registerPage.login(userName, password);
	}

	@When("User clicks the Signout button")
	public void user_clicks_the_signout_button() {
		
		registerPage.signOut();

	}

	@Then("Able to Signout and land in home page with Signin link")
	public void able_to_signout_and_land_in_home_page_with_signin_link() {
		
		registerPage.verifySignIn();
		registerPage.assertUrl("login");

	}
	

}