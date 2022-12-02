package testCaseOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObejctsOrangeHRM.AddRecruitmentPage;
import pageObejctsOrangeHRM.AddVacanciesPage;
import pageObejctsOrangeHRM.DashboardPage;
import pageObejctsOrangeHRM.LoginPage;

public class TestCase_05_AddVacancies {
	
	WebDriver driver;
	
	LoginPage LoginPageObject;
	DashboardPage DashboardPageObject;
	AddVacanciesPage AddVacanciesPageObject;
	AddRecruitmentPage AddRecruitmentPageObject;
	
	@BeforeTest
	public void launchUrl()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=0)
	public void adminLogin() throws Exception
	{
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginAsAdmin();
	}
	
	@Test(priority=1)
	public void addCandidateInRecruitment() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickRecruitment();
		AddRecruitmentPageObject = new AddRecruitmentPage(driver);
		AddRecruitmentPageObject.clickVacancies();
		AddVacanciesPageObject = new AddVacanciesPage(driver);
		AddVacanciesPageObject.clickOnAddVacanciesButton();
		AddVacanciesPageObject.addVacancy();
	}
	
	@AfterTest
	public void logoutAndCloseBrowser() throws Exception
	{
		Thread.sleep(5000);
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickLogoutInAdmin();
		driver.close();
	}

}
