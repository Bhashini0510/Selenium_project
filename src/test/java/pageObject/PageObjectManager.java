package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObject.QueuePage;
import pageObject.StackPage;

public class PageObjectManager {
	
	public RegisterPage registerPage;
	public LoginPage loginPage;
	public HomePage homePage;
	public LinkedListPage linkedListPage;
	public TreePage treePage;
	public WebDriver driver;
	public StackPage stackpage;
	public QueuePage queuepage;
	public GraphPage graphpage;
	public DsPage dsPage;
	
	/*
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public RegisterPage getRegisterPage()  {
		
		registerPage = new RegisterPage(driver);
		return registerPage;
		
	}
	
	public LoginPage getLoginPage()  {
		
		loginPage = new LoginPage(driver);
		return loginPage;
		
	}
	
	public HomePage getHomePage()  {
		
		homePage = new HomePage(driver);
		return homePage;
		
	}
	
	public LinkedListPage getLinkedListPage()  {
		
		linkedListPage = new LinkedListPage(driver);
		return linkedListPage;
		
	}
	
	public TreePage getTreePage()  {
		
		treePage = new TreePage(driver);
		return treePage;
		
	}
	public StackPage StackPageObject() {
		stackpage = new StackPage(driver);
		 return stackpage;
	}
	public QueuePage QueuePageObject() {
		queuepage = new QueuePage(driver);
		 return queuepage;
	}
	public DataStructurePage DataStructurePageObject() {
		datastructurepage = new DataStructurePage(driver);
		 return datastructurepage;
	}
	public ArrayPage1 ArraysPage() {
		arraypage = new ArrayPage1(driver);
		 return arraypage;
	}
	public GraphPage Graphpage() {
		graphpage = new GraphPage(driver);
		 return graphpage;
	}
*/
}
