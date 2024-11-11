package com.technosol.genric.webdriverUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
       public void waitForPageToLoad(WebDriver driver) {
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	   
       }
       public void waitForElementToPresent(WebDriver driver,WebElement e) {
    	   WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(20));
    	   wdw.until(ExpectedConditions.visibilityOf(e));
    	   
       }
       public void switchToChildBrowser(WebDriver driver,String partialUrl) {
    	  Set<String> wh = driver.getWindowHandles();
    	  Iterator<String> i = wh.iterator();
    	  while(i.hasNext()) {
    		  String windowId = i.next();
    		  driver.switchTo().window(windowId);
    		  String actUrl = driver.getCurrentUrl();
    		  if(actUrl.contains(partialUrl)) {
    			  break;
    		  }
    	  }
       }
    	  public void switchToParentBrowser(WebDriver driver,String partialTitle) {
        	  Set<String> wh = driver.getWindowHandles();
        	  Iterator<String> i = wh.iterator();
        	  while(i.hasNext()) {
        		  String windowId = i.next();
        		  driver.switchTo().window(windowId);
        		  String actUrl = driver.getTitle();
        		  if(actUrl.contains(partialTitle)) {
        			  break;
        		  }
        	  }
       }
    	  public void switchToFrame(WebDriver driver,int index) {
    		  driver.switchTo().frame(index);
    	  }
    	  public void switchToFrame(WebDriver driver,String frame) {
    		  driver.switchTo().frame(frame);
    	  }
    	  public void switchToFrame(WebDriver driver,WebElement e) {
    		  driver.switchTo().frame(e);
    	  }
    	  public void switchToAlertAccept(WebDriver driver) {
    		  driver.switchTo().alert().accept();
    	  }
    	  public void switchToAlertCancel(WebDriver driver) {
    		  driver.switchTo().alert().dismiss();
    	  }
    	  public void selectDropDown(WebElement elem,String text) {
    		  Select s1 = new Select(elem);
    		  s1.selectByVisibleText(text);
    		  
    	  }
    	  public void selectDropDown(WebElement elem,int index) {
    		  Select s1 = new Select(elem);
    		  s1.selectByIndex(index);;
    		  
    	  }
    	  public void mouseOnElement(WebDriver driver,WebElement elem) {
    		  Actions a = new Actions(driver);
    		  a.moveToElement(elem).perform();
    	  }
    	  public void doubleClick(WebDriver driver,WebElement elem) {
    		  Actions a = new Actions(driver);
    		  a.doubleClick(elem).perform();
    	  }
    	  public void scrollDown(WebDriver driver) {
    		  JavascriptExecutor e = (JavascriptExecutor) driver;
    		  e.executeScript("window.scrollBy(0,300)","");
    	  }
    	  public void captureScreenShot(WebDriver driver) {
    		  TakesScreenshot ts =(TakesScreenshot) driver;
    		  File f = ts.getScreenshotAs(OutputType.FILE);
    		  File ds = new File("./ConfAppData/result.png");
    		  f.renameTo(ds);
    		  
    	  }
}


