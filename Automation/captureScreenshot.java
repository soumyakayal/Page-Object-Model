package AdTheorent.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class captureScreenshot extends MainTest{
@Test
public void screenshot(){
	System.setProperty("webdriver.gecko.driver", "/Users/soumyak/Documents/selenium/geckodriver");
    driver=new FirefoxDriver();	
    driver.manage().window().maximize();

    driver.get("https://uatplatform.adtheorent.com/");
    String title = driver.getTitle();
    Assert.assertEquals("Non-AdTheorent", title);
    driver.close();
	
}
}