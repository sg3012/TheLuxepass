package com.luxepass.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luxepass.qa.base.TestBase;
import com.luxepass.qa.pages.HomePage;
import com.luxepass.qa.pages.HowitWorksPage;
import com.luxepass.qa.pages.LoginPage;
import com.luxepass.qa.pages.PartnerwithUsPage;

public class PartnerwithUSpageflowtest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	PartnerwithUsPage partnerwithus; 

	public PartnerwithUSpageflowtest() {
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

		loginpage = new LoginPage();
		homepage = new HomePage();
		loginpage = new LoginPage();
		partnerwithus = new PartnerwithUsPage();
		homepage = loginpage.login(prop.getProperty("Email"), prop.getProperty(
				"password")); /*
								 * With this statement the home page reference variable will eventually point to
								 * the home page object as login() method returns the Homepage object
	   							 */
	   partnerwithus=homepage.clickPartnerwithuslink(); 
	}

	@Test(priority = 1)
	public void partnerwithUSlabeltest() {
		Assert.assertTrue(partnerwithus.verifyPartnerwithuslabel(),"Partner with us label missing");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
