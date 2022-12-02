package pageObejctsOrangeHRM;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DirectoryPage {
	
	WebDriver driver;
	
	By directoryEmpName = By.xpath("//input[@placeholder='Type for hints...']");
	By searchingOption = By.xpath("//div[@role='listbox']");
	By searchButton = By.xpath("//button[text()=' Search ']");
	By recordFound = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div");
	By emailFound = By.xpath("//p[text()='Lisa.Andrews@osohrm.com']");
	By copyElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[6]/div[2]/button/i");
	
	public DirectoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchEmployeeInDirectory() throws Exception
	{
		driver.findElement(directoryEmpName).sendKeys("Lisa");
		Thread.sleep(2000);
		WebElement locateSearchingOption = driver.findElement(searchingOption);
		Actions action = new Actions(driver);
		action.moveToElement(locateSearchingOption).doubleClick().build().perform();
		
		// driver.findElement(searchingOption).click();
		driver.findElement(searchButton).click();
		Thread.sleep(1000);
		driver.findElement(recordFound).click();
		
		Thread.sleep(1000);
		WebElement locateEmailElement = driver.findElement(emailFound);
		Actions action1 = new Actions(driver);
		action1.moveToElement(locateEmailElement).build().perform();
		
		WebElement locateCopyElement = driver.findElement(copyElement);
		Actions action2 = new Actions(driver);
		action2.moveToElement(locateCopyElement).doubleClick().build().perform(); 
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		 Clipboard clipboard = toolkit.getSystemClipboard();
		 String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println(result);
	}

}
