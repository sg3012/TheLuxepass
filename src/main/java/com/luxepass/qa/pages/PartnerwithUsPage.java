package com.luxepass.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luxepass.qa.base.TestBase;

public class PartnerwithUsPage extends TestBase{

	@FindBy(xpath="//div[@class='container']"
			+ "//h3[contains(@class,'contact-heading') and contains(text(),'Submit Your Query')]")
	WebElement partnerwithuslabel; 
	
	public PartnerwithUsPage() {
		// TODO Auto-generated constructor stub
		
	    	PageFactory.initElements(driver,this); /*1. initelements() is used to initialize the Objects of a class.
	                                                 2. this keyword indicates the current class it is used in */        
	}
	
	public boolean verifyPartnerwithuslabel()
	{
		return partnerwithuslabel.isDisplayed(); 
	}
    
}