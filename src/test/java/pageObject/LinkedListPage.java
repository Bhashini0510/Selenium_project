package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.DriverSetUp;
import utilities.ExcelUtil;
import utilities.ScreenShot;
import utilities.TestSetUp;

public class LinkedListPage extends TestSetUp {
	
	WebDriver driver;
	DriverSetUp driverSetUp;
	
	List<WebElement> topicList;
	ArrayList<String> codeToTest;
	List<Map<Integer,String>> dataInput;
	List<String> leftTopicText=new ArrayList<String>();
	List<String> listTopicText=new ArrayList<String>();
	List<WebElement> leftTopicList;
	SoftAssert softAssert,softAssertSubmit;
	
	String expected, actual;
	public String url = "https://dsportalapp.herokuapp.com/login";
	String path="src/test/resources/inputdata/DataInput.xlsx";
	String newUrl="https://dsportalapp.herokuapp.com";
	
	By linkSignIn = By.xpath("//a[text()='Sign in']");
	By linkSignOut = By.xpath("//a[text()='Sign out']");
	By usrName=By.id("id_username");
	By pwd = By.id("id_password");
	By btnSubmit = By.xpath("//input[@type='submit']");
	By dropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By linkLL = By.xpath("//a[text()='Linked List']");
	By header = By.xpath("//h4");
	By btnGetStarted = By.xpath("//h5[text()='Linked List']/../a[text()='Get Started']");
	By listTopic = By.xpath("//a[@class='list-group-item']");
	By pageContent = By.xpath("//strong/p[contains(@class,'bg-secondary')]");
	By topicLeft = By.xpath("//li[contains(@class,'list-group-item')]/a");
	By btnTryHere = By.xpath("//a[contains(@class,'btn-info')]");
	By codeText = By.xpath("//div[contains(@class, 'CodeMirror')]/div/textarea");
	By btnRun = By.xpath("//button[text()='Run']");
	By out = By.id("output");
	By practiceQues = By.xpath("//a[text()='Practice Questions']");
	By practiceCodeEditor = By.id("editor");
	By btnCodeSubmit = By.xpath("//input[@type='submit']");
	
	public LinkedListPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getUrl() throws IOException {
		
		DriverSetUp.setProperties("login");
		String test =DriverSetUp.getProperties().get(0);
		return test;
		
	}
	
	public void login() throws IOException {
		
		driver.get(url);
		String userName=DriverSetUp.getProperties().get(2);
		String password=DriverSetUp.getProperties().get(3);
		driver.findElement(usrName).sendKeys(userName);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(btnSubmit).click();
	}
	
	public void login(String userName, String password) throws IOException {
		
		driver.get(url);
		driver.findElement(usrName).sendKeys(userName);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(btnSubmit).click();
	}
	
	public void selectLinkedList() throws IOException {
		String homeUrl=DriverSetUp.getProperties().get(0)+"home";
		driver.get(homeUrl);
		if(driver.findElement(linkSignOut).isDisplayed()) {
			driver.findElement(dropdown).click();
			driver.findElement(linkLL).click();
		}
		else if(driver.findElement(linkSignIn).isDisplayed()) {
			
			login();
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
		String homeUrl=DriverSetUp.getProperties().get(0)+"home";
		driver.get(homeUrl);
		driver.findElement(btnGetStarted).click();
	}
	
	public void verfiyTopics(String topic) {
		
		listTopicText=new ArrayList<String>();
		List<String>topicArray = List.of(topic.split(","));
		topicList = driver.findElements(listTopic);
		//Iterator<String> a=topicArray.iterator();
		Iterator<WebElement> ele = topicList.iterator();
		while(ele.hasNext()) {
			String topicLink =ele.next().getText();
			listTopicText.add(topicLink);
		}
		Assert.assertTrue(listTopicText.equals(topicArray));
		
	}
	
	public void clickTopic(String topicLink) {
		
		List<String>topicArray = List.of(topicLink.split(","));
		Iterator<String> a = topicArray.iterator();
		while(a.hasNext()){
			String topicToClick = a.next();
			driver.findElement(By.xpath("//a[@class='list-group-item'][text()='"+topicToClick+ "']")).click();
			//verifyListOnLeft(topicArray);
		}

	}
	
	public void clickTryHere() {
		
		driver.findElement(btnTryHere).click();
	}
	
	public void verifyListOnLeft(String topic) {
		
		List<String>topicArray = List.of(topic.split(","));
		leftTopicList = driver.findElements(topicLeft);
		Iterator<WebElement> ele = leftTopicList.iterator();
		leftTopicText = new ArrayList<String>();
		while(ele.hasNext()) {
			leftTopicText.add(ele.next().getText());
		}
		//System.out.println("expected: "+topic);
		//System.out.println("Actual: "+leftTopicText);
		softAssert.assertTrue(leftTopicText.equals(topicArray),"Topics on left is not same as expected");
		//clickPracticeQues();
		//driver.navigate().back();		
		
	}
	
	public void navigateTotopic(String page,String topic) {
		
		String newUrl="";
		
		switch(page) {
		
		case "Linked List":
			newUrl="https://dsportalapp.herokuapp.com/linked-list/"+topic.toLowerCase();
			break;
		case "Tree":
			newUrl="https://dsportalapp.herokuapp.com/tree/"+topic.toLowerCase();
			break;
		case "Queue":
			newUrl="https://dsportalapp.herokuapp.com/queue/"+topic.toLowerCase();
			break;
		case "Stack":
			newUrl="https://dsportalapp.herokuapp.com/stack/"+topic.toLowerCase();
			break;
		case "Graph":
			newUrl="https://dsportalapp.herokuapp.com/graph/"+topic.toLowerCase();
			break;
		case "Arrays":
			newUrl="https://dsportalapp.herokuapp.com/array/"+topic.toLowerCase();
			break;
		case "Datastructure":
			newUrl="https://dsportalapp.herokuapp.com/data-structures-introduction/"+topic.toLowerCase();
			break;
		}
		
		driver.get(newUrl);
	}
	
	public void clickPracticeQues(String page) {
		
		driver.findElement(practiceQues).click();
		switch(page) {
		
		case "Linked List":
			newUrl="https://dsportalapp.herokuapp.com/linked-list/practice";
			break;
		case "Tree":
			newUrl="https://dsportalapp.herokuapp.com/tree/practice";
			break;
		case "Queue":
			newUrl="https://dsportalapp.herokuapp.com/queue/practice";
			break;
		case "Stack":
			newUrl="https://dsportalapp.herokuapp.com/stack/practice";
			break;
		case "Graph":
			newUrl="https://dsportalapp.herokuapp.com/graph/practice";
			break;
		case "Arrays":
			newUrl="https://dsportalapp.herokuapp.com/array/practice";
			break;
		case "Datastructure":
			newUrl="https://dsportalapp.herokuapp.com/data-structures-introduction/practice";
			break;
		}
		expected =  newUrl;
		actual = driver.getCurrentUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
		driver.navigate().back();
	}
	
	public void getCodeFromExcel(String path,String sheetName, String topic) throws IOException {
		
		switch(sheetName) {
		case "LinkedList":
			newUrl = "https://dsportalapp.herokuapp.com/linked-list/";
			break;
		case "Tree":
			newUrl = "https://dsportalapp.herokuapp.com/tree/";
			break;
		case "Queue":
			newUrl = "https://dsportalapp.herokuapp.com/queue/";
			break;
		case "Stack":
			newUrl = "https://dsportalapp.herokuapp.com/stack/";
			break;
		case "Graph":
			newUrl = "https://dsportalapp.herokuapp.com/graph/";
			break;
		case "Arrays":
			newUrl = "https://dsportalapp.herokuapp.com/array/";
			break;
		case "Datastructure":
			newUrl = "https://dsportalapp.herokuapp.com/data-structures-introduction/";
			break;
		case "Practice":
			newUrl = "https://dsportalapp.herokuapp.com/array/practice";
			break;	
		}
		//login("User7654", "P@ssword1");
		//System.out.println(newUrl);
		driver.get(newUrl);
		softAssert =new SoftAssert();
		softAssertSubmit = new SoftAssert();
		dataInput=ExcelUtil.getDataFromExcel(path, sheetName);
		Iterator<Map<Integer, String>> inputLink= dataInput.iterator();
		//Iterator<WebElement> ele = topicList.iterator();
		while(inputLink.hasNext()) {
			topicList = driver.findElements(listTopic);
			Map<Integer,String> data = inputLink.next();
			for (WebElement link:topicList) {
				if(data.get(0).equalsIgnoreCase(link.getText())){
					System.out.println(link.getText());
					link.click();
					if(sheetName.equalsIgnoreCase("Practice")) {
						runPracticeCode(data.get(1));
						verifyOutput(data.get(2));
						if(data.get(2).contains("Error")) {
							submitPracticeCode();
						}
					}
					else {
						verifyListOnLeft(topic);
						runCode(data.get(1));
						verifyOutput(data.get(2));
					}
					driver.get(newUrl);
					break;				
				}
			}
		}
		softAssert.assertAll();
	}
	
	public void runCode(String codeInput) {
		
		driver.findElement(btnTryHere).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnRun)));
		driver.findElement(codeText).sendKeys(codeInput);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(btnRun)).perform();
		driver.findElement(btnRun).click();
	}
	
	public void runPracticeCode(String codeInput) {
		
		WebElement codeEditor=driver.findElement(codeText);
		codeEditor.sendKeys(Keys.CONTROL , "a");
		codeEditor.sendKeys(Keys.DELETE);
		//codeEditor.clear();
		codeEditor.sendKeys(codeInput);
		driver.findElement(btnRun).click();
	}
	
	public void submitPracticeCode() {
		
		driver.findElement(btnCodeSubmit).click();
		expected="Error occurred during submission";
		actual=driver.findElement(out).getText();
		softAssertSubmit.assertEquals(actual, expected);
		
	}
	public void verifyOutput(String codeOutput) throws IOException {
		
		expected = codeOutput;
		if(expected.contains("Error")) {
			
			driver.switchTo().alert();
			actual = driver.switchTo().alert().getText();
			driver.switchTo().alert().dismiss();	
		}
		else {
			actual = driver.findElement(out).getText();
		}
		if(!expected.equalsIgnoreCase(actual)) {
			ScreenShot.getByteScreenshot(expected);
		}
		softAssert.assertTrue(expected.equalsIgnoreCase(actual),"Expected: "+expected+" Actual: "+actual);
		
	}
}