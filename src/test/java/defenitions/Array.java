package defenitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ArrayPage;
import pageObject.PageObjectManager;
import pageObject.TreePage;
import utilities.DriverSetUp;
import utilities.TestSetUp;

public class Array extends TestSetUp  {
	
	WebDriver driver;
	String expected, actual;
	String path="src/test/resources/inputdata/DataInput.xlsx";
	/*
	TestSetUp setUp;
	PageObjectManager pageObjectManager;
	ArrayPage arrayPage;
	
	*/
	
	public Array() throws IOException {
		arrayPage = new ArrayPage(DriverSetUp.getDriver());
		
	}
	
	@When("User click on Array from the dropdown")
	public void user_click_on_array_from_the_dropdown() throws IOException {
	    arrayPage.selectArray();
	}

	@Then("Array page is displayed")
	public void array_page_is_displayed() {
		expected = "https://dsportalapp.herokuapp.com/array/";
		actual = arrayPage.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@Then("heaader Array is displayed")
	public void heaader_array_is_displayed() {
	    arrayPage.getPageHeader();
	}

	@When("User click on Get Started button for Array")
	public void user_click_on_get_started_button_for_array() throws IOException {
	    arrayPage.btnClick();
	}
	@When("User clicks on Practice Questions link on the left of page")
	public void user_clicks_on_practice_questions_link_on_the_left_of_page() {
		
	}

	@Then("User is able to run and submit practice codes")
	public void user_is_able_to_run_and_submit_practice_codes() {
	    
	}
}
