package com.qa.BDO.pages;

import java.util.Properties;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.BDO.factory.BDO_PlaywrightFactory;

public class BDO_Login{
	
	    Page page;

		Playwright playwright;
		Properties prop;
		BDO_PlaywrightFactory bwf;
		protected BDO_Login login;
		protected BDO_MyAccounts accounts;
	
	public BDO_Login(Page page)
	{
		this.page = page;
	}
	
	
	public void logintoApp(String username,String password)
	{
	    page.locator("input#username").fill(username);
		page.locator("input#password").fill(password);
		page.locator("input[name=login]").click();
	    page.waitForLoadState();
	}
	
	public String  Loginwithemptyusername()
	
	{
	 
		String InlineErrorusername = page.locator("//*[@id=\"username-validation-msg\"]").textContent();
		page.waitForLoadState();
		System.out.println("Inline_error:" +  InlineErrorusername);
		
		return InlineErrorusername;				
		
	}
	

	public String  Loginwithemptypassword()
	
	{
	 
	    String InlineErrorpassword = page.locator("//*[@id=\"password-validation-msg\"]").textContent();
	    System.out.println("Inline_error:" +  InlineErrorpassword);
		return InlineErrorpassword;
				
		
	}
	
 public String  Loginwithbothempty()

{	
	String InlineErrorusername = page.locator("//*[@id=\"username-validation-msg\"]").textContent();
 String InlineErrorpassword = page.locator("//*[@id=\"password-validation-msg\"]").textContent();
 String BothinlineErros = (InlineErrorusername + ' '+ "and" + ' '+ InlineErrorpassword);
 System.out.println("Inline_error:" +  InlineErrorusername + ' ' + "," + ' '+ InlineErrorpassword);

	return BothinlineErros;			
	
}
 
 
 public String  LoginwithInvalidUsernameandPassword()

{	
	String BDOLoginErroronHeader = page.locator("//*[@id=\"ss-error-msg\"]/div/div/div[2]/label").textContent();
 System.out.println("The Header_error is :" +  BDOLoginErroronHeader);
 boolean Icon= page.locator("//*[@id=\"ss-error-msg\"]/div/div/div[1]/span").isVisible();
 System.out.println("The error icon is displayed before error:" + Icon);
 
	return BDOLoginErroronHeader;
}
	


 public String  Loginaftersessionisexpired()

{	
	String BDOLoginErroronHeader = page.locator("//*[@id=\"ss-error-msg\"]/div/div/div[2]/label").textContent();
 System.out.println("The error when user click Login, after session out:" +  BDOLoginErroronHeader);
 boolean Icon= page.locator("//*[@id=\"ss-error-msg\"]/div/div/div[1]/span").isVisible();
 System.out.println("The error icon is displayed before error:" +Icon);
 
	return BDOLoginErroronHeader;
	
}
	

 public String  LoginwhenAttemptsExhausted()

{ 	
	String BDOLoginErroronHeader1 = page.locator("//*[@id=\"ss-error-msg\"]/div/div/div[2]/label").textContent();
 System.out.println("The Header_error:" +  BDOLoginErroronHeader1);
 boolean Icon= page.locator("//*[@id=\"ss-error-msg\"]/div/div/div[1]/span").isVisible();
 System.out.println("The error icon is displayed before error:" +Icon);
	return BDOLoginErroronHeader1;
}



 public String ValidateLoginSuccess()
{
	
 String PageHeader = page.locator("div.user-context-menu-info__name:has-text('BBNDB001')").textContent();
 System.out.println("The Page title after login is:" + page.title());
 return PageHeader;
	
}


 public String EnterOTP(String OTP)
{
	
 page.locator("text=Try another method").first().click();
 page.locator("text =Text me a One-Time PIN").click();
 page.locator("#bb-otp-field").fill(OTP);
 page.locator("//*[@id=\"bdo-verify-otp-form\"]/div/div/div/div[3]/div/button").click(); 
 page.waitForLoadState();
 if(page.locator("a:text('Continue')").isVisible()!= true )
 {
     
	 System.out.println("The Page title after login is:" + page.title());
       
 }
 else {
	 String text=  page.locator("a:text('Continue')").textContent();
     System.out.println(text);
	 page.locator("a:text('Continue')").click();
 }
 return OTP;
}
 
 
 public BDO_MyAccounts navigateToMyAccountsMoreTab()
 {
 	 
 	logintoApp("BBNDB001","Password@022");
 	EnterOTP("123456");
 	page.locator("a#bb-menu-header-button-transfers:has-text('More')").click();
	 	String Tab_name = page.locator("a#bb-menu-header-button-transfers:has-text('More')").textContent();
	    System.out.println(Tab_name);
 	return new BDO_MyAccounts(page);
 	
 }
}
