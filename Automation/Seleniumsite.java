package AdTheorent.Automation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Seleniumsite extends SelDriver {
	
	@Test
	public void seleniumElements() throws InterruptedException, IOException{
		
		driver.get("https://learn-selenium-automation-testing.blogspot.in/");
		
System.out.println("Open selenium site");

Reporter.log("Selenium site is Open");

screenCapture(null);
Reporter.log("Screenshot capture is done");
String Title=driver.getTitle();

Assert.assertEquals(Title, "Learn Selenium Automation Testing");
Reporter.log("Verifying the page with page title");

try{
	Assert.assertEquals(driver.getTitle(), "Learn Selenium Automation Testing");
	Reporter.log("Selenium page title is matching with the expected page title");

	
} catch (Error e){


System.out.println(e.getCause());
Reporter.log("Selenium page title is  not matching with the expected page title");


	}
	Reporter.log("Screenshot capture in TestNG Results ended");

}
}
