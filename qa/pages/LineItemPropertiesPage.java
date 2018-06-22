package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LineItemPropertiesPage extends TestBase{
	
	
	//Page Factory - OR:

    @FindBy(css="body > section > div.mainpanel.mainpanel_env > div.pageheader.clearfix > div.pull-left > h2 > span")
    WebElement line_item_name;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    //Initializing the Page Objects:
	
    public LineItemPropertiesPage(){
	PageFactory.initElements(driver, this);
	
    }
	
	
	
	

    //Actions

	public String validate_LineItem_Properties_PageTitle() {

		return driver.getTitle();

	}
	
	
	public boolean validateLineItemname() {
		 
		return line_item_name.isDisplayed();

	}
	
	
	
	
	
	
}
