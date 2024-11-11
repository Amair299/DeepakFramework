package com.technosol.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
   @FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
   private WebElement contactLink;
   
   @FindBy(xpath="//img[@alt='Create Contact...']")
   private WebElement newContact;
   
   @FindBy(xpath="//input[@name='lastname']")
   private WebElement lastName;
   
   @FindBy(xpath="/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")
   private WebElement save;
   
   @FindBy(xpath="//span[@class='dvHeaderText']")
   private WebElement headerMsg;

   @FindBy(xpath="//input[@name='support_start_date']")
   private WebElement supportStartDate;
   
   
   public WebElement getsupportStartDate() {
		return supportStartDate;
	}
   @FindBy(xpath="//input[@name='support_end_date']")
   private WebElement supportEndDate;
   
   
   public WebElement getsupportEndDate() {
		return supportEndDate;
	}
public WebElement getContactLink() {
	return contactLink;
}

public WebElement getNewContact() {
	return newContact;
}

public WebElement getLastName() {
	return lastName;
}

public WebElement getSave() {
	return save;
}

public WebElement getHeaderMsg() {
	return headerMsg;
}
   
   
}
