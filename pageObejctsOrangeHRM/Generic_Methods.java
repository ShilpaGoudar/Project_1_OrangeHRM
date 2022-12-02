package pageObejctsOrangeHRM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Generic_Methods {
	
	WebDriver driver;
	
	public Generic_Methods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectDropdown(List<WebElement> element, String value) throws Exception
	{
		for(WebElement ele:element)
		{
			if(ele.getText().equals(value))
			{
				ele.click();
				Thread.sleep(1000);
				break;
			}
		}
	}

}
