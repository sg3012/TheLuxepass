package com.luxepass.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luxepass.qa.base.TestBase;

public class HowitWorksPage extends TestBase{

	@FindBy(xpath="//div[@class='display-tc']//h1[contains(text(),'How It Works')]")
	WebElement howitworkslabel; 
	
	public HowitWorksPage() {
		// TODO Auto-generated constructor stub
		
	    	PageFactory.initElements(driver,this); /*1. initelements() is used to initialize the Objects of a class.
	                                                 2. this keyword indicates the current class it is used in */        
	}
	
	public boolean verifyHowitworkslabel()
	{
		return howitworkslabel.isDisplayed(); 
	}
    
}
