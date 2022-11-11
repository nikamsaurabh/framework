package genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photo 
{
	public void getPhoto(WebDriver driver, String name) throws IOException
	{	
		Date d= new Date();                    //4.1  this 2 lines take care  of taking photo
		String current = d.toString().replaceAll(":", "-"); 	   //whenever testcase get fail
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File ram = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(AutoConstant.photoPath+name+current+".png");
		FileUtils.copyFile(ram, dest);
	}
}


	//Step4:- Write a generic method to take photo

	//Step4.1:- Date d= new Date();  
	//d.toString().replaceAll(":", "-");
	//here we create object of Date class, replace all in one generic form

	//Step4.2:- We have to pass parameter "String name" to get to know which testcase
	//got failed, we get name of this testcase

	//Step4.3:-Photopath include the name of the test case, alongwith current date
	//so we have to pass +name+current+".png" its a extension.

	//Step4.4 in BaseClass closeapp method
	//before closing the app we have to give the status
