package defenitions;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import pageObject.RegisterPage;
import utilities.DriverSetUp;
import utilities.ScreenShot;
//import utilities.ScreenShot;
import utilities.StepDetails;
import utilities.TestSetUp;

public class Hooks {
	
	public WebDriver driver;
	
	public TestSetUp testSetUp;
	
	public Hooks(TestSetUp testSetUp) {
		this.testSetUp = testSetUp;
		
	}
	@BeforeAll
	public static void beforeAll() throws IOException {
	}
	
	@Before
	public void startUp(Scenario scenario) throws IOException {
		//driver=testSetUp.driverSetUp.WebDriverManager();
		DriverSetUp.setUpDriver();
		System.out.println("**************************************************\n");
		System.out.println(scenario.getName()+" started");	
		System.out.println("**************************************************\n");
	}
	
	@Before
	public void setUpScenario(Scenario scenario) {
		
		ScreenShot.scenarioName=scenario;
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
		
		System.out.println("**************************************************\n");
		System.out.println(scenario.getName()+" completed");
		System.out.println("**************************************************\n");
		driver=DriverSetUp.getDriver();
		try {
			if(scenario.isFailed()) {
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    byte[] fileContent = FileUtils.readFileToByteArray(src);
				//System.out.println(screenshotName+" ,"+registerPage.getByteScreenshot().size());
				scenario.attach(fileContent, "image/png", scenario.getName());	
				Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(fileContent));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterAll
	public static void afterAll() throws IOException {		
		DriverSetUp.tearDown();
	}

}