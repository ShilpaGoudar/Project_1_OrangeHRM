package pageObejctsOrangeHRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends XLUtility {
	
	WebDriver driver;

	By adminUserInput = By.xpath("//input[@name='username']");
	By adminPasswordInput = By.xpath("//input[@name='password']");
	By adminLoginButton = By.xpath("//button[@type='submit']");
	
	By loginInputEmptyErrorMessaage = By.xpath("//span[text()='Required']");
	By loginInputIncorrectErrorMessage = By.xpath("//p[text()='Invalid credentials']");
	
	By userInput = By.xpath("//input[@name='username']");
	By userPasswordInput = By.xpath("//input[@name='password']");
	By userLoginButton = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void loginAsAdmin() throws IOException
	{
		String adminUser = getCellData("URL_and_LoginDetails", 1, 1);
		String adminPassword = getCellData("URL_and_LoginDetails", 2, 1);
		
		driver.findElement(adminUserInput).sendKeys(adminUser);
		driver.findElement(adminPasswordInput).sendKeys(adminPassword);
		driver.findElement(adminLoginButton).click();	
	}
	
	public void loginAsUser() throws IOException
	{
		String userName = getCellData("URL_and_LoginDetails", 4, 1);
		String userPassword = getCellData("URL_and_LoginDetails", 5, 1);
		
		driver.findElement(userInput).sendKeys(userName);
		driver.findElement(userPasswordInput).sendKeys(userPassword);
		driver.findElement(userLoginButton).click();	
	}
	
	
	public void loginUserEmptyErrorMessage()
	{
		driver.findElement(adminUserInput).sendKeys("");
		driver.findElement(adminLoginButton).click();
		Boolean isErrorDisplayed = driver.findElement(loginInputEmptyErrorMessaage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(loginInputEmptyErrorMessaage).getAttribute("innerHTML");
		String expectedError = "Required";
		Assert.assertEquals(actualError, expectedError, "EmptyUser_Test_Failed");
	}
	
	public void loginIncorrectUserErrorMessage()
	{
		driver.findElement(adminUserInput).sendKeys("IncorrectUser");
		driver.findElement(adminPasswordInput).sendKeys("admin123");
		driver.findElement(adminLoginButton).click();
		Boolean isErrorDisplayed = driver.findElement(loginInputIncorrectErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(loginInputIncorrectErrorMessage).getAttribute("innerHTML");
		String expectedError = "Invalid credentials";
		Assert.assertEquals(actualError, expectedError, "IncorrectUser_Test_Failed");
	}
	
	public void loginPasswordEmptyErrorMessage()
	{
		driver.findElement(adminPasswordInput).sendKeys("");
		driver.findElement(adminLoginButton).click();
		Boolean isErrorDisplayed = driver.findElement(loginInputEmptyErrorMessaage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(loginInputEmptyErrorMessaage).getAttribute("innerHTML");
		String expectedError = "Required";
		Assert.assertEquals(actualError, expectedError, "EmptyPassword_Test_Failed");
	}
	
	public void loginIncorrectPasswordErrorMessage()
	{
		driver.findElement(adminUserInput).sendKeys("Admin");
		driver.findElement(adminPasswordInput).sendKeys("incorrectPassword");
		driver.findElement(adminLoginButton).click();
		Boolean isErrorDisplayed = driver.findElement(loginInputIncorrectErrorMessage).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error Message not displayed");
		String actualError = driver.findElement(loginInputIncorrectErrorMessage).getAttribute("innerHTML");
		String expectedError = "Invalid credentials";
		Assert.assertEquals(actualError, expectedError, "IncorrectPassword_Test_Failed");
	}
	
}
