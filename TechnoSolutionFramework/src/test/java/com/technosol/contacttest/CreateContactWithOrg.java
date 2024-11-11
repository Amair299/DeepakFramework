package com.technosol.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.technosol.genric.fileUtility.ExcelUtility;
import com.technosol.genric.fileUtility.FileUtility;
import com.technosol.genric.webdriverUtility.JavaUtility;

public class CreateContactWithOrg {

	public static void main(String[] args) throws Exception {
		//Reading data from property file
				FileUtility f1 = new FileUtility();
			     String   browser=f1.getDataFromPropertiesFile("browser");
			     String  url=f1.getDataFromPropertiesFile("url");
			     String  uname=f1.getDataFromPropertiesFile("username");
			     String pwd = f1.getDataFromPropertiesFile("password");
			     //Reading data from excel
			 	ExcelUtility e1 = new ExcelUtility();
			 	String org = e1.getDataFromExcel("Con",4,1);
			 	String ln = e1.getDataFromExcel("Con",4,2);
	     //Generating random numbers
			 	  JavaUtility ja = new JavaUtility();
			      int rn =  ja.getRandomNumber();
	     //Reading data from excel
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
	  	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  		driver.get(url);
	  		driver.findElement(By.name("user_name")).sendKeys(uname);
	  		driver.findElement(By.name("user_password")).sendKeys(pwd);
	  		driver.findElement(By.id("submitButton")).click();
	  		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	  		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	  		//create an organisation
	  		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
	  		driver.findElement(By.xpath("/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")).click();
	  		String msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	  		if (msg.contains(org)){
	  			System.out.println("Organisation Added successfully");
	  		}
	  		else {
	  			System.out.println("Failed to add organisation");
	  		}
	  		//create a last name
	  		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	  		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	  		  	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(ln);
	  	
	  	   driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
	       //switch to child window
	  	   Set<String> wh = driver.getWindowHandles();
	  	   Iterator<String> i = wh.iterator();
	  	   List<String> l1=new ArrayList<String>();
	  	   while(i.hasNext()) {
	  		  l1.add(i.next());
	  	   }
	  	   driver.switchTo().window(l1.get(1));
	  	   driver.findElement(By.id("search_txt")).sendKeys(org);
	  	   driver.findElement(By.name("search")).click();
	  	   driver.findElement(By.xpath("//a[text()='"+org+"']")).click();
	  	   driver.switchTo().window(l1.get(0));
	  	driver.findElement(By.xpath("/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")).click();
		 String msgln = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(msgln.contains(ln)) {
			   System.out.println("Testcase passed");
		   }
		   else {
			   System.out.println("Testcase failed");
		   }
		   Actions a1 = new Actions(driver);
				WebElement logout = driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]//img"));
				a1.moveToElement(logout).perform();
				driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
				System.out.println("Script  passed");
		   driver.close();   	 
	}

}
