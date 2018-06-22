package AdTheorent.Automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot extends MainTest{


	
	public static String capture (String screenshotName) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
/*		String dest = System.getProperty("user.dir") + "/ErrorScreenshot/" + screenshotName + ".png";
		File destionation = new File(dest);
		FileUtils.copyFile(source, destionation);
		
		return dest;*/
		String filePath = "/Users/soumyak/Documents/selenium/ErrorScreenshot";
/*
		//The below method will save the screen shot in drive with test method name 
        try {
			FileUtils.copyFile(source, new File(filePath+screenshotName+".png"));
			System.out.println("***Placed screen shot in "+filePath+" ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;*/
		
		
			FileUtils.copyFile(source, new File(filePath+screenshotName+".png"));
			System.out.println("***Placed screen shot in "+filePath+" ***");
		
		
		return filePath;
		
}

		
	}
	


