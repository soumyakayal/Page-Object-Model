package AdTheorent.Automation;

	import static org.testng.Assert.assertEquals;

	import java.awt.AWTException;
	import java.awt.Dimension;
	import java.awt.Point;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.InputEvent;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import jxl.Cell;
	import jxl.Sheet;
	import jxl.Workbook;
	import jxl.read.biff.BiffException;

import org.apache.commons.io.FileUtils;
/*import org.apache.commons.io.FileUtils;
	*/import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.safari.SafariDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;




	/*//Precondition:  a. Driver & Test data file path needs to be modified as per the need
	                   b. Make necessary changes in the Test Data file (if needed)
	                   c. A Strategy is associated with the Line Item
	            
	                 
	*/




	public class Model_Threshold_Updated_for_RTDM_OFF_on_Line_Item_Level_View extends TestBase{
		
		ExtentReports extent;
		ExtentTest logger;
		TestUtil testutil;

			@BeforeClass
			public void startTest(){
		
	System.out.println("Start the 'Model_Threshold_Updated_for_RTDM_OFF_on_Line_Item_Level_View' automation script in the UAT platform of the AdTheorent");	

	System.out.println("The objective of the Test is to validate whether the Model Threshold is Updated for RTDM OFF on Line Item Level View");	

	System.out.println("=====================================================================================XXX=============================================================================================================================");

	//ExtentReports(String filePath,Boolean replaceExisting) 
	//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
	//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
	//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
	//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/Model_Threshold_Updated_for_RTDM_OFF_on_Line_Item_Level_View.html", true);
	//extent.addSystemInfo("Environment","Environment Name")
	extent
	      .addSystemInfo("Host Name", "AdTheorent")
	      .addSystemInfo("Environment", "Automation Testing")
	      .addSystemInfo("User Name", "Soumya Kayal");
	      //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
	      //You could find the xml file below. Create xml file in your project and copy paste the code mentioned below
/*	extent.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports.xml"));			
*/	

	}

	//Creating a method getScreenshot and passing two parameters 
	//driver and screenshotName
	//This method is to capture the screenshot and return the path of the screenshot.

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	          //below line is just to append the date format with the screenshot name to avoid duplicate names		
	          String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	          //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
	          //Returns the captured file path
		return destination;
	}


			 // Here we are calling the Data Provider object with its Name
		
		 @DataProvider(name = "Authentication")
		  public Object[][] credentials() throws BiffException, IOException {
			  
			/* String home = System.getProperty("user.home");
			 File f = new File(FileNameUtils.normalize(home + "/Desktop/Selenium/TestData.xls"));	*/		 
			 
			  File f = new File("TestData/Model_Threshold_Updated_for_RTDM_OFF_on_Line_Item_Level_View.xls");
			  Workbook w = Workbook.getWorkbook(f);
			  Sheet s = w.getSheet("TestData");
			  int rows = s.getRows();
			  int columns = s.getColumns();
			  //System.out.println(rows);
			  //System.out.println(columns);
		 String inputData[] [] = new String [rows-1][columns];
		 for (int i=1; i<rows; i++){
			 for (int j=0; j<columns; j++){
				 
				 Cell c = s.getCell(j,i);
				 inputData[i-1][j] = c.getContents();
				 //System.out.println("The test data for login operation- "+inputData[i-1][j]);
			 }	 
			 
		 }
		        return inputData;
		 }
	    
		 
		 
			 @Test(dataProvider = "Authentication", enabled=true)
			 public void Model_Threshold_Updated_for_RTDM_OFF_on_Line_Item_Level_View(String sUsername, String sPassword, String litem, String strategy, String maxctr_vtr_1, String minctr_vtr_1) throws Exception  {  
		    	 
				 logger = extent.startTest("Model_Threshold_Updated_for_RTDM_OFF_on_Line_Item_Level_View");			
		 
		 		     TestBase.initialization();
		    	     
		    	     System.out.println("Initiating the login process");
		    	     
		    	     driver.findElement(By.id("txtLoginID")).clear();

				     driver.findElement(By.id("txtLoginID")).sendKeys(sUsername);
			    	 
				     Thread.sleep(1000);

			       
			    	 driver.findElement(By.id("txtPassword")).clear();

				     driver.findElement(By.id("txtPassword")).sendKeys(sPassword);
		    	     
		    	    Thread.sleep(4000);
		    	    

		    	    driver.findElement(By.xpath("//button[contains(text(),'Sign In') and @type='submit']")).click();
		   	  
		    	    System.out.println("The login process has been initiated successfully!!!");
		    	    
		    	    Thread.sleep(10000);
		    	    
		            String gettitle = driver.getTitle();
		            try{     

		    	    Assert.assertTrue(gettitle.contains("Dashboard - AdTheorent"), "Title of the page is not matching");
		    	    
		    	    System.out.println("Title of the page is "+driver.getTitle());
		            System.out.println("Logged in successfully!!!");
		            }
		            catch (TimeoutException e1) {
		            	 System.out.println("AdTheorent Dashboard page failed to load: "+e1.getMessage());
		         		
		            }catch (AssertionError e10) {
		            	 System.out.println("Title of the page is not matching: "+e10.getMessage());
			         		
		            }
		            
		    	    Thread.sleep(9000);
		    	    
	                //Navigating to Search Results page
		      	    
		      	    System.out.println("Searching for a particular Line Item ID in the search text box");
	 	  
		      	    Thread.sleep(2000);

		      	    System.out.println("Clicking on the Advanced Search button");

		      	    
		      	    driver.findElement(By.id("btnsearchTool")).click();
		      	    
		      	    Thread.sleep(3000);

		      	    System.out.println("Searching with the Line Item ID");
		      	    
		      	    Thread.sleep(3000);
   
		      	    driver.findElement(By.xpath("//li[@class='idSearch']//button[text()='Line Item']")).click();
 
		      	    Thread.sleep(3000);

			      	 //Entering the search criteria
		      	    
		      	    driver.findElement(By.id("txtkeywordSearch")).clear();	 

		      	    Thread.sleep(3000);
 
			      	System.out.println("Entering the Line Item ID in the search text box");

		      	    driver.findElement(By.id("txtkeywordSearch")).sendKeys(litem);	 
		      				
		      	    Thread.sleep(4000);
		      	    	  			
		      	    System.out.println("Clicking on the Global Search button");

		      	    driver.findElement(By.id("btnGlobalSearch")).click();
		      	    
		      	    Thread.sleep(5000);
		  
		      	       
		      	  String gettitle300 = driver.getTitle();
	              try{
	      	    Assert.assertTrue(gettitle300.contains("Line Item"), "Title of the page is not matching");

	      	    System.out.println("Title of the page is "+gettitle300);
	      	    
	      	    System.out.println("Successfully navigated to Line Item Properties page");
	              }
	              catch (TimeoutException e300) {

	              System.out.println("Line Item Properties page failed to load: "+e300.getMessage());
	    		
	             } catch (AssertionError e12) {
	            	 System.out.println("Title of the page is not matching: "+e12.getMessage());
		         		
	            }
	              
	      	    Thread.sleep(8000);
		      	    
		      	  
		      	    
		      	
		      	      //Verifying the Line Item name display on top
		      	    
	      	  try{
		    		  boolean b = driver.findElement(By.cssSelector("body > section > div.mainpanel.mainpanel_env > div.pageheader.clearfix > div.pull-left > h2 > span")).isDisplayed();
		    			
		              System.out.println("Desired Line Item name is displayed- "+b);
	      	  }
	      	  
	      	 catch (AssertionError e120) {
	      		 
           	 System.out.println("Desired Line Item name is not being displayed: "+e120.getMessage());
	      	  
		  		
	      	}
	      	  
	      	  Thread.sleep(3000);
		  			
	      	 /* WebTable List Elements */ 
				int wt_rownumber01;
				WebElement list_element01 = driver.findElement(By.xpath(".//*[@id='tblStrategy']/tbody"));
				List<WebElement> tr_collection01 = driver.findElements(By.xpath(".//*[@id='tblStrategy']/tbody/tr"));
			    wt_rownumber01=tr_collection01.size();
			    System.out.println("Total " +wt_rownumber01+ " Strategy present in the Strategy panel");
			    String stgy=strategy;
			 
			    for(int y=1;y< wt_rownumber01+1;y++)
					{
						String element01=driver.findElement(By.xpath(".//*[@id='tblStrategy']/tbody/tr["+y+"]/td[3]")).getText();
					
						if(stgy.equals(element01))
							{
								System.out.println("Do you want to click on "+element01+" Strategy?");
								
								Thread.sleep(3000);	

								String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN); 
								
								driver.findElement(By.xpath("//a[@pacing-log-name-id='-450']")).sendKeys(selectLinkOpeninNewTab);
								
								Thread.sleep(4000);	
								
								break;
							}	
					}
	      	  
			    
			      //Find All the Open Tabs
			    
		      	  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		      	  
		      	  //Switch to the Newly Opened Tab to Transfer Control to the Newly Opened Tab
		      	  
		      	  driver.switchTo().window(tabs.get(1));  
		      	  
			    System.out.println("We are on the newly opened tab");

		      	  
		      	 String gettitle301 = driver.getTitle();
	             try{
	     	    Assert.assertTrue(gettitle301.contains("Strategy"), "Title of the page is not matching");

	     	    System.out.println("Title of the page is "+gettitle301);
	     	    
	     	    System.out.println("Successfully navigated to Strategy Properties page");
	             }
	             catch (TimeoutException e301) {

	             System.out.println("Strategy Properties page failed to load: "+e301.getMessage());
	   		
	            } catch (AssertionError e13) {
	            	 System.out.println("Title of the page is not matching: "+e13.getMessage());
		         		
	            }
	             
	     	    Thread.sleep(6000);
	     	    
	     	               
	     	    //scroll down operation
  		      JavascriptExecutor jse10 = (JavascriptExecutor) driver;
  		      jse10.executeScript("window.scrollBy(0,700)", "");
  		      Thread.sleep(3000);
    	    
		     	    System.out.println("Scrolled down the page successfully");

	    		      Thread.sleep(5000);
	      	
	    		        System.out.println("****************************************************************************************");

	        			System.out.println("Displaying the Model names in the Model drop down field");

		    			/*WebElement y = driver.findElement(By.id("selectQTRTDMModel"));	

		    			Select s = new Select(y);
		    			
		    			List<WebElement> elements= s.getOptions();
		    			
		    			//Code to print the option values available in the drop down
		    			
		    			for(int i=0; i<elements.size(); i++)
		    						
		    			System.out.println(elements.get(i).getText());*/
		    			    			
		    			driver.findElement(By.id("selectQTRTDMModel")).click();
		    			
			     	    Thread.sleep(6000);

		    			driver.findElement(By.id("selectQTRTDMModel")).click();

			     	    Thread.sleep(2000);
		        	    
		    			System.out.println("Selecting the desired option from the Model drop down");

		    			System.out.println("Desired option is being selected from the drop down");
		    			
		    			Thread.sleep(4000);
		    					
		    			Select datpart1 = new Select(driver.findElement(By.id("selectQTRTDMModel")));
		    			
		    			datpart1.selectByValue("-1");	
		    			
		    			System.out.println("Successfully selected the Model name from the drop down field");

		    			Thread.sleep(6000);

	        			System.out.println("****************************************************************************************");  

	    				
	        			System.out.println("Clearing the values in the Min & Max CTR/VTR text boxes");

	    				driver.findElement(By.id("txtQTRTDMMinCtrVtr")).clear();
	    				
	    				Thread.sleep(3000);

	    				driver.findElement(By.id("txtQTRTDMMaxCtrVtr")).clear();
	    				
	        			System.out.println("Clearing of the text boxes is successful");
	        			
	    				Thread.sleep(2000);

	    				System.out.println("Saving the changes");
		   				
						Thread.sleep(2000);

/*						WebElement element139 = driver.findElement(By.cssSelector("#btnSaveStrategy"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element139);
								
						Thread.sleep(3000);
						
						driver.findElement(By.cssSelector("#btnSaveStrategy")).click();*/
	      
						driver.findElement(By.id("btnSaveStrategy")).click();

	    				System.out.println("****************************************************************************************");
		
	    			  	  //scroll down operation
	    	  		      JavascriptExecutor jse101 = (JavascriptExecutor) driver;
	    	  		      jse101.executeScript("window.scrollBy(0,700)", "");
	    	  		      Thread.sleep(3000);
	    	  		      						
					    System.out.println("Capturing the alert message in Min CTR/VTR field");

						  String laterror= driver.findElement(By.xpath("//span[@for='txtQTRTDMMinCtrVtr']")).getText();
						
					    System.out.println("System-generated alert message is :"+ laterror);
					    
						Thread.sleep(2000); 

					    System.out.println("****************************************************************************************");
						
					    System.out.println("Capturing the alert message in Max CTR/VTR field");

						  String longerror= driver.findElement(By.xpath("//span[@for='txtQTRTDMMaxCtrVtr']")).getText();
						
					    System.out.println("System-generated alert message is :"+ longerror);
					    
						Thread.sleep(8000); 

					    System.out.println("****************************************************************************************");
					    
					    
							System.out.println("Entering Min CTR/VTR value");

						    driver.findElement(By.id("txtQTRTDMMinCtrVtr")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), maxctr_vtr_1);

							Thread.sleep(5000); 

							System.out.println("Min CTR/VTR value is successfully entered");
							
							System.out.println("****************************************************************************************");

							System.out.println("Entering Max CTR/VTR value less than Min CTR/VTR value");

						    driver.findElement(By.id("txtQTRTDMMaxCtrVtr")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), minctr_vtr_1);

							Thread.sleep(5000); 

							System.out.println("Max CTR/VTR value is successfully entered");
							
							System.out.println("****************************************************************************************");

							System.out.println("Saving the changes");
			   				
							Thread.sleep(2000);

/*							WebElement element109 = driver.findElement(By.cssSelector("#btnSaveStrategy"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element109);
									
							Thread.sleep(3000);
							
		    				driver.findElement(By.cssSelector("#btnSaveStrategy")).click();*/
		      
							driver.findElement(By.id("btnSaveStrategy")).click();

		    				System.out.println("****************************************************************************************");
	        			
		    				// Switching to Alert        
	  	    	       	    Alert alert3 = driver.switchTo().alert();		
	  	    	       	    		
	  	    	       	    // Capturing alert message.    
	  	    	       	    String alertMessage3= driver.switchTo().alert().getText();		
	  	    	       	    		
	  	    	       	    // Displaying alert message		
	  	    	       	    System.out.println("The system-generated alert message is: "+alertMessage3);	
	  	    	       	    
	  	    	       	    Thread.sleep(5000);
	  	    	       	    		
	  	    	       	 	
                            //Accept alert
                            alert3.accept();
                                               
	  	    	       	    Thread.sleep(5000);
		   				
		    	       	        System.out.println("Successfully accepted system-generated alert message");
    	       	   
		    	       	        System.out.println("****************************************************************************************");		
	        			
		    	       	        System.out.println("Re-entering Min CTR/VTR value");

							    driver.findElement(By.id("txtQTRTDMMinCtrVtr")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), minctr_vtr_1);

								Thread.sleep(5000); 

								System.out.println("Min CTR/VTR value is successfully entered");
								
								System.out.println("****************************************************************************************");

								System.out.println("Re-entering Max CTR/VTR value");

							    driver.findElement(By.id("txtQTRTDMMaxCtrVtr")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), maxctr_vtr_1);

								Thread.sleep(5000); 

								System.out.println("Max CTR/VTR value is successfully entered");
								
								System.out.println("****************************************************************************************");

								System.out.println("Saving the changes");
				   				
								Thread.sleep(2000);

/*								WebElement element119 = driver.findElement(By.cssSelector("#btnSaveStrategy"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element119);
										
								Thread.sleep(3000);
								
			    				driver.findElement(By.cssSelector("#btnSaveStrategy")).click();*/
			      
								driver.findElement(By.id("btnSaveStrategy")).click();

			    				System.out.println("****************************************************************************************");
	        						
								Thread.sleep(3000);

								String msg30= driver.findElement(By.id("dvAlert")).getText();
								
							    System.out.println("System-generated message is :"+ msg30);
							    
							    System.out.println("****************************************************************************************");
								
								Thread.sleep(8000);

			            
			       //Switch to the Previous Tab to Transfer Control to the Previous Tab
			      	
			      	driver.switchTo().window((String)tabs.get(0));
		      	    
					  System.out.println("We have switched to the previous tab");
   	    
		  		      Thread.sleep(8000);

		  		    String gettitle30 = driver.getTitle();
		              try{
		      	    Assert.assertTrue(gettitle30.contains("Line Item"), "Title of the page is not matching");

		      	    System.out.println("Title of the page is "+gettitle30);
		      	    
		      	    System.out.println("Successfully navigated to Line Item Properties page");
		              }
		              catch (TimeoutException e30) {

		              System.out.println("Line Item Properties page failed to load: "+e30.getMessage());
		    		
		             } catch (AssertionError e125) {
		            	 System.out.println("Title of the page is not matching: "+e125.getMessage());
			         		
		            }
		              finally {
		            	  
		            	  driver.navigate().refresh();
		              }
		              
		  		      Thread.sleep(10000);

	    			System.out.println("****************************************************************************************");
					
					String strActualValue2 = driver.findElement(By.id("txtMinimumCtrVtr_-450")).getAttribute("value");
					
					System.out.println("Validating the Minimum CTR/VTR text box field:");
					
					System.out.println("True : TextField is Enable || False : TextField is Disable");
					
					System.out.println("Textfield Status: " +driver.findElement(By.id("txtMinimumCtrVtr_-450")).isEnabled());
					
					System.out.println("Minimum CTR/VTR Textfield value is = "+strActualValue2 +"");
      
	  		        Thread.sleep(2000);

    				System.out.println("****************************************************************************************");
					
					String strActualValue20 = driver.findElement(By.id("txtMaximumCtrVtr_-450")).getAttribute("value");
					
					System.out.println("Validating the Maximum CTR/VTR text box field:");
					
					System.out.println("True : TextField is Enable || False : TextField is Disable");
					
					System.out.println("Textfield Status: " +driver.findElement(By.id("txtMaximumCtrVtr_-450")).isEnabled());
					
					System.out.println("Maximum CTR/VTR Textfield value is = "+strActualValue20 +"");  
		              
					Thread.sleep(7000);

				      //Find All the Open Tabs
				    
			      	  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			      	  
			      	  //Switch to the Newly Opened Tab to Transfer Control to the Newly Opened Tab
			      	  
			      	  driver.switchTo().window(tabs2.get(1));  
			      	  
				    System.out.println("We are on the newly opened tab again");  
				    
				    //scroll down operation
  	  		      JavascriptExecutor jse171 = (JavascriptExecutor) driver;
  	  		      jse171.executeScript("window.scrollBy(0,700)", "");
  	  		      Thread.sleep(7000);
		             
    				System.out.println("****************************************************************************************");
					
				    System.out.println("Selecting the desired option from the Model drop down");

				    driver.findElement(By.id("selectQTRTDMModel")).click();
	    			
		     	    Thread.sleep(3000);

	    			driver.findElement(By.id("selectQTRTDMModel")).click();

		     	    Thread.sleep(2000);
	        	    
	    			System.out.println("Desired option is being selected from the drop down");
	    			
	    			Thread.sleep(4000);
	    					
	    			Select datpart2 = new Select(driver.findElement(By.id("selectQTRTDMModel")));
	    			
	    			datpart2.selectByValue("0");	
	    			
	    			System.out.println("Successfully selected the Model name from the drop down field");

	    			Thread.sleep(3000);

        			System.out.println("****************************************************************************************");  
					
        			System.out.println("Saving the changes");
	   				
					Thread.sleep(2000);

/*					WebElement element169 = driver.findElement(By.cssSelector("#btnSaveStrategy"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element169);
							
					Thread.sleep(3000);
					
    				driver.findElement(By.cssSelector("#btnSaveStrategy")).click();*/
     
					driver.findElement(By.id("btnSaveStrategy")).click();

    				System.out.println("****************************************************************************************");
						
					Thread.sleep(3000);

					String msg31= driver.findElement(By.id("dvAlert")).getText();
					
				    System.out.println("System-generated message is :"+ msg31);
				    
				    System.out.println("****************************************************************************************");
					
					Thread.sleep(8000);
					
				    System.out.println("We are closing the current tab");

	  			    Thread.sleep(2000);

		      	    
			        //Close the Current Tab
			      	  
			      	driver.switchTo().window((String)tabs.get(1)).close();      
					
				       //Switch to the Previous Tab to Transfer Control to the Previous Tab
				      	
				      	driver.switchTo().window((String)tabs.get(0));
			      	    
						  System.out.println("We have switched to the previous tab");
	   	    
			  		      Thread.sleep(8000);

			  		    String gettitle309 = driver.getTitle();
			              try{
			      	    Assert.assertTrue(gettitle309.contains("Line Item"), "Title of the page is not matching");

			      	    System.out.println("Title of the page is "+gettitle309);
			      	    
			      	    System.out.println("Successfully navigated to Line Item Properties page");
			              }
			              catch (TimeoutException e309) {

			              System.out.println("Line Item Properties page failed to load: "+e309.getMessage());
			    		
			             } catch (AssertionError e1025) {
			            	 System.out.println("Title of the page is not matching: "+e1025.getMessage());
				         		
			            }finally {
			            	  
			            	  driver.navigate().refresh();
			            	  
			              }
			              
			  		        Thread.sleep(4000);
     
			                String strActualValue290 = driver.findElement(By.id("txtMinimumCtrVtr_-450")).getAttribute("value");
							
							System.out.println("Validating the Minimum CTR/VTR text box field:");
							
							System.out.println("True : TextField is Enable || False : TextField is Disable");
							
							System.out.println("Textfield Status: " +driver.findElement(By.id("txtMinimumCtrVtr_-450")).isEnabled());
							
							System.out.println("Minimum CTR/VTR Textfield value is = "+strActualValue290 +"");
		      
			  		        Thread.sleep(2000);

		    				System.out.println("****************************************************************************************");
							
							String strActualValue280 = driver.findElement(By.id("txtMaximumCtrVtr_-450")).getAttribute("value");
							
							System.out.println("Validating the Maximum CTR/VTR text box field:");
							
							System.out.println("True : TextField is Enable || False : TextField is Disable");
							
							System.out.println("Textfield Status: " +driver.findElement(By.id("txtMaximumCtrVtr_-450")).isEnabled());
							
							System.out.println("Maximum CTR/VTR Textfield value is = "+strActualValue280 +"");  
							
							
							//Logout operation

							Thread.sleep(15000); 

						    testutil= new TestUtil();
						    
						    testutil.Logout_AdTheorent();
			    				
		    				
		  	         
		                //To generate the log when the test case is passed
		  		      
			              logger.log(LogStatus.PASS, "Test Case Passed is Model_Threshold_Updated_for_RTDM_OFF_on_Line_Item_Level_View");  
			              
		}	              
			              
		/*             @Test
    	public void failTest(){
    		logger = extent.startTest("failTest");
    		Assert.assertTrue(false);
    		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
    	}
    	
    	@Test
    	public void skipTest(){
    		logger = extent.startTest("skipTest");
    		throw new SkipException("Skipping - This is not ready for testing ");
    	} */           
        
@AfterMethod
public void getResult(ITestResult result){
if(result.getStatus() == ITestResult.FAILURE){
logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
}else if(result.getStatus() == ITestResult.SKIP){
logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
}
// ending test
//endTest(logger) : It ends the current test and prepares to create HTML report
extent.endTest(logger);
}








		@AfterClass

		public void endReport(){
			// writing everything to document
			//flush() - to write or update test information to your report. 
	                extent.flush();
	                //Call close() at the very end of your session to clear all resources. 
	                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
	                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
	                //Once this method is called, calling any Extent method will throw an error.
	                //close() - To close all the operation
	                extent.close();	

			        driver.close();

	System.out.println("Test case has been executed successfully!!!");	


	System.out.println("=====================================================================================XXX=============================================================================================================================");	


	}


	}     
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
			  				
	
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
			    	       	   
  	       	    
	            
		    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	             
	           
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		   
	              

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	








		
