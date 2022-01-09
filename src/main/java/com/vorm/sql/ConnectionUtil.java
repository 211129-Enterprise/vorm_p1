package com.vorm.sql;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection conn = null;

	// Singleton class
	private ConnectionUtil() {
		super();

	}

	public static Connection getConnection() {
		/**
		 * If the DB Connection is already established it is returned from the try block.
		 * If not a new Connection is established and returned.
		 */
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		try {
			Properties prop = new Properties();
			prop.load(new FileReader("/Users/viralbhavsar/Documents/vorm_p1/src/main/resources/application.properties"));
			conn = DriverManager.getConnection(prop.getProperty("awsurl"), prop.getProperty("awsuser"),
					prop.getProperty("awspass"));
//			System.out.print("DB Connected\n");
			return conn;
		} catch (SQLException se) {
			se.printStackTrace();

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();

		} catch (IOException e) {
			System.out.println("IO Exception triggered wiht application.properties");

		} finally {

		}
		return conn;

	}

}
