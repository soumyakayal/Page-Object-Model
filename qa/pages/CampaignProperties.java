package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class CampaignProperties extends TestBase{
	
	//Page Factory - OR:
	
	@FindBy(xpath=".//*[@id='dvCreativeBlock']")
	WebElement creative_lib_expand;

    @FindBy(css="a.btn:nth-child(5) > i:nth-child(1)")
    WebElement upload_tag_sheet_button;
    
    
    //Initializing the Page Objects:
	
    public CampaignProperties(){
	PageFactory.initElements(driver, this);
	
    }


        //Actions

		public String validate_Campaign_Properties_PageTitle() {

			return driver.getTitle();

		}

        public void click_on_upload_tagsheet(){
			
        	upload_tag_sheet_button.click();
			
		}
		

		public UploadTagSheet clickOnCreativeLibExpandbutton(){
			
			creative_lib_expand.click();
			
			return new UploadTagSheet();
		}

}
