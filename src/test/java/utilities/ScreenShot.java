package utilities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class ScreenShot {
	
	//DriverSetUp driverSetUp=new DriverSetUp();
	static WebDriver driver;
	public static Scenario scenarioName;
	
	public static void getByteScreenshot(String screenshot) throws IOException 
	{
		
		driver=DriverSetUp.getDriver();
		//String path = ("user,dir")+"Failed_Screenshot";
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    byte[] fileContent = FileUtils.readFileToByteArray(src);
	    String screenshotName = screenshot.replace(' ', '_');
	    //String screenshotName = StepDetails.stepName.replace(" ", "_");
		//System.out.println(screenshotName+" ,"+registerPage.getByteScreenshot().size());
		scenarioName.attach(fileContent, "image/png", screenshotName);	
		Allure.addAttachment(screenshotName, new ByteArrayInputStream(fileContent));
	    FileUtils.copyFile(src, new File("./ScreenShot_Folder/" + screenshotName + ".png"));
	    //return fileContent;
	}

}
