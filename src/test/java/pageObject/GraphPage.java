package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import utilities.DriverSetUp;
import utilities.ExcelUtil;
import utilities.TestSetUp;

public class GraphPage extends TestSetUp {
	WebDriver driver;
	DriverSetUp driverSetUp;
	LinkedListPage lp;
	
	List<WebElement> topicList;
	ArrayList<String> codeToTest;
	List<Map<Integer,String>> dataInput;
	List<String> leftTopicText=new ArrayList<String>();
	List<String> listTopicText=new ArrayList<String>();
	List<WebElement> leftTopicList;
	SoftAssert softAssert;
	
	String expected, actual;
	public String url = "https://dsportalapp.herokuapp.com/login";
	String path="src/test/resources/inputdata/DataInput.xlsx";
	
	By usrName=By.id("id_username");
	By pwd = By.id("id_password");
	By btnSubmit = By.xpath("//input[@type='submit']");
	By dropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By linkLL = By.xpath("//a[text()='Graph']");
	By header = By.xpath("//h4");
	By btnGetStarted = By.xpath("//h5[text()='Graph']/../a[text()='Get Started']");
	By listTopic = By.xpath("//a[@class='list-group-item']");
	By pageContent = By.xpath("//strong/p[contains(@class,'bg-secondary')]");
	By topicLeft = By.xpath("//li[contains(@class,'list-group-item')]/a");
	By btnTryHere = By.xpath("//a[contains(@class,'btn-info')]");
	By codeText = By.xpath("//div[contains(@class, 'CodeMirror')]/div/textarea");
	By btnRun = By.xpath("//button[text()='Run']");
	By out = By.id("output");
	By practiceQues = By.xpath("//a[text()='Practice Questions']");
	
	public GraphPage(WebDriver driver) {
		this.driver=driver;
		lp = new LinkedListPage(driver);
	}
	
	public void selectGraph() throws IOException {
		String homeUrl=DriverSetUp.getProperties().get(0)+"home";
		driver.get(homeUrl);
		if(driver.findElement(lp.linkSignOut).isDisplayed()) {
			driver.findElement(dropdown).click();
			driver.findElement(linkLL).click();
		}
		else if(driver.findElement(lp.linkSignIn).isDisplayed()) {
			lp.login();
		}
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
