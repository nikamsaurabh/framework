package scripting;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.ApplePage;
import pomPages.EbayLoginPage;

public class TestCase1 extends BaseClass
{
	@Test
	public void tc1()
	{
		EbayLoginPage eb= new EbayLoginPage(driver);
		
		driverutilities.mouseHover(driver, eb.getElectronicsbtn());
		
		ApplePage ap= new ApplePage(driver);
		ap.applebutton();
		
	}
}

