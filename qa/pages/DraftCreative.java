package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class DraftCreative extends TestBase{
	
	        
	
	
    //Page Factory - OR:
	
    @FindBy(xpath="//div[@title='Timezone: America/New_York (UTC/GMT -05:00)']//button[@data-toggle='dropdown']")
    WebElement usermenu;


	@FindBy(linkText="Log Out")
	WebElement logout_link;

	
	
    //Initializing the Page Objects:
	
    public DraftCreative(){
	PageFactory.initElements(driver, this);
	
    }

	
	        //Actions
	
			public String validateDraftCreativepagetitle() {
	 
				return driver.getTitle();

			}
			
			public void user_menu(){
				
				usermenu.click();
				
			}
			

			public LoginPage logout_link(){
				
				logout_link.click();
				
				return new LoginPage();
			}

	
}
