package com.technosol.contacttest;

import java.time.Duration;


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
import com.technosols.crm.basetest.BaseClass;

public class CreateOrgWithDates extends BaseClass {

	public void createOrgDates() throws Exception {
	     
			     //Generating random numbers
	     JavaUtility ja = new JavaUtility();
	      int rn =  ja.getRandomNumber();
			     //Reading data from excel
			       ExcelUtility e1 = new ExcelUtility();
				 	String lastname = e1.getDataFromExcel("Con",1,1)+rn;
			      //logic to get current date and 30 days from now
			        String date = ja.getSystemDate();
			        String days_30=ja.getRequiredDateFormat(30);
			   
			  		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			  	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
			  	driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(date);
			  	driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(days_30);	
			driver.findElement(By.xpath("/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")).click();
			 String msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			   if(msg.contains(date)) {
				   System.out.println("Testcase passed");
			   }
			   else {
				   System.out.println("Testcase failed");
			   }
			  
	}

}
