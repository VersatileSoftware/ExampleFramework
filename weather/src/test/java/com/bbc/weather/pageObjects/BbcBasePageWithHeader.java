package com.bbc.weather.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.bbc.weather.constants.StaticProperties;
import com.bbc.weather.core.Page;

public abstract class BbcBasePageWithHeader {
	
	public Page myBrowser;
	
	public BbcBasePageWithHeader(){
		 myBrowser=new Page();
		 PageFactory.initElements(myBrowser.browser, this);
	}
	
    public BbcHomePage navigateHomepage() throws Throwable {
    	myBrowser.navigateToPage(StaticProperties.HOMEPAGE_URL);
    	return new BbcHomePage();
    }


}
