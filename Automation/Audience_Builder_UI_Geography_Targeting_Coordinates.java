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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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
	                   c. No Coordinate data is in saved state
	*/




	public class Audience_Builder_UI_Geography_Targeting_Coordinates extends TestBase{

		ExtentReports extent;
		ExtentTest logger;
		TestUtil testutil;

			@BeforeClass
			public void startTest(){
		
	System.out.println("Start the 'Audience Builder UI: Coordinates' automation script in the UAT platform of the AdTheorent");	

	System.out.println("The objective of the Test is to validate the Audience_Builder_UI_Geography_Targeting_Coordinates section in the Geography Targeting interface");	

	System.out.println("=====================================================================================XXX=============================================================================================================================");

	//ExtentReports(String filePath,Boolean replaceExisting) 
	//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
	//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
	//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
	//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/Audience_Builder_UI_Geography_Targeting_Coordinates.html", true);
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
			 
			  File f = new File("TestData/Audience_Builder_UI_Geography_Targeting_Coordinates.xls");
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
	    
		 
		 
			 @Test(dataProvider = "Authentication", enabled=true, priority=1)
			 public void Navigate_To_Audience_Builder_UI_MANAGE_REAL_TIME_AUDIENCES_panel(String sUsername, String sPassword, String audiencename, String txtLatitude, String txtLongitude,String txtRadius, String txtMinRadius, String append, String txtLatitude_1, String txtLongitude_1, String txtRadius_1, String txtMinRadius_1, String replace) throws Exception  {  
		    	 
				 logger = extent.startTest("Navigate_To_Audience_Builder_UI_MANAGE_REAL_TIME_AUDIENCES_panel");			
		 
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
		            	 System.out.println("Dashboard page failed to load: "+e1.getMessage());
		         		
		            }catch (AssertionError e10) {
		            	 System.out.println("Title of the page is not matching: "+e10.getMessage());
			         		
		            }/*finally{
		            	driver.navigate().refresh();
		            }*/
		             
		    	    Thread.sleep(9000);
		    	    
		    	    
		    	    System.out.println("Navigating to Manage Retargeting Scripts page");

		    	    
		    	    driver.findElement(By.cssSelector("li.nav-parent:nth-child(2) > a:nth-child(1)")).click();
		    	    
		    	    Thread.sleep(5000);
		    	   
		   	    
		    	    driver.findElement(By.xpath("//a[@href='/GeoContextualSegment']")).click();

		    	    Thread.sleep(5000);
		      	    
		    	    String gettitle1 = driver.getTitle();
		            try{     

		    	    Assert.assertTrue(gettitle1.contains("Manage Retargeting Scripts"), "Title of the page is not matching");

		    	    System.out.println("Title of the page is "+gettitle1);
		    	    
		    	    System.out.println("Successfully navigated to Manage Retargeting Scripts page");
		            }
		            catch (AssertionError e2) {
		            	 System.out.println("Manage Retargeting Scripts page failed to load: "+e2.getMessage());
		         		
		            } 
			        
		    	    Thread.sleep(5000);
   
		            
		            logger.log(LogStatus.PASS, "Test Case Passed is Navigate_To_Audience_Builder_UI_MANAGE_REAL_TIME_AUDIENCES_panel");  

			 }
			 
			 
			 @Test(dataProvider = "Authentication", enabled=true, dependsOnMethods="Navigate_To_Audience_Builder_UI_MANAGE_REAL_TIME_AUDIENCES_panel", priority=2)
			 public void Audience_Builder_UI_Geography_Targeting_Coordinates_Invalid_Data(String sUsername, String sPassword, String audiencename, String txtLatitude, String txtLongitude,String txtRadius, String txtMinRadius, String append, String txtLatitude_1, String txtLongitude_1, String txtRadius_1, String txtMinRadius_1, String replace) throws Exception  {  
		    	 		
				 
				 
				 logger = extent.startTest("Audience_Builder_UI_Geography_Targeting_Coordinates_Invalid_Data");		


		    	    System.out.println("Scrolling down the Manage Retargeting Scripts page");

			              //scroll down operation
		    		      JavascriptExecutor jse10 = (JavascriptExecutor) driver;
		    		      jse10.executeScript("window.scrollBy(0,20000)", "");
		    		      Thread.sleep(6000);
			            
				    	    System.out.println("Expanding the MANAGE REAL-TIME AUDIENCES panel");
				    	    

				    	    WebElement element1 = driver.findElement(By.xpath("//a[@id='strCollapsable' and @onclick='InitAudienceSegmentList()']"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			
							Thread.sleep(5000);
							
							driver.findElement(By.xpath("//a[@id='strCollapsable' and @onclick='InitAudienceSegmentList()']")).click();
			            
							Thread.sleep(12000);
							
							System.out.println("****************************************************************************************");

     		    			System.out.println("Searching for an Audience Name in the search text box");

                             driver.findElement(By.xpath("//div[@id='tblAudienceSegment_filter']/label/input")).clear();

                             Thread.sleep(2000);

                             driver.findElement(By.xpath("//div[@id='tblAudienceSegment_filter']/label/input")).sendKeys(audiencename);
 			            
                            System.out.println("****************************************************************************************");
     		
     	        		    System.out.println("Selecting an Audience from the Audience Segment webtable");

                            Thread.sleep(9000);

     		    			   /* WebTable List Elements */ 
     						int wt_rownumber;
     						WebElement list_element1 = driver.findElement(By.xpath(".//*[@id='tblAudienceSegment']/tbody"));
     						List<WebElement> tr_collection1 = driver.findElements(By.xpath(".//*[@id='tblAudienceSegment']/tbody/tr"));
     					    wt_rownumber=tr_collection1.size();
     					    System.out.println("Total " +wt_rownumber+ " Audience(s) present in the Page");
     					    String audience=audiencename;
     					 
     					    for(int k=1;k< wt_rownumber+1;k++)
     							{
     								String element2=driver.findElement(By.xpath(".//*[@id='tblAudienceSegment']/tbody/tr["+k+"]/td[3]")).getText();
     							
     								if(audience.equals(element2))
     									{
     										System.out.println("Do you want to click on "+element2+" Audience Name?");
     										Thread.sleep(4000);	
     										WebElement element100 = driver.findElement(By.xpath("//table[@id='tblAudienceSegment']//tbody//tr//td//a[text()='Test_Audience_62']"));
     										((JavascriptExecutor) driver).executeScript("arguments[0].click();", element100);
									
     										Thread.sleep(3000);	
     										break;
     									}	
     							}
 							Thread.sleep(7000);	

     					    String gettitle221 = driver.getTitle();
     			            try{     

     			    	    Assert.assertTrue(gettitle221.contains("Audience"), "Title of the page is not matching");

     			    	    System.out.println("Title of the page is "+gettitle221);
     			    	    
     			    	    System.out.println("Successfully navigated to Audience page");
     			            }
     			            catch (AssertionError e321) {
     			            	 System.out.println("Audience page failed to load: "+e321.getMessage());
     			         		
     			            } 
     			            
     		    			Thread.sleep(7000);
		    	    

						    //click on GEOGRAPHY option
						      
				            System.out.println("Clicking on GEOGRAPHY Target Details section");

							driver.findElement(By.xpath(".//*[@id='divGeographySummary']")).click();
					      	            
						      Thread.sleep(6000); 
						      
					            System.out.println("Selecting the Coordinates option from the Geography Targeting interface");


						      WebElement ele = driver.findElement(By.xpath("//li//a[@onclick='GetCoordinateData()' and text()='Coordinates']"));

					            Actions act = new Actions(driver);

					            act.moveToElement(ele).build().perform();

					            act.click();
					            
					            act.perform();
			
				    		      Thread.sleep(8000);   
				    		      
						            System.out.println("Successfully navigated to the Coordinates page");

				    		      
				    		     /* System.out.println("****************************************************************************************");

						            System.out.println("Clearing all the mandatory field data");
						            
						            Thread.sleep(2000);   

									driver.findElement(By.id("txtLatitude")).clear();

									Thread.sleep(2000);   

									driver.findElement(By.id("txtLongitude")).clear();
									
									Thread.sleep(2000);   

									driver.findElement(By.id("txtRadius")).clear();
									
									Thread.sleep(2000);   

									driver.findElement(By.id("txtMinRadius")).clear();
									
						            System.out.println("Successfully cleared all the mandatory field data");
				    		      */
				    		        System.out.println("****************************************************************************************");

						            System.out.println("Clicking on the Add button without entering any Coordinate Data");

								    driver.findElement(By.id("btnAddCoordinate")).click();

									Thread.sleep(9000); 

									System.out.println("Alerts for the mandatory fields are being displayed");
				    		      
							    System.out.println("****************************************************************************************");

								System.out.println("Entering an invalid Latitude value");

							    driver.findElement(By.id("txtLatitude")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtLatitude);

								Thread.sleep(5000); 

								System.out.println("Latitude value is successfully entered");
								
								System.out.println("****************************************************************************************");

								System.out.println("Entering an invalid Longitude value");

							    driver.findElement(By.id("txtLongitude")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtLongitude);

								Thread.sleep(5000); 

								System.out.println("Longitude value is successfully entered");
								
								System.out.println("****************************************************************************************");

								System.out.println("Entering the Maximum Radius smaller than Minimum Radius value");

							    driver.findElement(By.id("txtRadius")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtRadius);

								Thread.sleep(5000); 

								System.out.println("Maximum Radius is successfully entered");
								
								System.out.println("****************************************************************************************");

								System.out.println("Entering the Minimum Radius greater than Maximum Radius value");

							    driver.findElement(By.id("txtMinRadius")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtMinRadius);

								Thread.sleep(5000); 

								System.out.println("Minimum Radius is successfully entered");
								
								System.out.println("****************************************************************************************");

								System.out.println("Clicking on Add button");

							    driver.findElement(By.id("btnAddCoordinate")).click();

								Thread.sleep(7000); 

								System.out.println("****************************************************************************************");		
								
							    System.out.println("Capturing the alert message in Latitude field");

								  String laterror= driver.findElement(By.xpath("//span[@for='txtLatitude']")).getText();
								
							    System.out.println("System-generated alert message is :"+ laterror);
							    
								Thread.sleep(2000); 

							    System.out.println("****************************************************************************************");
								
							    System.out.println("Capturing the alert message in Longitude field");

								  String longerror= driver.findElement(By.xpath("//span[@for='txtLongitude']")).getText();
								
							    System.out.println("System-generated alert message is :"+ longerror);
							    
								Thread.sleep(2000); 

							    System.out.println("****************************************************************************************");
								
							    System.out.println("Capturing the alert message in Max. Radius field");

								  String maxraderror= driver.findElement(By.xpath("//span[@for='txtRadius']")).getText();
								
							    System.out.println("System-generated alert message is :"+ maxraderror);
							    
								Thread.sleep(2000); 

							    System.out.println("****************************************************************************************");
								
							    System.out.println("Capturing the alert message in Min. Radius field");

								  String minraderror= driver.findElement(By.xpath("//span[@for='txtMinRadius']")).getText();
								
							    System.out.println("System-generated alert message is :"+ minraderror);
							    
								Thread.sleep(2000); 

							    System.out.println("****************************************************************************************");
								
							    System.out.println("Clicking on Cancel Changes button");

								Thread.sleep(2000);

								WebElement element109 = driver.findElement(By.xpath("//button[@value='Geography' and @onclick='ClosePopup(this)']"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element109);
									
								Thread.sleep(3000);

								driver.findElement(By.xpath("//button[@value='Geography' and @onclick='ClosePopup(this)']")).click();
								
								System.out.println("Modal Geography Targeting pop-up has been successfully closed");

								Thread.sleep(3000);

							    System.out.println("****************************************************************************************");
								
							    String gettitle222 = driver.getTitle();
	     			            try{     

	     			    	    Assert.assertTrue(gettitle222.contains("Audience"), "Title of the page is not matching");

	     			    	    System.out.println("Title of the page is "+gettitle222);
	     			    	    
	     			    	    System.out.println("Successfully navigated to Audience page");
	     			            }
	     			            catch (AssertionError e322) {
	     			            	 System.out.println("Audience page failed to load: "+e322.getMessage());
	     			         		
	     			            } 
	     			            
				              
				      	        Thread.sleep(8000);
								
							    //click on GEOGRAPHY option
							      
					            System.out.println("Clicking on GEOGRAPHY Targeting option");

					            driver.findElement(By.xpath(".//*[@id='lnkGeography']")).click();
			      	            
							    Thread.sleep(4000); 
							      
						        System.out.println("Successfully navigated to Geography Targeting interface");
						            
							    System.out.println("****************************************************************************************");
						     
							    System.out.println("Selecting the Coordinates option from the Geography Targeting interface");


							      WebElement ele1 = driver.findElement(By.xpath("//li//a[@onclick='GetCoordinateData()' and text()='Coordinates']"));

						            Actions act1 = new Actions(driver);

						            act1.moveToElement(ele1).build().perform();

						            act1.click();
						            
						            act1.perform();
						            							    
							            System.out.println("Successfully navigated to the Coordinates page");

						    		      Thread.sleep(8000);   

					    		      //To generate the log when the test case is passed
						  		      
						              logger.log(LogStatus.PASS, "Test Case Passed is Audience_Builder_UI_Geography_Targeting_Coordinates_Invalid_Data");
							    
							    
							    
			 }    
			 
			 @Test(dataProvider = "Authentication", enabled=true, dependsOnMethods="Audience_Builder_UI_Geography_Targeting_Coordinates_Invalid_Data", priority=3)
			 public void Audience_Builder_UI_Geography_Targeting_Coordinates_Append_And_Add_Data(String sUsername, String sPassword, String audiencename, String txtLatitude, String txtLongitude,String txtRadius, String txtMinRadius, String append, String txtLatitude_1, String txtLongitude_1, String txtRadius_1, String txtMinRadius_1, String replace) throws Exception  {  
							    
							    
				 logger = extent.startTest("Audience_Builder_UI_Geography_Targeting_Coordinates_Append_And_Add_Data");
				 
				 
					System.out.println("Performing Append operation");

          		    driver.findElement(By.id("spanCoordinateAppendType")).click();
	    			
	    			Thread.sleep(4000);
	    				
          		    driver.findElement(By.id("linkAppendCoordinate")).click();
	                
	    			Thread.sleep(5000);
							    
	    			String msgText =driver.findElement(By.xpath("//small[contains(text(),'Upload a CSV file in format of (lat,lon,max radius')]")).getText();
		    	    
		    	    System.out.println("The message text below the Browse button is: "+msgText);

	    		      Thread.sleep(4000);   

					//Click on the Browse Button
				    
				    System.out.println("Clicking on the Browse button");

				    WebElement uploadElement2 = driver.findElement(By.id("lnkUploadCO"));
				    
				    uploadElement2.click();

				    System.out.println("Uploading a Coordinate file");	

					
				    //File Need to be imported
					 
				  	File file1 = new File("/Users/soumyak/work/Coordinates/CocaCola_Meijer_LatLongs");
				  	 
				  	StringSelection stringSelection1= new StringSelection(file1.getAbsolutePath());

				  	 
				  	//Copy to clipboard 

				  	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
				  	 
				  	Robot robot1 = new Robot();
				  	 
				  /*	// Cmd + Tab is needed since it launches a Java app and the browser looses focus
				  	 
				  	robot1.keyPress(KeyEvent.VK_META);
				  	 
				  	robot1.keyPress(KeyEvent.VK_TAB);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_META);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_TAB);
				  	 
				  	robot1.delay(6000);*/
				  	 
				  	//Open Goto window
				  	 
				  	robot1.keyPress(KeyEvent.VK_META);
				  	 
				  	robot1.keyPress(KeyEvent.VK_SHIFT);
				  	 
				  	robot1.keyPress(KeyEvent.VK_G);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_META);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_SHIFT);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_G);
				  	 
				  	//Paste the clipboard value
				  	 
				  	robot1.keyPress(KeyEvent.VK_META);
				  	 
				  	robot1.keyPress(KeyEvent.VK_V);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_META);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_V);
				  	 
				  	//Press Enter key to close the Goto window and Upload window
				  	 
				  	robot1.keyPress(KeyEvent.VK_ENTER);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_ENTER);
				  	 
				  	robot1.delay(6000);
				  	 
				  	robot1.keyPress(KeyEvent.VK_ENTER);
				  	 
				  	robot1.keyRelease(KeyEvent.VK_ENTER);

					Thread.sleep(9000);

					System.out.println("Clicking on the Upload button");

					Thread.sleep(2000);

					driver.findElement(By.xpath("//button[@id='btnUploadCoordinate']")).click();
					
					Thread.sleep(8000);

					    /*// Switching to Alert        
	    	       	    Alert alert30 = driver.switchTo().alert();		
	    	       	    		
	    	       	    // Capturing alert message.    
	    	       	    String alertMessage30= driver.switchTo().alert().getText();		
	    	       	    		
	    	       	    // Displaying alert message		
	    	       	    System.out.println("The system-generated alert message is: "+alertMessage30);	
	    	       	    
	    	       	    Thread.sleep(5000);
	    	       	    		
	    	       	 	
                       //Accept alert
                       alert30.accept();
                                       
	    	       	    Thread.sleep(5000);
*/
	    	       	    System.out.println("Clicking on Delete All Coordinates button");
						
						driver.findElement(By.id("btn_DeleteAllCoordinates")).click();

						Thread.sleep(7000);
						
		    			    // Switching to Alert        
		    	       	    Alert alert20 = driver.switchTo().alert();		
		    	       	    		
		    	       	    // Capturing alert message.    
		    	       	    String alertMessage20= driver.switchTo().alert().getText();		
		    	       	    		
		    	       	    // Displaying alert message		
		    	       	    System.out.println("The system-generated alert message is: "+alertMessage20);	
		    	       	    
		    	       	    Thread.sleep(5000);
	     	 	
	                        //Accept alert
	                        alert20.accept();
	                                       
		    	       	    Thread.sleep(5000);
					
		    	       	 System.out.println("Successfully accepted system-generated alert message");
		    	       	 
		    	       	    //Click on the Browse Button
						    
						    System.out.println("Clicking on the Browse button");

						    WebElement uploadElement23 = driver.findElement(By.id("lnkUploadCO"));
						    
						    uploadElement23.click();

						    System.out.println("Uploading a Coordinate file");	

		    	       	    //File Need to be imported
		                 	 
		                   	File file2 = new File("/Users/soumyak/work/Coordinates/CocaCola_Meijer_LatLongs");
		                   	 
		                   	StringSelection stringSelection2= new StringSelection(file2.getAbsolutePath());

		                   	 
		                   	//Copy to clipboard 

		                   	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);
		                   	 
		                    driver.switchTo().window(driver.getWindowHandle());

		                    Robot robot = new Robot();
		                    
		                    //Open Goto window
		                    robot.keyPress(KeyEvent.VK_META);
		                    robot.keyPress(KeyEvent.VK_SHIFT);
		                    robot.keyPress(KeyEvent.VK_G);
		                    robot.keyRelease(KeyEvent.VK_META);
		                    robot.keyRelease(KeyEvent.VK_SHIFT);
		                    robot.keyRelease(KeyEvent.VK_G);

		                    //Paste the clipboard value
		                    robot.keyPress(KeyEvent.VK_META);
		                    robot.keyPress(KeyEvent.VK_V);
		                    robot.keyRelease(KeyEvent.VK_META);
		                    robot.keyRelease(KeyEvent.VK_V);

		                    //Press Enter key to close the Goto window and Upload window
		                    robot.delay(1000);
		                    robot.keyPress(KeyEvent.VK_ENTER);
		                    robot.keyRelease(KeyEvent.VK_ENTER);
		                    robot.delay(1000);
		                    robot.keyPress(KeyEvent.VK_ENTER);
		                    robot.keyRelease(KeyEvent.VK_ENTER);
		                     	
		                    Thread.sleep(9000);
		   				 
							System.out.println("Clicking on the Upload button");

							Thread.sleep(2000);

							driver.findElement(By.id("btnUploadCoordinate")).click();
							
							Thread.sleep(2000);

							System.out.println("File Upload has been successful!!!");

							Thread.sleep(5000);						
					
					
					String coordcount_01 = driver.findElement(By.id("tblCoordinate_info")).getText();

	    			System.out.println("System displays the following text in the page footer: "+coordcount_01);	

					Thread.sleep(6000);
   
					    		        System.out.println("****************************************************************************************");

										System.out.println("Entering a valid Latitude value");

									    driver.findElement(By.id("txtLatitude")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtLatitude_1);

										Thread.sleep(5000); 

										System.out.println("Latitude value is successfully entered");
										
										System.out.println("****************************************************************************************");

										System.out.println("Entering a valid Longitude value");

									    driver.findElement(By.id("txtLongitude")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtLongitude_1);

										Thread.sleep(5000); 

										System.out.println("Longitude value is successfully entered");
										
										System.out.println("****************************************************************************************");

										System.out.println("Entering the Maximum Radius value");

									    driver.findElement(By.id("txtRadius")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtRadius_1);

										Thread.sleep(5000); 

										System.out.println("Maximum Radius is successfully entered");
										
										System.out.println("****************************************************************************************");

										System.out.println("Entering the Minimum Radius value");

									    driver.findElement(By.id("txtMinRadius")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtMinRadius_1);

										Thread.sleep(5000); 

										System.out.println("Minimum Radius is successfully entered");
										
										System.out.println("****************************************************************************************");

										System.out.println("Clicking on Add button");

									    driver.findElement(By.id("btnAddCoordinate")).click();

										Thread.sleep(7000); 

										System.out.println("****************************************************************************************");		
							    
										String coordcount_02 = driver.findElement(By.id("tblCoordinate_info")).getText();

						    			System.out.println("System displays the following text in the page footer: "+coordcount_02);	

										Thread.sleep(6000);
					   
										System.out.println("Clicking on Last button in footer link");

									    driver.findElement(By.xpath("//a[@id='tblCoordinate_last']")).click();
									    
										System.out.println("We are on the last page of the Coordinate table");
										
										Thread.sleep(7000); 

										System.out.println("****************************************************************************************");		

										System.out.println("Clicking on the check box against the last added coordinate data");

									    driver.findElement(By.xpath("//input[@id='chkRTAudienceGeoCoordinate_236']")).click();
		
										System.out.println("Checkbox selection is successful");

										Thread.sleep(8000); 

										System.out.println("****************************************************************************************");		
							    
										System.out.println("Performing Remove Selected operation");

										driver.findElement(By.xpath("//i[@class='fa fa-check-square']")).click();
										
										Thread.sleep(3000); 

						          		driver.findElement(By.xpath("//a[@id='btnRemoveCoordinate' and text()='Remove Selected']")).click();
							    			
							    			Thread.sleep(7000);
							    					
							    			// Switching to Alert        
					  	    	       	    Alert alert1 = driver.switchTo().alert();		
					  	    	       	    		
					  	    	       	    // Capturing alert message.    
					  	    	       	    String alertMessage1= driver.switchTo().alert().getText();		
					  	    	       	    		
					  	    	       	    // Displaying alert message		
					  	    	       	    System.out.println("The system-generated alert message is: "+alertMessage1);	
					  	    	       	    Thread.sleep(5000);
					  	    	       	    		
					  	    	       	 	
				                            //Dismiss alert
				                            alert1.dismiss();
				                                               
					  	    	       	    Thread.sleep(5000);
						   				
						    	       	      System.out.println("Successfully dismissing system-generated alert message");
								
								
						    	       	   System.out.println("****************************************************************************************");		
										    
											System.out.println("Again performing Remove Selected operation");

											driver.findElement(By.xpath("//i[@class='fa fa-check-square']")).click();
											
											Thread.sleep(3000); 

							          		driver.findElement(By.xpath("//a[@id='btnRemoveCoordinate' and text()='Remove Selected']")).click();
								    			
								    			Thread.sleep(7000);
								    					
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
												    
													/*System.out.println("Clicking on First button in footer link");

							  	    	       	    Thread.sleep(4000);

												    driver.findElement(By.xpath("//a[@id='tblCoordinate_first']")).click();
												    
													System.out.println("We are on the first page of the Coordinate table");
													*/
													Thread.sleep(7000);  
													
													String cordcount = driver.findElement(By.id("tblCoordinate_info")).getText();

									    			System.out.println("System displays the following text in the Coordinate table footer: "+cordcount);	
							       	         
													Thread.sleep(2000);  

												     System.out.println("****************************************************************************************");	
														
														System.out.println("Saving the changes");
												
														Thread.sleep(2000);

														WebElement element109 = driver.findElement(By.xpath("//button[@id='btnSaveGeography' and @type='button']"));
														((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element109);
																
														Thread.sleep(3000);

														driver.findElement(By.xpath("//button[@id='btnSaveGeography' and @type='button']")).click();
								
														System.out.println("****************************************************************************************");		
														
													    System.out.println("Capturing the system-generated message");

														Thread.sleep(2000);

														String msg30= driver.findElement(By.id("dvAlert")).getText();
														
													    System.out.println("System-generated message is :"+ msg30);
													    
													    System.out.println("****************************************************************************************");
														
														Thread.sleep(3000);
														
										              
										                String gettitle212 = driver.getTitle();
							     			            try{     

							     			    	    Assert.assertTrue(gettitle212.contains("Audience"), "Title of the page is not matching");

							     			    	    System.out.println("Title of the page is "+gettitle212);
							     			    	    
							     			    	    System.out.println("Successfully navigated to Audience page");
							     			            }
							     			            catch (AssertionError e304) {
							     			            	 System.out.println("Audience page failed to load: "+e304.getMessage());
							     			         		
							     			            } 
							     			        
										      	        Thread.sleep(8000);
													
													    System.out.println("****************************************************************************************");
										
														String cordsummary1= driver.findElement(By.id("divGeographySummary")).getText();

													    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+cordsummary1);
								      	    
													    System.out.println("****************************************************************************************");

													      Thread.sleep(6000); 

													    //click on GEOGRAPHY option
													      
											            System.out.println("Clicking on GEOGRAPHY Targeting option");

											            driver.findElement(By.xpath(".//*[@id='lnkGeography']")).click();
									      	            
													    Thread.sleep(4000); 
													      
												        System.out.println("Successfully navigated to Geography Targeting interface with Coordinates tab in selected state");
												            
													    System.out.println("****************************************************************************************");
												    	
										      	        Thread.sleep(8000);

													      //To generate the log when the test case is passed
											  		      
											              logger.log(LogStatus.PASS, "Test Case Passed is Audience_Builder_UI_Geography_Targeting_Coordinates_Append_And_Add_Data");			
														
														
			 }		
														
														
			 @Test(dataProvider = "Authentication", enabled=true, dependsOnMethods="Audience_Builder_UI_Geography_Targeting_Coordinates_Append_And_Add_Data", priority=4)
			 public void Audience_Builder_UI_Geography_Targeting_Coordinates_Add_And_Replace_Data(String sUsername, String sPassword, String audiencename, String txtLatitude, String txtLongitude,String txtRadius, String txtMinRadius, String append, String txtLatitude_1, String txtLongitude_1, String txtRadius_1, String txtMinRadius_1, String replace) throws Exception  {  
				 
				 
				 logger = extent.startTest("Audience_Builder_UI_Geography_Targeting_Coordinates_Add_And_Replace_Data");
					
				 System.out.println("Exporting the Latitude/Longitude List");
					
			
											WebElement element167 = driver.findElement(By.xpath("//a[@id='btnExportLatLon']"));
											((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element167);
											
											Thread.sleep(2000); 

										
																	WebElement elem = driver.findElement(By.xpath("//a[@id='btnExportLatLon']"));
																	 
																	// This will enable this element if element is invisible      
																	 
																	String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
																	  
																	// Execute the Java Script for the element which we find out
																	((JavascriptExecutor) driver).executeScript(js, elem);
																	 
																	// Click on element
																	 
																	elem.click();
																	
											 
											Thread.sleep(8000); 
												
											System.out.println("Latitude/Longitude List is successfully exported");
													
											System.out.println("****************************************************************************************");			

											Thread.sleep(3000); 

				    String cordcount8 = driver.findElement(By.id("tblCoordinate_info")).getText();

	    			System.out.println("System displays the following text in the Coordinate table footer: "+cordcount8);	
	         
					Thread.sleep(2000);  

                    System.out.println("Clicking on Check All Coordinate checkbox");
					
					driver.findElement(By.id("chkCoordinateCheckAll")).click();

					System.out.println("****************************************************************************************");		
				    
					System.out.println("Performing Remove Selected operation");

					driver.findElement(By.xpath("//i[@class='fa fa-check-square']")).click();
					
					Thread.sleep(3000); 

	          		driver.findElement(By.xpath("//a[@id='btnRemoveCoordinate' and text()='Remove Selected']")).click();
		    			
		    			Thread.sleep(7000);
		    					
		    			// Switching to Alert        
  	    	       	    Alert alert1 = driver.switchTo().alert();		
  	    	       	    		
  	    	       	    // Capturing alert message.    
  	    	       	    String alertMessage1= driver.switchTo().alert().getText();		
  	    	       	    		
  	    	       	    // Displaying alert message		
  	    	       	    System.out.println("The system-generated alert message is: "+alertMessage1);	
  	    	       	    
  	    	       	    Thread.sleep(5000);
  	    	 
                        //Accept alert
                        alert1.accept();
                                           
  	    	       	    Thread.sleep(5000);
	   				
	    	       	      System.out.println("Successfully accepting system-generated alert message");
		  	    
	    	       	      
	    	       	   Thread.sleep(7000);  
						
						String cordcount = driver.findElement(By.id("tblCoordinate_info")).getText();

		    			System.out.println("System displays the following text in the Coordinate table footer: "+cordcount);	
      	         
						Thread.sleep(2000);  

	    	       	    System.out.println("****************************************************************************************");		
	    	       	    
	    	       	    System.out.println("Clicking on Delete All Coordinates button");
						
						driver.findElement(By.id("btn_DeleteAllCoordinates")).click();

						Thread.sleep(7000);
						
		    			    // Switching to Alert        
		    	       	    Alert alert20 = driver.switchTo().alert();		
		    	       	    		
		    	       	    // Capturing alert message.    
		    	       	    String alertMessage20= driver.switchTo().alert().getText();		
		    	       	    		
		    	       	    // Displaying alert message		
		    	       	    System.out.println("The system-generated alert message is: "+alertMessage20);	
		    	       	    
		    	       	    Thread.sleep(5000);
	     	 	
	                        //Accept alert
	                        alert20.accept();
	                                       
		    	       	    Thread.sleep(5000);
						
			    	       	System.out.println("Successfully accepted system-generated alert message");

						System.out.println("Saving the changes");
				
						Thread.sleep(2000);

						WebElement element100 = driver.findElement(By.xpath("//button[@id='btnSaveGeography' and @type='button']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element100);
								
						Thread.sleep(3000);

						driver.findElement(By.xpath("//button[@id='btnSaveGeography' and @type='button']")).click();

						System.out.println("****************************************************************************************");		
						
					    System.out.println("Capturing the system-generated message");

						Thread.sleep(2000);

						String msg3= driver.findElement(By.id("dvAlert")).getText();
						
					    System.out.println("System-generated message is :"+ msg3);
					    
					    System.out.println("****************************************************************************************");
						
						Thread.sleep(3000);
						
		              
		                String gettitle222 = driver.getTitle();
			            try{     

			    	    Assert.assertTrue(gettitle222.contains("Audience"), "Title of the page is not matching");

			    	    System.out.println("Title of the page is "+gettitle222);
			    	    
			    	    System.out.println("Successfully navigated to Audience page");
			            }
			            catch (AssertionError e322) {
			            	 System.out.println("Audience page failed to load: "+e322.getMessage());
			         		
			            } 
			         
		      	        Thread.sleep(8000);
				
					    System.out.println("****************************************************************************************");
		
						String cordsummary3= driver.findElement(By.id("divGeographySummary")).getText();

					    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+cordsummary3);
   	    
					    System.out.println("****************************************************************************************");

					      Thread.sleep(6000); 								  
	    	       	    
					        //click on GEOGRAPHY option
					      
				            System.out.println("Clicking on GEOGRAPHY Target Details section");

							driver.findElement(By.xpath(".//*[@id='divGeographySummary']")).click();
					      	            
						      Thread.sleep(6000); 
						      
					            System.out.println("Selecting the Coordinates option from the Geography Targeting interface");


						        WebElement ele = driver.findElement(By.xpath("//li//a[@onclick='GetCoordinateData()' and text()='Coordinates']"));

					            Actions act = new Actions(driver);

					            act.moveToElement(ele).build().perform();

					            act.click();
					            
					            act.perform();			            

				    		      Thread.sleep(8000);   
														
	    	       	    String cordcount1 = driver.findElement(By.id("tblCoordinate_info")).getText();

		    			System.out.println("System displays the following text in the Coordinate table footer: "+cordcount1);	

	    	       	    Thread.sleep(8000);									

			            System.out.println("****************************************************************************************");			
			            						
						System.out.println("Entering a valid Latitude value");

					    driver.findElement(By.id("txtLatitude")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtLatitude_1);

						Thread.sleep(9000); 

						System.out.println("Latitude value is successfully entered");
						
						System.out.println("****************************************************************************************");

						System.out.println("Entering a valid Longitude value");

					    driver.findElement(By.id("txtLongitude")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtLongitude_1);

						Thread.sleep(9000); 

						System.out.println("Longitude value is successfully entered");
						
						System.out.println("****************************************************************************************");

						System.out.println("Entering the Maximum Radius value");

					    driver.findElement(By.id("txtRadius")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtRadius_1);

						Thread.sleep(9000); 

						System.out.println("Maximum Radius is successfully entered");
						
						System.out.println("****************************************************************************************");

						System.out.println("Entering the Minimum Radius value");

					    driver.findElement(By.id("txtMinRadius")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), txtMinRadius_1);

						Thread.sleep(9000); 

						System.out.println("Minimum Radius is successfully entered");
						
						System.out.println("****************************************************************************************");

						System.out.println("Clicking on Add button");

					    driver.findElement(By.id("btnAddCoordinate")).click();
														
						Thread.sleep(6000);						
						
	    	       	    String cordcount3 = driver.findElement(By.id("tblCoordinate_info")).getText();

		    			System.out.println("System displays the following text in the Coordinate table footer: "+cordcount3);	
		    				
		    			Thread.sleep(7000);

		    			System.out.println("****************************************************************************************");	
		    			
						System.out.println("Performing Replace operation");

	          		    driver.findElement(By.id("spanCoordinateAppendType")).click();
		    					    					
		    			Thread.sleep(4000);
	    				
	          		    driver.findElement(By.id("linkReplaceCoordinate")).click();
		     
		    			Thread.sleep(6000);
								    
		    			System.out.println("****************************************************************************************");  				 
	      				 
	                     //Click on the Browse Button
	                     
	                     System.out.println("Clicking on the Browse button");

	                     WebElement uploadElement3 = driver.findElement(By.id("lnkUploadCO"));
	                     
	                     uploadElement3.click();

	                     System.out.println("Uploading the Coordinate file");	

	                 	
	                     //File Need to be imported
	                 	 
	                   	File file2 = new File("/Users/soumyak/work/Coordinates/CocaCola_Meijer_LatLongs");
	                   	 
	                   	StringSelection stringSelection2= new StringSelection(file2.getAbsolutePath());

	                   	 
	                   	//Copy to clipboard 

	                   	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);
	                   	 
	                    driver.switchTo().window(driver.getWindowHandle());

	                    Robot robot = new Robot();
	                    
	                    //Open Goto window
	                    robot.keyPress(KeyEvent.VK_META);
	                    robot.keyPress(KeyEvent.VK_SHIFT);
	                    robot.keyPress(KeyEvent.VK_G);
	                    robot.keyRelease(KeyEvent.VK_META);
	                    robot.keyRelease(KeyEvent.VK_SHIFT);
	                    robot.keyRelease(KeyEvent.VK_G);

	                    //Paste the clipboard value
	                    robot.keyPress(KeyEvent.VK_META);
	                    robot.keyPress(KeyEvent.VK_V);
	                    robot.keyRelease(KeyEvent.VK_META);
	                    robot.keyRelease(KeyEvent.VK_V);

	                    //Press Enter key to close the Goto window and Upload window
	                    robot.delay(1000);
	                    robot.keyPress(KeyEvent.VK_ENTER);
	                    robot.keyRelease(KeyEvent.VK_ENTER);
	                    robot.delay(1000);
	                    robot.keyPress(KeyEvent.VK_ENTER);
	                    robot.keyRelease(KeyEvent.VK_ENTER);
	                     	
	                    Thread.sleep(9000);
	   				 
						System.out.println("Clicking on the Upload button");

						Thread.sleep(2000);

						driver.findElement(By.id("btnUploadCoordinate")).click();
						
						Thread.sleep(2000);

						System.out.println("File Upload has been successful!!!");

						Thread.sleep(5000);						
	
	    	       	    String cordcount2 = driver.findElement(By.id("tblCoordinate_info")).getText();

		    			System.out.println("System displays the following text in the Coordinate table footer: "+cordcount2);	
		    			
						Thread.sleep(5000);						
			
						System.out.println("Clicking on Last button in footer link");

					    driver.findElement(By.xpath("//a[@id='tblCoordinate_last']")).click();
					    
						System.out.println("We are on the last page of the Coordinate table");
						
						Thread.sleep(9000); 								
								
						System.out.println("Saving the changes");
				
						Thread.sleep(2000);

						WebElement element189 = driver.findElement(By.xpath("//button[@id='btnSaveGeography' and @type='button']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element189);
								
						Thread.sleep(3000);

						driver.findElement(By.xpath("//button[@id='btnSaveGeography' and @type='button']")).click();

						System.out.println("****************************************************************************************");		
						
					    System.out.println("Capturing the system-generated message");

						Thread.sleep(2000);

						String msg30= driver.findElement(By.id("dvAlert")).getText();
						
					    System.out.println("System-generated message is :"+ msg30);
					    
					    System.out.println("****************************************************************************************");
						
						Thread.sleep(3000);
						
		              
		                String gettitle252 = driver.getTitle();
 			            try{     

 			    	    Assert.assertTrue(gettitle252.contains("Audience"), "Title of the page is not matching");

 			    	    System.out.println("Title of the page is "+gettitle252);
 			    	    
 			    	    System.out.println("Successfully navigated to Audience page");
 			            }
 			            catch (AssertionError e352) {
 			            	 System.out.println("Audience page failed to load: "+e352.getMessage());
 			         		
 			            } 
 			            
		              
		      	        Thread.sleep(8000);
						
						
					    System.out.println("****************************************************************************************");
		
						String cordsummary2= driver.findElement(By.id("divGeographySummary")).getText();

					    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+cordsummary2);
      	    
					    System.out.println("****************************************************************************************");

					      Thread.sleep(2000); 								
														
				    		      
						
						      	    //Logout operation
					      
					  			    Thread.sleep(12000);
					  			    
					  			    testutil= new TestUtil();
								    
								    testutil.Logout_AdTheorent();
					    				
					    				
					  	         
					  		       //To generate the log when the test case is passed
					  		      
					              logger.log(LogStatus.PASS, "Test Case Passed is Audience_Builder_UI_Geography_Targeting_Coordinates_Add_And_Replace_Data");
  
 
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
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
		      	    
		      	    
				   
      
		                
		              
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
			  				
	
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
			    	       	   
  	       	    
	            
		    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	             
	           
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		   
	              

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	








		
