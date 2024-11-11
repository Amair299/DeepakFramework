package com.technosol.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technosol.genric.fileUtility.ExcelUtility;

public class FlipkartTest {

	@Test(dataProvider="getProductData")
	public void addProductTest(String brand,String product) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("samsung",Keys.ENTER);
	   String price=driver.findElement(By.xpath("//a[@title='"+product+"']/../a[3]/div[1]/div[1]")).getText();
	   System.out.println(price);
	}  
	  @DataProvider
	   public Object[][] getProductData() throws Exception{
		   ExcelUtility ex = new ExcelUtility();
		   int rows = ex.getRowCount("products");
		   System.out.println(rows);
		   Object obj[][] = new Object[rows][2];
		   for(int i=0;i<rows;i++) {
			    obj[i][0]=ex.getDataFromExcel("products",i,0);
			    obj[i][1]=ex.getDataFromExcel("products",i,1);
         		}
	         
	    return obj; 
}
}