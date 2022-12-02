package pageObejctsOrangeHRM;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddVacanciesPage {
	
	WebDriver driver;
	
	By addVacanciesButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By vacancyName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input");
	By description = By.xpath("//textarea[@placeholder='Type description here']");
	By hiringManager = By.xpath("//input[@placeholder='Type for hints...']");
	By numberOfPositions = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[2]/div/div/div/div[2]/input");
	By activeCheckbox = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div/label/span");
	By publishCheckbox = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div/label/span");
	By rssFeedUrl = By.partialLinkText(".rss");
	By webPageUrl = By.partialLinkText(".html");
	By submitButton = By.xpath("//button[@type='submit']");
	
	public AddVacanciesPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickOnAddVacanciesButton()
	{
		driver.findElement(addVacanciesButton).click();
	}
	
	public void addVacancy() throws Exception
	{
		Properties PageProperties = new Properties();
		FileInputStream InputStream = new FileInputStream("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\Project1_OrangeHRM\\Project_1_OrangeHRM\\DataFiles\\PropertiesOfAllPages.properties");
		PageProperties.load(InputStream);
		String VacancyName = PageProperties.getProperty("VacancyName");
		String VacancyDescription = PageProperties.getProperty("VacancyDescription");
		String HiringManager = PageProperties.getProperty("HiringManager");
		String NumberOfPositions = PageProperties.getProperty("NumberOfPositions");
		
		driver.findElement(vacancyName).sendKeys(VacancyName);
		driver.findElement(description).sendKeys(VacancyDescription);
		driver.findElement(hiringManager).sendKeys(HiringManager);
		driver.findElement(numberOfPositions).sendKeys(NumberOfPositions);
		driver.findElement(activeCheckbox).click();
		driver.findElement(publishCheckbox).click();
		
		Thread.sleep(5000);
		driver.findElement(rssFeedUrl).click();
		Thread.sleep(2000);
		ArrayList<String> rssTab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(rssTab.get(1));
	    driver.close();
	    driver.switchTo().window(rssTab.get(0));
	    
		Thread.sleep(5000);
		driver.findElement(webPageUrl).click();
		Thread.sleep(3000);
		ArrayList<String> webTab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(webTab.get(1));
	    driver.close();
	    driver.switchTo().window(webTab.get(0));
		
		driver.findElement(submitButton).click();
	
	}
}
