package genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public PropertyFile pdata= new PropertyFile(); //3.2 We created object once to access getdata method
	public WebDriverUtilities driverutilities= new WebDriverUtilities(); //5.1
	
	@BeforeMethod
	public void openapp() throws IOException
	{
		WebDriverManager.chromedriver().setup(); //3.1 We Have Added WebDriverManager is dependency
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pdata.getdata("url"));      //3.3 call the method by using key "url"
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeapp(ITestResult res) throws IOException
	{	
		int status = res.getStatus();
		String name = res.getName();
		
		if(status==2)
		{
			Photo p= new Photo();
			p.getPhoto(driver, name);
		}
		
		driver.quit();
	}
}


	//Step3:- In every scenario opening & closing of the browser is a repetitive steps
	//so we create a generic method to open & close browser and extend to all other classes
	
	//Step3.1:- We have added WebDriverManager in dependency so it will take care of all the-
	//driver executables but we have to to tell specifically for which browser to work
	//mean set me up with chrome driver
	//so we have added this statement WebDriverManager.chromedriver().setup();

	//Step3.2:- We have created object of PropertyFile because evertime we can't create 
	//the object to access the non static method("getdata") of that class

	//3.3 call the method by using key "url"
	//we will get on error but later will resolve it

	//3.4 have to do change in PropertyFile class method
	//change the return type is String instead of void & add the return statement
	//error in 3.3 steps has been resolved here due to this

	//Step 4.4 Itest result is a inbuilt interface, for interface we cant create object so
	// we can access its method through reference variable res.getStatus(), this will
	// give status of the test case

	//Step 4.5 res.getName we get the name of failed test case

	//4.6 we write the if condition & status==2 for fail & inside create object of
	//Photo class to access the getPhoto method

	//5.1 to access the methods of the WebDriver utilities class  we have created the
	//object only once