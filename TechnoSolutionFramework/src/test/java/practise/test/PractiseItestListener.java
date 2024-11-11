package practise.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.technosols.crm.basetest.BaseClass;


public class PractiseItestListener extends BaseClass {
   @Test(retryAnalyzer=com.technosol.crm.listenerUtility.RetryImpl.class)
   public void HomePage() {
	  System.out.println("Start test for homepage");
	  String title = driver.getTitle();
	  Assert.assertEquals(title,"Home");
	  System.out.println("end of test for homepage");
   }
   
}
