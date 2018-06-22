package AdTheorent.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.util.TestBase;

public class KeyPressEvent extends TestBase{
	
	

	@Test
	public void KeyEventTest() 
	{
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.ENTER).build().perform();
		
		String text=driver.findElement(By.id("result")).getText();
		
		System.out.println(text);
		
		Assert.assertEquals(text, "You entered: ENTER");
		
	}
	
	

}
