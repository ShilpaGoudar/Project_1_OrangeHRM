package pageObejctsOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfoEmergencyContactsPage {
	
	WebDriver driver;
	
	MyInfoPersonalDetailsPage MyInfoPersonalDetailsPageObject;
	
	By clickAddAttahmentEmergencyContacts = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button");
	
	public MyInfoEmergencyContactsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean addAttachmentAssignedEmergencyContacts()
	{
		MyInfoPersonalDetailsPageObject = new MyInfoPersonalDetailsPage(driver);
		MyInfoPersonalDetailsPageObject.clickEmergencyContacts();
		WebElement checkAddButtonClicks=driver.findElement(clickAddAttahmentEmergencyContacts);
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(checkAddButtonClicks));
			checkAddButtonClicks.click();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
