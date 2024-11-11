package com.technosol.organisationtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.technosol.crm.objectrepositoryUtility.LoginPage;
import com.technosol.crm.objectrepositoryUtility.OrganisationPage;
import com.technosol.genric.fileUtility.ExcelUtility;
import com.technosol.genric.fileUtility.FileUtility;
import com.technosol.genric.webdriverUtility.JavaUtility;
import com.technosol.genric.webdriverUtility.WebDriverUtility;

public class CreateOrgAndDelete {
	public static void main(String[] args) throws Exception {
		
    FileUtility ft = new FileUtility();
    String browser = ft.getDataFromPropertiesFile("browser");
    String url = ft.getDataFromPropertiesFile("url");
    String username = ft.getDataFromPropertiesFile("username");
    String pwd = ft.getDataFromPropertiesFile("password");
    
    JavaUtility j = new JavaUtility();
    int rn = j.getRandomNumber();
    ExcelUtility ex = new ExcelUtility();
    String org = ex.getDataFromExcel("Org", 1,1)+rn;
    
    WebDriver driver = null;
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
		lp.loginAction(username, pwd);
		
		OrganisationPage og = new OrganisationPage(driver);
		og.createOrganisation(org);
		Thread.sleep(3000);
		og.getOrganisation().click();
		og.getSearchOrg().sendKeys(org);
		u.selectDropDown(og.getSearchIn(),"Organization Name");
		og.getSearchBt().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()="+org+"]/../../td[8]//a[text()='del']")).click();
		driver.close();
}
}