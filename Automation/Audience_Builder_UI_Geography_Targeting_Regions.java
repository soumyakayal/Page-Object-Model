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
	                   c. Country target already saved for the Selected Audience
	                 
	*/




	public class Audience_Builder_UI_Geography_Targeting_Regions extends TestBase{

		ExtentReports extent;
		ExtentTest logger;
		TestUtil testutil;

			@BeforeClass
			public void startTest(){
		
	System.out.println("Start the 'Audience_Builder_UI_Regions' automation script in the UAT platform of the AdTheorent");	

	System.out.println("The objective of the Test is to validate the Audience_Builder_UI_Regions section in the Geography Targeting interface");	

	System.out.println("=====================================================================================XXX=============================================================================================================================");

	//ExtentReports(String filePath,Boolean replaceExisting) 
	//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
	//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
	//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
	//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/Audience_Builder_UI_Geography_Targeting_Regions.html", true);
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
			 
			  File f = new File("TestData/Audience_Builder_UI_Regions.xls");
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
			 public void Navigate_To_Audience_Builder_UI_MANAGE_REAL_TIME_AUDIENCES_panel(String sUsername, String sPassword, String audiencename, String searchcity) throws Exception  {  
		    	 
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
			 public void Audience_Builder_UI_Regions(String sUsername, String sPassword, String audiencename, String searchcity) throws Exception  {  
		    	 		
				 
				 
				 logger = extent.startTest("Audience_Builder_UI_Regions");		


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
     			            
     		    			Thread.sleep(5000);

						    //click on GEOGRAPHY option
						      
				            System.out.println("Clicking on GEOGRAPHY option");

				            //click on GEOGRAPHY option
						      
				            System.out.println("Clicking on GEOGRAPHY Target Details section");

							driver.findElement(By.xpath(".//*[@id='divGeographySummary']")).click();
					      	            
						      Thread.sleep(6000); 
						      
					            System.out.println("Selecting the Regions option from the Geography Targeting interface");

						      WebElement ele = driver.findElement(By.xpath("//li[@id='liregions']//a[text()='Regions (State/Province)']"));

					            Actions act = new Actions(driver);

					            act.moveToElement(ele).build().perform();

					            act.click();
					            
					            act.perform();
					            
					            System.out.println("Successfully navigated to Regions interface");

					            
					            System.out.println("Default Region Target list is populated with all available Country value(s) as Checked with it's Child Region as a collapsed mode");
					            
				    		      Thread.sleep(8000);   

								System.out.println("****************************************************************************************");
		
								System.out.println("On Parent Country Selection, all Child Regions are in Checked mode");

								Thread.sleep(3000);

								System.out.println("Deselecting first Region from the Region Tree");

								driver.findElement(By.xpath("//div[@id='divID_236']//label//input[@type='checkbox' and @value='236']")).click();

								Thread.sleep(6000);
	      	    
								System.out.println("****************************************************************************************");

								System.out.println("Expanding the Region Tree");

								driver.findElement(By.xpath("//i[@id='i_236']")).click();
								
								Thread.sleep(4000);

								System.out.println("****************************************************************************************");

				    		      System.out.println("Scrolling down the web table");
				    		      
				    		      EventFiringWebDriver eventFiringWebDriver2 = new EventFiringWebDriver(driver);
				    		      
				    		      eventFiringWebDriver2.executeScript("document.querySelector('#dvRegionTree').scrollTop = 90000");
				    		      
							      Thread.sleep(6000); 
	
                                /* EventFiringWebDriver eventFiringWebDriver4 = new EventFiringWebDriver(driver);
				    		      
				    		      eventFiringWebDriver4.executeScript("document.querySelector('#countrySelect1').scrollTop = 90000");
				    		      
				    		      Thread.sleep(2000); 
				    		  	
                                 EventFiringWebDriver eventFiringWebDriver10 = new EventFiringWebDriver(driver);
				    		      
				    		      eventFiringWebDriver10.executeScript("document.querySelector('#countrySelect1').scrollTop = 90000");
				    		      
				    		      Thread.sleep(2000); 
					    		  	
                                 EventFiringWebDriver eventFiringWebDriver11 = new EventFiringWebDriver(driver);
				    		      
				    		      eventFiringWebDriver11.executeScript("document.querySelector('#countrySelect1').scrollTop = 90000"); */
				    		      
							      
									System.out.println("Country wise available Region List are displayed in Alphabetical order");

								      Thread.sleep(5000); 

							        System.out.println("****************************************************************************************");

									System.out.println("Checkbox options are available to select child Region nodes under Country");

								     /* Thread.sleep(2000); 


									System.out.println("Deselecting second Region from the Region Tree");

									driver.findElement(By.xpath("//div[@id='divID_248']//label//input[@type='checkbox' and @value='248']")).click();
*/
									Thread.sleep(6000);
		      	    
									System.out.println("****************************************************************************************");
							      
									System.out.println("Expanding the Region Tree");

									driver.findElement(By.xpath("//i[@id='i_248']")).click();
									
									Thread.sleep(4000);

									System.out.println("****************************************************************************************");

					    		      System.out.println("Scrolling down the web table");
					    		      
					    		      EventFiringWebDriver eventFiringWebDriver4 = new EventFiringWebDriver(driver);
					    		      
					    		      eventFiringWebDriver4.executeScript("document.querySelector('#dvRegionTree').scrollTop = 90000");
					    		      
								      Thread.sleep(6000); 
							      
								      System.out.println("****************************************************************************************");

								      System.out.println("Expanding the Collapse Tree");

									  driver.findElement(By.xpath("//i[@id='i_3625']")).click();

								      Thread.sleep(6000); 

								      System.out.println("Deselecting the region names for a particular country");

								      
									  driver.findElement(By.xpath("//div[@id='divID_284874']//label//input[@type='checkbox' and @value='284874']")).click();

								      Thread.sleep(3000); 

									  driver.findElement(By.xpath("//div[@id='divID_281123']//label//input[@type='checkbox' and @value='281123']")).click();

								      Thread.sleep(2000); 

								      System.out.println("Parent Country Checkbox state changes to intermediate selection on selecting some of Child Region(s) under any Country");
								      
  
								      System.out.println("****************************************************************************************");

								      Thread.sleep(10000); 

								      System.out.println("Deselecting third Region from the Region Tree");

										driver.findElement(By.xpath("//div[@id='divID_237']//label//input[@type='checkbox' and @value='237']")).click();

										Thread.sleep(6000);
			      	    
									    System.out.println("****************************************************************************************");

										
									System.out.println("Saving the changes after deselecting the Regions from the Region Tree");
									
									driver.findElement(By.id("btnSaveGeography")).click();
										
									Thread.sleep(2000);

                                    System.out.println("****************************************************************************************");		
									
								    System.out.println("Capturing the system-generated message");

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
					
									String countrysummary1= driver.findElement(By.id("divGeographySummary")).getText();

								    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+countrysummary1);
			      	    
								    System.out.println("****************************************************************************************");

								      Thread.sleep(6000); 

								    //click on GEOGRAPHY option
								      
								    System.out.println("Clicking on GEOGRAPHY Target Details section");

									driver.findElement(By.xpath(".//*[@id='divGeographySummary']")).click();
										
								    Thread.sleep(4000); 
								      
							        System.out.println("Successfully navigated to Geography Targeting interface with Region tab in selected state");
							            
								    /*Thread.sleep(3000); 

								    System.out.println("****************************************************************************************");
							    					    
								    System.out.println("Selecting the Regions (State/Province) option");

								      WebElement ele2 = driver.findElement(By.xpath("//li[@id='liregions']//a[text()='Regions (State/Province)']"));

							            Actions act2 = new Actions(driver);

							            act.moveToElement(ele2).build().perform();

							            act2.click();
							            
							            act2.perform();
							            
							            System.out.println("Successfully navigated to Regions interface");*/

						    		      Thread.sleep(7000);   
								    
								    
						    		    System.out.println("****************************************************************************************");
									      
											System.out.println("Expanding the Region Tree");

											driver.findElement(By.xpath("//i[@id='i_248']")).click();
											
											Thread.sleep(4000);

										System.out.println("****************************************************************************************");

										System.out.println("Expanding the Collapse Tree");

										driver.findElement(By.xpath("//i[@id='i_3625']")).click();

									    System.out.println("****************************************************************************************");

									      Thread.sleep(6000); 
								    
										System.out.println("Deselecting All options");
										
										driver.findElement(By.xpath("//input[@id='chkallRegion']")).click();

									     Thread.sleep(2000); 

										driver.findElement(By.xpath("//input[@id='chkallRegion']")).click();

										System.out.println("All the selected regional options are deselected");

										Thread.sleep(8000);

									    System.out.println("****************************************************************************************");

									    System.out.println("Saving the changes after deselecting the Regions from the Region Tree");
										
										driver.findElement(By.id("btnSaveGeography")).click();
											
										Thread.sleep(2000);

	                                    System.out.println("****************************************************************************************");		
										
									    System.out.println("Capturing the system-generated message");

										String msg4= driver.findElement(By.id("dvAlert")).getText();
										
									    System.out.println("System-generated message is :"+ msg4);
									    
									    System.out.println("****************************************************************************************");
										
										Thread.sleep(3000);	
								    
	                                    String gettitle223 = driver.getTitle();
			     			            try{     

			     			    	    Assert.assertTrue(gettitle223.contains("Audience"), "Title of the page is not matching");

			     			    	    System.out.println("Title of the page is "+gettitle223);
			     			    	    
			     			    	    System.out.println("Successfully navigated to Audience page");
			     			            }
			     			            catch (AssertionError e323) {
			     			            	 System.out.println("Audience page failed to load: "+e323.getMessage());
			     			         		
			     			            } 
			     			         
						      	        Thread.sleep(8000);
										
									    System.out.println("****************************************************************************************");
						
										String countrysummary2= driver.findElement(By.id("divGeographySummary")).getText();

									    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+countrysummary2);
				      	    
									    System.out.println("****************************************************************************************");

									      Thread.sleep(6000); 

									    //click on GEOGRAPHY option
									      
									    System.out.println("Clicking on GEOGRAPHY Target Details section");

										driver.findElement(By.xpath(".//*[@id='divGeographySummary']")).click();
											
									    Thread.sleep(4000); 
									      
								        System.out.println("Successfully navigated to Geography Targeting interface with Country tab in selected state");
								        
									    System.out.println("****************************************************************************************");

									    Thread.sleep(3000); 

								        System.out.println("Selecting the Regions (State/Province) option");

									      WebElement ele2 = driver.findElement(By.xpath("//li[@id='liregions']//a[text()='Regions (State/Province)']"));

								            Actions act2 = new Actions(driver);

								            act.moveToElement(ele2).build().perform();

								            act2.click();
								            
								            act2.perform();
								            
								            System.out.println("Successfully navigated to Regions interface");
	
										    Thread.sleep(5000); 

								            System.out.println("****************************************************************************************");

											System.out.println("Expanding the Collapse Tree");

											driver.findElement(By.xpath("//i[@id='i_229']")).click();

										    System.out.println("****************************************************************************************");
								    
										    System.out.println("Searching for a particular city in the search text box");

										    driver.findElement(By.xpath("//input[@id='txtSearchRegionCity']")).clear();

										    Thread.sleep(2000);

										    driver.findElement(By.xpath("//input[@id='txtSearchRegionCity']")).sendKeys(searchcity);
								    
										    Thread.sleep(20000);

										    System.out.println("****************************************************************************************");

											System.out.println("Expanding the Collapse Tree");

											driver.findElement(By.xpath("//i[@id='i_28']")).click();

										    System.out.println("****************************************************************************************");
								    
										    Thread.sleep(10000);

										    System.out.println("Deselecting the check box against the searched city");

											driver.findElement(By.xpath("//div[@id='divID_17136']//label//input[@type='checkbox' and @value='17136']")).click();

										    System.out.println("****************************************************************************************");
										   
										    Thread.sleep(8000);

										    System.out.println("Saving the changes after selecting the Regions from the Region Tree");
											
											driver.findElement(By.id("btnSaveGeography")).click();
												
											Thread.sleep(2000);

		                                    System.out.println("****************************************************************************************");		
											
										    System.out.println("Capturing the system-generated message");

											String msg5= driver.findElement(By.id("dvAlert")).getText();
											
										    System.out.println("System-generated message is :"+ msg5);
										    
										    System.out.println("****************************************************************************************");
											
											Thread.sleep(3000);	
											
		                                    String gettitle224 = driver.getTitle();
				     			            try{     

				     			    	    Assert.assertTrue(gettitle224.contains("Audience"), "Title of the page is not matching");

				     			    	    System.out.println("Title of the page is "+gettitle224);
				     			    	    
				     			    	    System.out.println("Successfully navigated to Audience page");
				     			            }
				     			            catch (AssertionError e324) {
				     			            	 System.out.println("Audience page failed to load: "+e324.getMessage());
				     			         		
				     			            } 
				     			            
							      	        Thread.sleep(8000);
											
										    System.out.println("****************************************************************************************");
							
											String countrysummary3= driver.findElement(By.id("divGeographySummary")).getText();

										    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+countrysummary3);
					      	    
										    System.out.println("****************************************************************************************");

										      Thread.sleep(6000); 

										    //click on GEOGRAPHY option
										      
										    System.out.println("Clicking on GEOGRAPHY Target Details section");

											driver.findElement(By.xpath(".//*[@id='divGeographySummary']")).click();
											
										    Thread.sleep(4000); 
										      
									        System.out.println("Successfully navigated to Geography Targeting interface with Regions tab in selected state");
			     
									        System.out.println("****************************************************************************************");

											System.out.println("Expanding the Collapse Tree");

											driver.findElement(By.xpath("//i[@id='i_229']")).click();

										      Thread.sleep(15000); 

										    System.out.println("****************************************************************************************");
										    
											System.out.println("Deselecting one state");

											driver.findElement(By.xpath("//div[@id='divID_2']//label//input[@type='checkbox' and @value='2']")).click();
											 
										    Thread.sleep(7000); 

										    System.out.println("Deselection is successful");

										    System.out.println("****************************************************************************************");
											 
											System.out.println("Expanding the state after the deselection operation at the state level");

											driver.findElement(By.xpath("//i[@id='i_2']")).click();
											 
										    Thread.sleep(15000); 

										    System.out.println("Expansion is successful");

										    System.out.println("****************************************************************************************");
										    
										    System.out.println("Scrolling down the web table");
							    		      
							    		      EventFiringWebDriver eventFiringWebDriver3 = new EventFiringWebDriver(driver);
							    		      
							    		      eventFiringWebDriver3.executeScript("document.querySelector('#dvRegionTree').scrollTop = 90000");
							    		      
										      Thread.sleep(2000); 
										    
                                              EventFiringWebDriver eventFiringWebDriver30 = new EventFiringWebDriver(driver);
							    		      
							    		      eventFiringWebDriver30.executeScript("document.querySelector('#dvRegionTree').scrollTop = 90000");
							    		      
										      Thread.sleep(2000); 

                                              EventFiringWebDriver eventFiringWebDriver31 = new EventFiringWebDriver(driver);
							    		      
							    		      eventFiringWebDriver31.executeScript("document.querySelector('#dvRegionTree').scrollTop = 90000");
							    		      
										      /*Thread.sleep(2000); 
										    
                                              EventFiringWebDriver eventFiringWebDriver32 = new EventFiringWebDriver(driver);
							    		      
							    		      eventFiringWebDriver32.executeScript("document.querySelector('#dvRegionTree').scrollTop = 90000");
							    		      
							    		      Thread.sleep(2000); 
											    
                                              EventFiringWebDriver eventFiringWebDriver33 = new EventFiringWebDriver(driver);
							    		      
							    		      eventFiringWebDriver33.executeScript("document.querySelector('#dvRegionTree').scrollTop = 90000");*/
							    		      
										      Thread.sleep(8000); 
								
                                            System.out.println("Clicking on Cancel Changes button");
											
											driver.findElement(By.id("btnGeographyCancel")).click();
												
                                            Thread.sleep(3000);	
											
		                                    String gettitle225 = driver.getTitle();
				     			            try{     

				     			    	    Assert.assertTrue(gettitle225.contains("Audience"), "Title of the page is not matching");

				     			    	    System.out.println("Title of the page is "+gettitle225);
				     			    	    
				     			    	    System.out.println("Successfully navigated to Audience page");
				     			            }
				     			            catch (AssertionError e325) {
				     			            	 System.out.println("Audience page failed to load: "+e325.getMessage());
				     			         		
				     			            } 
				     			            
							      	        Thread.sleep(8000);
											    
		                                    System.out.println("****************************************************************************************");
		        							
											String countrysummary4= driver.findElement(By.id("divGeographySummary")).getText();

										    System.out.println("Following system-generated message is being displayed in the GEOGRAPHY section: "+countrysummary4);
					      	    
										    System.out.println("****************************************************************************************");    
											    
										    Thread.sleep(6000); 

										    //click on GEOGRAPHY option
										      
								            System.out.println("Clicking on GEOGRAPHY Targeting option");

								            driver.findElement(By.xpath(".//*[@id='lnkGeography']")).click();
						      	            
										    Thread.sleep(4000); 
										      
									        System.out.println("Successfully navigated to Geography Targeting interface with Regions tab in selected state");    
											    
											Thread.sleep(5000);

									        System.out.println("****************************************************************************************");

											System.out.println("Expanding the Collapse Tree");

											driver.findElement(By.xpath("//i[@id='i_229']")).click();

										    Thread.sleep(4000);
										    
										    System.out.println("Expansion is successful");

										    System.out.println("****************************************************************************************");
											 
											System.out.println("Expanding the state level");

											driver.findElement(By.xpath("//i[@id='i_2']")).click();
											 
										    Thread.sleep(15000); 

										    System.out.println("Expansion is successful");

										    System.out.println("****************************************************************************************");  
										    										    
											System.out.println("Closing the Modal Geography Targeting pop-up by clicking on Cancel Changes button");

											Thread.sleep(3000);

											WebElement element107 = driver.findElement(By.xpath("//button[@value='Geography' and @onclick='ClosePopup(this)']"));
											((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element107);
											
											driver.findElement(By.xpath("//button[@value='Geography' and @onclick='ClosePopup(this)']")).click();
											
											System.out.println("Modal Geography Targeting pop-up has been successfully closed");

										    System.out.println("****************************************************************************************");
      
										    Thread.sleep(6000); 
				    		      
										    String gettitle226 = driver.getTitle();
				     			            try{     

				     			    	    Assert.assertTrue(gettitle226.contains("Audience"), "Title of the page is not matching");

				     			    	    System.out.println("Title of the page is "+gettitle226);
				     			    	    
				     			    	    System.out.println("Successfully navigated to Audience page");
				     			            }
				     			            catch (AssertionError e326) {
				     			            	 System.out.println("Audience page failed to load: "+e326.getMessage());
				     			         		
				     			            } 
								    
				     			            //Logout operation

											Thread.sleep(12000); 

										    testutil= new TestUtil();
										    
										    testutil.Logout_AdTheorent();
					    				
					  	         
					  		       //To generate the log when the test case is passed
					  		      
					              logger.log(LogStatus.PASS, "Test Case Passed is Audience_Builder_UI_Regions");
						              
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
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
								    
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
						            
		      	    
		      	    
				   
      
		                
		              
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
		                
			  				
	
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
		    				
			    	       	   
  	       	    
	            
		    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	       	    
  	             
	           
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		    	       	   
		   
	              

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	








		
