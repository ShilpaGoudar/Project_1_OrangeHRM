package pageObejctsOrangeHRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PIMPage {

	WebDriver driver;
	
	By adminUserAddEmployee = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	By inputAddEmployeeFirstName = By.xpath("//input[@name='firstName']");
	By inputAddEmployeeMiddleName = By.xpath("//input[@name='middleName']");
	By inputAddEmployeeLastName = By.xpath("//input[@name='lastName']");
	By inputAddEmployeeId = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
	By clickToAddImage = By.xpath("//i[@class='oxd-icon bi-plus']");
	By checkboxCreateDetails = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");
	By inputUserName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input");
	By inputPassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input");
	By inputConfirmPassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input");
	By clickSubmitDetails = By.xpath("//button[@type='submit']");
	
	public PIMPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void AddEmployee() throws AWTException, Exception
	{
			Properties PageProperties = new Properties();
			FileInputStream InputStream = new FileInputStream("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Project_1_OrangeHRM\\DataFiles\\PropertiesOfAllPages.properties");
			PageProperties.load(InputStream);
			String PIMFirstName = PageProperties.getProperty("PIM_FirstName");
			String PIMMiddleName = PageProperties.getProperty("PIM_MiddleName"); 
			String PIM_LastName = PageProperties.getProperty("PIM_LastName");
			String PIM_EmployeeId = PageProperties.getProperty("PIM_EmployeeId");
			String PIM_UserName = PageProperties.getProperty("PIM_UserName");
			String PIM_UserPassword = PageProperties.getProperty("PIM_UserPassword");
		
		driver.findElement(adminUserAddEmployee).click();
		driver.findElement(inputAddEmployeeFirstName).sendKeys(PIMFirstName);
		driver.findElement(inputAddEmployeeMiddleName).sendKeys(PIMMiddleName);
		driver.findElement(inputAddEmployeeLastName).sendKeys(PIM_LastName);
		driver.findElement(inputAddEmployeeId).clear();
		driver.findElement(inputAddEmployeeId).sendKeys(PIM_EmployeeId);
		driver.findElement(clickToAddImage).click();
		
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("Pictures\\Img1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL); //Press Control
		rb.keyPress(KeyEvent.VK_V); //Press V
		rb.keyRelease(KeyEvent.VK_CONTROL); //Release Ctrl
		rb.keyRelease(KeyEvent.VK_V); //Release V
		rb.keyPress(KeyEvent.VK_ENTER); //Press Enter
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement checkCreateLoginDetails = driver.findElement(checkboxCreateDetails);
		checkCreateLoginDetails.click();
		Assert.assertTrue(checkCreateLoginDetails.isEnabled(), "Enabled");
		driver.findElement(inputUserName).sendKeys(PIM_UserName);
		driver.findElement(inputPassword).sendKeys(PIM_UserPassword);
		driver.findElement(inputConfirmPassword).sendKeys(PIM_UserPassword);
		driver.findElement(clickSubmitDetails).click();
	}
}
