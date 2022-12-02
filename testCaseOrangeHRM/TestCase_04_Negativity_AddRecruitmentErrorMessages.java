package testCaseOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObejctsOrangeHRM.AddRecruitmentPage;
import pageObejctsOrangeHRM.DashboardPage;
import pageObejctsOrangeHRM.LoginPage;

public class TestCase_04_Negativity_AddRecruitmentErrorMessages {
	
	WebDriver driver;
	
	LoginPage LoginPageObject;
	DashboardPage DashboardPageObject;
	AddRecruitmentPage AddRecruitmentPageObject;
	
	@BeforeMethod
	public void launchUrlAndLoginThenClickToAddCandidate() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginAsAdmin();
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickRecruitment();
		AddRecruitmentPageObject = new AddRecruitmentPage(driver);
		AddRecruitmentPageObject.clickOnAddCandidate();
	}
	
	@Test(priority=0)
	public void checkForErrorMessage_EmptyFirstName()
	{
		AddRecruitmentPageObject = new AddRecruitmentPage(driver);
		AddRecruitmentPageObject.emptyFirstNameErrorMessage();
	}
	
	@Test(priority=1)
	public void checkForErrorMessage_EmptyLastName()
	{
		AddRecruitmentPageObject = new AddRecruitmentPage(driver);
		AddRecruitmentPageObject.emptyLastNameErrorMessage();
	}
	
	@Test(priority=2)
	public void checkForErrorMessage_EmptyEmail()
	{
		AddRecruitmentPageObject = new AddRecruitmentPage(driver);
		AddRecruitmentPageObject.emptyEmailErrorMessage();
	}
	
	@Test(priority=3)
	public void checkForErrorMessage_InvalidEmail()
	{
		AddRecruitmentPageObject = new AddRecruitmentPage(driver);
		AddRecruitmentPageObject.invalidEmailErrorMessage();
	}
	
	@Test(priority=4)
	public void checkForErrorMessage_InvalidFormatDate()
	{
		AddRecruitmentPageObject = new AddRecruitmentPage(driver);
		AddRecruitmentPageObject.invalidFormatDateErrorMessage();
	}
	
	@AfterMethod
	public void logoutAndCloseBrowser() throws Exception
	{
		Thread.sleep(2000);
		driver.close();
	}

}
