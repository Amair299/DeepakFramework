package practise.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class PractiseAssertionTest {
   
	@Test
	public void verifyHomePageTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String text = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		/*if(text.equalsIgnoreCase("Home")) {
			System.out.println("script pass");
		}
		else {
			System.out.println("script failed");
		}*/
		Assert.assertEquals(text,"Homely");
		Reporter.log("Passed");
		 driver.close();
	}
	@Test
	public void verifyLogoTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean logo =driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
	   Assert.assertTrue(logo);
	   Reporter.log("Passed",true);
	   driver.close();
	}
	@Test
	public void captureScreenShotTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		TakesScreenshot s1 = (TakesScreenshot) driver;
		File f1 = s1.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./Screenshots/test.png");
	    f1.renameTo(dest);
	}
	@Test
	public void testing() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
	    System.out.println(driver.getTitle());
	}
}
