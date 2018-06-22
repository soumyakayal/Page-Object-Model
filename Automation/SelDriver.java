package AdTheorent.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

/*import com.thoughtworks.qdox.tools.QDoxTester.Reporter;
*/
/*import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
*/
public class SelDriver {

	public static WebDriver driver;
	String baseurl;
	public static Properties property;
	
	@BeforeTest
	public void openBrowser() throws IOException{
		
	 Reporter.log("Screenshot capture in TestNG Results started");
		
   	 System.setProperty("webdriver.gecko.driver", "/Users/soumyak/Documents/selenium/geckodriver");
     driver= new FirefoxDriver();
     driver.manage().window().maximize();
     
     property = new Properties();
     FileInputStream objectsFile = new FileInputStream("/Users/soumyak/Documents/selenium/ErrorScreenshot");
     property.load(objectsFile);
	 Reporter.log("Chrome browser is maximized");
     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
     
     
	}
	@AfterMethod
	public void screenCapture(ITestResult results) throws IOException{
		if(ITestResult.FAILURE==results.getStatus()){
	    Reporter.log("Test case is failed due to below reason");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshotName = new File ("/Users/soumyak/Documents/selenium/ErrorScreenshot");
		
	    FileUtils.copyFile(scrFile, screenshotName);			
			
	    Reporter.log("<br><>img src='"+screenshotName+"' height='300' width='300'/><br>");

		}
		else {
		    Reporter.log("Test case is passed");

		}
		
	}
}
