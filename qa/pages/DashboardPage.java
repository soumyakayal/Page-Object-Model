package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class DashboardPage extends TestBase{


 	//Page Factory - OR:
	
@FindBy(id="btnsearchTool")
WebElement adv_search;

@FindBy(xpath="//li[@class='idSearch']//button[text()='Campaign']")
WebElement campaign_btn;

@FindBy(xpath="//li[@class='idSearch']//button[text()='Line Item']")
WebElement lineitem_btn;

@FindBy(xpath="txtkeywordSearch")
WebElement search_textbox;

@FindBy(id="btnGlobalSearch")
WebElement global_search;

@FindBy(linkText="Log Out")
WebElement logout_link;	
	
	     // Initializing the Page Objects:
		public DashboardPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions

		public String verifyDashboardPageTitle(){
			return driver.getTitle();
		}
		
		public void advance_search(){
			
			adv_search.click();
			
		}
		
        public void campaign_button_click(){
			
        	campaign_btn.click();
			
		}
        
        public void lineitem_button_click(){
			
        	lineitem_btn.click();
			
		}
		
        public void search_by_Campaign_ID(){
			
        	search_textbox.clear();
			
		}
      
        public void perform_global_search(){
			
        	global_search.click();
			
		}
        
      
		public void logout_link(){
			
			logout_link.click();
			
		}
        
		/*public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}*/
	
	
	
	
	
}
