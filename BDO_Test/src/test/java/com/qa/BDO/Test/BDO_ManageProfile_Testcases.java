package com.qa.BDO.Test;


import java.io.UnsupportedEncodingException;

import org.testng.annotations.Test;

import com.qa.BDO.BaseTest.BDO_BaseTest;



public class BDO_ManageProfile_Testcases extends BDO_BaseTest{
	
	
	@Test(priority = 1)
	public void NavigateToManageProfile() 
	{
		System.out.println("\nTC:01 Verify the UI of More Tab:\n");
		accounts=login.navigateToMyAccountsMoreTab();
		profile=accounts.NavigateToUpdateProfile();
		
	}
/*	
	@Test(priority = 5)
	public void VerifyManageProfile_UpdateMobile() throws InterruptedException
	{
		
		System.out.println("\nTC:02 Verify the UI of Update Mobile Number section:\n");
		String Old_Number=profile.VerifyUpdateMobileUI();
		String New_Number=profile.Update_Mobile_Number();
		profile.EnterUpdateOTP();
		String Success_updateMobile= profile.VerifyMobileUpdateSuccess();
		AssertJUnit.assertEquals(Success_updateMobile.trim(), "Mobile number updated!");
		profile.navigatebackToManageProfile();
		System.out.println("\nOld mobile number:"+ Old_Number);
		System.out.println("\nUpdated mobile number:"+ New_Number);
		Assert.assertNotEquals(Old_Number, New_Number);
		
	}*/
	

	@Test(priority = 2)
	public void Verify_Cancel_UpdateMobile()
	{
		System.out.println("\nTC:03 Verify the Cancel of Mobile Number update:\n");
		profile.VerifyCancel_Mobile();
	}
	
	

	@Test(priority = 3)
	public void Verify_Cancel_UpdateEmail()
	{
		System.out.println("\nTC:04 Verify the Cancel of Email Address update:\n");
		profile.VerifyCancel_Email();
	}
	
	@Test(priority =4)
	public void Verify_function_of_Cancel_pop()
	{
		System.out.println("\nTC:06 Verify the Cancel pop up appears for Email Address:\n");
		profile.VerifyCancel_Email_popup_appears();
	}
/*
	@Test(priority = 6)
	public void VerifyManageProfilePage_UpdateEmail() throws UnsupportedEncodingException
	{
		System.out.println("\nTC:05 Verify the UI of Update Email Address section:\n");
		String Old_Email=profile.VerifyUpdateEmailUI();
		String New_Email=profile.Update_Email_Address();
		profile.EnterUpdateOTP();
		String Success_updateEmail= profile.VerifyEmailUpdateSuccess();
		AssertJUnit.assertEquals(Success_updateEmail.trim(), "Email address updated!");
		profile.navigatebackToManageProfile();
		System.out.println("\nOld email address:"+ Old_Email);
		System.out.println("\nUpdated email address:"+ New_Email);
		Assert.assertNotEquals(Old_Email, New_Email);
		String brr_token=unlock.APITesttoGenerateAccessToken();
		upt_profile.APITesttoReset_Mobile_Email(brr_token);		
	}*/
	
	@Test(priority = 7)
	public void Reset_User_profile_details() throws UnsupportedEncodingException
	{
	
		String brr_token=unlock.APITesttoGenerateAccessToken();
		upt_profile.APITesttoReset_Mobile_Email(brr_token);
		
		
	}
	
	
}
