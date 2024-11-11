package com.technosol.organisationtest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public class CreateOrganizationIndType {
	public static void main(String[] args) throws Exception {
		//Reading data from property file
		FileUtility f1 = new FileUtility();
	     String browser,url,uname,pwd;
	     browser = f1.getDataFromPropertiesFile("browser");
	     url=f1.getDataFromPropertiesFile("url");
	     uname = f1.getDataFromPropertiesFile("username");
	     pwd =f1.getDataFromPropertiesFile("password");
	     //Generating random numbers
	     JavaUtility ja = new JavaUtility();
	      int rn =  ja.getRandomNumber();
	     //Reading data from excel
	      ExcelUtility e = new ExcelUtility();
	     String org= e.getDataFromExcel("Org", 1, 1)+rn;
	     String industry = e.getDataFromExcel("Org", 4, 1);
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
	  	   //Login
	  		LoginPage ln = new LoginPage(driver);
	  		ln.loginAction(uname, pwd);
	  		
	  		//org added with industry and save
	  		OrganisationPage og = new OrganisationPage(driver);
	  		og.createOrganisation(org,industry);
	  	   
	  		OrganisationInformationPage oi = new OrganisationInformationPage(driver);
	  		String msg = oi.getHeaderMsg().getText();
	  		if (msg.contains(org)){
	  			System.out.println("Test case passed");
	  		}
	  		HeaderOptionsPage hopt = new HeaderOptionsPage(driver);
	  		hopt.actionLogout(driver);
	  		System.out.println("Script  passed");
	        
	  		driver.close();
	  	}

	}




