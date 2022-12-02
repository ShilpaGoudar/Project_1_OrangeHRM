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
import pageObejctsOrangeHRM.MyInfoEmergencyContactsPage;
import pageObejctsOrangeHRM.LoginPage;
import pageObejctsOrangeHRM.MyInfoContactDetailsPage;
import pageObejctsOrangeHRM.MyInfoDependentsPage;
import pageObejctsOrangeHRM.MyInfoPersonalDetailsPage;
import pageObejctsOrangeHRM.MyInfoTaxExemptionPage;

public class TestCase_02_LoginAsUser_AddMyInfo_Logout {
	
WebDriver driver;
	
	LoginPage LoginPageObject;
	DashboardPage DashboardPageObject;
	MyInfoPersonalDetailsPage MyInfoPersonalDetailsPageObject;
	MyInfoContactDetailsPage MyInfoContactDetailsPageObject;
	MyInfoEmergencyContactsPage EmergencyContactsPageObject;
	MyInfoDependentsPage MyInfoDependentsPageObject;
	MyInfoTaxExemptionPage MyInfoTaxExemptionPageObject;
	
	@BeforeMethod
	public void launchUrlAndLoginAsUser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginAsUser();
		
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Assert Passed");
	}

	@Test(priority=0)
	public void addMyInfoPersonalDetails() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickMyInfo();
		MyInfoPersonalDetailsPageObject = new MyInfoPersonalDetailsPage(driver);
		MyInfoPersonalDetailsPageObject.addPersonalDetails();
	}
	
	@Test(priority=1)
	public void addMyInfoContactDetails() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickMyInfo();
		MyInfoContactDetailsPageObject = new MyInfoContactDetailsPage(driver);
		MyInfoContactDetailsPageObject.addContactDetails();
	}
	
	@Test(priority=2)
	public void checkFor_addAttachmentRequiredErrorMessage() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickMyInfo();
		MyInfoContactDetailsPageObject = new MyInfoContactDetailsPage(driver);
		MyInfoContactDetailsPageObject.addAttachmentErrorMessage();
	}
	
	@Test(priority=3)
	public void addEmergencyContacts() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickMyInfo();
		EmergencyContactsPageObject = new MyInfoEmergencyContactsPage(driver);
		EmergencyContactsPageObject.addAttachmentAssignedEmergencyContacts();
	}
	
	@Test(priority=4)
	public void addDependents() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickMyInfo();
		MyInfoDependentsPageObject = new MyInfoDependentsPage(driver);
		MyInfoDependentsPageObject.addAssignmentDependents();
	}
	
	@Test(priority=5, groups="Smoke")
	public void taxExemtionOptionsForUserDisabled() throws Exception
	{
		DashboardPageObject = new DashboardPage(driver);
		DashboardPageObject.clickMyInfo();
		MyInfoTaxExemptionPageObject = new MyInfoTaxExemptionPage(driver);
		MyInfoTaxExemptionPageObject.checkTaxExemptionOptionsDisabledForUser();
	}
	
	@AfterMethod
	public void logoutAndCloseBrowser() throws Exception
	{
		Thread.sleep(2000);
		driver.close();
	}
}
