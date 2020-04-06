package com.luxepass.qa.pages;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.luxepass.qa.base.TestBase;
import com.luxepass.qa.util.TestUtil;
public class HomePage extends TestBase {
    
	// PAGE OBJECT REPO:
     
	@FindBy(xpath = "//div[@class='menu-1']//ul//li//a[text()='How It Works']")
	WebElement howitworks;

	@FindBy(xpath = "//div[@class='menu-1']//ul[@class='nav navbar-nav navbar-right']//li//a[text()='Browse Hotel']")
	WebElement browseHotel;

	@FindBy(xpath = "//div[@class='menu-1']//ul[@class='nav navbar-nav navbar-right']//li//a[text()='My Orders']")
	WebElement myorders;

	@FindBy(xpath = "//div[@class='menu-link']//div[@class='menu-1']"
			+ "//img[starts-with(@src,'https://s3.us-west-2.amazonaws.com/luxepass') "
			+ "or starts-with(@src,'/assets/images')]")
	WebElement myprofile;

	@FindBy(xpath = "//li[@class='dropdown open']//ul[@class='dropdown-menu']//a[text()='My Account']")
	WebElement myaccountlink;

	@FindBy(xpath = "//div[@class='row']//div[@class='menu-1']//span[text()='Logout']")
	WebElement logoutlink;

	@FindBy(xpath = "//div[@class='join-us']//button[@class='custom-button input-btn']")
	WebElement locatebtn;

	@FindBy(xpath = "//input[@name='search-hotels' and @placeholder='Search For Hotels']")
	WebElement searchbox;

	@FindBy(xpath = "//div[@class='gtco-icon']//img[@src='assets/images/icon-1.png']")
	WebElement poolfilterimg;

	@FindBy(xpath = "//div[@class='gtco-icon']//img[@src='assets/images/icon-2.png']")
	WebElement gymfilterimg;

	@FindBy(xpath = "//div[@class='gtco-icon']//img[@src='assets/images/icon-3.png']")
	WebElement spasalonfilterimg;

	@FindBy(xpath = "//div[@class='m-prev swiper-button-prev']")
	WebElement prevslidericon;

	@FindBy(xpath = "//div[@class='feature-list hotels-slider swiper-container-initialized "
			+ "swiper-container-horizontal swiper-container-free-mode']")
	WebElement slidercontainerhotel;

	@FindBy(xpath = "//section[@class='about-work additional-feature']")
	WebElement slidercontainerhowitowrks;

	@FindBy(xpath = "//div[@class='m-next active swiper-button-next']")
	WebElement nxtslidericon;

//	@FindBy(xpath = "//div[@class='hotel-box on-img']//span[@class='right']//img[@src='assets/images/heart.png']")
//	List<WebElement> hearticons;

	@FindBy(xpath = "//section[@id='hotels']//a[@class='btn btn-info' and contains(text(),'Browse More')]")
	WebElement browsemorehotel;

	@FindBy(xpath = "//section[@class='about-work additional-feature']//a[@class='btn btn-info' and contains(text(),'Browse More')]")
	WebElement browsemorehowitworks;

//	@FindBy(xpath = "//*[name()='svg' ]//*[local-name()='path' and contains(@fill,'#') "
//			+ "and @class='ytp-large-play-button-bg']")
//	WebElement aboutusvideobtn;
	@FindBy(xpath = "//input[@class='custom-button input-num ng-untouched ng-pristine ng-invalid' "
			+ "and @formcontrolname='mobile']")
	WebElement smslinkinput;

	@FindBy(xpath = "//input[@class='custom-button input-num ng-untouched ng-pristine ng-invalid' "
			+ "and @formcontrolname='email']")
	WebElement emaillinkinput;

	@FindBy(xpath = "//button[text()='Text App Link']")
	WebElement sendsmsapplinkbtn;

	@FindBy(xpath = "//button[text()='Email App Link']")
	WebElement sendemailapplinkbtn;

	@FindBy(xpath = "//p[text()=' Google Play']")
	WebElement playstorelink;

	@FindBy(xpath = "//p[text()=' App Store']")
	WebElement appstore;

	@FindBy(xpath = "//input[@class='custom-button input-num subscrive ng-untouched ng-pristine ng-invalid']")
	WebElement subscribeemailinput;

	@FindBy(xpath = "//button[text()='Subscribe']")
	WebElement subscribebtn;
    
	@FindBy(linkText= "FAQ")
	WebElement FAQlnk;

	@FindBy(linkText = "Terms & Conditions")
	WebElement TandClnk;

	@FindBy(linkText = "Privacy Policy")
	WebElement Privacypolicylnk;

	@FindBy(linkText = "Contact Us")
	WebElement ContactUslnk;

	@FindBy(linkText = "Partner With Us")
	WebElement PartnerWithUslnk;

	@FindBy(xpath = "//i[@class='fa fa-instagram']")
	WebElement Instasocial;

	@FindBy(xpath = "//a[contains(@href,'https://www.facebook.com')]//i[@class='fa fa-facebook']")
	WebElement Facebooksocial;
	
	@FindBy(xpath="//div[@class='display-tc']//h1[contains(text(),'How It Works')]")
	WebElement howitworkslabel;
	
	@FindBy(xpath="//div[@class='section-heading']//h1[contains(text(),'Terms Of Use')]")
	WebElement TandCpagelabel;
	
	@FindBy(xpath="//div[@class='section-heading']"
			+ "//h1[contains(text(),'Privacy Policy')]")
	WebElement privacypolicylabel; 
	

//	@FindBy(xpath = "//div[@class='about-heading']")
//	WebElement containeraboutus;
	
//	@FindBy(xpath="//div[@class='gtco-icon']//img[@src='assets/images/icon-3.png']")
//	WebElement spasalonfilterimg;
	String parent,child; 
	public void scrollintoviewhotel(WebElement slidercontainerhotel, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", slidercontainerhotel);
	}

	public void scrollintoviewhowitworks(WebElement slidercontainerhowitworks, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", slidercontainerhowitworks);
	}

	public void clickslider(WebElement nxtslidericon, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", nxtslidericon);
	}

	public void clickheart(WebElement heartlist, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", heartlist);
	}
	
	public void hitFbsociallink(WebElement fbsocial, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", fbsocial);
	}
	
	public void hitInstasociallink(WebElement instasocial, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", instasocial);
	}
	
	public void scrollintoviewdownloadourapp(WebElement downloadourapp, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", downloadourapp);
	}
	
//	public void scrollintoviewaboutuscontainer(WebElement aboutuscontainer, WebDriver driver) {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].scrollIntoView(true);",aboutuscontainer);
//	}
		
	public HomePage() {                                     // For initializing the object of this page. 
		PageFactory.initElements(driver, this);
	}                                              

	public String validateHomePageTitle() {
		return driver.getTitle();

	}
    
	public boolean clickonHowitworks() {
		howitworks.click();
		return howitworkslabel.isDisplayed(); 
	}

	public HotelListingPage clickonBrowseHotel() {
		browseHotel.click();
		return new HotelListingPage();
	}

	public MyOrdersPage clickonMyorders() {
		myorders.click();
		return new MyOrdersPage();
	}

	public boolean clickonMyprofile() {
		myprofile.click();
		return myaccountlink.isDisplayed(); 

	}

	public MyProfilepage clickonMyaccount() {
		myaccountlink.click();
		return new MyProfilepage();
	}

	public HotelListingPage clickonBrowsemorehotel() {
		scrollintoviewhotel(slidercontainerhotel, driver);
		browsemorehotel.click();
		return new HotelListingPage();
	}

	public boolean clickonBrowsemorehowitworks() {
		scrollintoviewhowitworks(slidercontainerhowitowrks, driver);
		browsemorehowitworks.click();
		return howitworkslabel.isDisplayed();
	}

	public HotelListingPage clickonPoolfilter() {
		poolfilterimg.click();
		return new HotelListingPage();
	}

	public HotelListingPage clickonGymfilter() {
		gymfilterimg.click();
		return new HotelListingPage();
	}

	public HotelListingPage clickonSpafilter() {
		spasalonfilterimg.click();
		return new HotelListingPage();
	}

	public void addTofavorites() throws InterruptedException {
		List<WebElement> hearticons = driver.findElements(By.xpath("//div[@class='hotel-box on-img']"
				+ "//span[@class='right']//img[@src='assets/images/heart.png']"));
		scrollintoviewhotel(slidercontainerhotel, driver);
		for (int i = 0; i < hearticons.size(); i++) {
			// THIS CODE IS TO ADD ALL HOTELS TO FAVOURITES
			if (hearticons.get(i).isDisplayed() == true) {
				System.out.println("Index: "+i+" "+hearticons.get(i).isDisplayed());
				clickheart(hearticons.get(i), driver);
				Thread.sleep(1000);
			}

			else {
				System.out.println("Index: "+i+" "+hearticons.get(i).isDisplayed());
				clickslider(nxtslidericon, driver);
				clickheart(hearticons.get(i), driver);
			}

			Thread.sleep(1000);
		}

	}

//	public void playaboutusvideo() { 
//		scrollintoviewaboutuscontainer(containeraboutus, driver);
//		Actions clickaboutusvideo = new Actions(driver);
//		clickaboutusvideo.moveToElement(aboutusvideobtn).click(aboutusvideobtn).build().perform();
//		//System.out.println("About us video button visibility: "+aboutusvideobtn.isDisplayed());
//		
//	}

	public String sendsmsapplink(String phone) {
		WebElement downloadourapp = driver.findElement(By.xpath("//section[@id='contact']"));
		scrollintoviewdownloadourapp(downloadourapp, driver);
		smslinkinput.sendKeys(phone);
		sendsmsapplinkbtn.click();
		String actual_message = smslinkinput.getAttribute("innerHTML");
		return actual_message; 
	}

	public String sendemailapplink(String email) {
		WebElement downloadourapp = driver.findElement(By.xpath("//section[@id='contact']"));
		scrollintoviewdownloadourapp(downloadourapp, driver);
		emaillinkinput.sendKeys(email);
		sendemailapplinkbtn.click();
		String actual_message = emaillinkinput.getAttribute("innerHTML");
		return actual_message;
	}

	public String clickgoogleplay() {
		parent = driver.getWindowHandle(); 
		playstorelink.click();
		Set<String>allhandles=driver.getWindowHandles();	  
        Iterator<String> it = allhandles.iterator();
        while(it.hasNext()==true)
        {
        	child = it.next();
        	if(!parent.equalsIgnoreCase(child))
        	{
        		//System.out.println("CHILD WINDOW ID: " +child);
        		driver.switchTo().window(child);
        	}
        }
        return driver.getTitle();
	}

	public String clickappstore() {
		parent = driver.getWindowHandle();
		appstore.click();
		Set<String>allhandles=driver.getWindowHandles();	  
        Iterator<String> it = allhandles.iterator();
        while(it.hasNext()==true)
        {
        	child = it.next();
        	if(!parent.equalsIgnoreCase(child))
        	{
        		//System.out.println("CHILD WINDOW ID: " +child);
        		driver.switchTo().window(child);
        	}
        }
        return driver.getTitle();
	}

	public void sendsubscriptionemail(String email)

	{
		subscribeemailinput.sendKeys(email);
		subscribebtn.click();
	}

	public FAQPage clickFAQlink()

	{
		FAQlnk.click();
		return new FAQPage();
	}

	public ContactUs clickContactuslink()

	{
		ContactUslnk.click();
		return new ContactUs();
	}

	public PartnerwithUsPage clickPartnerwithuslink()

	{
		PartnerWithUslnk.click();
		return new PartnerwithUsPage();
	}

	public boolean clickTandClink()

	{
		TandClnk.click();
		return TandCpagelabel.isDisplayed(); 

	}

	public boolean clickPrivacypolicylink()

	{
		Privacypolicylnk.click();
        return privacypolicylabel.isDisplayed(); 
	}

	public String clickInstasociallink()

	{
		parent = driver.getWindowHandle();
//		Instasocial.click();
        hitInstasociallink(Instasocial, driver);
        Set<String>allhandles=driver.getWindowHandles();	  
        Iterator<String> it = allhandles.iterator();
        while(it.hasNext()==true)
        {
        	child = it.next();
        	if(!parent.equalsIgnoreCase(child))
        	{
        		//System.out.println("CHILD WINDOW ID: " +child);
        		driver.switchTo().window(child);
        	}
        }
        return driver.getTitle();
	}

	public String clickFBsociallink()

	{
		parent = driver.getWindowHandle();
//		Facebooksocial.click();
		hitFbsociallink(Facebooksocial, driver);
		Set<String>allhandles=driver.getWindowHandles();	  
        Iterator<String> it = allhandles.iterator();
        while(it.hasNext()==true)
        {
        	child = it.next();
        	if(!parent.equalsIgnoreCase(child))
        	{
        		//System.out.println("CHILD WINDOW ID: " +child);
        		driver.switchTo().window(child);
        	}
        }
        return driver.getTitle();
	}

}
