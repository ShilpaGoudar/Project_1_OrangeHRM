package pageObejctsOrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoTaxExemptionPage {
	
	WebDriver driver;
	
	MyInfoPersonalDetailsPage MyInfoPersonalDetailsPageObject;
	
	By federalITExemption = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input");
	By federalITStatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
	By stateITState = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/div/div/div[1]");
	
	public MyInfoTaxExemptionPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void checkTaxExemptionOptionsDisabledForUser()
	{
		MyInfoPersonalDetailsPageObject = new MyInfoPersonalDetailsPage(driver);
		MyInfoPersonalDetailsPageObject.clickTaxExemptions();
		
		Boolean status1 = driver.findElement(federalITExemption).isEnabled();
		if(status1)
		{
			System.out.println("Incorrect - Element to be disabled");
		}
		else
		{
			System.out.println("Correct - Element is disabled");
		}
		
		Boolean status2 = driver.findElement(federalITStatus).isSelected();
		if(status2)
		{
			System.out.println("Incorrect - Element to be disabled");
		}
		else
		{
			System.out.println("Correct - Element is disabled");
		}

		Boolean status3 = driver.findElement(stateITState).isSelected();
		if(status3)
		{
			System.out.println("Incorrect - Element to be disabled");
		}
		else
		{
			System.out.println("Correct - Element is disabled");
		}
	}

}
