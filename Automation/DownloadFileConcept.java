package AdTheorent.Automation;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
	

import com.qa.util.TestBase;

public class DownloadFileConcept extends TestBase{

	File folder;
	
	@BeforeMethod
	public void setup(){
		//UUID format- 88899-99898
		folder = new File(UUID.randomUUID().toString());
		
		folder.mkdir();
		
		System.setProperty("webdriver.chrome.driver", "/Users/soumyak/Documents/selenium/chromedriver");	
		
		ChromeOptions options=new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(); 
		
	}
	
	
	@Test
	public void DownloadFileTest() throws InterruptedException{
		
	driver.get("http://the-internet.herokuapp.com/download");	
	
	driver.findElement(By.linkText("some-file.txt")).click();
	
	//wait for 2 secs to download the file
	
	Thread.sleep(2000);
	
	File listOfFiles[]= folder.listFiles();
	
	//make sure the directory is not empty
	
	//Assert.assertEquals(listOfFiles.length, is(not(0)));
		
/*	Assert.assertTrue(listOfFiles.length>0);
*/	
	for(File file:listOfFiles){
		
		//make sure that the downloaded file is not empty
		//Assert.assertEquals(file.length(), is(not((long)0)));
		
		Assert.assertTrue(file.length()>0);
		
	}
	
	}
	
	
	@AfterMethod
	public void tearDown(){
		//File handling in Java
		driver.quit();
	
		for (File file : folder.listFiles()) {
			
			file.delete();
		}
		
		folder.delete();
			
	}
	
	
}
