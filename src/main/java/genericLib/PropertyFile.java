package genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile 
{
	public String getdata(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis= new FileInputStream(AutoConstant.propertyFilePath);
		p.load(fis);
		return p.getProperty(key);
	}
}


 //Step2:- We cannot hardcode the data either we can read it from external resouces
		  //so we can create a generic method to read the data from external resources
		 // & we extend it to other classes 

 //3.4 have to do change in PropertyFile class method
 //change the return type is String instead of void & add the return statement