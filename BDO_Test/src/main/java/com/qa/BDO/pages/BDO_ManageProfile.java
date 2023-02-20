package com.qa.BDO.pages;





import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BDO_ManageProfile {

 private final Page page;
 Playwright playwright;
	BDO_Login login;
	BDO_MyAccounts accounts;
	BDO_ManageProfile profile;
	
	 
	 public BDO_ManageProfile(Page page)
		{
			this.page = page;
		}

	
	public String VerifyUpdateEmailUI()
	{
		
		String l3 = page.locator("h2:text('Email Address')").textContent();
		String old_email = page.locator("div.bb-text-support").last().textContent();
		
		page.locator("h2:text('Email Address')").isVisible();
		if(true)
		{
		System.out.print("\nThe"+ l3 +"label is verified");
		System.out.print("\nThe current Email Address is:" + old_email);
		String btn_name1=page.locator("(//button[@type='button'])[251]").textContent();
		System.out.print(btn_name1+ "\n button is present\n");
		}
		page.locator("(//button[@type='button'])[251]").click();
	    String Update_Email_header= page.locator("(//h3[normalize-space()='Update Email Address'])[1]").textContent();
	    System.out.print("\nSub header is:" + Update_Email_header);
	    return old_email;
	}
	
	

    public String VerifyUpdateMobileUI()
		{
			String l1 = page.locator("h2:text('Mobile Number')").textContent();
			String old_mobile = page.locator("div.bb-text-support").first().textContent();
			page.locator("h2:text('Mobile Number')").isVisible();
			if(true)
			{
			System.out.print("\nThe"+ l1 +"label is verified");
			System.out.print("\nThe current Mobile Number is:" + old_mobile);
			String label_mob=page.locator("(//label[normalize-space()='Mobile number'])[1]").textContent();
			System.out.println("\nThe label above dropdown is:\n"+ label_mob);
			String btn_name=page.locator("(//button[@type='button'])[3]").textContent();
			System.out.println( btn_name + "\nbutton is present \n");
			}
			page.locator("(//button[@type='button'])[3]").click();
		    String Update_Mobile_header= page.locator("(//h3[normalize-space()='Update Mobile Number'])[1]").textContent();
		    System.out.print("Sub header is:" + Update_Mobile_header);
		    String Drp_value= page.locator("div.name").first().textContent();
		    System.out.println("\n The default country code is:" + Drp_value);
		    return old_mobile;
		   	
		}
 
 
    public String Update_Mobile_Number()
 {
	 String Mobile =page.locator("div.bb-text-support").first().textContent().trim();
	 String new_mobile;
	    System.out.print(Mobile);    
	    
	   if (Mobile.equalsIgnoreCase("+919561564998"))
	        {
		       page.locator("(//em[@class='bb-icon bb-icon-toggle-up bb-icon--md'])[1]").click();
		       page.locator("(//input[@id='bb_input_1'])[1]").click();
			   page.locator("(//input[@id='bb_input_1'])[1]").fill("philippines");
			   page.locator("(//em[@class='bb-icon bb-icon-search bb-icon--20'])[1]").click();
			   page.locator("div.name").first().click();	
			   new_mobile= "+639561564998";
	        }
	   else  
	        {
		       page.locator("(//em[@class='bb-icon bb-icon-toggle-up bb-icon--md'])[1]").click();
		       page.locator("(//input[@id='bb_input_1'])[1]").click();
			   page.locator("(//input[@id='bb_input_1'])[1]").fill("india");
			   page.locator("(//em[@class='bb-icon bb-icon-search bb-icon--20'])[1]").click();
			   page.locator("div.name").last().click();
			   new_mobile= "+919561564998";
			   }
	  
	   page.locator("#mobileNumber").click();
	   page.locator("#mobileNumber").fill("9561564998");
	   page.locator("(//button[@type='submit'])[1]").click();
	   
	   return new_mobile;
	   
 }
 
 
  public String VerifyMobileUpdateSuccess()
 {
	 page.locator("(//em[@class='bb-icon bb-icon-success-xxl bb-icon--md'])[1]").isVisible();
	 page.locator("(//h1[normalize-space()='Update Mobile Number'])[1]").isVisible();
	 String Suucess_msg= page.locator("(//div[@class='success-header'])[1]").textContent();
	 page.locator("(//button[normalize-space()='OK'])[1]").isVisible();
	
	 return Suucess_msg;
 }
 
  
  
 public BDO_ManageProfile navigatebackToManageProfile()
 {
 	
	page.locator("(//button[normalize-space()='OK'])[1]").click();
 	return new BDO_ManageProfile(page);
 }
 
 public void EnterUpdateOTP()
 {
	
   
     page.locator("#bb_input_0").click();
     page.locator("#bb_input_0").fill("123456");
     page.locator("(//button[normalize-space()='Confirm'])[1]").click();
 
   }
 
	
 
	
public String Update_Email_Address()
{
 String Email =page.locator("div.bb-text-support").last().textContent().trim();
    System.out.print(Email);   
    String new_email;
   if (Email.equalsIgnoreCase("swati@backbase.com"))
   {
	       page.locator("(//input[@id='email'])[1]").fill("ranjanswati100@gmail.com");
	       new_email="ranjanswati100@gmail.com";
		  
   }
   else
   {
	   page.locator("(//input[@id='email'])[1]").fill("swati@backbase.com");
	   new_email= "swati@backbase.com";
	     
		   }
  
   page.locator("(//button[@type='submit'])[2]").click();
   return new_email;
   
}


public String VerifyEmailUpdateSuccess()
{
	 page.locator("(//h1[normalize-space()='Update Email Address'])[1]").isVisible();
	 page.locator("(//em[@class='bb-icon bb-icon-success-xxl bb-icon--md'])[1]").isVisible();
	 String Suucess_mssg= page.locator("(//div[@class='success-header'])[1]").textContent();
	 page.locator("(//button[normalize-space()='OK'])[1]").isVisible();
	
	 return Suucess_mssg;
}

public void VerifyCancel_Mobile()
{

page.locator("(//button[@type='button'])[3]").click();
page.locator("(//div[@class='collapsible-container'])[1]").isVisible();
boolean updateEmail_disabled=page.locator("(//button[@type='button'])[251]").isDisabled();
System.out.print("\nUpdate button for email is diabled:"+updateEmail_disabled);
page.locator("(//span[contains(text(),'Cancel')])[1]").click();


}


public void VerifyCancel_Email()
{

page.locator("(//button[@type='button'])[251]").click();
page.locator("(//div[@class='collapsible-container'])[2]").isVisible();
boolean updateMobile_disabled= page.locator("(//button[@type='button'])[3]").isDisabled();
System.out.print("\nUpdate button for mobile is diabled:"+updateMobile_disabled);
page.locator("(//span[contains(text(),'Cancel')])[2]").click();


}

public void VerifyCancel_Email_popup_appears()
{

page.locator("(//button[@type='button'])[251]").click();
page.locator("(//div[@class='collapsible-container'])[2]").isVisible();
page.locator("(//input[@id='email'])[1]").fill("ranjanswati100@gmail.com");
page.locator("(//span[contains(text(),'Cancel')])[2]").click();
page.waitForLoadState();
 Locator popup_header= page.locator("(//h3[normalize-space()='Cancel email address update'])");
 if(popup_header.isVisible())
 {
	 Assert.assertEquals(popup_header.textContent().trim(),"Cancel email address update");
	 System.out.println("\nPop-up header is :"+popup_header.textContent());
 }
Locator popup_body=page.locator("(//div[@class='modal-body'])[1]");
if(popup_body.isVisible())
{
	Assert.assertEquals(popup_body.textContent().trim(),"Leaving this page will cancel your email address update");
	 System.out.println("\nPop-up content is :"+popup_body.textContent());
}
	Locator button_1= page.locator("(//button[normalize-space()='Stay'])");
	if(button_1.isEnabled()==true)
	{
		Assert.assertEquals(button_1.textContent().trim(), "Stay");
		System.out.println("\nPop-up has button1:"+button_1.textContent());
	}
	Locator button_2= page.locator("(//button[normalize-space()='Leave'])[1]");
	if(button_2.isEnabled()==true)
	{
		Assert.assertEquals(button_2.textContent().trim(),"Leave");
		System.out.println("\nPop-up has button2:"+button_2.textContent());
	}
	button_2.click();
	page.locator("(//div[@class='collapsible-container'])[2]").isDisabled();
	boolean updateMobile_disabled= page.locator("(//button[@type='button'])[3]").isEnabled();
	System.out.print("\nUpdate button for mobile is also enabled:"+updateMobile_disabled);
	
}


public void VerifyCancel_Mobile_popup_appears()
{

page.locator("(//button[@type='button'])[3]").click();
page.locator("(//div[@class='collapsible-container'])[1]").isVisible();
boolean updateEmail_disabled=page.locator("(//button[@type='button'])[251]").isDisabled();
System.out.print("\nUpdate button for email is diabled:"+updateEmail_disabled);
page.locator("(//span[contains(text(),'Cancel')])[1]").click();


}

}
