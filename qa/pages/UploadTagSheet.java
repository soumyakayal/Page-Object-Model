package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class UploadTagSheet extends TestBase {

	
	    //Page Factory - OR:
	
	    @FindBy(css="i.fa:nth-child(6)")
	    WebElement tooltip;

	
		@FindBy(id="btnTagSheetModalCancel")
		WebElement modal_cancel;

		
		@FindBy(id="btnSubmitTagSheet")
		WebElement submit_button;
		
		@FindBy(id="lnkTSUUpload")
		WebElement browse_button;
		
	    @FindBy(id="spnTagSheetUploadedFileName")
	    WebElement uploaded_text;
		
	    //Initializing the Page Objects:
		
	    public UploadTagSheet(){
		PageFactory.initElements(driver, this);
		
	    }
	    
	    // Actions
	    
        public void click_on_cancel_button(){
			
        	modal_cancel.click();
			
		}
        
        public String toolTipText(){
			
        	return tooltip.getAttribute("title");
			
		}
        
/*        public void submit_button(){
			
        	submit_button.click();
			
		}*/
	   
        public void browse_button(){
			
        	browse_button.click();
			
		}
        
        public String uploaded_text(){
			
        	return uploaded_text.getText();
			
		}
        
    	public DraftCreative submit_button(){
    		
        	submit_button.click();
        	
			return new DraftCreative();
		}
}
