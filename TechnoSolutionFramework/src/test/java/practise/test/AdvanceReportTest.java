package practise.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdvanceReportTest {

	ExtentReports reports;
	@BeforeSuite
	public void configBS() {
		//report configuration
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/test.html");
				spark.config().setDocumentTitle("CRM Test Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				//add env info
				 reports = new ExtentReports();
				reports.attachReporter(spark);
				reports.setSystemInfo("OS","Windows-10");
				reports.setSystemInfo("BROWSER","chrome");
	}
	@AfterSuite
	public void configAS() {
		reports.flush();
	}
	@Test
	public void createContactTest() {
		
		ExtentTest test = reports.createTest("createTest");
		test.log(Status.INFO,"login");
		test.log(Status.INFO,"Navigate to contact");
		test.log(Status.INFO,"create contact");
		if("ICICI".equalsIgnoreCase("ICICI")) {
			test.log(Status.PASS, "contact created");
		}
		else {
			test.log(Status.FAIL,"contact did not created");
		}
		

	}
	@Test
	public void createContactWithorgTest() {
		
		ExtentTest test = reports.createTest("createTest");
		test.log(Status.INFO,"login");
		test.log(Status.INFO,"Navigate to contact");
		test.log(Status.INFO,"create contact");
		if("ICICI".equalsIgnoreCase("ICICI")) {
			test.log(Status.PASS, "contact created");
		}
		else {
			test.log(Status.FAIL,"contact did not created");
		}
		

	}
	@Test
	public void createContactTestWithLN() {
		
		ExtentTest test = reports.createTest("createTest");
		test.log(Status.INFO,"login");
		test.log(Status.INFO,"Navigate to contact");
		test.log(Status.INFO,"create contact");
		if("ICICI".equalsIgnoreCase("ICICI")) {
			test.log(Status.PASS, "contact created");
		}
		else {
			test.log(Status.FAIL,"contact did not created");
		}
		

	}
}
