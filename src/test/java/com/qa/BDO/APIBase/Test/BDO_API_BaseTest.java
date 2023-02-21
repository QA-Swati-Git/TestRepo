package com.qa.BDO.APIBase.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.BDO.API.BDO_Unlockuser;
import com.qa.BDO.API.BDO_Update_user_Profile;
import com.qa.BDO.factory.BDO_PlaywrightFactory;
import com.qa.BDO.pages.BDO_Home;
import com.qa.BDO.pages.BDO_Login;
import com.qa.BDO.pages.BDO_ManageProfile;
import com.qa.BDO.pages.BDO_MyAccounts;

public class BDO_API_BaseTest extends BDO_Unlockuser{

	private Playwright playwright;
    private APIRequestContext apiRequestContext;
    protected Properties prop;
	protected BDO_Login login;
	protected BDO_Home homepage;
	protected BDO_ManageProfile profile;
	protected BDO_Unlockuser unlock;
	protected BDO_Update_user_Profile upt_profile;
	protected BDO_MyAccounts accounts;
	
	String Token;
	BDO_PlaywrightFactory bwf;
    Page page;
   
    
    @BeforeTest
	public void API_setup()
	
	{	
    	
    	bwf= new BDO_PlaywrightFactory();
		login= new BDO_Login(page);	
    	profile= new BDO_ManageProfile(page);
    	unlock= new BDO_Unlockuser();
    	upt_profile = new BDO_Update_user_Profile();
    	
		playwright=Playwright.create();
		
		
		
		
		
		Map<String,String> headers= new HashMap<>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("Authorization", "Basic WFBPQXY3aVk3TWFjUXhvTXFxSXFrVWZTazhjU2ZDeWg6Mld0QTk1cDNwbVI2eEJCdA==");
		headers.put("User-Agent", "PostmanRuntime/7.29.2");
		headers.put("Accept", "*/*");
		headers.put("Accept-Encoding", "gzip, deflate, br");
		headers.put("Connection", "keep-alive");
		headers.put("Cookie", "AWSALB=4GVYluXDVweikA+1TASjKsJ91C7LZoOaXzVjPIOYFdFrUxZ/lbu87YdFc9nE+av07XbcxdEZwVRJYHt0uo9XDqHvh6gSsWct4p8xdxyFbNiBL7+53WdZlvkYz9aQ; AWSALBCORS=4GVYluXDVweikA+1TASjKsJ91C7LZoOaXzVjPIOYFdFrUxZ/lbu87YdFc9nE+av07XbcxdEZwVRJYHt0uo9XDqHvh6gSsWct4p8xdxyFbNiBL7+53WdZlvkYz9aQ; AWSALB=YRFlONsz63uG5bltIP5rUPRgfUGJOIRvi79iw1/ZFo1aKlQ+EjL1Oh01yrl6pobmbqIcHNt6bXJn7VEGXZNXDvd2doBzjrh5kzzLraAGjWnF6666MnOrryzvxjkQ; AWSALBCORS=YRFlONsz63uG5bltIP5rUPRgfUGJOIRvi79iw1/ZFo1aKlQ+EjL1Oh01yrl6pobmbqIcHNt6bXJn7VEGXZNXDvd2doBzjrh5kzzLraAGjWnF6666MnOrryzvxjkQ; AWSALBAPP-1=remove; AWSALBAPP-2=remove; AWSALBAPP-3=remove; AWSALBAPP-0=AAAAAAAAAAD/A02X5lDniK0hpOtuUx7sOWx2MT4MsmFLflwuVtS6Y9jSKt40H7JFIfH0EmBZRtyJ0QbDyhtLFEEfK1b57a/RL0rG1LaSFRwZGfZGy6aAa6lQ0AqjwV0Kbw9dxtVOvFBRARbb; AWSALBAPP-0=AAAAAAAAAAC2aJOtczqsxvyOJ25NFikw4yUrxSELxPdl9t1Wt5CwzsCmV19i8CylbgsT/PAZTa28Fm+Wp40mNkt4fqJbAELnMIWV4cXnBFtQFIlwRbPELtYYuyZ/bteijYarrHjZstg/Q1jk; AWSALBAPP-1=remove; AWSALBAPP-2=remove; AWSALBAPP-3=remove");
		
	    apiRequestContext =playwright.request().newContext(new APIRequest.NewContextOptions()
	         .setBaseURL("https://bdo-unibank-dr.apigee.net/v1")
	         .setExtraHTTPHeaders(headers));
	    
	}
	
	

	
	@AfterTest

	public void tearDown_API()
	{
		apiRequestContext.dispose();
		playwright.close();
		
	}
	
}
