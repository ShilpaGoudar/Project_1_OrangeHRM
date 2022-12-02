package testCaseOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObejctsOrangeHRM.DashboardPage;
import pageObejctsOrangeHRM.DirectoryPage;
import pageObejctsOrangeHRM.LoginPage;

public class TestCase_06_SearchEmployeeInDirectory {
	
	WebDriver driver;
	
	LoginPage LoginPageObject;
	DirectoryPage DirectoryPageObject;
	DashboardPage DashboardPageObject;

	@BeforeMethod
	public void launchUrlAndLoginAsUser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginAsAdmin();
		
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Assert Passed");
	}
	

	@Test(priority=0)
	public void searchEmployeeAndGetEmailId() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickDirectory();
		DirectoryPageObject = new DirectoryPage(driver);
		DirectoryPageObject.searchEmployeeInDirectory();
	}
	
	@AfterMethod
	public void logoutAndCloseBrowser() throws Exception
	{
		Thread.sleep(2000);
		driver.close();
	}

}
