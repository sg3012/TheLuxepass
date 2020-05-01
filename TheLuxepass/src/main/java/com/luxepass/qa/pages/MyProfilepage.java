package com.luxepass.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luxepass.qa.base.TestBase;

public class MyProfilepage extends TestBase{
	@FindBy(xpath="//li[@class='profileTab']//h2[contains(text(),'My Profile')]")
	WebElement myprofilelabel;
	
	public MyProfilepage() {
		// TODO Auto-generated constructor stub
		
	    	PageFactory.initElements(driver,this); /*1. initelements() is used to initialize the Objects of a class.
	                                                 2. this keyword indicates the current class it is used in */        
	}
	
	public boolean verifyMyProfilelabel()
	{
		return myprofilelabel.isDisplayed();
	}

}
