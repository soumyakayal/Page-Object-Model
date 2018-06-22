package AdTheorent.Automation;

import java.util.ArrayList;
import java.util.Iterator;		
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
		

public class Multiplewindow {				

    public static void main(String[] args) throws InterruptedException {									
    	WebDriver driver;
    	System.setProperty("webdriver.gecko.driver", "/Users/soumyak/Documents/selenium/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();


   	     
   	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        		
        //Launching the site.				
            driver.get("https://www.naukri.com ");			
       /* driver.manage().window().maximize();*/		
                		
/*driver.findElement(By.xpath("html/body/p/a")).click();			
*/        		
        String MainWindow=driver.getWindowHandle();	
        
        System.out.println("Parent window id is "+MainWindow);
        
        
        
        // To handle all new opened window.				
            Set<String> s1=driver.getWindowHandles();	
            int count=s1.size();
            System.out.println("Total window count is "+count);
            ArrayList<String> tabs=new ArrayList<String>(s1);
            

     
                    // Switching to Child window
                    driver.switchTo().window(tabs.get(3));		
                    driver.manage().window().maximize();
                    System.out.println("Title of the first child window is "+driver.getTitle());
                            
                    driver.close();
                    
                    driver.switchTo().window(tabs.get(2));	
                    driver.manage().window().maximize();
                    System.out.println("Title of the second child window is "+driver.getTitle());
                    driver.close();

                    driver.switchTo().window(tabs.get(1));	
                    driver.manage().window().maximize();
                    System.out.println("Title of the third child window is "+driver.getTitle());
                    driver.close();

                        /*driver.findElement(By.xpath("html/body/form/table/tbody/tr[5]/td[2]/input"))
                        		.sendKeys("test@test.com");			
                                           
                       driver.findElement(By.xpath("html/body/form/table/tbody/tr[6]/td[2]/input")).click();			
                       Thread.sleep(3000);
       
			// Closing the Child Window.
                        driver.close();		*/
            		
        	
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);				
    Thread.sleep(3000);
    
    System.out.println("Title of the parent window is "+driver.getTitle());
    driver.close();
    
    System.out.println("Test case has been executed successfully!!!");

    }
    
}		

