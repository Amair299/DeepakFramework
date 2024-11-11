package com.technosol.contacttest;
/**
 * this test includes creating contact test cases with lastname,date and contact integrated with organisation
 * @author AMAIR
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.technosol.crm.objectrepositoryUtility.ContactPage;
import com.technosol.crm.objectrepositoryUtility.OrganisationPage;
import com.technosol.genric.fileUtility.ExcelUtility;
import com.technosol.genric.webdriverUtility.JavaUtility;
import com.technosol.genric.webdriverUtility.UtilityClassObject;
import com.technosol.genric.webdriverUtility.WebDriverUtility;
import com.technosols.crm.basetest.BaseClass;

@Listeners(com.technosol.crm.listenerUtility.ListImp.class)
public class CreateContactTestScriptTestNG extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactLastNameTest() throws Exception {

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// Reading data from excel
		// test=reports.createTest("createContactLastNameTest");
		ExcelUtility e1 = new ExcelUtility();
		String lastname = e1.getDataFromExcel("Con", 1, 1);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact page");
		ContactPage p = new ContactPage(driver);
		p.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "create new contact");
		p.getNewContact().click();
		p.getLastName().sendKeys(lastname);
		UtilityClassObject.getTest().log(Status.INFO, "save contact");
		p.getSave().click();
		String msg = p.getHeaderMsg().getText();
		boolean act = msg.contains(lastname);
		Assert.assertTrue(act);

	}

	@Test(groups = "regressionTest")
	public void createContactDateTest() throws Exception {
		JavaUtility ja = new JavaUtility();
		int rn = ja.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "reads data from excel");
		// Reading data from excel
		ExcelUtility e1 = new ExcelUtility();
		String lastname = e1.getDataFromExcel("Con", 1, 1) + rn;
		// logic to get current date and 30 days from now
		UtilityClassObject.getTest().log(Status.INFO, "gets system current date");
		String date = ja.getSystemDate();
		String days_30 = ja.getRequiredDateFormat(30);
		// System.out.println(date+" "+days_30);
		UtilityClassObject.getTest().log(Status.INFO, "login into app");
		WebDriverUtility u = new WebDriverUtility();
		u.waitForPageToLoad(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigates to contact page");
		ContactPage cp = new ContactPage(driver);
		cp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "new contact link clicked");
		cp.getNewContact().click();
		cp.getLastName().sendKeys(lastname);
		cp.getsupportStartDate().clear();
		cp.getsupportStartDate().sendKeys(date);
		cp.getsupportEndDate().clear();
		cp.getsupportEndDate().sendKeys(days_30);
		UtilityClassObject.getTest().log(Status.INFO, "support start and end date added successfully");
		cp.getSave().click();
		String msg = cp.getHeaderMsg().getText();
		boolean result = msg.contains(lastname);
		Assert.assertTrue(result);

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Exception {
		// Generating random numbers
		JavaUtility ja = new JavaUtility();
		int rn = ja.getRandomNumber();
		// Reading data from excel
		UtilityClassObject.getTest().log(Status.INFO, "reads data from excel");
		ExcelUtility e1 = new ExcelUtility();
		String org = e1.getDataFromExcel("Con", 4, 1) + rn;
		String ln = e1.getDataFromExcel("Con", 4, 2);
		// Create Organization
		UtilityClassObject.getTest().log(Status.INFO, "navigates to organisation page");
		OrganisationPage op = new OrganisationPage(driver);
		op.createOrganisation(org);
		Thread.sleep(3000);
		String msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (msg.contains(org)) {
			System.out.println("Organisation Added successfully");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL, "Unable to add organisation");
		}
		Thread.sleep(3000);
		// create a contact lastname
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		ContactPage p = new ContactPage(driver);
		p.getContactLink().click();
		p.getNewContact().click();
		p.getLastName().sendKeys(ln);
		UtilityClassObject.getTest().log(Status.INFO, "search for organisation");
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		// switch to child window
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> i = wh.iterator();
		List<String> l1 = new ArrayList<String>();
		while (i.hasNext()) {
			l1.add(i.next());
		}
		driver.switchTo().window(l1.get(1));
		driver.findElement(By.id("search_txt")).sendKeys(org);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + org + "']")).click();
		driver.switchTo().window(l1.get(0));
		driver.findElement(By.xpath(
				"/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]"))
				.click();
		String msgln = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean act = msgln.contains(ln);
		Assert.assertTrue(act);

	}
}