package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {
	
	public static DriverSetUp driverSetUp;
	public static WebDriver driver;
	public static String browser,url;
	
	
	private DriverSetUp() throws IOException {
		
		List<String> propValue=getProperties();
		browser=propValue.get(1);
		url=propValue.get(0);
	
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();  
	}
	
	public static void openPage(String url) {
		
		driver.get(url);
	}
	
	public static void setUpDriver() throws IOException {
        if (driverSetUp==null) {
        	driverSetUp = new DriverSetUp();
        }
    }
	
	public static WebDriver getDriver() {
        return driver;
    }
	
	/*
	public WebDriver WebDriverManager() throws IOException {
		
		
		
		if(driver==null) {
						
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();  
            driver.get(url);
		}
		return driver;	
	}
	*/
	
	public static List<String> getProperties() throws IOException {
		
		List<String> propValue = new ArrayList<String>();
		String path = "src/test/resources/properties/dsAlgo.properties";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		propValue.add(prop.getProperty("url"));
		propValue.add(prop.getProperty("browser"));
		propValue.add(prop.getProperty("userName"));
		propValue.add(prop.getProperty("password"));
		return propValue;
				
	}
	
	public static void setProperties(String pageName) throws IOException {
		
		String path = "src/test/resources/properties/dsAlgo.properties";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		String newUrl=prop.get("url")+"/"+pageName;
		prop.replace("url", prop.get("url"), newUrl);
		
	}
	
  public static void tearDown() {
         if(driver!=null) {
             driver.close();
             driver.quit();
         }
         driverSetUp = null;
     }

}
