package com.qa.BDO.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BDO_MyAccounts{
	
   private final Page page;
   public BDO_MyAccounts(Page page)
	{
		this.page=page;
	}
	

	
	protected BDO_Login login;
	protected BDO_MyAccounts accounts;
	protected BDO_ManageProfile profile;
	
	
	public BDO_ManageProfile NavigateToUpdateProfile()
	{
	    page.locator("div.bb-layout__bb-horizontal-nav-submenu-title:has-text('Update Profile')").click();
	   String profile_Label=page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Update Profile")).textContent();
	   System.out.println("The header is:" +  profile_Label);
	    return new BDO_ManageProfile(page);
	  
	}
	
	public void VerifyMoreTab()
	{
		
		 Locator locator_label = page.locator("div.bb-layout__bb-horizontal-nav-submenu-title:has-text('Update Profile')");
		 Locator locator_Subtext = page.locator("div.bb-layout__horizontal-nav-submenu-description:has-text('Update your personal information')");
		 
	    if( locator_label.isVisible())
	    {
	    	System.out.println("The Label is:" +  locator_label.textContent());
	    }
	    if( locator_Subtext.isVisible()) {
		 System.out.println("The Subtext is:" +  locator_Subtext.textContent());}
	    else
	    {System.out.println("The Subtext isnot visible");}
	    boolean Icon= page.locator("em.bb-icon bb-icon-user-profile bb-icon--sm").isVisible();
	    if(Icon==true) 
	    {
	    System.out.println("The icon is displayed:" +Icon);
	    }
	    else
	    {
	        System.out.println("The icon is not displayed");
	    }
	}

}
