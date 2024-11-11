package com.technosol.crm.objectrepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationWindowPage {

	@FindBy(id="search_txt")
	private WebElement search;
	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(name="search_field")
	private WebElement searchIn;
	public WebElement getSearchIn() {
		return searchIn;
	}
	

	@FindBy(name="search")
	private WebElement searchNow;
	public WebElement getSearchNow() {
		return searchNow;
	}
}
