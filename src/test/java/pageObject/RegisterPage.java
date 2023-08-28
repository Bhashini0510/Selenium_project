package pageObject;



import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

import defenitions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTable.TableConverter;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.TestStepResultStatus;
import io.cucumber.plugin.EventListener;
import io.qameta.allure.Allure;
import tech.grasshopper.pdf.section.scenario.ScenarioStepDetails;
import utilities.DriverSetUp;
import utilities.ScreenShot;
//import utilities.ScreenShot;
import utilities.StepDetails;
import utilities.TestSetUp;

public class RegisterPage extends TestSetUp {
	
	public String url,browser;
	String registeredName="";
	String homePage;
	String alertText;
	String user, pass,confpass,message;
	public int userflag,passflag,confirmflag;
	String expectedUrl, actualUrl;
	WebElement name;
	List<byte[]> capture = new ArrayList<byte[]>();
	
	public WebDriver driver;
	public DriverSetUp driverSetUp;
	public SoftAssert softAssert;
	Scenario scenario;
	//ScreenShot screenShot;
	
	By btnGetStarted = By.xpath("//button[@class='btn']");
	By linkRegister = By.xpath("//a[text()=' Register ']");
	By usr = By.name("username");
	By pwd = By.name("password1");
	By confirmPwd = By.name("password2");
	By btnRegister = By.xpath("//input[@type='submit']");
	By alertMessage = By.xpath("//div[contains(@class,'alert')]");
	By btnLogin = By.xpath("//a[text()='Login ']");
	By loginPwd = By.name("password");
	By linkSignOut = By.xpath("//a[text()='Sign out']");
	By linkSignIn = By.xpath("//a[text()='Sign in']");
	By homeUserName=By.xpath("//a[@href='']");
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	
	}
	
	public String getUrl() throws IOException {
		
		String test =DriverSetUp.getProperties().get(0);
		return test;
		
	}
	
	public void register(DataTable table) throws IOException {
		
			softAssert= new SoftAssert();
			if(table.cell(0, 0)==null){
				String userName=DriverSetUp.getProperties().get(2);
				String password = DriverSetUp.getProperties().get(3);
				final DataTableTypeRegistry registry = new DataTableTypeRegistry(Locale.ENGLISH);
				final DataTable.TableConverter tableConverter = new DataTableTypeRegistryTableConverter(registry);
		        List<List<String>> dataTableList = new ArrayList<>();
		        List<String> columns = Arrays.asList("username","password");
		        List<String> rows = Arrays.asList(userName,password);
		        dataTableList.add(columns);
		        dataTableList.add(rows);
		        table = DataTable.create(dataTableList,tableConverter);
				//System.out.println(table.toString());
				//table.asMap.add("UserName",DriverSetUp.getProperties().get(2));	
			}
			List<Map<String,String>> input =table.asMaps(String.class, String.class);
			for(Map<String,String> row:input) {
				
				userflag=0;
				passflag=0;
				confirmflag=0;
				user=row.get("username");
				pass=row.get("password");
				
				if(input.size()>2) {
					confpass = row.get("confirm");
					message = row.get("message");
				}
				else {
					confpass = row.get("password");
					message = "";
				}
				registeredName = user;
				if(user==null||user.isEmpty()) {
					userflag=1;
				}
				else {
					driver.findElement(usr).sendKeys(user);
				}
				
				if(pass==null||pass.isEmpty()) {
					passflag=1;
				}
				else {
					driver.findElement(pwd).sendKeys(pass);
				}
				
				if(confpass==null||confpass.isBlank()) {
					confirmflag=1;
				}
				else {
					driver.findElement(confirmPwd).sendKeys(confpass);
				}
				driver.findElement(btnRegister).click();
				if(!(message.isEmpty())) {
					String expected=message;
					String actual=actualError();
					try {
						assertError(actual,expected);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				else {
					
				}
					
		}
		softAssert.assertAll();
	}
	
	public void assertError(String actual, String expected) throws IOException {
		
		if(!expected.equalsIgnoreCase(actual)) {
			ScreenShot.getByteScreenshot(expected);
		}
		softAssert.assertEquals(actual, expected);		
	}
	
	public void assertUrl(String expected) {
		
		expectedUrl ="https://dsportalapp.herokuapp.com/"+expected;
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	public void assertName() {
		
		String regName = getUserName();
		Assert.assertTrue(!regName.isEmpty(),"The registered user name is not displayed");
	}
	public String actualError() {
		
		String actualMessage="";
		if(userflag==1) {
			
			actualMessage=driver.findElement(usr).getAttribute("validationMessage");
			
		}
		else if(passflag==1) {
			
			actualMessage=driver.findElement(pwd).getAttribute("validationMessage");
			
		}
		else if(confirmflag==1) {
			
			actualMessage=driver.findElement(confirmPwd).getAttribute("validationMessage");
			
		}
		else if(confirmflag==0 && passflag==0 && userflag==0) {
			
			actualMessage=driver.findElement(alertMessage).getText();
		}
		return actualMessage;

	}
	
	public String getPageUrl() {
		
		actualUrl=driver.getCurrentUrl();
		return actualUrl;
	}
	
	public String getUserName() {
		
		String name = driver.findElement(homeUserName).getText();
		return name;
	}
	
	public void navigateToRegisterPage() throws IOException {
		
		url=getUrl();
		driver.get(url);
		driver.findElement(btnGetStarted).click();
		driver.findElement(linkRegister).click();
		
	}
	
	public void navigateToLoginPage() throws IOException {
		
		navigateToRegisterPage();
		driver.findElement(btnLogin).click();
		
	}
	
	public void login(String userName, String password) throws IOException {
		
		navigateToRegisterPage();
		navigateToLoginPage();
		driver.findElement(usr).sendKeys(userName);
		driver.findElement(loginPwd).sendKeys(password);
		driver.findElement(btnRegister).click();
	}
	
	public void signOut() {
		
		driver.findElement(linkSignOut).click();
	}
	
	public void verifySignIn() {
		
		driver.findElement(linkSignIn).click();
		
	}
	
	public List<byte[]> getByteScreenshot() throws IOException 
	{
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    byte[] fileContent = FileUtils.readFileToByteArray(src);
	    capture.add(fileContent);
	    return capture;
	}

}