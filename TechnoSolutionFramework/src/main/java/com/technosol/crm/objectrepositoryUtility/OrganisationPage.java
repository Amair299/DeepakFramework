package com.technosol.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganisationPage {
	
   public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

   @FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
   private WebElement organisation;
   
   @FindBy (xpath="//img[@title='Create Organization...']")
   private WebElement createOrganisation;
   
   @FindBy (xpath="//input[@name='accountname']")
   private WebElement organisationName;
   
   @FindBy (xpath="/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")
   private WebElement save;

   @FindBy(xpath="//select[@name='industry']")
   private WebElement industry;
   
   @FindBy(name="phone")
   private WebElement contact;
   
   @FindBy(name="search_text")
   private WebElement searchOrg;
   
   @FindBy(id="bas_searchfield")
   private WebElement searchIn;
   
   @FindBy(xpath="//input[@name='submit']")
   private WebElement searchBt;
   public WebElement getSearchBt() {
	   return searchBt;
   }
   
   public WebElement getSearchIn() {
	   return searchIn;
   }
   public WebElement getSearchOrg() {
	   return searchOrg;
   }
   public WebElement getContact() {
	   return contact;
   }
public WebElement getOrganisation() {
	return organisation;
}

public WebElement getCreateOrganisation() {
	return createOrganisation;
}

public WebElement getOrganisationName() {
	return organisationName;
}

public WebElement getSave() {
	return save;
}
public WebElement getIndustry() {
	return industry;
}
//create organisation
   public void createOrganisation(String org) {
	   organisation.click();
	   createOrganisation.click();
	   organisationName.sendKeys(org);
	   save.click();
 }
   //create organisation with industryname
   public void createOrganisation(String org,String indName) {
	   organisation.click();
	   createOrganisation.click();
	   organisationName.sendKeys(org);
	   Select s1 = new Select(industry);
	   s1.selectByValue(indName);
	   save.click();
 }
}
