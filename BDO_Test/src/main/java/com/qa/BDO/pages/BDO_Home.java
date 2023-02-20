package com.qa.BDO.pages;

import com.microsoft.playwright.Page;

public class BDO_Home {
	

    private Page page;
    
	private String BDOheader = "h1#kc-page-title";
	private String BDOLabel1 = "(//label[normalize-space()='Username'])[1]";
	private String BDOinputBox1 = "(//input[@id='username'])[1]";
	private String BDOinputBox2 = "(//input[@id='password'])[1]";
	private String BDOsbbutton = "(//input[@id='kc-login'])[1]";
	private String BDOLabel3 = "(//div[@class='bb-highlight bb-block bb-block--sm bb-text-align-center--sm-down bb-input-info-message'])[1]";
	private String BDOlink1 = "(//a[normalize-space()=\"I'd like to get my username\"])[1]";
	private String BDOlink2 ="(//a[normalize-space()=\"I'd like to reset my password\"])[1]";
	private String BDOOldLoginlink ="(//a[normalize-space()='Log in to the old Online Banking website'])[1]"; 
			
			
	

	public BDO_Home(Page page)
	{
		this.page = page;
	}
	
	public String getHomePageTitle()
	{
		return page.title();
	}
	
	public String getHomePageurl()
	{
		return page.url();
	}
	
	public void verifyLogo()
	{
		boolean logo=page.locator("(//div[@class='bb-stack__item identity-logo bb-block bb-block--lg'])[1]").isEnabled();
		System.out.println("The logo is visible: " + logo);
		
	}
	
	
	public String GetHomePageComponenets()
	{
		String firstlabel = page.locator(BDOheader).textContent();	
		System.out.println("Application header name is:"+ firstlabel.trim());
		
		String inputBox1 = page.locator(BDOinputBox1).textContent();	
		System.out.println("Application first inputbox name is:"+ inputBox1.trim());
		
		String inputBox2 = page.locator(BDOinputBox2).textContent();	
		System.out.println("Application second inputbox name is:"+ inputBox2.trim());
		
		String sbbutton = page.locator(BDOsbbutton).textContent();
		System.out.println("Name of Button on home page is:"+ sbbutton.trim());
		
		String Label3 = page.locator(BDOLabel3).textContent();	
		System.out.println("Application third label name is:"+ Label3.trim());
		
		String link1 = page.locator(BDOlink1).textContent();	
		System.out.println("First link on home page is:"+ link1.trim());
		
		String link2 = page.locator(BDOlink2).textContent();	
		System.out.println("First link on home page is:"+ link2.trim());
		
		String OldLoginlink = page.locator(BDOOldLoginlink).textContent();
		System.out.println("Old login link name is:"+ OldLoginlink.trim());
		
		return page.locator(BDOLabel1).first().textContent();
		
		
	}

}
