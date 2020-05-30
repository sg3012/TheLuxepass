package com.luxepass.qa.tests;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.luxepass.qa.base.TestBase;
import com.luxepass.qa.pages.HomePage;
import com.luxepass.qa.pages.LoginPage;
import com.luxepass.qa.pages.SignUppage;
import com.luxepass.qa.util.Getexceldata;

public class Signuppageflowtest extends TestBase {
	SignUppage signuppage; /*
							 * 1. We have declared LoginPage class reference variable with default access
							 * Modifier so that we could use this reference variable inside any class of
							 * this package. Same is the case with reference variable of home page
							 */
	LoginPage loginpage;

	public Signuppageflowtest() {
		super(); /*
					 * 1. This statement will call the super/base class(TestBase) constructor and
					 * load the properties file in this class. 2. This statement is mandatory to be
					 * used if u are designing your framework using properties file. 3. This is done
					 * to avoid the nullpointerException when the initialization() method is called
					 * to initialize and use the properties from the properties file.
					 */
	}

	@BeforeMethod /* 1. Will be executed before the execution of each @Test annotation */
	public void setUp() /*
						 * As the name indicates this method will create the initial setup of the
						 * following things : -- Sets up the driver for the required browser with the
						 * help of method initialization().
						 */
	{
		initialization();
		signuppage = new SignUppage(); /*
										 * Created a SignupPage Class Object and will call it's constructor which will
										 * eventually initialize the Object
										 */
	}

	@Test(priority = 1)
	public void signuppageclickcrossicon_onsignup() throws InterruptedException
	{
		signuppage.clickcrossicononsignup();
	}
	
	@Test(priority = 2)
	public void signuppageclickcrossicon_onverifynonactiveemail() throws InterruptedException
	{
		signuppage.clickcrossicononverifynonactiveemail();
	}
	
	@Test(priority = 3)
	public void signuppageclickcrossicon_onverifyaccount() throws InterruptedException
	{
		signuppage.clickcrossicononverifyaccount();
	}
	
	@Test(priority = 4)
	public void signuppageclicktandclink() throws InterruptedException
	{
		signuppage.clicktandclink();
	}
	
	@Test(priority = 5)
	public void signuppageclickcrossicon_onlogin() throws InterruptedException
	{
		signuppage.clickcrossicononlogin();
	}
	
	@Test(priority = 6)
	public void signuppageverifynonactiveemail() throws InterruptedException {
		loginpage = signuppage.verifynonactiveemail(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("Email")
                 ,prop.getProperty("password"),prop.getProperty("confirmpassword"));  
		Thread.sleep(2000);
	}
	@Test(priority = 7)
	 public void signuppageresendcodetest1() throws InterruptedException
    {
    	loginpage=signuppage.resendcode(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("Email")
                 ,prop.getProperty("password"),prop.getProperty("confirmpassword"));	
    	Thread.sleep(2000);
    }

    @Test(priority=8)
    public void signuppageresendcodetest2() throws InterruptedException
    {
    	loginpage=signuppage.resendcode(prop.getProperty("Email"));	
    	Thread.sleep(2000);
    }
    @Test(priority=9, dataProvider="getTestdata")
    public void signupPagesignuptest(String firstname,String laststname,String email, String pwd,String confirmpass) throws InterruptedException
    {
 	   loginpage=signuppage.signup(firstname,laststname,email,pwd,confirmpass);
// 	  homepage=signuppage.signup();
 	   Thread.sleep(2000);
 	   
    }
    
    @DataProvider
	
	public Iterator<Object[]> getTestdata() {
		
	ArrayList<Object[]> testdata= Getexceldata.fetchdata();
	
	return testdata.iterator();
	
	}

    @AfterMethod
    public void teardown()
    {
 	driver.quit();   
    }
}
