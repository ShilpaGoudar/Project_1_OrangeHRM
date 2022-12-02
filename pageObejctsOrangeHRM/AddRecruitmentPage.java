package pageObejctsOrangeHRM;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddRecruitmentPage {
	
	WebDriver driver;
	
	By recruitmentAddCandidate = By.xpath("//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--secondary']");
	By vacanciesButton = By.xpath("//a[text()='Vacancies']");
	By candidateFirstName = By.xpath("//input[@name='firstName']");
	By candidateMiddleName = By.xpath("//input[@name='middleName']");
	By candidateLastName = By.xpath("//input[@name='lastName']");
	By candidateEmail = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input");
	By candidateContactNum = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input");
	By candidateResumeBrowseButton = By.xpath("//div[text()='Browse']");
	By candidateKeywords = By.xpath("//input[@placeholder='Enter comma seperated words...']");
	By candidateDateOfApplication = By.xpath("//input[@placeholder='yyyy-mm-dd']");
	By candidateNotes = By.xpath("//textarea[@placeholder='Type here']");
	By candidateConsentCheckbox = By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");
	By candidateSave = By.xpath("//button[@type='submit']");
	
	By requiredErrorMessage = By.xpath("//span[text()='Required']");
	By invalidEmailErrorMessage = By.xpath("//span[text()='Expected format: admin@example.com']");
	By invalidFormatDateErrorMessage = By.xpath("//span[text()='Should be a valid date in yyyy-mm-dd format']");
	
	public AddRecruitmentPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickVacancies()
	{
		driver.findElement(vacanciesButton).click();
	}
	
	public void clickOnAddCandidate()
	{
		driver.findElement(recruitmentAddCandidate).click();
	}
	
	public void addCandidateInRecruitment() throws Exception
	{
		Properties PageProperties = new Properties();
		FileInputStream InputStream = new FileInputStream("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Project_1_OrangeHRM\\DataFiles\\PropertiesOfAllPages.properties");
		PageProperties.load(InputStream);
		String Candidate_FirstName = PageProperties.getProperty("Candidate_FirstName");
		String Candidate_MiddleName = PageProperties.getProperty("Candidate_MiddleName");
		String Candidate_LastName = PageProperties.getProperty("Candidate_LastName");
		String Candidate_Email = PageProperties.getProperty("Candidate_Email");
		String Candidate_ContactNum = PageProperties.getProperty("Candidate_ContactNum");
		String Candidate_Keywords = PageProperties.getProperty("Candidate_Keywords");
		String Candidate_DateOfApplication = PageProperties.getProperty("Candidate_DateOfApplication");
		String Candidate_Notes = PageProperties.getProperty("Candidate_Notes");
		
		driver.findElement(candidateFirstName).sendKeys(Candidate_FirstName);
		driver.findElement(candidateMiddleName).sendKeys(Candidate_MiddleName);
		driver.findElement(candidateLastName).sendKeys(Candidate_LastName);
		driver.findElement(candidateEmail).sendKeys(Candidate_Email);
		driver.findElement(candidateContactNum).sendKeys(Candidate_ContactNum);
		
		driver.findElement(candidateResumeBrowseButton).click();
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Project_1_OrangeHRM\\DataFiles\\Test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL); 
		rb.keyPress(KeyEvent.VK_V); 
		rb.keyRelease(KeyEvent.VK_CONTROL); 
		rb.keyRelease(KeyEvent.VK_V); 
		rb.keyPress(KeyEvent.VK_ENTER); 
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(candidateKeywords).sendKeys(Candidate_Keywords);
		WebElement tocClearDate = driver.findElement(candidateDateOfApplication);
		tocClearDate.sendKeys(Keys.CONTROL + "a");
		tocClearDate.sendKeys(Keys.DELETE);
		driver.findElement(candidateDateOfApplication).sendKeys(Candidate_DateOfApplication);
		driver.findElement(candidateNotes).sendKeys(Candidate_Notes);
		driver.findElement(candidateConsentCheckbox).click();
		driver.findElement(candidateSave).click();
	}
	
	
	public void emptyFirstNameErrorMessage()
	{
		driver.findElement(candidateFirstName).sendKeys("");
		driver.findElement(candidateSave).click();
		Boolean isErrorDisplayed = driver.findElement(requiredErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(requiredErrorMessage).getAttribute("innerHTML");
		String expectedError = "Required";
		Assert.assertEquals(actualError, expectedError, "EmptyFirstName_Test_Failed");
	}
	
	public void emptyLastNameErrorMessage()
	{
		driver.findElement(candidateLastName).sendKeys("");
		driver.findElement(candidateSave).click();
		Boolean isErrorDisplayed = driver.findElement(requiredErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(requiredErrorMessage).getAttribute("innerHTML");
		String expectedError = "Required";
		Assert.assertEquals(actualError, expectedError, "EmptyLastName_Test_Failed");
	}
	
	public void emptyEmailErrorMessage()
	{
		driver.findElement(candidateEmail).sendKeys("");
		driver.findElement(candidateSave).click();
		Boolean isErrorDisplayed = driver.findElement(requiredErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(requiredErrorMessage).getAttribute("innerHTML");
		String expectedError = "Required";
		Assert.assertEquals(actualError, expectedError, "EmptyEmail_Test_Failed");
	}
	
	public void invalidEmailErrorMessage()
	{
		driver.findElement(candidateEmail).sendKeys("abdchy");
		driver.findElement(candidateSave).click();
		Boolean isErrorDisplayed = driver.findElement(invalidEmailErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(invalidEmailErrorMessage).getAttribute("innerHTML");
		String expectedError = "Expected format: admin@example.com";
		Assert.assertEquals(actualError, expectedError, "InvalidEmail_Test_Failed");
	}
	
	public void invalidFormatDateErrorMessage()
	{
		driver.findElement(candidateDateOfApplication).sendKeys("22-10-2015");
		driver.findElement(candidateSave).click();
		Boolean isErrorDisplayed = driver.findElement(invalidFormatDateErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(invalidFormatDateErrorMessage).getAttribute("innerHTML");
		String expectedError = "Should be a valid date in yyyy-mm-dd format";
		Assert.assertEquals(actualError, expectedError, "InvalidEmail_Test_Failed");
	}
	
}
