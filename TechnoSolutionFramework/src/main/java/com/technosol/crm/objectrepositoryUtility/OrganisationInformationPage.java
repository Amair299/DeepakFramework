package com.technosol.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationPage {
	public OrganisationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
   @FindBy(id="mouseArea_Organization Name")
   private WebElement orgname;
   
   @FindBy(xpath="//span[@class='dvHeaderText']")
   private WebElement headerMsg;

public WebElement getOrgname() {
	return orgname;
}

public WebElement getHeaderMsg() {
	return headerMsg;
}
  
 }
