package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplePage 
{
	@FindBy(xpath="//a[text()='Apple']")
	private WebElement applebtn;
	
	public ApplePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void applebutton()
	{
		applebtn.click();
	}
}
