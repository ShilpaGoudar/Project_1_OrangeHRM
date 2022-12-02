package testCaseOrangeHRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObejctsOrangeHRM.DashboardPage;
import pageObejctsOrangeHRM.LoginPage;

public class TestCase_01_Negativity_LoginErrorMessages {
	
	WebDriver driver;
	
	LoginPage LoginPageObject;
	DashboardPage DashboardPageObject;
	
	@BeforeMethod
	public void launchUrl() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=0)
	public void EmptyUserCheckForErrorMessage() throws IOException
	{
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginUserEmptyErrorMessage();
	}
	
	@Test(priority=1)
	public void IncorrectUserCheckForErrorMessage() throws IOException
	{
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginIncorrectUserErrorMessage();
	}
	
	@Test(priority=2)
	public void EmptyPasswordCheckForErrorMessage() throws IOException
	{
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginPasswordEmptyErrorMessage();
	}
	
	@Test(priority=3)
	public void IncorrectPasswordCheckForErrorMessage() throws IOException
	{
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginIncorrectPasswordErrorMessage();
	}

	@AfterMethod
	public void logoutAndCloseBrowser() throws Exception
	{
		Thread.sleep(2000);
		driver.close();
	}

}
