package com.technosols.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.technosol.crm.objectrepositoryUtility.HeaderOptionsPage;
import com.technosol.crm.objectrepositoryUtility.LoginPage;
import com.technosol.genric.dbUtility.DatabaseUtility;
import com.technosol.genric.fileUtility.FileUtility;
import com.technosol.genric.webdriverUtility.UtilityClassObject;

public class BaseClass {

	public DatabaseUtility db = new DatabaseUtility();
	public FileUtility ft = new FileUtility();
	public WebDriver driver=null;
	public static WebDriver tdriver=null;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws Exception {
		System.out.println("Connection to db");
		db.getConnection("jdbc:mysql://localhost:3306/scott","host","tiger");
		
	}
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Exception {
		System.err.println("Launch the browser");
		String browser =ft.getDataFromPropertiesFile("browser");
		if(browser.equals("firefox")) {
	  	    driver = new FirefoxDriver();
	  	}
	  	else if(browser.equals("chrome")) {
	  		driver = new ChromeDriver();
	  	}
	  	else if(browser.equals("edge")) {
	  		driver = new EdgeDriver();
	  	}
		String url =  ft.getDataFromPropertiesFile("url");
		driver.get(url);
		tdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Exception {
		System.out.println("Login to app");
		LoginPage pg = new LoginPage(driver);
		pg.loginAction(ft.getDataFromPropertiesFile("username"),ft.getDataFromPropertiesFile("password"));
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("Logout the app");
		HeaderOptionsPage hp = new HeaderOptionsPage(driver);
		hp.actionLogout(driver);
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC(){
		System.out.println("Close browser");
		driver.quit();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Exception {
		System.out.println("Close db connection and report");
		db.closeDbConnection();
		
	
	}
	@BeforeTest
	public void configBT() {
		
	}
	@AfterTest
	public void configAT() {
		
	}
}
