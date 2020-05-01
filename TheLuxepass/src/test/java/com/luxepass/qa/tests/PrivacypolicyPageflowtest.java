package com.luxepass.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luxepass.qa.base.TestBase;
import com.luxepass.qa.pages.HomePage;
import com.luxepass.qa.pages.LoginPage;
import com.luxepass.qa.pages.PrivacyPolicyPage;

public class PrivacypolicyPageflowtest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	PrivacyPolicyPage privacypolicy; 

	public PrivacypolicyPageflowtest(){
		super(); /*
					 * 1. This statement will call the super/base class(TestBase) constructor and
					 * load the properties file in this class. 2. This statement is mandatory to be
					 * used if u are designing your framework using properties file. 3. This is done
					 * to avoid the nullpointerException when the initialization() method is called
					 * to initialize and use the properties from the properties file.
					 */
	}

	@BeforeMethod /* 1. Will be executed before the execution of each @Test annotation */
	public void setUp() throws InterruptedException {
		initialization(); /*
							 * As the name indicates this method will create the initial setup of the
							 * following things : -- Sets up the driver for the required browser.
							 */

		/*
		 * loginpage = new LoginPage(); Created a LoginPage Class Object and will call
		 * it's constructor which will eventually initialize the Object
		 */
		homepage = new HomePage();
		loginpage = new LoginPage();
		privacypolicy= new PrivacyPolicyPage(); 
		homepage = loginpage.login(prop.getProperty("Email"), prop.getProperty(
				"password")); /*
								 * With this statement the home page reference variable will eventually point to
								 * the home page object as login() method returns the Homepage object
	   							 */
	   homepage.clickPrivacypolicylink();
	}

	@Test(priority = 1)
	public void Privacypolicylabeltest() {
		Assert.assertTrue(privacypolicy.verifyPrivacypolicylabel(),"Privacy policy label missing");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
