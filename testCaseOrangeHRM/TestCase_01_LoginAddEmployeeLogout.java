package testCaseOrangeHRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObejctsOrangeHRM.DashboardPage;
import pageObejctsOrangeHRM.LoginPage;
import pageObejctsOrangeHRM.PIMPage;

public class TestCase_01_LoginAddEmployeeLogout {
	
	WebDriver driver;
	
	LoginPage LoginPageObject;
	DashboardPage DashboardPageObject;
	PIMPage PIMPageObject;
	
	@Parameters({"browserName"})
	@BeforeMethod
	public void launchUrl(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=0)
	public void adminLogin() throws IOException
	{
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginAsAdmin();
		
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Assert Passed");
	}
	
	@Test(priority=1)
	public void addEmployeeToList() throws Exception
	{
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginAsAdmin();
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickPIM();
		PIMPageObject = new PIMPage(driver);
		PIMPageObject.AddEmployee();
	}
	
	@AfterMethod
	public void logoutAndCloseBrowser() throws Exception
	{
		Thread.sleep(5000);
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickLogoutInAdmin();
		driver.close();
	}

}
