package com.qa.BDO.Test;

import java.io.UnsupportedEncodingException;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.BDO.BaseTest.BDO_BaseTest;



public class BDO_Login_Testcases extends BDO_BaseTest{
	

	
@Test(priority = 2)
	public void LoginAttemptExhausted() throws UnsupportedEncodingException 
	{
		
		login.logintoApp("BBNDB010", "Password1");
		System.out.println("\nTC:05 The  login attempts exhausted:\n");
		login.LoginwhenAttemptsExhausted();
		unlock.APITesttoGenerateAccessToken();
		unlock.APITesttoUnlockUser();	    
	    
	}



@Test(dataProvider = "credentials")
public void VerifyLoginCredentials(String Scenario, String Username, String Password) throws UnsupportedEncodingException
{	
login.logintoApp(Username, Password);		
if (Scenario.equals("EmptyUsername"))
   {
	System.out.println("\nTC:001  No UserName and Valid Password:\n");
	
    String ErroronHeader = login.Loginwithemptyusername();

	AssertJUnit.assertEquals(ErroronHeader, "Enter username");	

   }

else if(Scenario.equals("PasswordEmpty"))
   {
	
	System.out.println("\nTC:002 Valid UserName and no Password:\n");
	
	String ErroronHeader1 = login.Loginwithemptypassword();
	
	AssertJUnit.assertEquals(ErroronHeader1, "Enter password");
   }

else if(Scenario.equals("BothCredentialEmpty"))
   {
	System.out.println("\nTC:003 No Username and No Password:\n");
	String ErroronHeader2 = login.Loginwithbothempty();
	
	AssertJUnit.assertEquals(ErroronHeader2, "Enter username and Enter password");
   }

else if(Scenario.equals("InvalidUsernameandPassword"))
   {
	System.out.println("\nTC:004 The expected error for Invalid Username and Password:\n");
	String ErroronHeader3 = login.LoginwithInvalidUsernameandPassword();
	
	AssertJUnit.assertEquals(ErroronHeader3, "Incorrect username or password.  Please try again.");
   }

else {
	
   	System.out.println("User will continue to try login");
     }
}


	

@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][]{
				
				{"EmptyUsername","","Password@0007"},
				{"PasswordEmpty","BBNDB001",""},
				{"BothCredentialEmpty", "" ,""},
				{"InvalidUsernameandPassword","BBNDB0010","Password@0007"},
				{"InvalidPassword","BBNDB001","Test@20"},				
				
				};
	}


@Test (priority = 3)	
public void VaildateSuccessfullogin() 

{	
	System.out.println("\nTC:06 The expected Username on successful login attempt:\n");
	login.logintoApp(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	login.EnterOTP(prop.getProperty("default_otp").trim());
	String ErroronHeader9 = login.ValidateLoginSuccess();
	System.out.println("The username displayed:" + ErroronHeader9);
	AssertJUnit.assertEquals(prop.getProperty("username").trim(), ErroronHeader9.trim());
}

}
