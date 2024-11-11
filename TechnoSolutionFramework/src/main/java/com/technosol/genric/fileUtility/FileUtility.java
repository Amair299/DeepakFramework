package com.technosol.genric.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * A utility class to fetch data from properties file
 * @author AMAIR
 *
 */
public class FileUtility {

	/**
	 * returns data from properties file
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getDataFromPropertiesFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./ConfAppData/Data.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
