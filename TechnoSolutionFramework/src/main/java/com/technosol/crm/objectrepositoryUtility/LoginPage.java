package com.technosol.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
   @FindBy(name="user_name")
   private WebElement usernameE;
   public WebElement getUsernameE() {
	return usernameE;
}
   @FindBy(name="user_password")
   private WebElement passwordE;
public WebElement getPasswordE() {
	return passwordE;
}
@FindBy(id="submitButton")
private WebElement loginButtE;
public WebElement getLoginButtE() {
	return loginButtE;
}

public void loginAction(String username,String pwd) {
	driver.manage().window().maximize();
	usernameE.sendKeys(username);
	passwordE.sendKeys(pwd);
	loginButtE.click();
}
   
   
   
}
