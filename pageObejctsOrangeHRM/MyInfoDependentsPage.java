package pageObejctsOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfoDependentsPage {
	
	WebDriver driver;
	
	MyInfoPersonalDetailsPage MyInfoPersonalDetailsPageObject;
	
	By addAssignedDependents = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button");
	By addDependentText = By.xpath("//h6[text()='Add Dependent']");
	By dependentName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
	By dependentDateOfBirth = By.xpath("//input[@placeholder='yyyy-mm-dd']");
	By dependentSaveButton = By.xpath("//button[@type='submit']");
	
	public MyInfoDependentsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addAssignmentDependents()
	{
		MyInfoPersonalDetailsPageObject = new MyInfoPersonalDetailsPage(driver);
		MyInfoPersonalDetailsPageObject.clickDependents();
		driver.findElement(addAssignedDependents).click();
		
		WebElement checkAddAssignedDependentsClicks=driver.findElement(addDependentText);
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(checkAddAssignedDependentsClicks));
			driver.findElement(dependentName).sendKeys("Shilpa");
			driver.findElement(dependentDateOfBirth).sendKeys("2023-06-28");
			driver.findElement(dependentSaveButton).click();
		}
		catch(Exception e) {
			System.out.println("Add Assigned Dependent Failed");
		}
	}

}
