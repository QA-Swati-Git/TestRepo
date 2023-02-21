package com.qa.BDO.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Route;
import com.microsoft.playwright.Tracing;

public class BDO_PlaywrightFactory {
	
	
	Playwright playwright;
	public APIRequestContext apiRequestContext;
	Browser browser;
	BrowserContext brContext;
	Page page;
	Properties prop;

	
	
	public Page initBrowser(Properties prop)
	{
		String browserName=prop.getProperty("browser").trim();
		System.out.println("The browser name is:"+ browserName);
		playwright= Playwright.create();
		
		
		switch(browserName.toLowerCase())
		{
		case "chrome":
			browser= playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
			
		case "chromium":
			browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "firefox":
			browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
				
		case "safari":
			browser= playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
			default:
				System.out.println("Please pass right bowser name");
				break;
				
		} 
		
		brContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1750,1080)); 
		page= brContext.newPage();	
		navigateToURL(prop.getProperty("url").trim());
        
		return page;
	}    
	   
	    
					
		
	
	private void navigateToURL(String url) 
	{
		this.addExtraHeaders();
        this.page.navigate(url);
		
	}


	private void addExtraHeaders() {
		      this.page.route("**/*", route -> {
			  Map<String, String> headers1 = new HashMap<>(route.request().headers());
			  headers1.put(prop.getProperty("headerName").trim(), prop.getProperty("headerValue").trim()); 
			  route.resume(new Route.ResumeOptions().setHeaders(headers1));
			});
		
	}
	
	public Properties init_prop()
	{	
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/Config/config.properties");
			prop= new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}


}
