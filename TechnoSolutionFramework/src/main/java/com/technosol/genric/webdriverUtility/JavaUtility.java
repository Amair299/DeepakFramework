package com.technosol.genric.webdriverUtility;
/**
 * this class provides utilities for java where we can get a random number based om 
 * given range,get current system date
 * @author AMAIR
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	/*
	 * returns random number
	 */
	public int getRandomNumber() {
		Random r = new Random();
		int rn = r.nextInt(1000);
		return rn;
	}
     /**
      * provides system current date
      * @return  systemdate
      */
	public String getSystemDate() {
		LocalDate ld = LocalDate.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String sysDate = ld.format(dt);
		return sysDate;
	}
     /**
      * provides date in given calendar format 
      * @param days
      * @return days
      */
	public String getRequiredDateFormat(int days) {
		LocalDate ld = LocalDate.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ld.format(dt);
		LocalDate dateAfter30Days = ld.plusDays(days);
		String days_30 = dateAfter30Days.format(dt);
		return days_30;
	}
}
