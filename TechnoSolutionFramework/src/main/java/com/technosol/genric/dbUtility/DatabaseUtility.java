package com.technosol.genric.dbUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
/**
 * A utility for database to connect to mysql db and retrive data
 * @author AMAIR
 *
 */
public class DatabaseUtility {
	Connection c = null;
/**
 * connect to mysql database
 * @param url
 * @param un
 * @param pwd
 * @throws Exception
 */
	public void getConnection(String url, String un, String pwd) throws Exception {
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			c = DriverManager.getConnection(url, un, pwd);
		} catch (Exception e) {

		}
	}
/**
 * close connection to mysql database
 * @throws Exception
 */
	public void closeDbConnection() throws Exception {
		c.close();
	}
/**
 * TO create an select query 
 * @param query
 * @return
 * @throws SQLException
 */
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet rs = null;
		try {
			Statement st = c.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {

		}
		return rs;
	}
	/**
	 * TO provide an non select query
	 * @param query
	 * @return data as result set:int
	 */

	public int updateInsertQuery(String query) {
		Statement st;
		int rs = 0;
		try {
			st = c.createStatement();
			rs = st.executeUpdate(query);
		} catch (SQLException e) {

		}

		return rs;
	}
}
