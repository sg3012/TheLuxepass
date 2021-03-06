// This class is designed to automate the signup flow on Luxepass
package com.luxepass.qa.pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;
import javax.activation.*;
import javax.mail.Folder;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.luxepass.qa.base.TestBase;
import com.luxepass.qa.util.TestUtil;

public class SignUppage extends TestBase {

	// PAGE OBJECT REPO :
	String OTP;
	String result;
	String text;
	String html;
	@FindBy(xpath = "//span[contains(text(), 'Login / Signup')]")
	WebElement loginsignupbtn;

	@FindBy(xpath = "//span[@class='click-login' and text()='Signup']")
	WebElement signuplink;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstnameinput;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastnameinput;

	@FindBy(xpath = "//div[@class='control ']//input[@name='email']")
	WebElement emailinput;

	@FindBy(xpath = "//div[@class='show_pass_login']//parent::div[@class='control']//child::input[@name='password']")
	WebElement enterpasswordinput;

	@FindBy(xpath = "//div[@class='show_pass_login']//parent::div[@class='control']//child::input[@name='confirmpassword']")
	WebElement enterconfirmpasswordinput;

	@FindBy(xpath = "//label[@for='box-1']")
	WebElement tandccheckbox;

	@FindBy(xpath = "//button[@type='submit' and text()='Signup']")
	WebElement signupbtn;

	@FindBy(xpath = "//label[text()='I agree to ']//a[text()='Terms & Conditions']")
	WebElement tanclink;

	@FindBy(xpath = "//a[text()='Verify Email']")
	WebElement verifyemaillink;

	@FindBy(xpath = "//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[contains(@class,'pop-num-form')]//div[contains(@class,'verify-btn')]//preceding-sibling::div[contains(@class,'float-label')]//div[@class='control']//input[@name='email']")
	WebElement nonactiveemail;

	@FindBy(xpath = "//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[contains(@class,'pop-num-form')]//div[@class='control']//input[@formcontrolname='otp']")
	WebElement otpinput;

	@FindBy(xpath = "//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[contains(@class,'pop-num-form')]//div[contains(@class,'verify-btn')]//button[contains(text(),'Submit')]")
	WebElement verifyaccountsubmitbtn;
	@FindBy(xpath = "//a[text()='Resend code']")
	WebElement resendcodelink;

	@FindBy(xpath = "//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[contains(@class,'pop-num-form')]//div[contains(@class,'verify-btn')]//button[contains(text(),'Verify')]")
	WebElement verifybtn;

	@FindBy(xpath = "//div[@id='signUp']//div[@class='er_pop_wrapper']//p[@class='closed']//img[contains(@src,'assets/images')]")
	WebElement crossiconsignup;
	@FindBy(xpath = "//div[@id='verifyAccount ForgotPopUpOTPForm']//div[@class='er_pop_wrapper']//p[@class='closed']//img[contains(@src,'assets/images')]")
	WebElement crossiconverifyaccount;
	@FindBy(xpath = "//div[@id='logIn']//div[@class='er_pop_wrapper']//p[@class='closed']//img[contains(@src,'assets/images')]")
	WebElement crossiconlogin;

	@FindBy(xpath = "//div[@id='changePassword']//div[@class='er_pop_wrapper']//p[@class='closed']//img[contains(@src,'assets/images')]")
	WebElement crossiconnonactiveemail;
	@FindBy(xpath = "//span[text()='Login' and @class='click-login']")
	WebElement loginlink;

	public void clickTandC_Checkbox(WebElement e, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e);
	}

	public void clickverifybutton(WebElement e, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e);
	}

	public SignUppage() { // For initializing the object of this page.
		PageFactory.initElements(driver, this);
	}

	public void clickcrossicononsignup() throws InterruptedException {
		loginsignupbtn.click();
		Thread.sleep(1200);
		signuplink.click();
		Thread.sleep(1200);
		crossiconsignup.click();
	}

	public void clickcrossicononlogin() throws InterruptedException {
		loginsignupbtn.click();
		Thread.sleep(1200);
		crossiconlogin.click();
	}

	public void clickcrossicononverifynonactiveemail() throws InterruptedException{
		loginsignupbtn.click();
		Thread.sleep(1200);
		signuplink.click();
		Thread.sleep(1200);
		verifyemaillink.click();
		Thread.sleep(1200);
		crossiconnonactiveemail.click();
	}

	public void clickcrossicononverifyaccount() throws InterruptedException {
		loginsignupbtn.click();
		Thread.sleep(1200);
		signuplink.click();
		Thread.sleep(1200);
		firstnameinput.sendKeys(prop.getProperty("firstname"));
		Thread.sleep(1200);
		lastnameinput.sendKeys(prop.getProperty("lastname"));
		Thread.sleep(1200);
		emailinput.sendKeys(prop.getProperty("Email"));
		Thread.sleep(1200);
		enterpasswordinput.sendKeys(prop.getProperty("password"));
		Thread.sleep(1200);
		enterconfirmpasswordinput.sendKeys(prop.getProperty("confirmpassword"));
		Thread.sleep(1200);
		clickTandC_Checkbox(tandccheckbox, driver);
		Thread.sleep(1200);
		signupbtn.click();
		Thread.sleep(1200);
		crossiconverifyaccount.click();
	}

//	public void clickverifyemaillink() {
//		verifyemaillink.click();
//	}

	public void clicktandclink() throws InterruptedException {
		loginsignupbtn.click();
		Thread.sleep(1200);
		signuplink.click();
		Thread.sleep(1200);
		tanclink.click();
	}
    
	// This method send and receive the signup OTP and completes the sign up process
	public LoginPage signup(String firstname, String lastname, String email, String password, String confirmpassword)
//	public HomePage signup()
			throws InterruptedException {

		OTP = null;
		result = null;
		text = null;
		html = null;
		int unreadmsgcount, temp;
		Folder folder = null;
		Store store = null;
		Message[] unreadmessages;
		Flags seen;
		FlagTerm unseenFlagTerm;
		BodyPart plaintextpart = null;
		BodyPart htmlpart = null;

		// Creating properties class object and Initializing all the properties for
		// receiving mail :
		Properties props = new Properties();
		props.put("mail.imap.auth", "true"); // Indicates whether the SMPT host or mail sever takes email and
												// password authentication or not.
		props.put("mail.imap.host", "imap.gmail.com"); // host name for the gmail SMTP server.
		props.put("mail.imap.port", "993"); // smtp port for gmail smtp server
		props.put("mail.store.protocol", "imaps"); // defines socketFactory port
		props.put("mail.transport.protocol", "imaps"); // defines socketFactory class
		props.put("mail.imap.starttls.enable", "true");
		// Creating sessions class Object :

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("passphrase"));
			}
		});

		try {
			// Creating store class object :
			store = session.getStore("imaps");

			// Connect to the imap server :
			store.connect("imap.gmail.com", email, password);

			// Create Folder class object of type "INBOX" :
			folder = store.getFolder("Inbox");

			// Open the folder in Read-write Only mode :
			folder.open(Folder.READ_WRITE);

			// Retrieve the Unseen messages in an array of type Message :
			seen = new Flags(Flags.Flag.SEEN);
			unseenFlagTerm = new FlagTerm(seen, false);
			unreadmessages = folder.search(unseenFlagTerm);

			System.out.println("Flags Supported by the folder: " + folder.getPermanentFlags());
//					System.out.println("Flags Supported by the system: " + flag.getSystemFlags().toString());
			unreadmsgcount = unreadmessages.length;
			temp = unreadmsgcount;
			System.out.println("INITIAL UNSEEN messages in Inbox: " + unreadmsgcount);

			loginsignupbtn.click();
			signuplink.click();
			firstnameinput.clear();
			firstnameinput.sendKeys(firstname);
			lastnameinput.clear();
			lastnameinput.sendKeys(lastname);
			emailinput.clear();
			emailinput.sendKeys(email);
			enterpasswordinput.clear();
			enterpasswordinput.sendKeys(password);
			enterconfirmpasswordinput.clear();
			enterconfirmpasswordinput.sendKeys(confirmpassword);

			clickTandC_Checkbox(tandccheckbox, driver);
//		Thread.sleep(1000); 

			signupbtn.click();
//		verifyemaillink.click(); 
//		nonactiveemail.sendKeys(prop.getProperty("Email"));
//		verifyaccountsubmitbtn.click();
//		Thread.sleep(240000);
			wait = new WebDriverWait(driver, TestUtil.implicitWait);
			verifybtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[@class='pop-num-form ng-untouched ng-pristine ng-invalid']//button[text()='Verify']")));
			// TODO Auto-generated method stub
			while (unreadmsgcount == temp) {
				System.out.println("INSIDE COUNT LOOP");
				folder.close(); /*
								 * These 2 steps are done to refresh count of messages in the folder
								 */
				folder.open(Folder.READ_WRITE);
				unreadmessages = folder.search(unseenFlagTerm);
				unreadmsgcount = unreadmessages.length;
			}
			System.out.println("Total UNSEEN in Inbox: " + unreadmsgcount);

			// Traverse the array and print all the messages :
			if (unreadmsgcount > 0) {
				for (int i = unreadmsgcount - 1; i > (unreadmsgcount - 3); i--) {
					// Create a separate message for each message in the messages[] array above :
					Message message = unreadmessages[i];
					System.out.println("Flags supported by this message: " + message.getFlags());
					// Printing the msg subject, number, Sender :
					System.out.println("------------------------------");
					System.out.println("Email number: " + (i + 1));
					System.out.println("Sender:" + message.getFrom()[0]);
					System.out.println("Subject: " + message.getSubject());
//						System.out.println("Content: " + message.getContent().toString());

					System.out.println("Date: " + message.getReceivedDate());
					System.out.println("Reply-to: " + message.getReplyTo()[0].toString());

					while (text == null) {
						if (message instanceof MimeMessage && message.getSubject().equals("Verify your account")
								&& message.getReplyTo()[0].toString()
										.equals("The LuxePass <customersupport@theluxepass.com>")) {
							MimeMessage m = (MimeMessage) message;
							Object o = m.getContent();
							if (o instanceof Multipart) {
								System.out.println("------MULIPARTS INVLOVED-----------------------");
								Multipart mp = (Multipart) o;
								int mpcount = mp.getCount();
								System.out.println("MULTIPARTS COUNT: " + mpcount);
								for (int j = 0; j < mpcount; j++) {
									BodyPart bp = mp.getBodyPart(j); // Storing the bodypart content at index "j" of a
																		// multipart inside
																		// Bodypart reference variable.

									if (bp.isMimeType("text/html")) { // Checking if the concerned BODYPART MimeType is
																		// HTML or not
										System.out.println("HTML PART: ");
										System.out.println("Content at BodyPart: " + j);
										htmlpart = bp;
										html = (String) htmlpart.getContent();
										System.out.println("HTML PART CONVERTED TO TEXT: " + html);

									} else if (bp.isMimeType("text/plain")) { // Checking if the concerned BODYPART
																				// MimeType is PLAIN TEXT or not
										System.out.println("PLAIN TEXT PART: ");
										System.out.println("Content at BodyPart: " + j);
										plaintextpart = bp;
										text = (String) plaintextpart.getContent();
										System.out.println("TEXT PART: " + text);
									}

									else if (o instanceof String) // If the content of the message is a simple text
																	// message.
									{
										result = (String) o;
									}
								}

							}
							Pattern pattern = Pattern.compile("[0-9]+");
							Matcher matcher = pattern.matcher(text);
							while (matcher.find() == true) {
								OTP = matcher.group();
							}
						}

						else {
							System.out.println("-----------DESIRED SUBJECT NOT FOUND ----------------------------");
						}
						break;
					}
				}
			} else {
				System.out.println("MESSAGE WITH NEW FLAG NOT FOUND");
			}

			System.out.println("OTP: " + OTP);
			folder.close();
			store.close();
		}

		catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		catch (MessagingException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Verify button visibility: " + verifybtn.isDisplayed());
		otpinput.clear();
		otpinput.sendKeys(OTP);
		clickverifybutton(verifybtn, driver);
		return new LoginPage();

	}

	public LoginPage resendcode(String firstname, String lastname, String email, String password,
			String confirmpassword)
//public HomePage signup()
			throws InterruptedException {

		OTP = null;
		result = null;
		text = null;
		html = null;
		int unreadmsgcount, temp;
		Folder folder = null;
		Store store = null;
		Message[] unreadmessages;
		Flags seen;
		FlagTerm unseenFlagTerm;
		BodyPart plaintextpart = null;
		BodyPart htmlpart = null;

		// Creating properties class object and Initializing all the properties for
		// receiving mail :
		Properties props = new Properties();
		props.put("mail.imap.auth", "true"); // Indicates whether the SMPT host or mail sever takes email and
												// password authentication or not.
		props.put("mail.imap.host", "imap.gmail.com"); // host name for the gmail SMTP server.
		props.put("mail.imap.port", "993"); // smtp port for gmail smtp server
		props.put("mail.store.protocol", "imaps"); // defines socketFactory port
		props.put("mail.transport.protocol", "imaps"); // defines socketFactory class
		props.put("mail.imap.starttls.enable", "true");
		// Creating sessions class Object :

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("passphrase"));
			}
		});

		try {
			// Creating store class object :
			store = session.getStore("imaps");

			// Connect to the imap server :
			store.connect("imap.gmail.com", prop.getProperty("username"), prop.getProperty("passphrase"));

			// Create Folder class object of type "INBOX" :
			folder = store.getFolder("Inbox");

			// Open the folder in Read Only mode :
			folder.open(Folder.READ_WRITE);

			// Retrieve the Unseen messages in an array of type Message :
			seen = new Flags(Flags.Flag.SEEN);
			unseenFlagTerm = new FlagTerm(seen, false);
			unreadmessages = folder.search(unseenFlagTerm);

			System.out.println("Flags Supported by the folder: " + folder.getPermanentFlags());
//				System.out.println("Flags Supported by the system: " + flag.getSystemFlags().toString());
			unreadmsgcount = unreadmessages.length;
			temp = unreadmsgcount;
			System.out.println("INITIAL UNSEEN messages in Inbox: " + unreadmsgcount);

			loginsignupbtn.click();
			signuplink.click();
			firstnameinput.sendKeys(firstname);
			lastnameinput.sendKeys(lastname);
			emailinput.sendKeys(email);
			enterpasswordinput.sendKeys(password);
			enterconfirmpasswordinput.sendKeys(confirmpassword);

			clickTandC_Checkbox(tandccheckbox, driver);
//	Thread.sleep(1000); 

			signupbtn.click();

			while (unreadmsgcount == temp) {
				System.out.println("INSIDE COUNT LOOP 1");
				folder.close(); /*
								 * These 2 steps are done to refresh count of messages in the folder
								 */
				Thread.sleep(1200);
				folder.open(Folder.READ_WRITE);

				unreadmessages = folder.search(unseenFlagTerm);
				unreadmsgcount = unreadmessages.length;
			}
			System.out.println("TOTAL UNSEEN MSGS COUNT AFTER COUNT LOOP1 : " + unreadmsgcount);
			Thread.sleep(6000);
			unreadmsgcount = temp;

			resendcodelink.click();
			Thread.sleep(10000);
//	verifyemaillink.click(); 
//	nonactiveemail.sendKeys(prop.getProperty("Email"));
//	verifyaccountsubmitbtn.click();
//	Thread.sleep(240000);
			wait = new WebDriverWait(driver, TestUtil.implicitWait);
			verifybtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[@class='pop-num-form ng-untouched ng-pristine ng-invalid']//button[text()='Verify']")));
			// TODO Auto-generated method stub
			while (unreadmsgcount == temp) {
				System.out.println("INSIDE COUNT LOOP 2");
				folder.close(); /*
								 * These 2 steps are done to refresh count of messages in the folder
								 */
				folder.open(Folder.READ_WRITE);
				Thread.sleep(1200);
				unreadmessages = folder.search(unseenFlagTerm);
				unreadmsgcount = unreadmessages.length;
			}
			System.out.println("Total UNSEEN in Inbox: " + unreadmsgcount);

			// Traverse the array and print all the messages :
			if (unreadmsgcount > 0) {
				for (int i = unreadmsgcount - 1; i > (unreadmsgcount - 3); i--) {
					// Create a separate message for each message in the messages[] array above :
					Message message = unreadmessages[i];
					System.out.println("Flags supported by this message: " + message.getFlags());
					// Printing the msg subject, number, Sender :
					System.out.println("------------------------------");
					System.out.println("Email number: " + (i + 1));
					System.out.println("Sender:" + message.getFrom()[0]);
					System.out.println("Subject: " + message.getSubject());
//					System.out.println("Content: " + message.getContent().toString());

					System.out.println("Date: " + message.getReceivedDate());
					System.out.println("Reply-to: " + message.getReplyTo()[0].toString());

					while (text == null) {
						if (message instanceof MimeMessage && message.getSubject().equals("Verify your account")
								&& message.getReplyTo()[0].toString()
										.equals("The LuxePass <customersupport@theluxepass.com>")) {
							MimeMessage m = (MimeMessage) message;
							Object o = m.getContent();
							if (o instanceof Multipart) {
								System.out.println("------MULIPARTS INVLOVED-----------------------");
								Multipart mp = (Multipart) o;
								int mpcount = mp.getCount();
								System.out.println("MULTIPARTS COUNT: " + mpcount);
								for (int j = 0; j < mpcount; j++) {
									BodyPart bp = mp.getBodyPart(j); // Storing the bodypart content at index "j" of a
																		// multipart inside
																		// Bodypart reference variable.

									if (bp.isMimeType("text/html")) { // Checking if the concerned BODYPART MimeType is
																		// HTML or not
										System.out.println("HTML PART: ");
										System.out.println("Content at BodyPart: " + j);
										htmlpart = bp;
										html = (String) htmlpart.getContent();
										System.out.println("HTML PART CONVERTED TO TEXT: " + html);

									} else if (bp.isMimeType("text/plain")) { // Checking if the concerned BODYPART
																				// MimeType is PLAIN TEXT or not
										System.out.println("PLAIN TEXT PART: ");
										System.out.println("Content at BodyPart: " + j);
										plaintextpart = bp;
										text = (String) plaintextpart.getContent();
										System.out.println("TEXT PART: " + text);
									}

									else if (o instanceof String) // If the content of the message is a simple text
																	// message.
									{
										result = (String) o;
									}
								}

							}
							Pattern pattern = Pattern.compile("[0-9]+");
							Matcher matcher = pattern.matcher(text);
							while (matcher.find() == true) {
								OTP = matcher.group();
							}
						}

						else {
							System.out.println("-----------DESIRED SUBJECT NOT FOUND ----------------------------");
						}
						break;
					}
				}
			} else {
				System.out.println("MESSAGE WITH NEW FLAG NOT FOUND");
			}

			System.out.println("OTP: " + OTP);
			folder.close();
			store.close();
		}

		catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		catch (MessagingException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

//		System.out.println("Verify button visibility: " + verifybtn.isDisplayed());
//		otpinput.sendKeys(OTP);
//		clickverifybutton(verifybtn, driver);	
		return new LoginPage();
	}

	public LoginPage resendcode(String email)
//public HomePage signup()
			throws InterruptedException {

		OTP = null;
		result = null;
		text = null;
		html = null;
		int unreadmsgcount, temp;
		Folder folder = null;
		Store store = null;
		Message[] unreadmessages;
		Flags seen;
		FlagTerm unseenFlagTerm;
		BodyPart plaintextpart = null;
		BodyPart htmlpart = null;

		// Creating properties class object and Initializing all the properties for
		// receiving mail :
		Properties props = new Properties();
		props.put("mail.imap.auth", "true"); // Indicates whether the SMPT host or mail sever takes email and
												// password authentication or not.
		props.put("mail.imap.host", "imap.gmail.com"); // host name for the gmail SMTP server.
		props.put("mail.imap.port", "993"); // smtp port for gmail smtp server
		props.put("mail.store.protocol", "imaps"); // defines socketFactory port
		props.put("mail.transport.protocol", "imaps"); // defines socketFactory class
		props.put("mail.imap.starttls.enable", "true");
		// Creating sessions class Object :

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("passphrase"));
			}
		});

		try {
			// Creating store class object :
			store = session.getStore("imaps");

			// Connect to the imap server :
			store.connect("imap.gmail.com", prop.getProperty("username"), prop.getProperty("passphrase"));

			// Create Folder class object of type "INBOX" :
			folder = store.getFolder("Inbox");

			// Open the folder in Read Only mode :
			folder.open(Folder.READ_WRITE);

			// Retrieve the Unseen messages in an array of type Message :
			seen = new Flags(Flags.Flag.SEEN);
			unseenFlagTerm = new FlagTerm(seen, false);
			unreadmessages = folder.search(unseenFlagTerm);

			System.out.println("Flags Supported by the folder: " + folder.getPermanentFlags());
//				System.out.println("Flags Supported by the system: " + flag.getSystemFlags().toString());
			unreadmsgcount = unreadmessages.length;
			temp = unreadmsgcount;
			System.out.println("INITIAL UNSEEN messages in Inbox: " + unreadmsgcount);

			loginsignupbtn.click();
			signuplink.click();
			firstnameinput.sendKeys(prop.getProperty("firstname"));
			lastnameinput.sendKeys(prop.getProperty("firstname"));
			emailinput.sendKeys(prop.getProperty("Email"));
			enterpasswordinput.sendKeys(prop.getProperty("password"));
			enterconfirmpasswordinput.sendKeys(prop.getProperty("confirmpassword"));
			clickTandC_Checkbox(tandccheckbox, driver);
//	Thread.sleep(1000); 

			signupbtn.click();

			while (unreadmsgcount == temp) {
				System.out.println("INSIDE COUNT LOOP 1");
				folder.close(); /*
								 * These 2 steps are done to refresh count of messages in the folder
								 */
				Thread.sleep(1200);
				folder.open(Folder.READ_WRITE);

				unreadmessages = folder.search(unseenFlagTerm);
				unreadmsgcount = unreadmessages.length;
			}
			System.out.println("TOTAL UNSEEN MSGS COUNT AFTER COUNT LOOP1 : " + unreadmsgcount);
			Thread.sleep(6000);
			unreadmsgcount = temp;
			crossiconsignup.click();
			loginsignupbtn.click();
			signuplink.click();
			verifyemaillink.click();
			nonactiveemail.sendKeys(prop.getProperty("Email"));
			verifyaccountsubmitbtn.click();
			resendcodelink.click();
			Thread.sleep(10000);

			wait = new WebDriverWait(driver, TestUtil.implicitWait);
			verifybtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[@class='pop-num-form ng-untouched ng-pristine ng-invalid']//button[text()='Verify']")));

			// TODO Auto-generated method stub
			while (unreadmsgcount == temp) {
				System.out.println("INSIDE COUNT LOOP 2");
				folder.close(); /*
								 * These 2 steps are done to refresh count of messages in the folder
								 */
				Thread.sleep(1200);
				folder.open(Folder.READ_WRITE);

				unreadmessages = folder.search(unseenFlagTerm);
				unreadmsgcount = unreadmessages.length;
			}
			System.out.println("TOTAL UNSEEN MSGS COUNT AFTER COUNT LOOP2 : " + unreadmsgcount);

			// Traverse the array and print all the messages :
			if (unreadmsgcount > 0) {
				for (int i = unreadmsgcount - 1; i > (unreadmsgcount - 3); i--) {
					// Create a separate message for each message in the messages[] array above :
					Message message = unreadmessages[i];
					System.out.println("Flags supported by this message: " + message.getFlags());
					// Printing the msg subject, number, Sender :
					System.out.println("------------------------------");
					System.out.println("Email number: " + (i + 1));
					System.out.println("Sender:" + message.getFrom()[0]);
					System.out.println("Subject: " + message.getSubject());
//					System.out.println("Content: " + message.getContent().toString());

					System.out.println("Date: " + message.getReceivedDate());
					System.out.println("Reply-to: " + message.getReplyTo()[0].toString());

					while (text == null) {
						if (message instanceof MimeMessage && message.getSubject().equals("Verify your account")
								&& message.getReplyTo()[0].toString()
										.equals("The LuxePass <customersupport@theluxepass.com>")) {
							MimeMessage m = (MimeMessage) message;
							Object o = m.getContent();
							if (o instanceof Multipart) {
								System.out.println("------MULIPARTS INVLOVED-----------------------");
								Multipart mp = (Multipart) o;
								int mpcount = mp.getCount();
								System.out.println("MULTIPARTS COUNT: " + mpcount);
								for (int j = 0; j < mpcount; j++) {
									BodyPart bp = mp.getBodyPart(j); // Storing the bodypart content at index "j" of a
																		// multipart inside
																		// Bodypart reference variable.

									if (bp.isMimeType("text/html")) { // Checking if the concerned BODYPART MimeType is
																		// HTML or not
										System.out.println("HTML PART: ");
										System.out.println("Content at BodyPart: " + j);
										htmlpart = bp;
										html = (String) htmlpart.getContent();
										System.out.println("HTML PART CONVERTED TO TEXT: " + html);

									} else if (bp.isMimeType("text/plain")) { // Checking if the concerned BODYPART
																				// MimeType is PLAIN TEXT or not
										System.out.println("PLAIN TEXT PART: ");
										System.out.println("Content at BodyPart: " + j);
										plaintextpart = bp;
										text = (String) plaintextpart.getContent();
										System.out.println("TEXT PART: " + text);
									}

									else if (o instanceof String) // If the content of the message is a simple text
																	// message.
									{
										result = (String) o;
									}
								}

							}
							Pattern pattern = Pattern.compile("[0-9]+");
							Matcher matcher = pattern.matcher(text);
							while (matcher.find() == true) {
								OTP = matcher.group();
							}
						}

						else {
							System.out.println("-----------DESIRED SUBJECT NOT FOUND ----------------------------");
						}
						break;
					}
				}
			} else {
				System.out.println("MESSAGE WITH NEW FLAG NOT FOUND");
			}

			System.out.println("OTP: " + OTP);
			folder.close();
			store.close();
		}

		catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		catch (MessagingException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Verify button visibility: " + verifybtn.isDisplayed());
		otpinput.sendKeys(OTP);
		clickverifybutton(verifybtn, driver);
		return new LoginPage();
	}

	public LoginPage verifynonactiveemail(String firstname, String lastname, String email, String password,
			String confirmpassword)
			throws InterruptedException {

		OTP = null;
		result = null;
		text = null;
		html = null;
		int unreadmsgcount, temp;
		Folder folder = null;
		Store store = null;
		Message[] unreadmessages;
		Flags seen;
		FlagTerm unseenFlagTerm;
		BodyPart plaintextpart = null;
		BodyPart htmlpart = null;

		// Creating properties class object and Initializing all the properties for
		// receiving mail :
		Properties props = new Properties();
		props.put("mail.imap.auth", "true"); // Indicates whether the SMPT host or mail sever takes email and
												// password authentication or not.
		props.put("mail.imap.host", "imap.gmail.com"); // host name for the gmail SMTP server.
		props.put("mail.imap.port", "993"); // smtp port for gmail smtp server
		props.put("mail.store.protocol", "imaps"); // defines socketFactory port
		props.put("mail.transport.protocol", "imaps"); // defines socketFactory class
		props.put("mail.imap.starttls.enable", "true");
		// Creating sessions class Object :

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("passphrase"));
			}
		});

		try {
			// Creating store class object :
			store = session.getStore("imaps");

			// Connect to the imap server :
			store.connect("imap.gmail.com", prop.getProperty("username"), prop.getProperty("passphrase"));

			// Create Folder class object of type "INBOX" :
			folder = store.getFolder("Inbox");

			// Open the folder in Read Only mode :
			folder.open(Folder.READ_WRITE);

			// Retrieve the Unseen messages in an array of type Message :
			seen = new Flags(Flags.Flag.SEEN);
			unseenFlagTerm = new FlagTerm(seen, false);
			unreadmessages = folder.search(unseenFlagTerm);

			System.out.println("Flags Supported by the folder: " + folder.getPermanentFlags());
//				System.out.println("Flags Supported by the system: " + flag.getSystemFlags().toString());
			unreadmsgcount = unreadmessages.length;
			temp = unreadmsgcount;
			System.out.println("INITIAL UNSEEN messages in Inbox: " + unreadmsgcount);

			loginsignupbtn.click();
			signuplink.click();
			firstnameinput.sendKeys(firstname);
			lastnameinput.sendKeys(lastname);
			emailinput.sendKeys(email);
			enterpasswordinput.sendKeys(password);
			enterconfirmpasswordinput.sendKeys(confirmpassword);

			clickTandC_Checkbox(tandccheckbox, driver);
//	Thread.sleep(1000); 

			signuplink.click();
			crossiconsignup.click();
			loginsignupbtn.click();
			signuplink.click();
			verifyemaillink.click();
			nonactiveemail.sendKeys(prop.getProperty("Email"));
			verifyaccountsubmitbtn.click();
			Thread.sleep(2000);
//	Thread.sleep(240000);
			wait = new WebDriverWait(driver, TestUtil.implicitWait);
			verifybtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//h2[text()='Verify Account']//parent::div[@class='login-heading']//following-sibling::form[@class='pop-num-form ng-untouched ng-pristine ng-invalid']//button[text()='Verify']")));
			// TODO Auto-generated method stub
			while (unreadmsgcount == temp) {
				System.out.println("INSIDE COUNT LOOP");
				folder.close(); /*
								 * These 2 steps are done to refresh count of messages in the folder
								 */
				folder.open(Folder.READ_WRITE);
				Thread.sleep(1200);
				unreadmessages = folder.search(unseenFlagTerm);
				unreadmsgcount = unreadmessages.length;
			}
			System.out.println("Total UNSEEN in Inbox: " + unreadmsgcount);

			// Traverse the array and print all the messages :
			if (unreadmsgcount > 0) {
				for (int i = unreadmsgcount - 1; i > (unreadmsgcount - 3); i--) {
					// Create a separate message for each message in the messages[] array above :
					Message message = unreadmessages[i];
					System.out.println("Flags supported by this message: " + message.getFlags());
					// Printing the msg subject, number, Sender :
					System.out.println("------------------------------");
					System.out.println("Email number: " + (i + 1));
					System.out.println("Sender:" + message.getFrom()[0]);
					System.out.println("Subject: " + message.getSubject());
//					System.out.println("Content: " + message.getContent().toString());

					System.out.println("Date: " + message.getReceivedDate());
					System.out.println("Reply-to: " + message.getReplyTo()[0].toString());

					while (text == null) {
						if (message instanceof MimeMessage && message.getSubject().equals("Verify your account")
								&& message.getReplyTo()[0].toString()
										.equals("The LuxePass <customersupport@theluxepass.com>")) {
							MimeMessage m = (MimeMessage) message;
							Object o = m.getContent();
							if (o instanceof Multipart) {
								System.out.println("------MULIPARTS INVLOVED-----------------------");
								Multipart mp = (Multipart) o;
								int mpcount = mp.getCount();
								System.out.println("MULTIPARTS COUNT: " + mpcount);
								for (int j = 0; j < mpcount; j++) {
									BodyPart bp = mp.getBodyPart(j); // Storing the bodypart content at index "j" of a
																		// multipart inside
																		// Bodypart reference variable.

									if (bp.isMimeType("text/html")) { // Checking if the concerned BODYPART MimeType is
																		// HTML or not
										System.out.println("HTML PART: ");
										System.out.println("Content at BodyPart: " + j);
										htmlpart = bp;
										html = (String) htmlpart.getContent();
										System.out.println("HTML PART CONVERTED TO TEXT: " + html);

									} else if (bp.isMimeType("text/plain")) { // Checking if the concerned BODYPART
																				// MimeType is PLAIN TEXT or not
										System.out.println("PLAIN TEXT PART: ");
										System.out.println("Content at BodyPart: " + j);
										plaintextpart = bp;
										text = (String) plaintextpart.getContent();
										System.out.println("TEXT PART: " + text);
									}

									else if (o instanceof String) // If the content of the message is a simple text
																	// message.
									{
										result = (String) o;
									}
								}

							}
							Pattern pattern = Pattern.compile("[0-9]+");
							Matcher matcher = pattern.matcher(text);
							while (matcher.find() == true) {
								OTP = matcher.group();
							}
						}

						else {
							System.out.println("-----------DESIRED SUBJECT NOT FOUND ----------------------------");
						}
						break;
					}
				}
			} else {
				System.out.println("MESSAGE WITH NEW FLAG NOT FOUND");
			}

			System.out.println("OTP: " + OTP);
			folder.close();
			store.close();
		}

		catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		catch (MessagingException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Verify button visibility: " + verifybtn.isDisplayed());
		otpinput.sendKeys(OTP);
		clickverifybutton(verifybtn, driver);

		return new LoginPage();
	}
}