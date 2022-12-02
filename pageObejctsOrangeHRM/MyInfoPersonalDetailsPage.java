package pageObejctsOrangeHRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyInfoPersonalDetailsPage {
	
	WebDriver driver;
	
	Generic_Methods Generic_MethodsObject;
	
	By userNickname = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input");
	By userLicenseExpiryDate = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input");
	By userNationality = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div");
	By userNationalityList = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div[2]/div");
	By userMaritalStatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div");
	By userMaritalStatusList = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div[2]/div");
	By userGender = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label/span");
	By userBloodType = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div");
	By userBloodTypeList = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div[2]/div");
	By userPersonalDetailsSave = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button");
	By userCustomFieldsSave = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button");
	By userAddAttachment = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div/button");
	By userAttachmentBrowse = By.xpath("//div[text()='Browse']");
	By userInputComment = By.xpath("//textarea[@placeholder='Type comment here']");
	By userAddAttachmentSave = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]");
	
	By userEmployeeId = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input");
	By userDriverLicenseNum = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input");
	By userSSNNum = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input");
	By userSINNum = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input");
	
	By contactDetails = By.linkText("Contact Details");
	By emergencyContacts = By.linkText("Emergency Contacts");
	By dependents = By.linkText("Dependents");
	By immigration = By.linkText("Immigration");
	By job = By.linkText("Job");
	By salary = By.linkText("Salary");
	By taxExemptions = By.linkText("Tax Exemptions");
	By reportTo = By.linkText("Report-to");
	By qualifications = By.linkText("Qualifications");
	By membershipa = By.linkText("Memberships");
	
	public MyInfoPersonalDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addPersonalDetails() throws AWTException, Exception
	{
		
		Properties PageProperties = new Properties();
		FileInputStream InputStream = new FileInputStream("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Project_1_OrangeHRM\\DataFiles\\PropertiesOfAllPages.properties");
		PageProperties.load(InputStream);
		String MyInfo_NickName = PageProperties.getProperty("MyInfo_NickName");
		String MyInfo_LicenseExpiryDate = PageProperties.getProperty("MyInfo_LicenseExpiryDate"); 
		String MyInfo_Comment = PageProperties.getProperty("MyInfo_Comment");
		
		driver.findElement(userNickname).sendKeys(MyInfo_NickName);
		
		try {
		Boolean isEmployeeIdEnabled = driver.findElement(userEmployeeId).isEnabled();
		Assert.assertFalse(isEmployeeIdEnabled, "Employee Id disabled for User Login");
		}
		catch(Exception e)
		{
			System.out.println("Employee id to be disabled");
		}
		Boolean isDriversLicenseNumEnabled = driver.findElement(userDriverLicenseNum).isEnabled();
		Assert.assertFalse(isDriversLicenseNumEnabled, "Driver's License Number disabled for User Login");
		Boolean isSSNNumberEnabled = driver.findElement(userSSNNum).isEnabled();
		Assert.assertFalse(isSSNNumberEnabled, "SSN Number disabled for User Login");
		Boolean isSINNumberEnabled = driver.findElement(userSINNum).isEnabled();
		Assert.assertFalse(isSINNumberEnabled, "SIN Number disabled for User Login");
		
		driver.findElement(userLicenseExpiryDate).sendKeys(MyInfo_LicenseExpiryDate);
		
		driver.findElement(userNationality).click();
		List<WebElement> Nations = driver.findElements(userNationalityList);
		Generic_MethodsObject = new Generic_Methods(driver);
		Generic_MethodsObject.selectDropdown(Nations, "Indian");
		Thread.sleep(3000);
		
		driver.findElement(userMaritalStatus).click();
		List<WebElement> MaritalStatuses = driver.findElements(userMaritalStatusList);
		Generic_MethodsObject = new Generic_Methods(driver);
		Generic_MethodsObject.selectDropdown(MaritalStatuses, "Married");
		Thread.sleep(3000);
		
		driver.findElement(userGender).click();
		
		driver.findElement(userBloodType).click();
		List<WebElement> typesOfBlood = driver.findElements(userBloodTypeList);
		Generic_MethodsObject = new Generic_Methods(driver);
		Generic_MethodsObject.selectDropdown(typesOfBlood, "B+");
		Thread.sleep(5000);
		
		driver.findElement(userPersonalDetailsSave).click();
		
		driver.findElement(userCustomFieldsSave).click();
		driver.findElement(userAddAttachment).click();
		driver.findElement(userAttachmentBrowse).click();
		
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Project_1_OrangeHRM\\DataFiles\\Test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL); //Press Control
		rb.keyPress(KeyEvent.VK_V); //Press V
		rb.keyRelease(KeyEvent.VK_CONTROL); //Release Ctrl
		rb.keyRelease(KeyEvent.VK_V); //Release V
		rb.keyPress(KeyEvent.VK_ENTER); //Press Enter
		rb.keyRelease(KeyEvent.VK_ENTER);
	
		driver.findElement(userInputComment).sendKeys(MyInfo_Comment);
		Thread.sleep(5000);
		driver.findElement(userAddAttachmentSave).click();
	}
	
	public void clickContactDetails()
	{
		driver.findElement(contactDetails).click();
	}
	
	public void clickEmergencyContacts()
	{
		driver.findElement(emergencyContacts).click();
	}
	
	public void clickDependents()
	{
		driver.findElement(dependents).click();
	}
	
	public void clickImmigration()
	{
		driver.findElement(immigration).click();
	}
	
	public void clickJob()
	{
		driver.findElement(job).click();
	}
	
	public void clickSalary()
	{
		driver.findElement(salary).click();
	}
	
	public void clickTaxExemptions()
	{
		driver.findElement(taxExemptions).click();
	}
	
	public void clickReportTo()
	{
		driver.findElement(reportTo).click();
	}
	
	public void clickQualifications()
	{
		driver.findElement(qualifications).click();
	}
	
	public void clickMemberships()
	{
		driver.findElement(membershipa).click();
	}

}
