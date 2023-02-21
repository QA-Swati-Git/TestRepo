package com.qa.BDO.API;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import io.gatling.jsonpath.JsonPath;

public class BDO_Update_user_Profile {
	
	
	Playwright playwright;
	APIRequestContext apiRequestContext;
	JsonPath JSON;
	Properties prop;
	
	
	
	public void APITesttoReset_Mobile_Email(String Bearer_Token) throws UnsupportedEncodingException
	{
		playwright=Playwright.create();
		Map<String,String> headers1= new HashMap<>();

		headers1.put("Authorization", "Bearer"+" "+Bearer_Token);
		System.out.print("Bearer"+" "+Bearer_Token);
		headers1.put("Content-Type", "application/json");		
		apiRequestContext =playwright.request().newContext(new APIRequest.NewContextOptions()
		         .setBaseURL("https://bdo-unibank-dr.apigee.net")
		         .setExtraHTTPHeaders(headers1));
		
		HashMap<String, String> payload= new HashMap<>();


		payload.put("status","ACTIVE");
		payload.put("mobilePhone","+919561564998");
		payload.put("emailAddr","swati@backbase.com");
       
		APIResponse response1= apiRequestContext.put("/v1/auth/accounts/BBNDB001", RequestOptions.create().setData(payload));
		System.out.println(response1.status());
		if(response1.status()== 200)
		{
		System.out.println("\n The user's mobile and email is reset!");
		System.out.println("\nThe Mobile is set to:" + "+919561564998");
		System.out.println("\nThe email is set to:" + "swati@backbase.com");
		}
		
	}

}
