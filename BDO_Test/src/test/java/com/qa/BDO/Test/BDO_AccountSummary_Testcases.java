package com.qa.BDO.Test;

import org.testng.annotations.Test;

import com.qa.BDO.BaseTest.BDO_BaseTest;


public class BDO_AccountSummary_Testcases extends BDO_BaseTest{
	
		@Test(priority = 1)
		public void NavigateToUpdateProfilePage()
		{
			System.out.println("\nTC:01 Verify the UI of More Tab:\n");
			accounts=login.navigateToMyAccountsMoreTab();
			accounts.VerifyMoreTab();
			
		}
}
