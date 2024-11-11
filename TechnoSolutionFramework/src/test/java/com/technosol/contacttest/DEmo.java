package com.technosol.contacttest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DEmo {

	@Test
	public void remo1Test() {
		System.out.println("Testcase-1");
	}
	
	@Test
	public void demo2Test() {
		System.out.println("Testcase-2");
	}
	
	@Test(dataProvider="getData")
	public void createCon(String fn,String ln,int con) {
		System.out.println(fn+" "+ln+" "+con);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[3][3];
		obj[0][0]="John";
		obj[0][1]="cena";
		obj[0][2]=1212;
		obj[1][0]="Kendy";
		obj[1][1]="com";
		obj[1][2]=1212;
		obj[2][0]="Sunny";
		obj[2][1]="singh";
		obj[2][2]=4545;
		
		return obj;
	}
}

