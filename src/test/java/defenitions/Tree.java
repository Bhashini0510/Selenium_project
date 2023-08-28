package defenitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LinkedListPage;
import pageObject.PageObjectManager;
import pageObject.TreePage;
import utilities.DriverSetUp;
import utilities.TestSetUp;

public class Tree extends TestSetUp {
	
	WebDriver driver;
	List<WebElement> topicList;
	List<String> codeTest;
	String expected, actual;
	String path="src/test/resources/inputdata/DataInput.xlsx";
	
	TestSetUp setUp;
	PageObjectManager pageObjectManager;
	TreePage treePage;
	
	public Tree(TestSetUp setUp) {
		treePage = new TreePage(DriverSetUp.getDriver());
	}
		
	
	@When("User click on Tree from the dropdown")
	public void user_click_on_tree_from_the_dropdown() throws IOException {
	    treePage.selectTree();
	}

	@Then("Tree page is displayed")
	public void tree_page_is_displayed() {
		
		expected = "https://dsportalapp.herokuapp.com/tree/";
		actual = treePage.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@Then("heaader Tree is displayed")
	public void heaader_tree_is_displayed() {
		expected = "Tree";
		actual = treePage.getPageHeader();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	@When("User click on Get Started button for Tree")
	public void user_click_on_get_started_button_for_tree() throws IOException {
	    treePage.btnClick();
	}
	


}