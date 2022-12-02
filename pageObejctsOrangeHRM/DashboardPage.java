package pageObejctsOrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
	
	WebDriver driver;
	
	By adminUserSelectMenu = By.xpath("//p[@class='oxd-userdropdown-name']");
	By adminUserLogout = By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]");
	By adminUserPIM = By.xpath("//ul[@class='oxd-main-menu']//li[2]");
	By userMyInfo = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span");
	By adminUserRecruitment = By.xpath("//span[text()='Recruitment']");
	By dirctory = By.xpath("//span[text()='Directory']");
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickLogoutInAdmin()
	{
		Actions action = new Actions(driver);
		WebElement adminUser = driver.findElement(adminUserSelectMenu);
		action.moveToElement(adminUser).build().perform();
		adminUser.click();
		WebElement adminLogout = driver.findElement(adminUserLogout);
		action.moveToElement(adminLogout).build().perform();
		adminLogout.click();
	}
	
	public void clickPIM()
	{
		driver.findElement(adminUserPIM).click();
	}
	
	public void clickMyInfo()
	{
		driver.findElement(userMyInfo).click();
	}
	
	public void clickRecruitment()
	{
		driver.findElement(adminUserRecruitment).click();
	}
	
	public void clickDirectory()
	{
		driver.findElement(dirctory).click();
	}

}
