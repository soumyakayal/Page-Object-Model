package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase{

	
	     	//Page Factory - OR:
	
		@FindBy(id="txtLoginID")
		WebElement username;
		
		@FindBy(id="txtPassword")
		WebElement password;
		
		@FindBy(xpath="//button[contains(text(),'Sign In') and @type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//img[@src='/images/logo.png']")
		WebElement adthlogo;
		
		@FindBy(partialLinkText="Password?")
		WebElement pwdlink;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
			
		}

		//Actions
		
		public String validateLoginPageTitle() {
 
			return driver.getTitle();

		}
		
		public boolean validateAdTheorentImageLink() {
			 
			return adthlogo.isDisplayed();

		}
		
		public boolean validatePasswordLink() {
			 
			return pwdlink.isDisplayed();

		}
		
		public DashboardPage login(String un, String pwd){
		
			username.sendKeys(un);
			
			password.sendKeys(pwd);
			
			loginBtn.click();
			
/*			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginBtn);*/
		
			return new DashboardPage();
			
		}
		
}
