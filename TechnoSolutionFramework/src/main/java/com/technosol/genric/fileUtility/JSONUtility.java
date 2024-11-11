package com.technosol.genric.fileUtility;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * A utility for JSON file
 * @author AMAIR
 *
 */
public class JSONUtility {
	/**
	 * To reads a data from JSON file
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getDataFromJSONFile(String key) throws Exception {
		JSONParser p = new JSONParser();
		Object obj = p.parse(new FileReader("./ConfAppData/CommonData.json"));
		JSONObject j = (JSONObject) obj;
		return j.get(key).toString();
	}
}
