package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class StrategyPropertiesPage extends TestBase{

	
 	//Page Factory - OR:
	
@FindBy(id="selectQTRTDMModel")
WebElement model_click;
	
@FindBy(id="txtQTRTDMMinCtrVtr")
WebElement min_CTR_VTR;	
	
@FindBy(id="txtQTRTDMMaxCtrVtr")
WebElement max_CTR_VTR;		
	
@FindBy(id="btnSaveStrategy")
WebElement save_strategy;		
	
@FindBy(xpath="//span[@for='txtQTRTDMMinCtrVtr']")
WebElement alert_min_CTR_VTR;		
	
@FindBy(xpath="//span[@for='txtQTRTDMMaxCtrVtr']")
WebElement alert_max_CTR_VTR;		
	
@FindBy(id="dvAlert")
WebElement success_msg;	
	
	
	
	



//Initializing the Page Objects:

public StrategyPropertiesPage(){
PageFactory.initElements(driver, this);

}
	
	
	
	
	
    //Actions

	public String validate_Strategy_Properties_PageTitle() {

		return driver.getTitle();

	}
	
    public void click_on_model_dropdown(){
		
    	model_click.click();
		
	}
	
    public void min_CTR_VTRT_clear(){
		
    	min_CTR_VTR.clear();
		
	}
	
    public void max_CTR_VTRT_clear(){
		
    	max_CTR_VTR.clear();
		
	}

    public void save_strategy(){
		
    	save_strategy.click();
		
	}
   
	public String alert_msg1() {

		return alert_min_CTR_VTR.getText();

	}
   
	public String alert_msg2() {

		return alert_max_CTR_VTR.getText();

	}
	
	public String success_msg() {

		return success_msg.getText();

	}

}
