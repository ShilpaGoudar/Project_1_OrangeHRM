package testCaseOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_03_ForgotPassword {
	
	WebDriver driver;
	
	@Parameters({"browserName"})
	@BeforeTest
	public void launchUrl(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=0)
	public void adminLogin()
	{
		driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shilpa123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String ExpectedText = "Reset Password link sent successfully";
		String ActualText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")).getText();
		
		Assert.assertEquals(ActualText, ExpectedText, "Message Not Found");
	}
	
	@AfterTest
	public void CloseBrowser() throws Exception
	{
		Thread.sleep(5000);
		driver.close();
	}

}
