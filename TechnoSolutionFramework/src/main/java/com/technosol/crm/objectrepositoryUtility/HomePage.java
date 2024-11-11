package com.technosol.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    @FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
    private WebElement organizationsLink;
    public WebElement getorganizationsLink() {
    	return organizationsLink;
    }
    
    @FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
    private WebElement contactsLink;
    public WebElement getcontactsLink() {
    	return contactsLink;
    }
}
