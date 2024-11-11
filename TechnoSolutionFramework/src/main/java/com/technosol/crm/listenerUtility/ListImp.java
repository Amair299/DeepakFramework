package com.technosol.crm.listenerUtility;

import java.io.File;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.technosol.genric.webdriverUtility.UtilityClassObject;
import com.technosols.crm.basetest.BaseClass;
/**
 * 
 * @author AMAIR
 *
 */
public class ListImp implements ITestListener,ISuiteListener {
  
	public ExtentReports reports;
	public static ExtentTest test;
	public void onStart(ISuite suite) {
		System.out.println("Report cinfiguration");
		//report configuration
		String time = new Date().toString().replace(" ", "_").replace(":","_");
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/test"+time+".html");
				spark.config().setDocumentTitle("CRM Test Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				//add env info
				 reports = new ExtentReports();
				reports.attachReporter(spark);
				reports.setSystemInfo("OS","Windows-10");
				reports.setSystemInfo("BROWSER","chrome");
	}

	public void onFinish(ISuite suite) {
	System.out.println("report backup is done");
	reports.flush();
	}
	public void onTestStart(ITestResult result) {
		System.out.println("==========="+result.getMethod().getMethodName()+"==START");
	    test = reports.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.setTest(test);
	    test.log(Status.INFO, "test started for same");
	}
    
	public void onTestSuccess(ITestResult result) {
		System.out.println("==========="+result.getMethod().getMethodName()+"===END");
		 test.log(Status.PASS, "test completed");
	}

	public void onTestFailure(ITestResult result) {
		String mn = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":","_");
		TakesScreenshot s1 =(TakesScreenshot) BaseClass.tdriver;
		String src = s1.getScreenshotAs(OutputType.BASE64);
		//File dest = new File("./Screenshots/"+mn+"  "+time+".png");
		//src.renameTo(dest);
		test.addScreenCaptureFromBase64String(src,mn+"_"+time);
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	
   
}
