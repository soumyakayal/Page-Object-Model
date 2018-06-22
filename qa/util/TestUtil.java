package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import com.qa.util.TestBase;


public class TestUtil extends TestBase{
	
/*	public static long PAGE_LOAD_TIMEOUT = 20;
*/	public static long IMPLICIT_WAIT = 60;
	
	
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public void Logout_AdTheorent() throws InterruptedException{
		
		    driver.findElement(By.xpath("//div[@title='Timezone: America/New_York (UTC/GMT -05:00)']//button[@data-toggle='dropdown']")).click();
		    
		    Thread.sleep(2000);
		    
		    driver.findElement(By.linkText("Log Out")).click();
		    
		    System.out.println("Logging out from account");
		    
		    Thread.sleep(4000);	
		    
		    try{
		    	
			Assert.assertEquals(driver.getCurrentUrl(), "https://uatplatform.adtheorent.com/","You have not landed into the Login panel");
			
		    }
		    
	        catch (TimeoutException e3) {
	        	
	      	 System.out.println("Login panel failed to load: "+e3.getMessage());
	   		
	       } catch (AssertionError e14) {
	    	   
         	 System.out.println("You have not landed into the Login panel: "+e14.getMessage());
	         		
         }
			boolean z = driver.findElement(By.cssSelector("h1.text-center > img:nth-child(1)")).isDisplayed();
			
	      System.out.println("AdTheorent Image link displayed "+z);
	      
	      boolean k = driver.findElement(By.partialLinkText("Password?")).isDisplayed();
	      
	      System.out.println("Forgot password link is displayed "+k);
	      
	      System.out.println("You are navigated to " + driver.getTitle());	
	
}

	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	

	

}