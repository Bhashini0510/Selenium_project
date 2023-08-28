package defenitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObject.PageObjectManager;
import pageObject.QueuePage;
import utilities.DriverSetUp;
import utilities.TestSetUp;

public class Queue extends TestSetUp {
	
	WebDriver driver;
	List<WebElement> topicList;
	List<String> codeTest;
	String expected, actual;
	String path="src/test/resources/inputdata/DataInput.xlsx";
	
	TestSetUp setUp;
	PageObjectManager pageObjectManager;
	QueuePage queuePage;
	
	public Queue() {
		
		queuePage=new QueuePage(DriverSetUp.getDriver());
		
	}
		
	
	@When("User click on Queue from the dropdown")
	public void user_click_on_queue_from_the_dropdown() throws IOException {
	    queuePage.selectQueue();
	}

	@Then("Queue page is displayed")
	public void queue_page_is_displayed() {
		
		expected = "https://dsportalapp.herokuapp.com/queue/";
		actual = queuePage.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@Then("heaader Queue is displayed")
	public void heaader_queue_is_displayed() {
		expected = "Queue";
		actual = queuePage.getPageHeader();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@When("User click on Get Started button for Queue")
	public void user_click_on_get_started_button_for_queue() throws IOException {
	    queuePage.btnClick();
	}
	


}