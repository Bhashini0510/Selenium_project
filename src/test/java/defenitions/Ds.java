package defenitions;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.DriverSetUp;
import utilities.TestSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.DsPage;
import pageObject.GraphPage;
import pageObject.PageObjectManager;


public class Ds extends TestSetUp{
	WebDriver driver;
	List<WebElement> topicList;
	List<String> codeTest;
	String expected, actual;
	String path="src/test/resources/inputdata/DataInput.xlsx";
	
	TestSetUp setUp;
	PageObjectManager pageObjectManager;
	DsPage dsPage;
	
	public Ds() {
		dsPage=new DsPage(DriverSetUp.getDriver());
	}
		
	@Then("Data Structures-Introduction page is displayed")
	public void data_structures_introduction_page_is_displayed() {
		
		expected = "https://dsportalapp.herokuapp.com/data-structures-introduction/";
		actual = dsPage.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@Then("heaader Data Structures-Introduction is displayed")
	public void heaader_data_structures_introduction_is_displayed() {
		expected = "Data Structures-Introduction";
		actual = dsPage.getPageHeader();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@When("User click on Get Started button for Datastructure")
	public void user_click_on_get_started_button_for_datastructure() throws IOException {
	    dsPage.btnClick();
	}
	
}



