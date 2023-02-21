package com.qa.BDO.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.qa.BDO.BaseTest.BDO_BaseTest;


public class BDO_Home_Testcases extends BDO_BaseTest{	


	
	
	@Test
	public void ValidateHomePageElements()
	{
		String Actualtitle= homepage.getHomePageTitle();
		
		homepage.verifyLogo();

		AssertJUnit.assertEquals(Actualtitle, "BDO Online");
		System.out.println("Page Title of application is:"+ Actualtitle);
		
		String Actualurl= homepage.getHomePageurl();
		System.out.println("Complete url of the Application:"+ Actualurl);
		
		
		String Actuallabel= homepage.GetHomePageComponenets();
		AssertJUnit.assertEquals(Actuallabel, "Username");
		System.out.println("First label of the page is:"+ Actuallabel);
		
		
		
		
			
	}
	
}
