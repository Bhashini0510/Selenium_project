package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DriverSetUp;
import utilities.TestSetUp;

public class ArrayPage extends TestSetUp {
	
	WebDriver driver;
	DriverSetUp driverSetUp;
	LinkedListPage lp;
	
	String expected, actual;
	public String url = "https://dsportalapp.herokuapp.com/login";
	
	By usrName=By.id("id_username");
	By pwd = By.id("id_password");
	By btnSubmit = By.xpath("//input[@type='submit']");
	By dropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By linkLL = By.xpath("//a[text()='Arrays']");
	By header = By.xpath("//h4");
	By btnGetStarted = By.xpath("//h5[text()='Array']/../a[text()='Get Started']");
	By listTopic = By.xpath("//a[@class='list-group-item']");
	By pageContent = By.xpath("//strong/p[contains(@class,'bg-secondary')]");
	By topicLeft = By.xpath("//li[contains(@class,'list-group-item')]/a");
	By btnRun = By.xpath("//button[text()='Run']");
	By out = By.id("output");
	By practiceQues = By.xpath("//a[text()='Practice Questions']");
	By practiceCodeEditor = By.id("editor");
	By btnCodeSubmit = By.xpath("//input[@type='submit']");
	
	public ArrayPage(WebDriver driver) {
		this.driver=driver;
		lp = new LinkedListPage(driver);
	}
	
	public void selectArray() throws IOException {
		
		String homeUrl=DriverSetUp.getProperties().get(0)+"home";
		driver.get(homeUrl);
		lp.login();
		driver.findElement(dropdown).click();
		driver.findElement(linkLL).click();
		/*
		if(driver.findElement(lp.linkSignOut).isDisplayed()) {
			
		}
		else if(driver.findElement(lp.linkSignIn).isDisplayed()) {
			
		}*/
	}
	
	public String getPageUrl() {
		
		actual=driver.getCurrentUrl();
		return actual;
	}
	
	public String getPageHeader(){
		
		actual=driver.findElement(header).getText();
		return actual;
	}
	
	public void btnClick() throws IOException {
		url=DriverSetUp.getProperties().get(0)+"home";
		driver.get(url);
		driver.findElement(btnGetStarted).click();
	}	

}
