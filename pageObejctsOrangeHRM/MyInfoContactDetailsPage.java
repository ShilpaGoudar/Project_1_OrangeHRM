package pageObejctsOrangeHRM;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyInfoContactDetailsPage {
	
	WebDriver driver;
	
	MyInfoPersonalDetailsPage MyInfoPersonalDetailsPageObject;
	
	By inputStreet1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
	By inputStreet2 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input");
	By inputCity = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input");
	By inputState = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/input");
	By inputZip = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input");
	By inputMobileNum = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input");
	By addAttachment = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/button");
	By browseButton = By.xpath("//div[text()='Browse']");
	By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[3]/button[2]");
	
	By requiredErrorMessage = By.xpath("//span[text()='Required']");
	
	public MyInfoContactDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addContactDetails() throws Exception
	{
		MyInfoPersonalDetailsPageObject = new MyInfoPersonalDetailsPage(driver);
		MyInfoPersonalDetailsPageObject.clickContactDetails();
		Properties PageProperties = new Properties();
		FileInputStream InputStream = new FileInputStream("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Project_1_OrangeHRM\\DataFiles\\PropertiesOfAllPages.properties");
		PageProperties.load(InputStream);
		String MyInfoContact_Street1 = PageProperties.getProperty("MyInfoContact_Street1");
		String MyInfoContact_Street2 = PageProperties.getProperty("MyInfoContact_Street2");
		String MyInfoContact_City = PageProperties.getProperty("MyInfoContact_City");
		String MyInfoContact_State = PageProperties.getProperty("MyInfoContact_State");
		String MyInfoContact_Zip = PageProperties.getProperty("MyInfoContact_Zip");
		String MyInfoContact_Mobile = PageProperties.getProperty("MyInfoContact_Mobile");
		
		driver.findElement(inputStreet1).sendKeys(MyInfoContact_Street1);
		driver.findElement(inputStreet2).sendKeys(MyInfoContact_Street2);
		driver.findElement(inputCity).sendKeys(MyInfoContact_City);
		driver.findElement(inputState).sendKeys(MyInfoContact_State);
		driver.findElement(inputZip).sendKeys(MyInfoContact_Zip);
		driver.findElement(inputMobileNum).sendKeys(MyInfoContact_Mobile);
		
		driver.findElement(addAttachment).click();
		driver.findElement(browseButton).click();
		
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL); //Press Control
		rb.keyPress(KeyEvent.VK_V); //Press V
		rb.keyRelease(KeyEvent.VK_CONTROL); //Release Ctrl
		rb.keyRelease(KeyEvent.VK_V); //Release V
		rb.keyPress(KeyEvent.VK_ENTER); //Press Enter
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(saveButton).click();
	}
	
	public void addAttachmentErrorMessage() throws Exception
	{
		MyInfoPersonalDetailsPageObject = new MyInfoPersonalDetailsPage(driver);
		MyInfoPersonalDetailsPageObject.clickContactDetails();
		
		driver.findElement(addAttachment).click();
		driver.findElement(browseButton).click();
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL); //Press Control
		rb.keyPress(KeyEvent.VK_V); //Press V
		rb.keyRelease(KeyEvent.VK_CONTROL); //Release Ctrl
		rb.keyRelease(KeyEvent.VK_V); //Release V
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER); //Press Enter
		rb.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(saveButton).click();
		
		Boolean isErrorMessageShown = driver.findElement(requiredErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorMessageShown, "Displayed Error Message");
		
		String actualError = driver.findElement(requiredErrorMessage).getAttribute("innerHTML");
		String expectedError = "Required";
		Assert.assertEquals(actualError, expectedError, "Error Message Required");
	}

}
