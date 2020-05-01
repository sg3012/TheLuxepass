package com.luxepass.qa.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luxepass.qa.base.TestBase;
import com.luxepass.qa.pages.ContactUs;
import com.luxepass.qa.pages.FAQPage;
import com.luxepass.qa.pages.HomePage;
import com.luxepass.qa.pages.HotelListingPage;
import com.luxepass.qa.pages.LoginPage;
import com.luxepass.qa.pages.MyOrdersPage;
import com.luxepass.qa.pages.MyProfilepage;
import com.luxepass.qa.pages.PartnerwithUsPage;

public class HomePageflowtest extends TestBase {
	LoginPage loginpage; 
	HomePage homepage;
	HotelListingPage hotelisting;
	MyOrdersPage myorders;
	MyProfilepage myprofile;
	FAQPage fAQPage;
	ContactUs contactus;
	PartnerwithUsPage partnerwithus;

	public HomePageflowtest() {
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
		homepage = loginpage.login(prop.getProperty("Email"), prop.getProperty(
				"password")); /*
								 * With this statement the home page reference variable will eventually point to
								 * the home page object as login() method returns the Homepage object
								 */
	}

	@Test(priority = 1)
	public void homepageTitletest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "The LuxePass");
	}

	@Test(priority = 2)
	public void howitworkstest() throws InterruptedException {
		boolean visibility=homepage.clickonHowitworks();
		Assert.assertTrue(visibility, "How it works label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 3)
	public void browsehoteltest() throws InterruptedException {
		hotelisting = homepage.clickonBrowseHotel();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='numberof-hotels text-left']"
				+ "//h4[starts-with(text(),'All(')]")).isDisplayed(), "Hotellisting page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 4)
	public void myOrderstest() throws InterruptedException {
		myorders = homepage.clickonMyorders();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='history-heading']"
				+ "//h3[contains(text(),'Order History')]")).isDisplayed(), "MyOrders page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 5)
	public void myprofileicontest() throws InterruptedException {
		boolean visibility=homepage.clickonMyprofile();
		Assert.assertTrue(visibility, "MyProfile drop-down menu not visible");
		Thread.sleep(1500);
	}

	@Test(priority = 6)
	public void myaccounttest() throws InterruptedException {
		homepage.clickonMyprofile();
		myprofile = homepage.clickonMyaccount();
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='profileTab']"
				+ "//h2[contains(text(),'My Profile')]")).isDisplayed(), "MyProfile page label not visible");
		Thread.sleep(1500);
	}

	@Test(priority = 7)
	public void poolfiltertest() throws InterruptedException {
	    
		hotelisting = homepage.clickonPoolfilter();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='numberof-hotels text-left']"
				+ "//h4[starts-with(text(),'All(')]")).isDisplayed(), "Hotellisting page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 8)
	public void gymfiltertest() throws InterruptedException {
		hotelisting = homepage.clickonGymfilter();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='numberof-hotels text-left']"
				+ "//h4[starts-with(text(),'All(')]")).isDisplayed(), "Hotellisting page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 9)
	public void spasalonfiltertest() throws InterruptedException {
		hotelisting = homepage.clickonSpafilter();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='numberof-hotels text-left']"
				+ "//h4[starts-with(text(),'All(')]")).isDisplayed(), "Hotellisting page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 10)
	public void addtofavoritestest() throws InterruptedException {
		homepage.addTofavorites();
	}

	@Test(priority = 11)
	public void browsemorehoteltest() throws InterruptedException {
		hotelisting = homepage.clickonBrowsemorehotel();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='numberof-hotels text-left']"
				+ "//h4[starts-with(text(),'All(')]")).isDisplayed(), "Hotellisting page label not displayed");
		Thread.sleep(1500);
	}
	
//	@Test(priority = 12)
//	public void aboutusvideotest() throws InterruptedException {
//		homepage.playaboutusvideo();	
//		Thread.sleep(1500);
//	}
	
	@Test(priority = 13)
	public void browsemorehowitworkstest() throws InterruptedException {
		boolean visibility=homepage.clickonBrowsemorehowitworks();
		Assert.assertTrue(visibility, "How it works label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 14)
	public void sendsmsapplinktest() throws InterruptedException {
		String actual_message=homepage.sendsmsapplink(prop.getProperty("phone"));
		Assert.assertEquals(actual_message,"Sent a link via SMS to install the app","LINK NOT SENT THROUGH SMS");
		Thread.sleep(2000);    // Couldn't insert assert as SMS validation is not getting displayed against which assert could be inserted
	}

	@Test(priority = 15)
	public void sendemailpplinktest() throws InterruptedException {
		String actual_message=homepage.sendemailapplink(prop.getProperty("Email"));
		Assert.assertEquals(actual_message,"Sent a link via Mail to install the app","LINK NOT SENT THROUGH MAIL");
		Thread.sleep(2000); // Couldn't insert assert as SMS validation is not getting displayed against which assert could be inserted
	}

	@Test(priority = 16)
	public void playstoredownloadtest() throws InterruptedException {
		String title=homepage.clickgoogleplay();
		Assert.assertEquals(title,"The LuxePass - Apps on Google Play","Play store page title not matched");
		System.out.println("Title:" +title);
	}

	@Test(priority = 17)
	public void appstoredownloadtest() throws InterruptedException {
		String title=homepage.clickappstore(); // Couldn't insert assert as itunes page is not connecting
	}

	@Test(priority = 18)
	public void sendsubscribeemailtest() throws InterruptedException {
		homepage.sendsubscriptionemail(prop.getProperty("Email")); /*Couldn't insert assert as SMS validation is not 
		                                                            getting displayed against which assert could be inserted*/
	}

	@Test(priority = 19)
	public void navigatefooterFAQtest() throws InterruptedException {
		fAQPage = homepage.clickFAQlink();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='faq_banner_content']"
				+ "//h1[contains(text(),'FAQ')]")).isDisplayed(), "FAQ page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 20)
	public void navigatefooterTandctest() throws InterruptedException {
		boolean title=homepage.clickTandClink();
		Assert.assertTrue(title, "TandC page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 21)
	public void navigatefooterPrivacypolicytest() throws InterruptedException {
		boolean title=homepage.clickPrivacypolicylink();
		Assert.assertTrue(title, "Privacy policy page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 22)
	public void navigatefooterContactustest() throws InterruptedException {
		contactus = homepage.clickContactuslink();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='container']"
				+ "//h3[contains(@class,'contact-heading') and contains(text(),'Contact us')]")).isDisplayed(), "Contact US page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 23)
	public void navigatefooterPartnerwithustest() throws InterruptedException {
		partnerwithus = homepage.clickPartnerwithuslink();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='container']"
				+ "//h3[contains(@class,'contact-heading') and contains(text(),'Submit Your Query')]")).isDisplayed(), "Partner with US page label not displayed");
		Thread.sleep(1500);
	}

	@Test(priority = 24)
	public void navigateInstasocialpagetest() throws InterruptedException {
		String title=homepage.clickInstasociallink();
		System.out.println("Title: "+title);
		Assert.assertTrue(title.contains("Instagram photos and videos"),"Instagram page title not matched");
		Thread.sleep(1500);
	}

	@Test(priority = 25)
	public void navigateFBsocialpagetest() throws InterruptedException {
		String title=homepage.clickFBsociallink();
		Assert.assertEquals(title,"The LuxePass - Home | Facebook","FB page title not matched");
		Thread.sleep(1500);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
