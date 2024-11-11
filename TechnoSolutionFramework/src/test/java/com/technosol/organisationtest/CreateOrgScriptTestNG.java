package com.technosol.organisationtest;
/**
 * this tests includes create organisation,add industry,add contact,and delete it
 * @author AMAIR
 */
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.technosol.crm.objectrepositoryUtility.OrganisationInformationPage;
import com.technosol.crm.objectrepositoryUtility.OrganisationPage;
import com.technosol.genric.fileUtility.ExcelUtility;
import com.technosol.genric.webdriverUtility.JavaUtility;
import com.technosol.genric.webdriverUtility.UtilityClassObject;
import com.technosol.genric.webdriverUtility.WebDriverUtility;
import com.technosols.crm.basetest.BaseClass;

@Listeners(com.technosol.crm.listenerUtility.ListImp.class)
public class CreateOrgScriptTestNG extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrg() throws Exception {
		// Generating random numbers
		JavaUtility ja = new JavaUtility();
		int rn = ja.getRandomNumber();
		// Reading data from excel
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		ExcelUtility e1 = new ExcelUtility();
		String org = e1.getDataFromExcel("Org", 1, 1) + rn;
		WebDriverUtility u = new WebDriverUtility();
		u.waitForPageToLoad(driver);

		OrganisationPage og = new OrganisationPage(driver);
		og.createOrganisation(org);

		OrganisationInformationPage i = new OrganisationInformationPage(driver);
		String msg = i.getHeaderMsg().getText();
		boolean result = msg.contains(org);
		Assert.assertTrue(result);

	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustry() throws Exception {

		// Generating random numbers
		JavaUtility ja = new JavaUtility();
		int rn = ja.getRandomNumber();
		// Reading data from excel
		ExcelUtility e = new ExcelUtility();
		String org = e.getDataFromExcel("Org", 1, 1) + rn;
		String industry = e.getDataFromExcel("Org", 4, 1);
		// org added with industry and save
		OrganisationPage og = new OrganisationPage(driver);
		og.createOrganisation(org, industry);
		Thread.sleep(3000);
		OrganisationInformationPage oi = new OrganisationInformationPage(driver);
		String msg = oi.getHeaderMsg().getText();
		boolean result = msg.contains(org);
		Assert.assertTrue(result);
	}

	@Test(groups = "regressionTest")
	public void createOrgWithContact() throws Exception {
		// Generating random numbers
		JavaUtility ja = new JavaUtility();
		int rn = ja.getRandomNumber();
		// Reading data from excel
		ExcelUtility e1 = new ExcelUtility();
		String org = e1.getDataFromExcel("Org", 1, 1) + rn;
		String contact = e1.getDataFromExcel("Org", 7, 1);
		OrganisationPage p = new OrganisationPage(driver);
		p.getOrganisation().click();
		p.getCreateOrganisation().click();
		p.getOrganisationName().sendKeys(org);
		p.getContact().sendKeys(contact);
		p.getSave().click();
		Thread.sleep(3000);
		OrganisationInformationPage og = new OrganisationInformationPage(driver);
		String msg = og.getHeaderMsg().getText();
		boolean result = msg.contains(org);
		Assert.assertTrue(result);
	}

	@Test(groups = "regressionTest")
	public void createOrgAndDelete() throws Exception {
		JavaUtility j = new JavaUtility();
		int rn = j.getRandomNumber();
		ExcelUtility ex = new ExcelUtility();
		String org = ex.getDataFromExcel("Org", 1, 1) + rn;
		OrganisationPage og = new OrganisationPage(driver);
		og.createOrganisation(org);
		Thread.sleep(3000);
		og.getOrganisation().click();
		og.getSearchOrg().sendKeys(org);
		WebDriverUtility u = new WebDriverUtility();
		u.selectDropDown(og.getSearchIn(), "Organization Name");
		og.getSearchBt().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='" + org + "']/../../td[8]//a[normalize-space()='del']"))
				.click();
		u.switchToAlertAccept(driver);
	}
}
