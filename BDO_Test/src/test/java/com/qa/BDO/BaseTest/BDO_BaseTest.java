package com.qa.BDO.BaseTest;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.BDO.API.BDO_Unlockuser;
import com.qa.BDO.API.BDO_Update_user_Profile;
import com.qa.BDO.factory.BDO_PlaywrightFactory;
import com.qa.BDO.pages.BDO_Home;
import com.qa.BDO.pages.BDO_Login;
import com.qa.BDO.pages.BDO_ManageProfile;
import com.qa.BDO.pages.BDO_MyAccounts;

public class BDO_BaseTest {
	

	BDO_PlaywrightFactory bwf;
    Page page;
	protected Properties prop;
	protected BDO_Login login;
	protected BDO_Home homepage;
	protected BDO_ManageProfile profile;
	protected BDO_Unlockuser unlock;
	protected BDO_Update_user_Profile upt_profile;
	protected BDO_MyAccounts accounts;
	Playwright playwright;
	BrowserContext brContext;

	@BeforeTest	
	public void setup() throws UnsupportedEncodingException 
	{
		bwf= new BDO_PlaywrightFactory();
		prop=bwf.init_prop();
		page=bwf.initBrowser(prop);
		homepage= new BDO_Home(page);
		login= new BDO_Login(page);		
		//profile= new BDO_ManageProfile(page);
		unlock= new BDO_Unlockuser();
		upt_profile = new BDO_Update_user_Profile();
	
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
		
	
		
	}


}
