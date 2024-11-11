package com.technosol.crm.objectrepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderOptionsPage {
	public HeaderOptionsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement singOutLogo;
     
    public WebElement getSingOutLogo() {
		return singOutLogo;
	}

	public WebElement getLogout() {
		return logout;
	}
	@FindBy (xpath="//a[normalize-space()='Sign Out']")
    private WebElement logout;
    public void actionLogout(WebDriver driver) {
    	Actions a1 = new Actions(driver);
    	a1.moveToElement(singOutLogo).perform();
    	logout.click();
    }
    
}
