package com.technosol.organisationtest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.technosol.crm.objectrepositoryUtility.HeaderOptionsPage;
import com.technosol.crm.objectrepositoryUtility.LoginPage;
import com.technosol.crm.objectrepositoryUtility.OrganisationPage;
import com.technosol.crm.objectrepositoryUtility.OrganisationInformationPage;
import com.technosol.genric.fileUtility.ExcelUtility;
import com.technosol.genric.fileUtility.FileUtility;
import com.technosol.genric.webdriverUtility.JavaUtility;
import com.technosol.genric.webdriverUtility.WebDriverUtility;
public class CreateOrganization {
public static void main(String[] args) throws Exception {
	//Reading data from property file
	FileUtility f1 = new FileUtility();
     String browser,url,uname,pwd;
     browser=f1.getDataFromPropertiesFile("browser");
     url=f1.getDataFromPropertiesFile("url");
     uname=f1.getDataFromPropertiesFile("username");
     pwd = f1.getDataFromPropertiesFile("password");
     //Generating random numbers
       JavaUtility ja = new JavaUtility();
      int rn =  ja.getRandomNumber();
     //Reading data from excel
 	ExcelUtility e1 = new ExcelUtility();
 	String org = e1.getDataFromExcel("Org",1,1)+rn;
     //polymorphism
      WebDriver driver=null;
  	if(browser.equals("firefox")) {
  	    driver = new FirefoxDriver();
  	}
  	else if(browser.equals("chrome")) {
  		driver = new ChromeDriver();
  	}
  	else if(browser.equals("edge")) {
  		driver = new EdgeDriver();
  	}
  	   WebDriverUtility u = new WebDriverUtility();
  	   u.waitForPageToLoad(driver);
  		driver.get(url);
  		LoginPage lp = new LoginPage(driver);
  		lp.loginAction(uname, pwd);
  		
  		OrganisationPage og = new OrganisationPage(driver);
  		og.createOrganisation(org);
  		
  		OrganisationInformationPage i = new OrganisationInformationPage(driver);
  	//	if (i.verifyOrgName(org)){
  			System.out.println("Test case passed");
  		//}
  		//else {
  			System.out.println("Test case Failed");
  		//}
  		HeaderOptionsPage p = new HeaderOptionsPage(driver);
  		p.actionLogout(driver);
        
  		driver.close();
  	}

}


